package org.hercworks.app;

import java.io.File;

import org.hercworks.app.ctrl.dbaview.DbaFileOpenerController;
import org.hercworks.app.main.AppConfig;
import org.hercworks.app.view.dba.impl.DBAFileOpener;
import org.hercworks.app.view.dba.impl.DBAFileOpener.OpenMode;

public class TestDialog {

	public static void main(String[] args) {

		AppConfig.getConfig().debugConfig();
		DBAFileOpener open = new DBAFileOpener(new DbaFileOpenerController() {
			
			@Override
			public void processFileChoice(File dbaFile, File dplFile) {
				// TODO Auto-generated method stub
				
			}
		}, OpenMode.DBA_ONLY);
		open.init();
		
		open.pack();
		open.setVisible(true);
	}
}
