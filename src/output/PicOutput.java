package output;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class PicOutput {

	public void picOutputASCII(BufferedImage img, String url) {

		PrintWriter pw = null;
		String[] asciiCodes = new String[] {
			"$", "@", "B", "%", "&", "W", "M", "#", "*", "o", "a", "h", "k", "b", "d",
				"p", "q", "w", "m", "Z", "O", "0", "Q", "L", "C", "J", "U", "Y", "X", "z", 
				"c", "1", "{", "}", "[", "]", "?", "-", "+", "~", "<", ">", "i", "!", "I",
				";", ":", ",", ",", "^", "`", "'", "." 
		};

		try {
			pw = new PrintWriter(new FileWriter((url), false));
		} catch (IOException e) {
			e.printStackTrace();
		}

		float codeRange = 255.0f / asciiCodes.length;

		for (int row = 0; row < img.getHeight(); row++) {
			for (int col = 0; col < img.getWidth(); col++) {
				
				Color color = new Color(img.getRGB(col, row));

				double grayScaleValue = color.getRed() * 0.21 + color.getGreen() * 0.72 + color.getBlue() * 0.07;

				int index = (int) (grayScaleValue / codeRange);

				pw.print(asciiCodes[index]);
				pw.flush();
				pw.flush();
			}

			pw.println("");
			pw.flush();
			pw.flush();
		}
	}
}
