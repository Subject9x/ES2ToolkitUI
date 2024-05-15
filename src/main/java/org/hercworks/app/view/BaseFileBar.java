package org.hercworks.app.view;

import java.util.List;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

/**
 * Base File Menu bar for any application frame.
 * @author roohr
 */
public class BaseFileBar extends JMenuBar{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4613028287954061626L;
	private JMenu fileMenu = new JMenu("File");
	
	
	public BaseFileBar(JMenuItem[] fileItems, List<JMenu> addlMenus) {
		
		for(JMenuItem j : fileItems) {
			fileMenu.add(j);
		}
		
		JMenuItem exit = new JMenuItem("Exit");
		fileMenu.add(exit);
		
		add(fileMenu);
	}
}
