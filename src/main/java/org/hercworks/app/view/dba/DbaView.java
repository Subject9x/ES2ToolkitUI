package org.hercworks.app.view.dba;

import org.hercworks.app.ctrl.dbaview.DbaViewController;

public interface DbaView {

	public void loadNewFile(String filePath, String dplPath);
	
	public void setDbaViewController(DbaViewController controller);
	
}
