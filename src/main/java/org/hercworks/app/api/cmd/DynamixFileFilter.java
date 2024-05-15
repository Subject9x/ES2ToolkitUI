package org.hercworks.app.api.cmd;

import java.io.File;

import javax.swing.filechooser.FileFilter;

import org.hercworks.voln.FileType;

public class DynamixFileFilter extends FileFilter{

	private FileType type;
	
	public DynamixFileFilter(FileType fileType) {
		this.type = fileType;
	}
	
	@Override
	public boolean accept(File f) {
		if(f == null) {
			return false;
		}
		if(f.isDirectory()) {
			return true;
		}
		if(f.getPath().toLowerCase().contains("." + type.val().toLowerCase())) {
			return true;
		}
		return false;
	}

	@Override
	public String getDescription() {
		return "." + type.val();
	}
	
	public FileType getFileType() {
		return this.type;
	}
}
