package org.hercworks.app.ctrl.dbaview;

import org.hercworks.app.model.dbaview.DbaViewModel;
import org.hercworks.app.view.dba.DbaView;

public interface DbaViewController {

	
	
	public void setDbaViewModel(DbaViewModel model);
	public void setDbaView(DbaView view);
	public void updateDbaView(DbaView view);
}
