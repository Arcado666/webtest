package com.webtest.webui.core;

import java.util.List;

import com.webtest.webui.ui.Element;

public abstract interface ElementsSearchStrategy<T>
{
  public abstract List<T> searchAll(Element paramElement);
}