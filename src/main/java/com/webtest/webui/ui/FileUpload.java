package com.webtest.webui.ui;

import java.io.File;
import java.net.URL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.webtest.webui.action.FileUploadAble;
import com.webtest.webui.action.RandomFileUploadAble;

@Component
@Scope("prototype")
public class FileUpload extends AbstractElement
{

  @Autowired
  private FileUploadAble fileUploadAble;

  @Autowired
  private RandomFileUploadAble randomFileUploadAble;
  private File targetFile;

  public boolean click()
  {
    this.fileUploadAble.click(this);
    return true;
  }

  public boolean upload(File file)
  {
    return this.fileUploadAble.upload(this, file);
  }

  public boolean upload(URL url)
  {
    return this.fileUploadAble.upload(this, url);
  }

  public boolean upload()
  {
    return upload(this.targetFile);
  }

  public boolean randomUpload()
  {
    return this.randomFileUploadAble.upload(this);
  }

  public boolean isEnabled()
  {
    return this.fileUploadAble.isEnabled(this);
  }

  public boolean isHidden()
  {
    return this.fileUploadAble.isHidden(this);
  }

  public File getTargetFile()
  {
    return this.targetFile;
  }

  public void setTargetFile(File targetFile)
  {
    this.targetFile = targetFile;
  }
}
