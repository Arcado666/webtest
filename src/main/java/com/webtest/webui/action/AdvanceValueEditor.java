package com.webtest.webui.action;

import com.webtest.webui.ui.Element;

public abstract interface AdvanceValueEditor extends ValueEditor
{
  public abstract void appendValue(Element paramElement, Object paramObject);

  public abstract void fillNotBlankValue(Element paramElement, Object paramObject);
}