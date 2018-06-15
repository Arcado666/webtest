package com.webtest.webui.action;

import com.webtest.webui.ui.Element;

public abstract interface ValueEditor extends Status
{
  public abstract Object getValue(Element paramElement);

  public abstract void setValue(Element paramElement, Object paramObject);

  public abstract void submit(Element paramElement);
}
