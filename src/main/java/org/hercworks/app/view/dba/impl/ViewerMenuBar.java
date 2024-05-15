package org.hercworks.app.view.dba.impl;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

import org.hercworks.app.ctrl.dbaview.MenuBarFileController;

public class ViewerMenuBar extends JMenuBar{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1318832155988569910L;
	
	private MenuBarFileController controller;
	
	private JMenu file;
	private JMenu edit;
	
	public void init() {
		file = add(MenuFile(this.controller));
		edit = add(MenuEdit());
	}
	
	public ViewerMenuBar(MenuBarFileController mbFileCtrl) {
		super();
		this.controller = mbFileCtrl;
	}
	
	//FILE MENU
	private JMenu MenuFile(MenuBarFileController mbFileCtrl) {
		
		JMenu fileMenu = new JMenu("File");
		
//		JMenuItem newFile = new JMenuItem("New .DBA");
//		newFile.addActionListener((e)->{mbFileCtrl.menuNewFile();});
		
		JMenuItem openFile = new JMenuItem("Open .DBA");
		openFile.addActionListener((e)->{mbFileCtrl.menuOpenFile();});
		
		JMenuItem closeFile = new JMenuItem("Close .DBA");
		closeFile.addActionListener((e)->{mbFileCtrl.menuCloseFile();});
		
//		JMenuItem exportFile = new JMenuItem("Export .DBA");
//		exportFile.addActionListener((e)->{mbFileCtrl.menuExportFile();});
		
//		JMenuItem replaceDPL = new JMenuItem("Replace .DPL");
//		replaceDPL.addActionListener((e)->{mbFileCtrl.menuReplaceDpl();});
		
		JMenuItem close = new JMenuItem("Exit");
		close.addActionListener((e)->{mbFileCtrl.menuExitApp();});
//		
//		fileMenu.add(newFile);
		fileMenu.add(openFile);
		fileMenu.add(closeFile);
//		fileMenu.add(exportFile);
//		fileMenu.add(replaceDPL);
		fileMenu.addSeparator();
		fileMenu.add(close);
		
		return fileMenu;
	}
	
	//EDIT MENU?
	private JMenu MenuEdit() {
		JMenu editMenu = new JMenu("Edit");
		
		
		return editMenu;
	}
	
	//return direct popupmenu component
	public JPopupMenu getFileMenu() {
		return file.getPopupMenu();
	}
	
	//return direct popupmenu component
	public JPopupMenu getEdiMenu() {
		return edit.getPopupMenu();
	}
}
