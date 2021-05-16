package week5;

import acm.graphics.*;
import acm.program.*;
import java.util.*;
import java.awt.event.*;
import javax.swing.*;
//import java.lang.*;

public class BoxDiagram extends GraphicsProgram {
	
	public void init () {
		
		contents = new HashMap<String, GObject>();
		createGUI();
		addActionListeners();
		addMouseListeners();
		
	}
		
	private void createGUI () {			
		
		add(new JLabel ("Name"), SOUTH);
		textField = new JTextField(30);
		textField.addActionListener(this);
		addButton = new JButton("Add");
		removeButton = new JButton ("Remove");
		clearButton = new JButton ("Clear");
		add(textField, SOUTH);
		add(addButton, SOUTH);
		add(removeButton, SOUTH);
		add(clearButton, SOUTH);
		addActionListeners();
		//GRect rect = new GRect (getWidth() - 60 / 2, getHeight() - 25 /2, BOX_WIDTH, BOX_HEIGHT);
		//add(rect);
		//addMouseListeners();
		
	}
	
	private void createBox(String name) {
		
		GCompound box = new GCompound();
		GRect outLine = new GRect (BOX_WIDTH, BOX_HEIGHT);
		GLabel label = new GLabel (name);
		box.add(outLine, -BOX_WIDTH / 2, -BOX_HEIGHT / 2);
		box.add(label, -label.getWidth() / 2, -label.getHeight() / 2);
		add(box, getWidth() / 2, getHeight() / 2);
		//add(label, -label.getWidth(), -label.getHeight());
		contents.put(name, box);
	}
	
	private void removeBox(String name) {
		
		GObject obj = contents.get(name);
		if (obj != null) {
			remove(obj);
		}
	}
	
	private void removeContents() {
		
		Iterator <String> iterator = contents.keySet().iterator();
		while (iterator.hasNext()) {
			removeBox (iterator.next());
		}
		contents.clear();
	}
	
	public void actionPerformed(ActionEvent e) {
		
		Object source = e.getSource();
		if (source == addButton || source == textField) {
			createBox(textField.getText());
			println("Add Button Pressed");
		} else if (source == removeButton) {
			removeBox (textField.getText());
			println("Remove Button Pressed");
		} else if (source == clearButton) {
			removeContents();
			println("Clear Button Pressed");
		}
		
	}
	
	public void mousePressed(MouseEvent e) {
		
		last = new GPoint(e.getPoint());
		currentObject = getElementAt (last);
	}
	
	public void mouseClicked(MouseEvent e) {
		
		if (currentObject != null) {
			currentObject.sendToFront();
		}
	}
	
	public void mouseDragged (MouseEvent e) {
		if (currentObject != null) {
			currentObject.move(e.getX() - last.getX(), e.getY() - last.getY());
			last = new GPoint(e.getPoint());
		}
	}
	
	private static final double BOX_WIDTH = 120;
	private static final double BOX_HEIGHT = 50;
	
	private GObject currentObject;
	private GPoint last;
	private HashMap<String, GObject> contents;
	private JTextField textField;
	private JButton addButton;
	private JButton clearButton;
	private JButton removeButton;

}
