package week2;

/*
 * Merit America Java Program
 * Name: Al Hughes Date: 04/18/2021
 * Week #2 Program #4 Drawing Lines
 * 
 * Assisted by Programmer Ethan Vaughn
 * Friend and same church
 * Program compiles but does draw lines with
 * a mouse press and release after being 
 * dragged 
 * 
 */

//import acm.program.GraphicsProgram;

import acm.graphics.*;
import acm.program.*;
import java.awt.event.*;


public class DrawingLines extends GraphicsProgram {
	
	public void run() {
		line = new GLine(0, 0, 0, 0);
		addMouseListeners();
	}
	
	public void mousePressed(MouseEvent e) {
		
		double x = e.getX();
		double y = e.getY();
		
		GLine line = new GLine(x, y, x, y);
		add(line);
		
	}
	
	public void mouseDragged(MouseEvent e) {
		if (line == null) 
			return;
		double x = e.getX();
		double y = e.getY();
		//GLine line  = new GLine(x, y, x, y);
		line.setEndPoint(x, y);
		
	}
	GLine line;
}
