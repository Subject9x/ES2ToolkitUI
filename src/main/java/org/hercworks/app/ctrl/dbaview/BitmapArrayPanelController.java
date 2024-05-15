package org.hercworks.app.ctrl.dbaview;

import java.awt.image.BufferedImage;

import org.hercworks.app.view.dba.BitmapArrayPanelView;

public interface BitmapArrayPanelController {

	public void updateBitmapArrayView(BitmapArrayPanelView view);
	
	public void updateBitmapArrayImages(BitmapArrayPanelView view, BufferedImage[] newImages);
}
