package com.webtest.webui.ui;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.webtest.webui.action.ClickAble;
import com.webtest.webui.action.HoverAble;
import com.webtest.webui.action.SequenceAble;
import com.webtest.webui.util.StringUtils;

@Component
@Scope("prototype")
public class Button extends AbstractElement
{

  @Autowired
  private ClickAble clickAble;

  @Autowired
  private HoverAble hoverAble;

  @Autowired
  private List<SequenceAble> sequenceAbleList;

  public void click()
  {
    this.clickAble.click(this);
  }

  public void dbClick()
  {
    this.clickAble.dbClick(this);
  }

  public void hover()
  {
    this.hoverAble.hover(this);
  }

  public void sequenceOperation()
  {
    List actions = new ArrayList();

    String seqOper = (String)getData("SEQ_OPER");
    String seqOperName = getDataStr("SEQ_OPER_NAME");

    actions.addAll(Arrays.asList(seqOper.split(",")));

    this.clickAble.click(this);

    for (SequenceAble sequenceAble : this.sequenceAbleList)
    {
      String tagetSeqName = sequenceAble.getName();
      if (StringUtils.isBlank(tagetSeqName))
      {
        throw new RuntimeException(String.format("The SequenceAble'name is blank! Class is %s.", new Object[] { sequenceAble
          .getClass() }));
      }

      if (tagetSeqName.equals(seqOperName))
      {
        sequenceAble.perform(this, actions);
        break;
      }
    }
  }

  public boolean isEnabled()
  {
    return this.clickAble.isEnabled(this);
  }

  public boolean isHidden()
  {
    return this.clickAble.isHidden(this);
  }

  public ClickAble getClickAble()
  {
    return this.clickAble;
  }

  public void setClickAble(ClickAble clickAble)
  {
    this.clickAble = clickAble;
  }

  public HoverAble getHoverAble()
  {
    return this.hoverAble;
  }

  public void setHoverAble(HoverAble hoverAble)
  {
    this.hoverAble = hoverAble;
  }
}
