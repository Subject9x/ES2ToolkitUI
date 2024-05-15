package org.hercworks.app.view.dba.impl;

import java.awt.GridLayout;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class EditorPanel extends JPanel{

	
	private FileInfoPanel fileInfo;
	
	private void init() {
		setLayout(new GridLayout(2, 1));
		fileInfo = new FileInfoPanel();
		add(fileInfo);
	}
	
	public EditorPanel() {
		super();
		init();
	}
	
	class FileInfoPanel extends JPanel{

		private JLabel filePath;
		private JLabel dplPath;
		
		private void init() {
			setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
			
			add(new JLabel("File:"));
			filePath = new JLabel("");
			add(filePath);
			
			add(new JLabel("Palette:"));
			dplPath = new JLabel("");
			add(dplPath);
		}
		
		public FileInfoPanel() {
			super();
			init();
		}
		public void setFilePath(String filePath) {
			this.filePath.setText(filePath);
		}

		public void setDplPath(String dplPath) {
			this.dplPath.setText(dplPath);
		}

		public String getFilePath() {
			return filePath.getText();
		}

		public String getDplPath() {
			return dplPath.getText();
		}
		
	}
	
	public FileInfoPanel getFileInfo() {
		return fileInfo;
	}
}
