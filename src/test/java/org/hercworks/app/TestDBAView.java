package org.hercworks.app;

import org.hercworks.app.main.AppConfig;
import org.hercworks.app.view.DBAViewerMain;

public class TestDBAView {


	private static AppConfig appConfig;
	
	public static void main(String[] args) {
		appConfig = AppConfig.getConfig();
		appConfig.debugConfig();
		
		DBAViewerMain editor = new DBAViewerMain();
		editor.run();
	}

}
