package org.hercworks.app.api;

import java.awt.image.BufferedImage;
import java.awt.image.WritableRaster;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.hercworks.core.data.file.dyn.DynamixBitmap;
import org.hercworks.core.data.file.dyn.DynamixBitmapArray;
import org.hercworks.core.data.file.dyn.DynamixPalette;
import org.hercworks.core.io.transform.common.DynamixBitmapArrayTransformer;
import org.hercworks.core.io.transform.common.DynamixPaletteTransformer;

public final class DBAUtil {

	private static DBAUtil INSTANCE;
	
	private DBAUtil() {}
	
	
	public static DBAUtil getInstance() {
		if(INSTANCE == null) {
			INSTANCE = new DBAUtil();
		}
		return INSTANCE;
	}
	
	public static DynamixBitmapArray loadDynamixBitmapArray(File file) throws FileNotFoundException, ClassCastException, IOException{
		DynamixBitmapArrayTransformer transformDba = new DynamixBitmapArrayTransformer();
		
		FileInputStream fizz = new FileInputStream(file);
		
		DynamixBitmapArray dba = (DynamixBitmapArray)transformDba.bytesToObject(fizz.readAllBytes());
		
		fizz.close();
		
		return dba;
	}
	
	public static DynamixPalette loadDynamixPalette(File file) throws FileNotFoundException, ClassCastException, IOException{
		DynamixPaletteTransformer transform = new DynamixPaletteTransformer();
		
		FileInputStream fizz = new FileInputStream(file);
	 
		DynamixPalette dpl = (DynamixPalette)transform.bytesToObject(fizz.readAllBytes());
		
		fizz.close();

		return dpl;
	}
	
	public static BufferedImage[] generateImages(DynamixBitmapArray dba, DynamixPalette dpl, int scale) {
		
		BufferedImage[] images = new BufferedImage[dba.getImages().size()];
	
		int cnt = 0;
		for(DynamixBitmap dbm : dba.getImages()) {
			
			BufferedImage generate = null;
			try {
				generate = new BufferedImage(dbm.getCols(), dbm.getRows(), BufferedImage.TYPE_INT_ARGB);
				
			}
			catch(Exception e) {
				System.out.println(e.getMessage());
			}
			if(generate == null) {
				continue;
			}
			
			WritableRaster raster = (WritableRaster)generate.getRaster();
			int[] rasterData = new int[dbm.getCols()*dbm.getRows()*4];
			
			int i = 0;
			for(int r=0; r < dbm.getRows(); r++) {
				for(int c=0; c < dbm.getCols(); c++) {
					if(i >= dbm.getImageData().length()) {
						break;
					}
					int cell = (r * dbm.getCols()) + c;
					int idx = Byte.toUnsignedInt(dbm.getImageData().array()[cell]);
					
					try {
						rasterData[i] = dpl.colorAt(idx).getColor().getRGB();// + palette.colorAt(idx).getColor().getTransparency();
//						System.out.println("PIXEL("+c+","+r+")=" + (byte)idx);
					}
					catch(NullPointerException nope) {
						System.out.println("PIXEL("+c+","+r+")=" + (byte)idx + "~MISSING"); 
					}
					catch(Exception e) {
						System.out.println("ERROR - " + e.getMessage());
					}
					i++;
				}
			}
			raster.setDataElements(0, 0, dbm.getCols(), dbm.getRows(), rasterData);
			images[cnt] = generate;
			cnt++;
		}
		return images;
	}
	
	
	
}
