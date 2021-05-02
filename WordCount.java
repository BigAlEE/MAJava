package week4;

import acm.program.ConsoleProgram;
import java.io.*;

public class WordCount extends ConsoleProgram {
	
	public void run() {
		
		int chars = 0;
		int lines = 0;
		int words = 0;
		
		BufferedReader rd = openFileReader("File to be read: ");
		try {
			while (true) {
				String line = rd.readLine();
				if (line == null) break;
				chars += line.length();
				lines++;
				words += numWords(line);
			}
			rd.close();			
		} catch (IOException ex) {
			println("An IOExcetion has happened!");
		}
		
		println("Number of characters = " + chars);
		println("Number of lines = " + lines);
		println("Number of words = " + words);
	}

	private BufferedReader openFileReader (String prompt) {
		
		BufferedReader rd = null;
		while (rd == null) {
			try {
				String name = readLine (prompt);
				rd = new BufferedReader (new FileReader(name));
			} catch (IOException ex) {
				println("Bad File Name!");
			}
			
		}
		
		return rd;
	}
	
	private int numWords(String line) {
		
		boolean numChars = false;
		int words = 0;
		for (int i = 0; i < line.length(); i++) {
			char ch = line.charAt(i);
			if (Character.isLetterOrDigit(ch)) {
				numChars = true;
			} else { 
				if (numChars) words++;
				numChars = false;
			
			}
		}
		
		if (numChars) words++;
		return words;
	}
}
