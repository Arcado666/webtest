package com.webtest.webui.ui;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.webtest.webui.action.RandomSelectAble;
import com.webtest.webui.action.SelectAble;

@Component
@Scope("prototype")
public class Selector extends AbstractElement
{
  private String text;
  private int index;
  private String value;

  @Autowired
  private SelectAble selectAble;

  @Autowired
  private RandomSelectAble randomSelectAble;

  public boolean selectByText(String text)
  {
    return this.selectAble.selectByText(this, text);
  }

  public boolean selectByText()
  {
    return selectByText(this.text);
  }

  public boolean selectByIndex(int index)
  {
    return this.selectAble.selectByIndex(this, index);
  }

  public boolean selectByIndex()
  {
    return selectByIndex(this.index);
  }

  public boolean selectByValue(String value)
  {
    return this.selectAble.selectByValue(this, value);
  }

  public Object randomSelect()
  {
    return this.randomSelectAble.randomSelect(this);
  }

  public boolean selectByValue()
  {
    return selectByValue(this.value);
  }

  public SelectAble getSelectAble()
  {
    return this.selectAble;
  }

  public void setSelectAble(SelectAble selectAble)
  {
    this.selectAble = selectAble;
  }

  public boolean isEnabled()
  {
    return this.selectAble.isEnabled(this);
  }

  public boolean isHidden()
  {
    return this.selectAble.isHidden(this);
  }

  public String getText()
  {
    return this.text;
  }

  public void setText(String text)
  {
    this.text = text;
  }

  public int getIndex()
  {
    return this.index;
  }

  public void setIndex(int index)
  {
    this.index = index;
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
