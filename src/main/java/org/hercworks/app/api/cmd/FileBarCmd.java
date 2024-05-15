package org.hercworks.app.api.cmd;

public enum FileBarCmd {

	FILE_STUB("FILE/"),
	FILE_NEW("FILE/NEW/"),
	FILE_SAVE("FILE/SAVE/"),
	FILE_OPEN("FILE/OPEN/"),
	FILE_CLOSE("FILE/CLOSE/"),
	FILE_EXPORT("FILE/EXPORT/"),
	FILE_EXIT("FILE/EXIT/");
	
	
	private String cmd;
	
	private FileBarCmd(String cmd) {
		this.cmd = cmd;
	}
	
	public String cmdString() {
		return this.cmd;
	}
	
}
