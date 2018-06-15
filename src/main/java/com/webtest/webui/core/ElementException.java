package com.webtest.webui.core;

public class ElementException extends RuntimeException
{
  public ElementException(String message)
  {
    super(message);
  }

  public ElementException(Class<?> elementCls)
  {
    super("wrong element type: " + elementCls.getClass().getName());
  }
}
