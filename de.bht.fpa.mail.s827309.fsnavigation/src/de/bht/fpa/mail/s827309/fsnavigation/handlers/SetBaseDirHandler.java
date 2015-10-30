package de.bht.fpa.mail.s827309.fsnavigation.handlers;


import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.preferences.ConfigurationScope;
import org.eclipse.core.runtime.preferences.IEclipsePreferences;
import org.eclipse.core.runtime.preferences.IPreferencesService;
import org.eclipse.swt.widgets.DirectoryDialog;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.handlers.HandlerUtil;
import org.osgi.service.prefs.BackingStoreException;
import org.osgi.service.prefs.Preferences;

import de.bht.fpa.mail.s827309.fsnavigation.NavigationView;

/**
 * Our sample handler extends AbstractHandler, an IHandler base class.
 * 
 * @see org.eclipse.core.commands.IHandler
 * @see org.eclipse.core.commands.AbstractHandler
 */
public class SetBaseDirHandler extends AbstractHandler {
  /**
   * The constructor.
   */
  public SetBaseDirHandler() {
  }

  /**
   * the command has been executed, so extract extract the needed information
   * from the application context.
   */
  public Object execute(ExecutionEvent event) throws ExecutionException {
    //
    IWorkbenchWindow window = HandlerUtil.getActiveWorkbenchWindowChecked(event);
    // Dialog zur Verzeichnissauswahl
    DirectoryDialog dlg = new DirectoryDialog(window.getShell());
    // Dialog zur Verzeichnissauswahl
    String choosenPath = dlg.open();
    // JFace nutzen
    System.out.println(choosenPath);
    // Patterns nutzen um letzte Pathes zu speichern.
    SingletonFile file = SingletonFile.getInstance();
    file.setpath(choosenPath);
    // MessageDialog.openInformation(
    // window.getShell(),
    // "Fsnavigation",
    // "Hello, Eclipse world");
    
    Preferences prefs = getPrefs();
    try {
      prefs.put("" + prefs.keys().length, choosenPath);
      prefs.flush();
    } catch (BackingStoreException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    
    
    
    
    return null;
  }
  
  public static Preferences getPrefs() {
    IPreferencesService service = Platform.getPreferencesService();
    IEclipsePreferences root = service.getRootNode();
    Preferences prefs = root.node(ConfigurationScope.SCOPE).node("de.bht.fpa.mail.s827309.fsnavigation.view1");
    return prefs;
}
}
