package org.hercworks.app.model.dbaview.impl;

import java.awt.image.BufferedImage;

import org.hercworks.app.model.dbaview.DbaViewModel;
import org.hercworks.core.data.file.dyn.DynamixBitmapArray;
import org.hercworks.core.data.file.dyn.DynamixPalette;

public class DbaViewModelEntity implements DbaViewModel {

	private String filePath;
	private String dplPath;
	private DynamixBitmapArray dba;
	private DynamixPalette dpl;
	private BufferedImage[] images;
	
	
	public DbaViewModelEntity() {}
	
	@Override
	public void setFilePath(String path) {
		this.filePath = path;
	}

	@Override
	public String getFilePath() {
		return this.filePath;
	}

	@Override
	public void setDPLPath(String dplPath) {
		this.dplPath = dplPath;
	}

	@Override
	public String getDPLPath() {
		return this.dplPath;
	}

	@Override
	public void setDynamixBitmap(DynamixBitmapArray dba) {
		this.dba = dba;
	}

	@Override
	public DynamixBitmapArray getDynamixBitmapArr() {
		return this.dba;
	}

	@Override
	public void setDynamixPalette(DynamixPalette dpl) {
		this.dpl = dpl;		
	}

	@Override
	public DynamixPalette getDynamixPalette() {
		return this.dpl;
	}

	@Override
	public void setBufferedImages(BufferedImage[] images) {
		this.images = images;
	}

	@Override
	public BufferedImage[] getBufferedImages() {
		return images;
	}
}
