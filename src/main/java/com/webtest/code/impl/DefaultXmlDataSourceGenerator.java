package com.webtest.code.impl;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
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

@Component("xml_to_datasource")
public class DefaultXmlDataSourceGenerator implements Generator {
	private static final Logger logger = LoggerFactory.getLogger(DefaultXmlDataSourceGenerator.class);
	private String outputDir;
	private Map<String, Document> docMap;
	private Callback callback;
	private InputStream confInput;
	public void generate(String srcCoding, String outputDir) {
		this.outputDir = outputDir;
		ClassLoader classLoader = getClass().getClassLoader();
		try {
			confInput = classLoader.getResourceAsStream(srcCoding);
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
						try {
							confInput.close();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
			}
		} catch (DocumentException e) {
			InputStream confInput;
			String resPath;
			Document doc;
			logger.error(String.format("Main config [%s] parse process error.", new Object[] { srcCoding }), e);
		} catch (SAXException e) {
			e.printStackTrace();
		} finally {
			for (String resPath : this.docMap.keySet()) {
				Document doc = (Document) this.docMap.get(resPath);
				write(doc, resPath);
			}
		}
	}

	public void generate(InputStream input, String outputDir, Callback<?> callback)
			throws DocumentException, SAXException {
		this.callback = callback;
		this.outputDir = outputDir;
		this.docMap = new HashMap();
		try {
			read(input);
		} catch (IOException e) {
			logger.error(String.format("Main config parse process error.", new Object[0]), (Throwable) e);

			for (e = (IOException) this.docMap.keySet().iterator(); ((Iterator) e).hasNext();) {
				String resPath = (String) ((Iterator) e).next();

				Document doc = (Document) this.docMap.get(resPath);
				write(doc, resPath);
			}
		} finally {
			for (String resPath : this.docMap.keySet()) {
				Document doc = (Document) this.docMap.get(resPath);
				write(doc, resPath);
			}
		}
	}

