package com.webtest.webui.action;

import com.webtest.webui.ui.Element;

public abstract interface CheckAble
{
  public abstract void checkByText(Element paramElement, String paramString);

  public abstract void checkByValue(Element paramElement, String paramString);
}