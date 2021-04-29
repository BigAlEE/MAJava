package week3;

import acm.program.ConsoleProgram;

public class AddCommasToNumberStrings extends ConsoleProgram {
	
	private String addCommasToNumericString (String digits) {
		
		String results = "";
		int counter = 0;
        for (int i = digits.length()-1; i >= 0 ; i--) {
            char ch = digits.charAt(i);
            results = ch + results;
            counter++;
             if (counter % 3 == 0){
                 results = "," + results;
             }
        }    
		
        return results;
	}
	
	public void run() {
		
		while (true) {
			
			String digits = readLine("Enter a numeric string: ");
			if (digits.length() == 0) break;
			println(addCommasToNumericString (digits));
		}

	}
	
	
	
}
