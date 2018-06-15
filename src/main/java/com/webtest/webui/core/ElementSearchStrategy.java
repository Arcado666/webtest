package com.webtest.webui.core;

import com.webtest.webui.ui.Element;

public abstract interface ElementSearchStrategy<T>
{
  public abstract T search(Element paramElement);

  public abstract String description();
}
