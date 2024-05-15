package org.hercworks.app.view;

import org.hercworks.app.ctrl.dbaview.DbaViewController;
import org.hercworks.app.ctrl.dbaview.impl.DbaViewCtrl;
import org.hercworks.app.main.AppConfig;
import org.hercworks.app.model.dbaview.impl.DbaViewModelEntity;
import org.hercworks.app.view.dba.impl.DBAViewer;

public class DBAViewerMain {

	private DBAViewer viewer;
	
	public DBAViewerMain() {}
	
	public void run() {
		
		DbaViewController viewCtrl = new DbaViewCtrl(new DbaViewModelEntity(), null);
		
		viewer = new DBAViewer(viewCtrl);
		viewCtrl.setDbaView(viewer);
		viewer.init();
		viewer.update(viewer.getGraphics());
		viewer.setVisible(true);
		viewer.repaint();
		AppConfig config = AppConfig.getConfig();
		
	}
}
