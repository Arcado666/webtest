package com.webtest.webui.action;

import com.webtest.webui.ui.Element;

public abstract interface Status
{
  public abstract boolean isEnabled(Element paramElement);

  public abstract boolean isHidden(Element paramElement);
}
