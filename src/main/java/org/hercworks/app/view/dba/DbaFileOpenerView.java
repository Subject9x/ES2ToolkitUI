package org.hercworks.app.view.dba;

import java.io.File;

import org.hercworks.app.view.dba.impl.DBAFileOpener.OpenMode;

public interface DbaFileOpenerView {

	
	public File getDBAFile();
	public File getDPLFile();
	public OpenMode getMode();
}
