package com.webtest.webui.ui;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.webtest.webui.action.AdvanceValueEditor;
import com.webtest.webui.action.ClickAble;
import com.webtest.webui.action.ValueEditor;

@Component
@Scope("prototype")
public class Text extends AbstractElement
{
  private String value;
  private String callback;

  @Autowired
  private ValueEditor valueEditor;

  @Autowired
  private AdvanceValueEditor advanceValueEditor;

  @Autowired
  private ClickAble clickAble;

  public Text()
  {
  }

  public Text(String value)
  {
    this.value = value;
  }

  public Text fillValue(String value)
  {
    setValue(value);

    return fillValue();
  }

  public Text fillValue()
  {
    String val4Fill = this.value;

    this.valueEditor.setValue(this, val4Fill);

    return this;
  }

  public Text appendValue()
  {
    String val4Fill = this.value;

    this.advanceValueEditor.appendValue(this, val4Fill);

    return this;
  }

  public Text fillNotBlankValue()
  {
    String val4Fill = this.value;

    this.advanceValueEditor.fillNotBlankValue(this, val4Fill);

    return this;
  }

  public String getValue()
  {
    return this.value;
  }

  public Text setValue(String value)
  {
    this.value = value;
    return this;
  }

  public Text click()
  {
    getClickAble().click(this);
    return this;
  }

  public Text performEnter()
  {
    this.valueEditor.submit(this);

    return this;
  }

  public boolean isEnabled()
  {
    return this.valueEditor.isEnabled(this);
  }

  public boolean isHidden()
  {
    return this.valueEditor.isHidden(this);
  }

  public ValueEditor getValueEditor()
  {
    return this.valueEditor;
  }

  public void setValueEditor(ValueEditor valueEditor)
  {
    this.valueEditor = valueEditor;
  }

  public ClickAble getClickAble()
  {
    return this.clickAble;
  }

  public void setClickAble(ClickAble clickAble)
  {
    this.clickAble = clickAble;
  }

  public String getCallback()
  {
    return this.callback;
  }

  public void setCallback(String callback)
  {
    this.callback = callback;
  }
}
