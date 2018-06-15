package com.webtest.webui;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;

import com.webtest.datasource.DynamicData;
import com.webtest.webui.core.Keyboard;
import com.webtest.webui.core.Mouse;
import com.webtest.webui.ui.Button;
import com.webtest.webui.ui.Text;
import com.webtest.webui.util.StringUtils;

public abstract class Page
{
  private String id;
  private String url;
  private String dataSource;
  private Map<String, Object> data = new HashMap();
  private String paramPrefix;

  @Autowired
  private Mouse mouse;

  @Autowired
  private Keyboard keyboard;

  @Autowired
  private Button commonBut;

  @Autowired
  private Text commonText;

  @Autowired
  private List<DynamicData> dynamicDataList;

  public abstract void open();

  public abstract void close();

  public abstract void closeOthers();

  public String getId()
  {
    return this.id;
  }

  public void setId(String id)
  {
    this.id = id;
  }

  public String getUrl()
  {
    return this.url;
  }

  public void setUrl(String url)
  {
    this.url = url;
  }

  public abstract String getCurrentUrl();

  public abstract String getPageSource();

  public abstract String getTitle();

  public String getDataSource()
  {
    return this.dataSource;
  }

  public void setDataSource(String dataSource)
  {
    this.dataSource = dataSource;
  }

  public void putData(String key, Object value)
  {
    this.data.put(key, value);
  }

  public void putAllData(Map<String, Object> allData)
  {
    this.data.putAll(allData);
  }

  public void removeData(String key)
  {
    this.data.remove(key);
  }

  public boolean containsKey(String key)
  {
    return this.data.containsKey(key);
  }

  public void clearData()
  {
    this.data.clear();
  }

  public String paramTranslate(String value)
  {
    String result = value;
    for (DynamicData dynamicData : this.dynamicDataList)
    {
      if ("system".equals(dynamicData.getType()))
      {
        result = dynamicData.getValue(result);
        break;
      }
    }

    result = StringUtils.paramTranslate(this.data, getParamPrefix(), result);

    return result;
  }

  public Mouse getMouse()
  {
    return this.mouse;
  }

  public Keyboard getKeyboard()
  {
    return this.keyboard;
  }

  public final Button getCommonBut()
  {
    return this.commonBut;
  }

  public final void setCommonBut(Button commonBut)
  {
    this.commonBut = commonBut;
  }

  public final Text getCommonText()
  {
    return this.commonText;
  }

  public final void setCommonText(Text commonText)
  {
    this.commonText = commonText;
  }

  public String getParamPrefix()
  {
    return this.paramPrefix;
  }

  public void setParamPrefix(String paramPrefix)
  {
    this.paramPrefix = paramPrefix;
  }
}