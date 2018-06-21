package com.webtest.code.impl;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.VisitorSupport;
import org.dom4j.XPath;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;
import org.dom4j.xpath.DefaultXPath;
import org.jaxen.SimpleNamespaceContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.xml.sax.SAXException;

import com.webtest.code.Callback;
import com.webtest.code.Generator;
import com.webtest.code.StringUtils;

@Component("xml_to_suite_runner")
public class DefaultXmlSuiteRunnerGenerator implements Generator {
	private static final Logger logger = LoggerFactory.getLogger(DefaultXmlDataSourceGenerator.class);
	private String outputDir;
	private String srcCoding;
	private Map<String, String> suiteActionMap = new HashMap();

	private Document suiteRunnerDoc = null;

	public DefaultXmlSuiteRunnerGenerator() {
		this.suiteActionMap.put("button", "click");
		this.suiteActionMap.put("input", "fillValue");
		this.suiteActionMap.put("select", "randomSelect");
		this.suiteActionMap.put("file_upload", "upload");
	}

	public void generate(String srcCoding, String outputDir) {
		this.srcCoding = srcCoding;

		ClassLoader classLoader = getClass().getClassLoader();
		try {
			InputStream confInput = classLoader.getResourceAsStream(srcCoding);
			Throwable localThrowable3 = null;
			try {
				generate(confInput, outputDir, null);
			} catch (Throwable localThrowable1) {
				localThrowable3 = localThrowable1;
				throw localThrowable1;
			} finally {
				if (confInput != null)
					if (localThrowable3 != null)
						try {
							confInput.close();
						} catch (Throwable localThrowable2) {
							localThrowable3.addSuppressed(localThrowable2);
						}
					else
						confInput.close();
			}
		} catch (IOException e) {
			logger.error(String.format("Main config [%s] parse process error.", new Object[] { srcCoding }), e);
		}
	}

