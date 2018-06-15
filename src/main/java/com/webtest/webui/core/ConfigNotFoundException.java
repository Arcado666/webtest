package com.webtest.webui.core;

public class ConfigNotFoundException extends ConfigException
{
  private static final long serialVersionUID = 1L;
  private String type;
  private String configPath;
  private String message;

  public ConfigNotFoundException(String message)
  {
    this.message = message;
  }

  public ConfigNotFoundException(String type, String configPath)
  {
    this.type = type;
    this.configPath = configPath;
  }

  public String getMessage()
  {
    this.message = (this.message != null ? this.message : String.format("Can not found config file for AutoTest, type [%s], path [%s].", new Object[] { this.type, this.configPath }));

    return this.message;
  }
}
