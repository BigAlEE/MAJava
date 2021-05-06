package week4;

import acm.program.*;

public class SecondLargest extends ConsoleProgram{
	
	private static final int SENTINEL = 0;
	
	public void run() {
		
		println ("In order to find the largest and the second largest in a sequence of ");
		println ("entered numbers, the user needs to input at least 2 numbers and to exit ");
		println ("simply enter 0.");
		
		int largest = -1;
		int secondLargest = -1;
		
		while (true) {
			int testNumber = readInt("Enter Number: ");
			if (testNumber == 0) {
				break;
			}
			if (testNumber > largest) {
				secondLargest = largest;
				largest = testNumber;
			} else if (testNumber > secondLargest) {
				secondLargest = testNumber;
			}
		}
		
		println("The largest number input: " + largest);
		println("The second largest number input: " + secondLargest);
	}

}
