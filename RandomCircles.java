package week2;

/*
 * Merit America Java Program
 * Name: Al Hughes Date: 04/18/2021
 * Week #2 3rd Program assignment Random Circles
 * Tech Squad B
 * 
 */

//import acm.graphics.GOval;
//import acm.program.GraphicsProgram;

import acm.program.*;
import acm.graphics.*;
import acm.util.*;


public class RandomCircles extends GraphicsProgram {
	
	/*
	 * Class variables and instances for the program 
	 * using the givens for the program
	 */
	
	private static final double MINIMUM_RADII = 5;
	private static final double MAXIMUM_RADII = 50;
	private static final int NUM_CIRCLES = 10;
	
	private RandomGenerator rgen = RandomGenerator.getInstance();
	
	public void run() {
		
		int i = 0;
		
		while(i < NUM_CIRCLES) {
			
			double r = rgen.nextDouble(MINIMUM_RADII, MAXIMUM_RADII);
			double x = rgen.nextDouble(0, getWidth() - (2 * r));
			double y = rgen.nextDouble(0, getHeight() - (2 * r));
			
			
			GOval circles = new GOval(x, y, 2 * r, 2 * r);
			circles.setFilled(true);
			circles.setFillColor(rgen.nextColor());
			add(circles);
			
			i++;
		}
		
				
	}
	

}
