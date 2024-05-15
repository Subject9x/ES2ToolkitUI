package org.hercworks.app.view.dba.impl;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.JFrame;

import org.hercworks.app.api.DBAUtil;
import org.hercworks.app.ctrl.dbaview.BitmapArrayPanelController;
import org.hercworks.app.ctrl.dbaview.DbaFileOpenerController;
import org.hercworks.app.ctrl.dbaview.DbaViewController;
import org.hercworks.app.ctrl.dbaview.MenuBarFileController;
import org.hercworks.app.view.dba.BitmapArrayPanelView;
import org.hercworks.app.view.dba.DbaView;
import org.hercworks.core.data.file.dyn.DynamixBitmapArray;
import org.hercworks.core.data.file.dyn.DynamixPalette;

public class DBAViewer extends JFrame implements DbaView, BitmapArrayPanelController, MenuBarFileController, DbaFileOpenerController{
	
	private static final long serialVersionUID = -8134785486607880723L;

	private Dimension frameSize;
	
	//components
	private DBAToolbar toolBar;
	private BitmapArrayPanel bitmapView;
	private EditorPanel editorPanel;
	
	//controllers
	private DbaViewController controller;
	
	
	public void init() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		
		frameSize = new Dimension(1620, 1080);
		setMinimumSize(new Dimension(800, 600));
		setSize(frameSize);

		ViewerMenuBar mb = new ViewerMenuBar(this);
		mb.init();
		setJMenuBar(mb);

		toolBar = new DBAToolbar(null);
		toolBar.init(1);
		add(toolBar, BorderLayout.NORTH);
		
		editorPanel = new EditorPanel();
		add(editorPanel, BorderLayout.WEST);
		
		bitmapView = new BitmapArrayPanel(this);
		add(bitmapView, BorderLayout.CENTER);
		
		setLocation(new Point(100, 50));
	}	
	
	public BitmapArrayPanel getBitmapView() {
		return bitmapView;
	}

	public void setBitmapView(BitmapArrayPanel bitmapView) {
		this.bitmapView = bitmapView;
	}

	public DBAViewer(DbaViewController controller) {
		super();
		setDbaViewController(controller);
	}
	public DBAViewer(String title, DbaViewController controller) {
		super(title);
		setDbaViewController(controller);
	}

	@Override
	public void loadNewFile(String filePath, String dplPath) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setDbaViewController(DbaViewController controller) {
		this.controller = controller;
	}

	
	//BitmapArrayPanel controller binding
	@Override
	public void updateBitmapArrayView(BitmapArrayPanelView view) {
	}

	@Override
	public void updateBitmapArrayImages(BitmapArrayPanelView view, BufferedImage[] newImages) {
		
		view.updatePanelArray(newImages, 1);
	}

	//MenuBar -> File
	@Override
	public void menuNewFile() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void menuOpenFile() {
		DBAFileOpener fileOpener = new DBAFileOpener(this, DBAFileOpener.OpenMode.BOTH);
		fileOpener.init();
		
		fileOpener.pack();
		fileOpener.setLocation(getLocation().x + getWidth()/2 - fileOpener.getWidth()/2, 
				getLocation().y + getHeight()/2 - fileOpener.getHeight()/2);
		fileOpener.setVisible(true);
	}

	@Override
	public void menuCloseFile() {
		editorPanel.getFileInfo().setFilePath("<none>");
		editorPanel.getFileInfo().setDplPath("<none>");
		updateBitmapArrayImages(bitmapView, new BufferedImage[0]);
	}

	@Override
	public void menuExportFile() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void menuReplaceDpl() {
		DBAFileOpener fileOpener = new DBAFileOpener(this, DBAFileOpener.OpenMode.DPL_ONLY);
		fileOpener.init();
		
		fileOpener.pack();
		fileOpener.setLocation(getLocation().x + getWidth()/2 - fileOpener.getWidth()/2, 
				getLocation().y + getHeight()/2 - fileOpener.getHeight()/2);
		fileOpener.setVisible(true);
	}

	@Override
	public void menuExitApp() {
		System.exit(0);
	}

	
	//MenuBar -> File -> Open
	@Override
	public void processFileChoice(File dbaFile, File dplFile) {
		
		editorPanel.getFileInfo().setFilePath(dbaFile.getPath());
		editorPanel.getFileInfo().setDplPath(dplFile.getPath());
		
		BufferedImage[] images = null;
		try {
			DynamixBitmapArray dba = DBAUtil.loadDynamixBitmapArray(dbaFile);
			DynamixPalette dpl = DBAUtil.loadDynamixPalette(dplFile);
			if(dba != null && dpl != null) {
				images = DBAUtil.generateImages(dba, dpl, 1);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return;
		} catch (ClassCastException e) {
			e.printStackTrace();
			return;
		} catch (IOException e) {
			e.printStackTrace();
			return;
		}
		
		updateBitmapArrayImages(bitmapView, images);
	}
}

