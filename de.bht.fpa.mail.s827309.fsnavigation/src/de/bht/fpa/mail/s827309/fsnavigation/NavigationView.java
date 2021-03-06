package de.bht.fpa.mail.s827309.fsnavigation;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.part.ViewPart;

import de.bht.fpa.mail.s000000.common.mail.model.IMessageTreeItem;
import de.bht.fpa.mail.s000000.common.mail.model.Message;
import de.bht.fpa.mail.s827309.fsnavigation.handlers.SingletonFile;

public class NavigationView extends ViewPart implements
		ISelectionChangedListener, Observer {
	
	private TreeViewer viewer;

	@Override
	public void createPartControl(Composite parent) {

		viewer = new TreeViewer(parent);

		viewer.setContentProvider(new NsNavigationContentProvider());
		//
		viewer.setLabelProvider(new FsNavigationLabel());

		viewer.setInput(new FolderItem(	new File(System.getProperty("user.home"))));
		// System.getProperty macht aus String Pfad!
		
		//viewer.addSelectionChangedListener(this);

		//String path = System.getProperty("user.home");
		//IMessageTreeItem in = new FolderItem(new File(path));
		//BaseDirSubject.getInstance().addObserver(this);
		//viewer.setInput(in);
		
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

		//List<Message> messages = ti.getMessages();
	}

	@Override
	public void update(Observable arg0, Object givenPath) {
		// Methode wird von Observer aufgerufen
		String path = (String) givenPath;
		
		// pr�fen ob Pfad ausgew�hlt wurde
		if (path != null){
			viewer.setInput(new FolderItem(new File(path)));
		}
		
	}
	
}