package week2;

/* Merit America Java Program
 * Name: Al Hughes Tech Squad B
 * Assignment Week 2 Program #2 RobotFace * 
 * imports used for the assignment.  The original import did not work. * 
 */

import acm.program.*;
import acm.graphics.*;
import java.awt.*;

public class RobotFace extends GraphicsProgram {
	
	// Class variables as stated in the assignment.  The values were random picks to test program
	
	private static final double HEAD_WIDTH = 400;
	private static final double HEAD_HEIGHT = 400;
	private static final double EYE_RADIUS = 40;
	private static final double MOUTH_WIDTH = 300;
	private static final double MOUTH_HEIGHT = 60;
	
	
	// Start the program.
	public void run() {
		
		// Center of screen method
		createCanvas(getWidth() / 2, getHeight() / 2);
		println(getWidth() / 2);
		println(getHeight() / 2);		
	}	
		// Putting the face on the canvas centered the screen with the facial methods
		private void createCanvas(double ctrXAxis, double ctrYAxis) {
			
			makeHead(ctrXAxis, ctrYAxis);
			makeLEye(ctrXAxis, ctrYAxis);
			makeREye(ctrXAxis, ctrYAxis);
			makeMouth(ctrXAxis, ctrYAxis);
		}
		
		// Defining the head on the screen		
		private void makeHead(double ctrXAxis, double ctrYAxis) {
			
			GRect head = new GRect(ctrXAxis - HEAD_WIDTH / 2, ctrYAxis - HEAD_HEIGHT / 2, 
					HEAD_WIDTH, HEAD_HEIGHT);			
			head.setFilled(true);
			head.setFillColor(Color.GRAY);
			add(head);
		}
		
		// Adding left eye to the head
		private void makeLEye(double ctrXAxis, double ctrYAxis) {
		
			GOval lEye = new GOval((ctrXAxis - HEAD_WIDTH / 4) - EYE_RADIUS, (ctrYAxis - HEAD_HEIGHT / 4) - EYE_RADIUS,
					EYE_RADIUS * 2, EYE_RADIUS * 2);
			lEye.setFilled(true);
			lEye.setFillColor(Color.RED);		
			add(lEye);
		}
		
		// Adding the right eye to the head
		private void makeREye(double ctrXAxis,double ctrYAxis) {
			 
			GOval rEye = new GOval((ctrXAxis + HEAD_WIDTH / 4) - EYE_RADIUS, (ctrYAxis - HEAD_HEIGHT / 4) - EYE_RADIUS,
					EYE_RADIUS * 2, EYE_RADIUS * 2);
			rEye.setFilled(true);
			rEye.setFillColor(Color.RED);		
			add(rEye);			
		}
		
		// Adding mouth to the face
		private void makeMouth(double ctrXAxis, double ctrYAxis) {
			
			GRect mouth = new GRect(ctrXAxis - MOUTH_WIDTH / 2, ctrYAxis + MOUTH_HEIGHT / 0.75, MOUTH_WIDTH, MOUTH_HEIGHT);
			mouth.setFilled(true);
			mouth.setFillColor(Color.WHITE);		
			add(mouth);
		}
		
		
}


