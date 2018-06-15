package com.webtest.webui.core;

public class ConfigException extends AutoTestException
{
  private static final long serialVersionUID = 1L;
  private final String message;

  public ConfigException()
  {
    super("Config exception.");
    this.message = "Config exception.";
  }

  public ConfigException(String message, String message1) {
    super(message);
    this.message = message1;
  }

  public String getMessage()
  {
    return String.format("%s %s", new Object[] { super.getMessage(), this.message });
  }
}
