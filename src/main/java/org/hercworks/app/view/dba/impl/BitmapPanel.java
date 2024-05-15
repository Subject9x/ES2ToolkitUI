package org.hercworks.app.view.dba.impl;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class BitmapPanel extends JPanel implements ImageObserver {

	private static final long serialVersionUID = -8091149275281431795L;
	
	//components
	private JLabel frameIdLbl;
	private JLabel frameSizeValLbl;
	private JLabel imageLbl;
	
	//
	private int frameId;
	private BufferedImage img;
	private BufferedImage displayImg;
	
	public BitmapPanel() {
		super();
		setLayout(new BorderLayout());
		setBackground(Color.BLUE);
		
		JPanel info = new JPanel();
			JLabel frameLbl = new JLabel("Frame ");
			frameIdLbl = new JLabel();
			
			info.add(frameLbl);
			info.add(frameIdLbl);
			
			JLabel frameSizeLbl = new JLabel("size:");
			frameSizeValLbl = new JLabel();
			
			info.add(frameSizeLbl);
			info.add(frameSizeValLbl);
			info.setLayout(new FlowLayout());
		
		imageLbl = new JLabel();
		
		add(info, BorderLayout.NORTH);
		
		add(imageLbl, BorderLayout.CENTER);
	}
	
	public void setupImage(BufferedImage img, int scalar) {
		setImg(displayImg);
		displayImg = img;
		try {
			displayImg = resizeImage(img, img.getWidth() * scalar, img.getHeight() * scalar);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Dimension imgSize = new Dimension(displayImg.getWidth(), displayImg.getHeight());
		imageLbl.setIcon(new ImageIcon(displayImg));
		imageLbl.setMinimumSize(imgSize);
		imageLbl.setSize(imgSize);
		imageLbl.setMaximumSize(imgSize);
		
		frameSizeValLbl.setText(String.valueOf(img.getWidth()) + "x" + String.valueOf(img.getHeight()));
		
		repaint();
	}

	public int getFrameId() {
		return frameId;
	}

	public BufferedImage getImg() {
		return img;
	}

	public void setFrameId(int frameId) {
		this.frameId = frameId;
		frameIdLbl.setText(String.valueOf(frameId));
	}

	public void setImg(BufferedImage img) {
		this.img = img;
	}
	
	private BufferedImage resizeImage(BufferedImage originalImage, int targetWidth, int targetHeight) throws IOException {
	    BufferedImage resizedImage = new BufferedImage(targetWidth, targetHeight, BufferedImage.TYPE_INT_RGB);
	    Graphics2D graphics2D = resizedImage.createGraphics();
	    graphics2D.drawImage(originalImage, 0, 0, targetWidth, targetHeight, null);
	    graphics2D.dispose();
	    return resizedImage;
	}
}
