package org.hercworks.app.model.dbaview;

import java.awt.image.BufferedImage;

import org.hercworks.core.data.file.dyn.DynamixBitmapArray;
import org.hercworks.core.data.file.dyn.DynamixPalette;

public interface DbaViewModel {

	
	public void setFilePath(String path);
	public String getFilePath();
	public void setDPLPath(String dplPath);
	public String getDPLPath();

	public void setDynamixBitmap(DynamixBitmapArray dba);
	public DynamixBitmapArray getDynamixBitmapArr();
	
	public void setDynamixPalette(DynamixPalette dpl);
	public DynamixPalette getDynamixPalette();
	
	public void setBufferedImages(BufferedImage[] images);
	public BufferedImage[] getBufferedImages();
	
}
