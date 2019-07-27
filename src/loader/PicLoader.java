package loader;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class PicLoader {

	String _url;
	BufferedImage img = null;


	public BufferedImage loadPic(String url) {
		try {
			img = ImageIO.read(new File(url));

		} catch (IOException e) {
			System.out.println("Fehler aufgetreten: " + e);
		}

		return img;
	}
}
