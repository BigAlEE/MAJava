package week4;

import acm.graphics.*;
import acm.program.*;
import java.awt.*;
import java.awt.event.*;

public class Frogger {
	
	private static final int SQSIZE = 75;
	private static final int NCOLS = 7;
	private static final int NROWS = 3;
	
	public static final int APPLICATION_Width = NCOLS * SQSIZE;
	public static final int APPLICATION_Height = NROWS * SQSIZE;
	
	private GImage frog;
	private double fx;
	private double fy;
	
	
	public void run() {
		frog = new GImage("frog.gif");
		fx = (NCOLS / 2 + 0.5) * SQSIZE;
		fy = (NROWS - 0.5) * SQSIZE;
		add (frog, fx - frog.getWidth() / 2, fy - frog.getHeight() / 2);
		
		addMouseListeners();		
	}
	
	public void mouseClicked(MouseEvent e) {
		double mx = e.getX();
		double my = e.getY();
		
		if (Math.abs(mx - fx) > Math.abs(my - fy)) {
			if (mx > fx) {
				moveFrog(SQSIZE, 0);
			} else {
				moveFrog (-SQSIZE, 0);
			}
			
		} else {
			if (my > fy) {
				moveFrog(0, SQSIZE);
				
			} else {
				moveFrog(0 , -SQSIZE);
			}
		}
		
	}
	
	private void moveFrog(double dx, double dy) {
		if (insideFroggerWorld(fx +dx, fy +dy)) {
			fx += dx;
			fy += dy;
			frog.move (dx, dy);
		}
		
	}
	
	
	private boolean insideFroggerWorld(double x, double y) {
		return (x >= 0 && x <= NCOLS * SQSIZE && y >= 0 && y <= NROWS * SQSIZE);
	}

}
