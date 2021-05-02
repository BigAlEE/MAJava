package week4;

import acm.program.ConsoleProgram;
import java.util.*;

public class UniqueNames extends ConsoleProgram {
	
	public void run() {
		
		ArrayList<String> list = new ArrayList<String>();
		while (true) {
			
			String name = readLine("Enter name: ");
			if (name.equals("")) break;
			if (!list.contains(name)) {
				list.add(name);
			}
		}
		println("Name list contains: ");
		printList(list);
	}
	private void printList(ArrayList list) {
		for (int i = 0; i < list.size(); i++) {
			println(list.get(i));
		}
	}
}