	public void generate(InputStream input, String outputDir, Callback callback) {
		this.outputDir = outputDir;

		this.suiteRunnerDoc = DocumentHelper.createDocument();
		try {
				read(input);
		} catch (IOException e) {
			logger.error(String.format("Main config [%s] parse process error.", new Object[] { this.srcCoding }), e);
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		XMLWriter xmlWriter = null;

		File outputDirFile = new File(outputDir);
		if (!outputDirFile.isDirectory()) {
			outputDirFile.mkdirs();
		}

		File outputFile = new File(outputDir, System.currentTimeMillis() + ".xml");
		try {
			OutputStream dsOutput = new FileOutputStream(outputFile);
			Throwable localThrowable3 = null;
			try {
				OutputFormat outputFormat = OutputFormat.createPrettyPrint();
				outputFormat.setIndentSize(4);
				xmlWriter = new XMLWriter(dsOutput, outputFormat);

				xmlWriter.write(this.suiteRunnerDoc);

				if (callback != null) {
					callback.callback(outputFile);
				}
			} catch (Throwable localThrowable1) {
				localThrowable3 = localThrowable1;
				throw localThrowable1;
			} finally {
				if (dsOutput != null)
					if (localThrowable3 != null)
						try {
							dsOutput.close();
						} catch (Throwable localThrowable2) {
							localThrowable3.addSuppressed(localThrowable2);
						}
					else
						dsOutput.close();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void read(InputStream inputStream) throws DocumentException, IOException, SAXException {
		Document document = new SAXReader().read(inputStream);

		parse(document);
	}

	private void parse(Document doc) {
		SimpleNamespaceContext simpleNamespaceContext = new SimpleNamespaceContext();
		simpleNamespaceContext.addNamespace("ns", "https://mall.sunmi.com");

		XPath xpath = new DefaultXPath("/ns:autotest/ns:includePage");
		xpath.setNamespaceContext(simpleNamespaceContext);

		List<Element> includePageList = xpath.selectNodes(doc);
		if ((includePageList != null) && (includePageList.size() > 0)) {
			for (Element includePage : includePageList) {
				String pageConfig = includePage.attributeValue("pageConfig");

				generate(pageConfig, this.outputDir);
			}
		}

		xpath = new DefaultXPath("/ns:autotest/ns:pages");
		xpath.setNamespaceContext(simpleNamespaceContext);
		Element pagesEle = (Element) xpath.selectSingleNode(doc);
		String pagePackage = pagesEle.attributeValue("pagePackage", "");
		if (StringUtils.isNotBlank(pagePackage)) {
			pagePackage = pagePackage.trim();
		}

		xpath = new DefaultXPath("/ns:autotest/ns:pages/ns:page");
		xpath.setNamespaceContext(simpleNamespaceContext);

		List<Element> pageNodes = xpath.selectNodes(doc);
		if (pageNodes != null) {
			for (Element ele : pageNodes) {
				String pageClsStr = ele.attributeValue("class");
				if (pageClsStr == null) {
					logger.warn("can not found class attribute.");
					continue;
				}

				try {
					parse(doc, pagePackage, pageClsStr, ele);
				} catch (Exception e) {
					logger.error("Page element [{}] parse error, in document [{}].", "pageClsStr", doc);
					logger.error("Page element parse error.", e);
				}
			}
		}
	}

	private void parse(Document doc, String pagePackage, String pageClsStr, Element ele) throws Exception {
		updateXmlDataSourceByEle(ele, pagePackage, pageClsStr);
	}

	private void updateXmlDataSourceByEle(Element ele, String pagePackage, String pageClsStr) {
		SimpleDateFormat dateFormat = new SimpleDateFormat();
		this.suiteRunnerDoc.addComment("Auto created by AutoTest, " + dateFormat.format(new Date()));

		SimpleNamespaceContext simpleNamespaceContext = new SimpleNamespaceContext();
		simpleNamespaceContext.addNamespace("ns", "http://suite.surenpi.com");

		XPath xpath = new DefaultXPath("/ns:suite");
		xpath.setNamespaceContext(simpleNamespaceContext);

		Element dataSourcesEle = this.suiteRunnerDoc.getRootElement();
		if (dataSourcesEle == null) {
			String prefix = "suren";
			dataSourcesEle = this.suiteRunnerDoc.addElement(prefix + ":suite");

			dataSourcesEle.addNamespace(prefix, "http://suite.surenpi.com");
			dataSourcesEle.addAttribute("xmlns:xsi", "http://www.w3.org/2001/XMLSchema-instance");
			dataSourcesEle.addAttribute("xsi:schemaLocation",
					"https://mall.sunmi.com http://surenpi.com/schema/suite/autotest.web.framework.suite.xsd ");

			dataSourcesEle.addAttribute("pageConfig", this.srcCoding);
			dataSourcesEle.addAttribute("pagePackage", pagePackage);
		}

		xpath = new DefaultXPath("/ns:suite/ns:page[@class='" + pageClsStr + "']");
		xpath.setNamespaceContext(simpleNamespaceContext);
		Element dataSourceEle = (Element) xpath.selectSingleNode(this.suiteRunnerDoc);
		if (dataSourceEle == null) {
			String prefix = dataSourcesEle.getNamespacePrefix();
			if (StringUtils.isBlank("")) {
				String parentName = dataSourcesEle.getName();
				if (parentName.contains(":")) {
					prefix = parentName.split(":")[0];
				}
			}

			if (StringUtils.isNotBlank(prefix)) {
				prefix = prefix + ":";
			}

			dataSourceEle = dataSourcesEle.addElement(prefix + "page");

			dataSourceEle.addAttribute("class", pageClsStr);
		}

		xpath = new DefaultXPath("/ns:suite/ns:page[@class='" + pageClsStr + "']/ns:actions[1]");
		xpath.setNamespaceContext(simpleNamespaceContext);
		Element pageEle = (Element) xpath.selectSingleNode(dataSourceEle);
		if (pageEle == null) {
			String prefix = dataSourceEle.getNamespacePrefix();
			if (StringUtils.isNotBlank(prefix)) {
				prefix = prefix + ":";
			}

			pageEle = dataSourceEle.addElement(prefix + "actions");
		}

		ele.accept(new PageFieldVisitor(pageEle));
	}

	class PageFieldVisitor extends VisitorSupport {
		private SimpleNamespaceContext simpleNamespaceContext = new SimpleNamespaceContext();
		private Element actionsEle;

		public PageFieldVisitor(Element pageEle) {
			this.actionsEle = pageEle;
			this.simpleNamespaceContext.addNamespace("ns", "http://suite.surenpi.com");
		}

		public void visit(Element node) {
			if (!"field".equals(node.getName())) {
				return;
			}

			String fieldName = node.attributeValue("name");
			String type = node.attributeValue("type");
			String action = (String) DefaultXmlSuiteRunnerGenerator.this.suiteActionMap.get(type);
			if ((StringUtils.isBlank(fieldName)) || (StringUtils.isBlank(action))) {
				return;
			}

			XPath xpath = new DefaultXPath("//ns:action[@field='" + fieldName + "']");
			xpath.setNamespaceContext(this.simpleNamespaceContext);

			Element fieldEle = (Element) xpath.selectSingleNode(this.actionsEle);
			if (fieldEle == null) {
				String prefix = this.actionsEle.getNamespacePrefix();
				if (StringUtils.isNotBlank(prefix)) {
					prefix = prefix + ":";
				}

				fieldEle = this.actionsEle.addElement(prefix + "action");

				fieldEle.addAttribute("field", fieldName);
			}

			fieldEle.addAttribute("name", action);
		}
	}
}
