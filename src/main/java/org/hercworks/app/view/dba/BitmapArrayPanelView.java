package org.hercworks.app.view.dba;

import java.awt.image.BufferedImage;

import javax.swing.JPanel;

import org.hercworks.app.ctrl.dbaview.BitmapArrayPanelController;

public interface BitmapArrayPanelView {
	
	public JPanel getTopPanel();
	public int getSelectedFrame();
	public void updatePanelArray(BufferedImage[] newImages, int scale);
	public void setBitmapArrayPanelController(BitmapArrayPanelController controller);
	
}
