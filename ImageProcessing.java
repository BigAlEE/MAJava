package week4;

import acm.graphics.*;
import acm.program.*;

public class ImageProcessing extends GraphicsProgram {
	
	public void run() {
		String image = readLine ("Please enter picture name to inlude file extension: " + " \r\n >> ");
		if (image.equals ("")) {
			println("File not found!!");
		}
		
		GImage picture = new GImage(image);
		add(flipHorizontal(picture));
	}
	
	private GImage flipHorizontal(GImage image) {
		int [][]array = image.getPixelArray();
		int width = array[0].length;
		int height = array.length;
		for (int row = 0; row < height; row++) {
			for (int p1 = 0; p1 < width / 2; p1++) {
				int p2 = width - p1 - 1;
				int temp = array[row][p1];
				array[row][p1] = array[row][p2];
				array[row][p2] = temp;
			}
		}
		return new GImage(array);
	}
	
}
