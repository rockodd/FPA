package de.bht.fpa.mail.s827309.fsnavigation;

import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.Viewer;

public class NsNavigationContentProvider implements ITreeContentProvider {
		// hier muss unsere Baumstruktur in die des ITreeCOntentProvider gecastet werden.
	
	// Einfüge Content Provider stellt innere FIlestruktur dar
	// stellt eigentliche Baumstruktur zur verfügung
	@Override
	public void dispose() {
	}

	@Override
	public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
	}

	@Override
	public Object[] getElements(Object inputElement) {
		return getChildren(inputElement);
	}

	@Override
	public Object[] getChildren(Object parentElement) {
		return ((FileTreeItem) parentElement).getChildren().toArray();
	}

	@Override
	public Object getParent(Object element) {
		return null;
	}

	@Override
	public boolean hasChildren(Object element) {
		return ((FileTreeItem) element).hasChildren();
	}

}