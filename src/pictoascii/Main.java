package pictoascii;

import java.awt.image.BufferedImage;

import loader.PicLoader;
import output.PicOutput;

public class Main {

	public static void main(String args[]) {

		PicLoader pl = new PicLoader();
		BufferedImage img = pl.loadPic("./pics/pic.png");

		PicOutput po = new PicOutput();
		po.picOutputASCII(img, "./output/o.txt");

		System.out.println("Convert successfully");
	}
}
