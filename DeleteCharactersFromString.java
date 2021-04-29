package week3;

import acm.program.ConsoleProgram;

public class DeleteCharactersFromString extends ConsoleProgram {
	
	public void run() {
		
		while (true) {
		
			String str = readLine ("Please add the word or sentence for editing: ");
			String stringChar = readLine ("Please enter one character to be removed: ");
			char ch = stringChar.charAt(0);
			if (str.length() == 0 && stringChar.charAt(ch) == 0) break;
			println (removeAllOccurrences(str , ch));
		}

	}
	
	public String removeAllOccurrences(String str, char ch) {
		String results = "";
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) != ch) {
				
				results += str.charAt(i);
				
			}
		}
		return results;
		
	}
	
}
