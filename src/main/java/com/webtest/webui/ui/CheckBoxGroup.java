package com.webtest.webui.ui;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.webtest.webui.action.CheckAble;

@Component
@Scope("prototype")
public class CheckBoxGroup extends AbstractElement
{

  @Autowired
  private CheckAble checkAble;
  private String targetText;
  private String value;

  /** @deprecated */
  public boolean selectByText()
  {
    return selectByText(this.targetText);
  }

  /** @deprecated */
  public boolean selectByText(String text)
  {
    this.checkAble.checkByText(this, text);

    return true;
  }

  /** @deprecated */
  public int selectByTextArray(String[] texts)
  {
    int count = 0;
    if (texts == null)
    {
      return count;
    }

    for (String text : texts)
    {
      if (!selectByText(text))
        continue;
      count++;
    }

    return count;
  }

  public void selectByValue()
  {
    selectByValue(this.value);
  }

  public void selectByValue(String value)
  {
    this.checkAble.checkByValue(this, value);
  }

  public void selectByValues(String[] values)
  {
    if (values == null)
    {
      return;
    }

    for (String valueItem : values)
    {
      selectByValue(valueItem);
    }
  }

  public boolean isEnabled()
  {
    return false;
  }

  public boolean isHidden()
  {
    return false;
  }

  public String getTargetText()
  {
    return this.targetText;
  }

  public void setTargetText(String targetText)
  {
    this.targetText = targetText;
  }

  public String getValue()
  {
    return this.value;
  }

  public void setValue(String value)
  {
    this.value = value;
  }
}
