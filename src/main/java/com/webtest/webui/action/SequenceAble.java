package com.webtest.webui.action;

import java.util.List;

import com.webtest.webui.ui.Element;

public abstract interface SequenceAble
{
  public abstract void perform(Element paramElement, List<String> paramList);

  public abstract String getName();

  public abstract String getDescription();
}
