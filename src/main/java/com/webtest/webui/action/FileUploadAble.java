package com.webtest.webui.action;

import java.io.File;
import java.net.URL;

import com.webtest.webui.ui.Element;

public abstract interface FileUploadAble extends Status
{
  public abstract boolean upload(Element paramElement, URL paramURL);

  public abstract boolean upload(Element paramElement, File paramFile);

  public abstract boolean click(Element paramElement);
}