package org.hercworks.app.view.dba.impl;

import java.awt.FlowLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.border.EtchedBorder;

import org.hercworks.app.ctrl.dbaview.BitmapArrayPanelController;
import org.hercworks.app.view.dba.BitmapArrayPanelView;

public class BitmapArrayPanel extends JPanel implements  BitmapArrayPanelView, MouseListener{
	
	private BitmapArrayPanelController controller;
	
	public void init() {
		setDoubleBuffered(true);
	}
	
	public BitmapArrayPanel(BitmapArrayPanelController controller) {
		super();
		setBitmapArrayPanelController(controller);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
//		controller.frameSelected(((BitmapPanel)e.getSource()).getFrameId());
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		((BitmapPanel)e.getSource()).setBorder(new EtchedBorder(EtchedBorder.RAISED));
	}

	@Override
	public void mouseExited(MouseEvent e) {
		((BitmapPanel)e.getSource()).setBorder(null);
	}
	
	//CONTROLLER BINDING
	@Override
	public JPanel getTopPanel() {
		return this;
	}

	@Override
	public void updatePanelArray(BufferedImage[] newImages, int scale) {
		removeAll();

		for(int i=0; i < newImages.length; i++) {
			BufferedImage img = newImages[i];
			
			BitmapPanel bitmapPanel = new BitmapPanel();
			bitmapPanel.setFrameId(i);
			bitmapPanel.setupImage(img, scale);
			
			bitmapPanel.addMouseListener(this);
			
			add(bitmapPanel);
		}
		setLayout(new FlowLayout());
		getParent().update(getParent().getGraphics());
//		SwingUtilities.invokeLater(new Runnable() {
//			@Override
//			public void run() {
//				for(int i=0; i < newImages.length; i++) {
//					BufferedImage img = newImages[i];
//					
//					BitmapPanel bitmapPanel = new BitmapPanel();
//					bitmapPanel.setFrameId(i);
//					bitmapPanel.setupImage(img, 4);
//					
//					bitmapPanel.addMouseListener(this);
//					
//					add(bitmapPanel);
//				}
//				setLayout(new FlowLayout());
//				getParent().repaint();
//			}
//		});
	}
	@Override
	public int getSelectedFrame() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setBitmapArrayPanelController(BitmapArrayPanelController controller) {
		this.controller = controller;
	}

}
