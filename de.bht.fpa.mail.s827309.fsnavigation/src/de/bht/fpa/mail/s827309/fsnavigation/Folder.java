package de.bht.fpa.mail.s827309.fsnavigation;

import java.util.List;

import org.eclipse.swt.graphics.Image;

import de.bht.fpa.mail.s000000.common.mail.model.IMessageTreeItem;
import de.bht.fpa.mail.s000000.common.mail.model.Message;

//import de.bht.fpa.mail.s000000.common.mail.model.IMessageTreeItem;
//import de.bht.fpa.mail.s000000.common.mail.model.Message;

public class Folder implements IMessageTreeItem{

  @Override
  public String getText() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public Image getImage() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public boolean hasChildren() {
    // TODO Auto-generated method stub
    return false;
  }

  @Override
  public List<IMessageTreeItem> getChildren() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public List<Message> getMessages() {
    // TODO Auto-generated method stub
    return null;
  }

}