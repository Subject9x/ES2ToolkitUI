package org.hercworks.app;

import org.hercworks.app.main.AppConfig;

public class TestArmEditor {


	private static AppConfig appConfig;
	
	public static void main(String[] args) {
		appConfig = AppConfig.getConfig();
		appConfig.debugConfig();
//		
//		EditorMain editor = new EditorMain();
//		editor.run();
	}

}
