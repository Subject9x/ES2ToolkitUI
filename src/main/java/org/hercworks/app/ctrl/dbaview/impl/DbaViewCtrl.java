package org.hercworks.app.ctrl.dbaview.impl;

import org.hercworks.app.ctrl.dbaview.DbaViewController;
import org.hercworks.app.model.dbaview.DbaViewModel;
import org.hercworks.app.view.dba.DbaView;

public class DbaViewCtrl implements DbaViewController {

	private DbaViewModel model;
	private DbaView view;
	
	public DbaViewCtrl(DbaViewModel model, DbaView view) {
		setDbaViewModel(model);
		setDbaView(view);
	}
	
	@Override
	public void setDbaViewModel(DbaViewModel model) {
		this.model = model;
	}

	@Override
	public void setDbaView(DbaView view) {
		this.view = view;
	}

	@Override
	public void updateDbaView(DbaView view) {
		this.view = view;
	}

	
	
}
