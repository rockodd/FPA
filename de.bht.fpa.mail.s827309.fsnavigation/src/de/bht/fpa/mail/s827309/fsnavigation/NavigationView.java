package de.bht.fpa.mail.s827309.fsnavigation;

import java.io.File;
import java.util.Observable;
import java.util.Observer;

import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.part.ViewPart;
import org.osgi.service.prefs.BackingStoreException;
import org.osgi.service.prefs.Preferences;

import de.bht.fpa.mail.s000000.common.mail.model.IMessageTreeItem;
import de.bht.fpa.mail.s827309.fsnavigation.handlers.SetBaseDirHandler;
import de.bht.fpa.mail.s827309.fsnavigation.handlers.SingletonFile;

public class NavigationView extends ViewPart implements ISelectionChangedListener, Observer {

  private TreeViewer viewer;

  @Override
  public void createPartControl(Composite parent) {

    // Prefernces pr�fen ob letztes Verzeichniss vorhanden
    Preferences pref = SetBaseDirHandler.getPrefs();
    String startDir = null;

    try {
      startDir =  pref.get(pref.keys().length -1 + "", System.getProperty("user.home"));
    } catch (BackingStoreException e) {
      // TODO Auto-generated catch block
      
    }
  
    viewer = new TreeViewer(parent);

    viewer.setContentProvider(new NsNavigationContentProvider());
    //
    viewer.setLabelProvider(new FsNavigationLabel());
    // TODO Pr�fen ob File Null ist!!!
    viewer.setInput(new FolderItem(new File(startDir)));
    // System.getProperty macht aus String Pfad!

    // viewer.addSelectionChangedListener(this);

    // String path = System.getProperty("user.home");
    // IMessageTreeItem in = new FolderItem(new File(path));
    // BaseDirSubject.getInstance().addObserver(this);
    // viewer.setInput(in);

    // dem Singleton den Observer mitteilen
    SingletonFile.getInstance().addObserver(this);
  }

  @Override
  public void setFocus() {
    // TODO Auto-generated method stub

  }

  @Override
  public void selectionChanged(SelectionChangedEvent event) {
    // TODO Auto-generated method stub
    IStructuredSelection ts = (IStructuredSelection) event.getSelection();
    IMessageTreeItem ti = (IMessageTreeItem) ts.getFirstElement();

    // List<Message> messages = ti.getMessages();
  }

  @Override
  public void update(Observable arg0, Object givenPath) {
    // Methode wird von Observer aufgerufen
    String path = (String) givenPath;

    // pr�fen ob Pfad ausgew�hlt wurde
    if (path != null) {
      viewer.setInput(new FolderItem(new File(path)));
    }

  }

}