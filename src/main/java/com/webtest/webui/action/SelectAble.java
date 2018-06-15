package com.webtest.webui.action;

import java.util.List;

import com.webtest.webui.ui.Element;

public abstract interface SelectAble extends Status
{
  public abstract boolean selectByText(Element paramElement, String paramString);

  public abstract boolean selectByValue(Element paramElement, String paramString);

  public abstract boolean selectByIndex(Element paramElement, int paramInt);

  public abstract boolean selectAll(Element paramElement);

  public abstract boolean deselectByText(Element paramElement, String paramString);

  public abstract boolean deselectByValue(Element paramElement, String paramString);

  public abstract boolean deselectByIndex(Element paramElement, int paramInt);

  public abstract boolean deselectAll(Element paramElement);

  public abstract boolean isMultiple(Element paramElement);

  public abstract List<Element> getOptions(Element paramElement);

  public abstract List<Element> getSelectedOptions(Element paramElement);
}
