package core;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Loader {
	/* 
	 * === Helper functions for the rest of the game. ===
	 * quickLoad(String p) returns an image based on a path
	 */
	
	public BufferedImage quickLoad(String p) {
		BufferedImage b = null;
		try {		
			b = ImageIO.read(getClass().getClassLoader().getResource(p + ".png"));
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		return b;
	}

}