	private void read(InputStream inputStream) throws DocumentException, IOException, SAXException {
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

				String dataSrc = ele.attributeValue("dataSource");
				try {
					parse(doc, pagePackage, pageClsStr, dataSrc, ele);
				} catch (Exception e) {
					logger.error("Page element [{}] parse error, in document [{}].", "pageClsStr", doc);
					logger.error("Page element parse error.", e);
				}
			}
		}
	}

	private void parse(Document doc, String pagePackage, String pageClsStr, String dataSrc, Element ele)
			throws Exception {
		SimpleNamespaceContext simpleNamespaceContext = new SimpleNamespaceContext();
		simpleNamespaceContext.addNamespace("ns", "https://mall.sunmi.com");

		XPath xpath = new DefaultXPath("/ns:autotest/ns:dataSources/ns:dataSource[@name='" + dataSrc + "']");
		xpath.setNamespaceContext(simpleNamespaceContext);
		Element dataSourceEle = (Element) xpath.selectSingleNode(doc);
		if (dataSourceEle == null) {
			logger.error("Can not found dataSource element by {}.", dataSrc);
			return;
		}

		String dsType = dataSourceEle.attributeValue("type");
		String dsResource = dataSourceEle.attributeValue("resource");

		logger.debug("DataSource type is {}, resource is {}.", dsType, dsResource);

		updateXmlDataSourceByEle(ele, dsResource, pagePackage, pageClsStr);
	}

	private void updateXmlDataSourceByEle(Element ele, String dsResource, String pagePackage, String pageClsStr) {
		Document doc = (Document) this.docMap.get(dsResource);
		if (doc == null) {
			doc = prepareDoc(dsResource);
			this.docMap.put(dsResource, doc);
		}

		SimpleNamespaceContext simpleNamespaceContext = new SimpleNamespaceContext();
		simpleNamespaceContext.addNamespace("ns", "http://datasource.surenpi.com");

		XPath xpath = new DefaultXPath("/ns:dataSources");
		xpath.setNamespaceContext(simpleNamespaceContext);

		Element dataSourcesEle = doc.getRootElement();
		dataSourcesEle.addAttribute("pagePackage", pagePackage);

		if (StringUtils.isNotBlank(pagePackage)) {
			pagePackage = pagePackage.trim();
			xpath = new DefaultXPath("/ns:dataSources[@pagePackage='" + pagePackage + "']/ns:dataSource[@pageClass='"
					+ pageClsStr + "']");
			xpath.setNamespaceContext(simpleNamespaceContext);
		} else {
			xpath = new DefaultXPath("/ns:dataSources/ns:dataSource[@pageClass='" + pageClsStr + "']");
			xpath.setNamespaceContext(simpleNamespaceContext);
		}
		Element dataSourceEle = (Element) xpath.selectSingleNode(doc);
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

			dataSourceEle = dataSourcesEle.addElement(prefix + "dataSource");

			dataSourceEle.addAttribute("pageClass", pageClsStr);
		}

		if (StringUtils.isNotBlank(pagePackage)) {
			pagePackage = pagePackage.trim();
			xpath = new DefaultXPath("/ns:dataSources[@pagePackage='" + pagePackage + "']/ns:dataSource[@pageClass='"
					+ pageClsStr + "']/ns:page[1]");
			xpath.setNamespaceContext(simpleNamespaceContext);
		} else {
			xpath = new DefaultXPath("/ns:dataSources/ns:dataSource[@pageClass='" + pageClsStr + "']/ns:page[1]");
			xpath.setNamespaceContext(simpleNamespaceContext);
		}
		Element pageEle = (Element) xpath.selectSingleNode(dataSourceEle);
		if (pageEle == null) {
			String prefix = dataSourceEle.getNamespacePrefix();
			if (StringUtils.isNotBlank(prefix)) {
				prefix = prefix + ":";
			}

			pageEle = dataSourceEle.addElement(prefix + "page");
		}

		ele.accept(new PageFieldVisitor(pageEle, pagePackage, pageClsStr));
	}

	private Document prepareDoc(String resPath) {
		ClassLoader clsLoader = getClass().getClassLoader();
		URL url = clsLoader.getResource(resPath);
		InputStream dsInput = null;
		try {
			if (url != null) {
				dsInput = url.openStream();
			}
		} catch (IOException e1) {
			e1.printStackTrace();
		}

		Document doc = null;
		if (dsInput != null) {
			try {
				doc = new SAXReader().read(dsInput);
			} catch (DocumentException e) {
				e.printStackTrace();
			}
		} else {
			doc = DocumentHelper.createDocument();
		}

		SimpleDateFormat dateFormat = new SimpleDateFormat();
		doc.addComment("Auto created by AutoTest, " + dateFormat.format(new Date()));

		SimpleNamespaceContext simpleNamespaceContext = new SimpleNamespaceContext();
		simpleNamespaceContext.addNamespace("ns", "http://datasource.surenpi.com");

		XPath xpath = new DefaultXPath("/ns:dataSources");
		xpath.setNamespaceContext(simpleNamespaceContext);

		Element dataSourcesEle = (Element) xpath.selectSingleNode(doc);
		if (dataSourcesEle == null) {
			String prefix = "suren";
			dataSourcesEle = doc.addElement(prefix + ":dataSources");

			dataSourcesEle.addNamespace(prefix, "http://datasource.surenpi.com");
			dataSourcesEle.addAttribute("xmlns:xsi", "http://www.w3.org/2001/XMLSchema-instance");
			dataSourcesEle.addAttribute("xsi:schemaLocation",
					"https://mall.sunmi.com http://surenpi.com/schema/datasource/autotest.web.framework.datasource.xsd ");
		}

		return doc;
	}

	private void write(Document doc, String resPath) {
		OutputFormat outputFormat = OutputFormat.createPrettyPrint();
		outputFormat.setIndentSize(4);

		write(doc, outputFormat, resPath);
	}

	private void write(Document doc, OutputFormat format, String resPath) {
		ClassLoader clsLoader = getClass().getClassLoader();
		URL url = clsLoader.getResource(resPath);

		String outputFileName = null;
		if (url != null) {
			outputFileName = new File(url.getFile()).getName();
		} else {
			outputFileName = new File(resPath).getName();
		}

		File outputDirFile = new File(this.outputDir);
		if (!outputDirFile.isDirectory()) {
			outputDirFile.mkdirs();
		}

		File outputFile = new File(outputDirFile, outputFileName);
		try {
			OutputStream dsOutput = new FileOutputStream(outputFile);
			Throwable localThrowable3 = null;
			try {
				OutputFormat outputFormat = OutputFormat.createPrettyPrint();
				outputFormat.setIndentSize(4);
				XMLWriter xmlWriter = new XMLWriter(dsOutput, outputFormat);

				xmlWriter.write(doc);

				if (this.callback != null) {
					this.callback.callback(outputFile);
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

	class PageFieldVisitor extends VisitorSupport {
		private SimpleNamespaceContext simpleNamespaceContext = new SimpleNamespaceContext();
		private Element pageEle;
		private String pagePackage;
		private String pageClsStr;

		public PageFieldVisitor(Element pageEle, String pagePackage, String pageClsStr) {
			this.pageEle = pageEle;
			this.pagePackage = pagePackage;
			this.pageClsStr = pageClsStr;
			this.simpleNamespaceContext.addNamespace("ns", "http://datasource.surenpi.com");
		}

		public void visit(Element node) {
			if (!"field".equals(node.getName())) {
				return;
			}

			String fieldName = node.attributeValue("name");
			String data = node.attributeValue("data", "");
			String type = node.attributeValue("type");
			if ((fieldName == null) || ("".equals(fieldName)) || ("button".equals(type))) {
				return;
			}
			XPath xpath;
			if (StringUtils.isNotBlank(this.pagePackage)) {
				this.pagePackage = this.pagePackage.trim();
				xpath = new DefaultXPath(
						"/ns:dataSources[@pagePackage='" + this.pagePackage + "']/ns:dataSource[@pageClass='"
								+ this.pageClsStr + "']/ns:page[1]/ns:field[@name='" + fieldName + "']");
				xpath.setNamespaceContext(this.simpleNamespaceContext);
			} else {
				xpath = new DefaultXPath("/ns:dataSources/ns:dataSource[@pageClass='" + this.pageClsStr
						+ "']/ns:page[1]/ns:field[@name='" + fieldName + "']");
				xpath.setNamespaceContext(this.simpleNamespaceContext);
			}
			Element fieldEle = (Element) xpath.selectSingleNode(this.pageEle);
			if (fieldEle == null) {
				String prefix = this.pageEle.getNamespacePrefix();
				if (StringUtils.isNotBlank(prefix)) {
					prefix = prefix + ":";
				}

				fieldEle = this.pageEle.addElement(prefix + "field");

				fieldEle.addAttribute("name", fieldName);
				fieldEle.addAttribute("data", data);
			}
		}
	}
}
