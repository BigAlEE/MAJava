package week2;

/* Name: Al Hughes Tech Squad B 4/19/2021
 * Merit America Java Program Week2 Assignment #2
 * Fibonacci Sequence without using an array.
 */

import acm.program.*;

public class Fibonacci extends ConsoleProgram {					// Setting up the class

	
	public void run() {											// Method to run program
		
		// Setting the first two numbers in the sequence 
		int fib0 = 0;
		int fib1 = 1;		
		
		// Loop to calculate the total of the Fibonacci Sequence 
		while(fib0 <= MAX_VALUE) {			
					
			int fibTotal = fib1 + fib0;
			
			println(fib0);
			
			fib0 = fib1;
			fib1 = fibTotal;
				
		}

	}
	
	/* This is the class instance that cannot be changed. */
	
	private static final int MAX_VALUE = 10000;
}
