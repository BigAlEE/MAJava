package week1;
import stanford.karel.*;

public class KarelDefendsDemocracy extends SuperKarel {
	
	/* Project One for Merit America
	   Completed By: Alfred Hughes
	   Date: 04/10/2021
	   Purpose: To look for any hanging chads on the Voter Card that 
	            are not in a column with a Center Marker.  If Chads are
	            found, thay are to be removed and then move to the next
	            approperiate column.
	 */
	
	

	/* 
	 * Start of the program. Entering into the first column and looking
       to see if there is a marker. If there is, Karel will move on, 
       otherwise he will look for the Hanging Chads.	
	*/
	public void run() {
		move();
		lookMarker();
		
	}
	/* 
	 * Method used to determine whether Karel will move on to the next
	 * column, or look for chads.
	 */
	
	private void lookMarker() {
		if(beepersPresent()) {
			nextColumn();
		}else {
			lookChads();
		}
	}
	
	/* 
	 * If the center marker (beeper) is found, then Karel will move to 
	 * the next column while a watching out for the end of the Voter Card 
	 * so that he does not run into it.  All the while looking for Center
	 * Markers 
	 */
	
	private void nextColumn() {
		move();
		if(frontIsClear()) {
			move();
			lookMarker();
		}
		
	}
	
	/* 
	 * If Karel see no center Marker, he will exam the column for chads.
	 * He will then move on to the next column.
	 */
	
	private void lookChads() {
		turnLeft();
		getChads();
		getChads();
		turnRight();
		nextColumn();
	}
	
	/* 
	 * If Karel finds any chads while traversing to column, he will pick
	 * them up and place them in his beeper bag.
	 */
	
	private void getChads() {
		move();
		while(beepersPresent()) {
			pickBeeper();
		}
		turnAround();
		move();
	}
}