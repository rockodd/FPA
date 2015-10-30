package de.bht.fpa.mail.s827309.fsnavigation;

import java.io.File;
import java.util.List;
import java.util.ArrayList;

import org.eclipse.swt.graphics.Image;

import de.bht.fpa.mail.s000000.common.mail.model.IMessageTreeItem;

public class FolderItem extends FileTreeItem {

	public FolderItem(File file) {
		super(file);
	}
	
	@Override
	public Image getImage() {
		return Activator.imageDescriptorFromPlugin(Activator.PLUGIN_ID,"icons/folder.png").createImage();
	}
	
	@Override
	public boolean hasChildren() {
		// FOlde rkann Children haben
		return file.list() != null; // lässt sich alle Elemente geben die nicht null sind
	}
	
	
	@Override
	public List<IMessageTreeItem> getChildren() {
		ArrayList<IMessageTreeItem> children = new ArrayList<IMessageTreeItem>();
		if (file == null || file.listFiles() == null || file.listFiles().length == 0)
			return children;
		
		for(File item : file.listFiles()){
			if (item.isDirectory()){
				children.add(new FolderItem(item));
			}else{
				children.add(new FileItem(item));
			}
		}
		
		return children;
	}
	
	
}