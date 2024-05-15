package org.hercworks.app.view.dba.impl;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;

import org.hercworks.app.ctrl.dbaview.impl.DbaToolbarController;

public class DBAToolbar extends JPanel implements ActionListener {

	private static String SCALE_UP = "+";
	private static String SCALE_DN = "-";
	
	private JButton imageUp;
	private JButton imageDn;
	private JLabel scalarSize;
	
	private DbaToolbarController controller;
	private int scalarValue;

	public void init(int scaleStart) {
		scalarValue = scaleStart;
		setLayout(new FlowLayout());
		
		add(new JLabel("Scale"));
		scalarSize = new JLabel(String.valueOf(scalarValue));
		add(scalarSize);
		
		imageUp = new JButton(SCALE_UP);
		imageUp.setMinimumSize(new Dimension(64,64));
		imageUp.setBorder(new BevelBorder(BevelBorder.RAISED));
		imageUp.addActionListener(this);
		
		imageDn = new JButton(SCALE_DN);
		imageDn.setMinimumSize(new Dimension(64,64));
		imageDn.setBorder(new BevelBorder(BevelBorder.RAISED));
		imageDn.addActionListener(this);
		
		add(imageUp);
		add(imageDn);
	}
	
	public DBAToolbar(DbaToolbarController controller) {
		super();
		this.controller = controller;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println(e.getActionCommand());
		if(e.getActionCommand().equals(SCALE_DN)) {
			scalarValue -= 1;
			if(scalarValue == 0) {
				scalarValue = -1;
			}
		}
		else if(e.getActionCommand().equals(SCALE_UP)) {
			scalarValue += 1;
			if(scalarValue == 0) {
				scalarValue = 1;
			}
		}
		scalarSize.setText(String.valueOf(scalarValue));
//		controller.adjustImageScalar(scalarValue);
	}
}
