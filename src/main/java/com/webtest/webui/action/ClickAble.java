package com.webtest.webui.action;

import com.webtest.webui.ui.Element;

public abstract interface ClickAble extends Status
{
  public abstract void click(Element paramElement);

  public abstract void dbClick(Element paramElement);
}
