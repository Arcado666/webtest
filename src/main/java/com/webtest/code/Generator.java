package com.webtest.code;

import java.io.InputStream;
import org.dom4j.DocumentException;
import org.xml.sax.SAXException;

public abstract interface Generator
{
  public abstract void generate(String paramString1, String paramString2);

  public abstract void generate(InputStream paramInputStream, String paramString, Callback<?> paramCallback)
    throws DocumentException, SAXException;
}
