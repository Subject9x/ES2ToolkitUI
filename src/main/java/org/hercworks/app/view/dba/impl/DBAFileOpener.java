package org.hercworks.app.view.dba.impl;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.hercworks.app.api.cmd.DynamixFileFilter;
import org.hercworks.app.ctrl.dbaview.DbaFileOpenerController;
import org.hercworks.app.main.AppConfig;
import org.hercworks.app.view.dba.DbaFileOpenerView;
import org.hercworks.voln.FileType;

public class DBAFileOpener extends JDialog implements DbaFileOpenerView, ActionListener{

	private static String OK_BUTTON = "Open";
	private static String CANCEL_BUTTON = "Cancel";
	public enum OpenMode{
		DBA_ONLY,
		DPL_ONLY,
		BOTH;
		private OpenMode() {}
		
	}
	
	private File dbaFile;
	private File dplFile;
	private OpenMode mode;
	
	private JPanel rootPanel;
	private JLabel alertMessage;
	private JTextField chooseDBAPath;
	private JTextField chooseDPLPath;
	
	private DbaFileOpenerController controller;
	
	public void init() {
		setTitle("Open .DBA");
		rootPanel = new JPanel();
		rootPanel.setLayout(new BorderLayout());
		
		JPanel alertBar = new JPanel();
			alertMessage = new JLabel();
			alertBar.add(alertMessage);
		rootPanel.add(alertMessage, BorderLayout.NORTH);
			
		JPanel fileInfo = new JPanel();
		fileInfo.setLayout(new GridLayout(2, 1));
				JPanel dbaFilePnl = new JPanel();
					JLabel dbaLbl = new JLabel(".DBA File");
					chooseDBAPath = new JTextField(null, 32);
					JButton btnDbaPick = new JButton("...");
					btnDbaPick.addActionListener((e)->{
						doFileChooseAction(FileType.DBA, AppConfig.getConfig().getAppPath() +"/");
					});
					
					dbaFilePnl.add(dbaLbl);
					dbaFilePnl.add(chooseDBAPath);
					dbaFilePnl.add(btnDbaPick);
				fileInfo.add(dbaFilePnl);
				dbaFilePnl.setVisible(getMode().equals(OpenMode.BOTH) || getMode().equals(OpenMode.DBA_ONLY));
			

				JPanel dplFilePnl = new JPanel();
					JLabel dplLbl = new JLabel(".DPL File");
					chooseDPLPath = new JTextField(null, 32);
					JButton btnDplPick = new JButton("...");
					btnDplPick.addActionListener((e)->{
						doFileChooseAction(FileType.DPL, AppConfig.getConfig().getAppPath() +"/");
					});
					
					dplFilePnl.add(dplLbl);
					dplFilePnl.add(chooseDPLPath);
					dplFilePnl.add(btnDplPick);
				fileInfo.add(dplFilePnl);
				dplFilePnl.setVisible(getMode().equals(OpenMode.BOTH) || getMode().equals(OpenMode.DPL_ONLY) );
		rootPanel.add(fileInfo, BorderLayout.CENTER);	

		JPanel buttonRow = new JPanel();
			JButton btnOk = new JButton(OK_BUTTON);
				btnOk.addActionListener(this);
			JButton btnCancel = new JButton(CANCEL_BUTTON);
				btnCancel.addActionListener(this);
			
			buttonRow.add(btnOk);
			buttonRow.add(btnCancel);
		rootPanel.add(buttonRow, BorderLayout.SOUTH);
		
		add(rootPanel);
		pack();
		setResizable(false);
	}
	
	public DBAFileOpener(DbaFileOpenerController controller, OpenMode mode) {
		super();
		this.controller = controller;
		this.mode = mode;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println(e.toString());
		if(e.getActionCommand().equals(CANCEL_BUTTON)) {
			dispose();
			return;
		}
		if(e.getActionCommand().equals(OK_BUTTON)) {
			String pathDba = chooseDBAPath.getText();
			String pathDpl = chooseDPLPath.getText();
			
			if(getMode().equals(OpenMode.BOTH) || getMode().equals(OpenMode.DBA_ONLY)) {
				if(pathDba == null || pathDba.equals("")) {				
					alertMessage.setText("Please select a .DBA file.");
					return;
				}
			}
			if(getMode().equals(OpenMode.BOTH) || getMode().equals(OpenMode.DPL_ONLY)) {
				if(pathDpl == null || pathDpl.equals("")) {				
					alertMessage.setText("Please select a .DPL file.");
					return;
				}
			}
			
			controller.processFileChoice(getDBAFile(), getDPLFile());
			dispose();
		}
	}
	
	//FileChoose dialog
	class DBAFilePicker extends JFileChooser{
		
		public DBAFilePicker(FileType dynFileType, String startPath) {
			super(startPath);
			setFileFilter(new DynamixFileFilter(dynFileType));
			setDragEnabled(false);
		}
		
		public FileType getFileType() {
			if(getFileFilter() instanceof DynamixFileFilter) {
				return ((DynamixFileFilter)getFileFilter()).getFileType();	
			}
			return null;
		}
	}
	
	//not controller related
	private void doFileChooseAction(FileType fileType, String startPath) {
	
		DBAFilePicker pick = new DBAFilePicker(fileType, startPath);
		int event = pick.showOpenDialog(this);
		
		if(event == JFileChooser.APPROVE_OPTION) {
			File f = pick.getSelectedFile();
			System.out.println(f.getPath());
			//TODO - could be abstracted to interface controller at some point.
			if(fileType.equals(FileType.DBA)) {
				chooseDBAPath.setText(f.getPath());
				this.dbaFile = f;
			}
			else if(fileType.equals(FileType.DPL)) {
				chooseDPLPath.setText(f.getPath());
				this.dplFile = f;
			}
		}
	}
	
	@Override
	public File getDBAFile() {
		return this.dbaFile;
	}

	@Override
	public File getDPLFile() {
		return this.dplFile;
	}
	
	@Override
	public OpenMode getMode() {
		return this.mode;
	}
}
