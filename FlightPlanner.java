package week5;

import acm.program.*;
import acm.io.*;

//import java.awt.List;
import java.io.*;
import java.util.*;



public class FlightPlanner extends ConsoleProgram {
	
	static String location;
	static String startLocation;
	
	static List <Route> routes;
	static List <Route> routesTaken;	
	static Set<String> places;
	static Scanner scan;	
	
	public void run () {
		
		setup();
		welcome();
		location = getStartLocation();
		tripPlanner();
		printSummary();
	
	}
	
	public static void printSummary() {
		System.out.println ("Your round trip is:  ");
		for (Route r : routesTaken) {
			System.out.println ("  "r.getStart() + " -> " + r.getEnd());
		}
		System.out.println ("Thanks!");
	}
	
	public static void tripPlanner() {
		while (true) {
			System.out.print("Where would you like to go from ");
			System.out.println (location + "?");
			for (Route r : routes) {
				if (r.getStart().equals(location)) {
					System.out.println ("  " + r.getEnd());
				}
			}
			location = pickValidRoute();
			if (location.equals(startLocation)) {
				return;
			}
					
		}
		
	}
	
	public static String pickValidRoute() {
		while (true) {
			
			String dest = scan.nextLine();
			for (Route r : routes) {
				if (r.getStart().equals(location)) {
					if (dest.equals(r.getEnd())) {
						routesTaken.add(r);
						return dest;
					}
				}
			}
			System.out.println("Invalid Entry, try again.");
		}
		
	}
	
	
	public static String getStartLocation() {
		while (true) {
			System.out.println ("Enter starting location:  ");
			String s = scan.nextLine();
			if (places.contains(s)) {
				startLocation = s;
				return s;
				
			}
			System.out.println("Invalid entry, try again!");
			
		}
		
	}
	
	public static void welcome() {
		System.out.println ("Welcome to the Flight Planner.");
		System.out.println("Here are the available cities to choose from: ");
		for (String s : places) {
			
			System.out.println ("  " + s);
		}
		
	}
	
	public static void setup() {
		routes = new ArrayList<>();
		routesTaken = new ArrayList<>();
		places = new HashSet<>();
		scan = new Scanner(System.in);
		
		String path = "FlightPaths.txt";
		
		try {
			File file = new File(path);
			Scanner reader = new Scanner (file);
			
			while (reader.hasNextLine()) {
				
				String data = reader.nextLine();
				if (data.equals("")) {
					continue;
				}
				String[] d = data.split(" -> ");
				
				places.add(d[0]);
				places.add(d[1]);
				routes.add(new Route(d[0], d[1]));
			}
			
		} catch (Exception e) {
			System.out.println("File not Found!");
			
		}
		
	
	}
	
}
