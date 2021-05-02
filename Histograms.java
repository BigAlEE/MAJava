package week4;

import acm.program.*;
import acm.util.*;
import java.io.*;

public class Histograms extends ConsoleProgram {
	
	public void run() {
		initHistogram();
		getScoresHistogram();
		printHistogram();
		
		}
	
	private void initHistogram() {
		histogramArray = new int[11];
		for (int i = 0; i < 11; i++) {
			histogramArray[i] = 0;
		}
	}
	
	private void getScoresHistogram() {
		try {
			BufferedReader rd = new BufferedReader (new FileReader(DATA_FILE));
			while (true) {
				
				String dataPoints = rd.readLine();
				if (dataPoints == null) break;
				int score = Integer.parseInt(dataPoints);
				if (score < 0 || score > 100) {
					throw new ErrorException ("Score out of bounds!");
					
				} else {
					int range = score / 10;
					histogramArray[range]++;					
				}
			}
			rd.close();
		} catch (IOException ex) {
			throw new ErrorException (ex);
		}
		
	}
	
	private void printHistogram() {
		for (int range = 0; range <= 10; range++) {
			String label;
			switch (range) {
				case 0: label = "00-09"; break;
				case 10: label = "  100"; break;
				default: label = (10 * range) + "=" + (10 * range + 9);
						break;
			}
			String stars = createStars (histogramArray[range]);
			println(label + ": " + stars);
		}
	}
	
	private String createStars(int n) {
		
		String stars = "";
		for (int i = 0; i < n; i++) {
			stars += "*";			
		}
		return stars;
	}
	
	private int[] histogramArray;
	private static final String DATA_FILE = "MidtermScores.txt";
}
