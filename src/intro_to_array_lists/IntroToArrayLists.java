package intro_to_array_lists;

import java.util.ArrayList;

public class IntroToArrayLists {
	public static void main(String[] args) {
		//1. Create an array list of Strings
		ArrayList<String>names = new ArrayList<String>();
		//   Don't forget to import the ArrayList class
		
		//2. Add five Strings to your list
		names.add("Aaron Rodgers");
		names.add("Mesut Ozil");
		names.add("Stephen Curry");
		names.add("Alexis Sanchez");
		names.add("Clay Matthews");
		
		//3. Print all the Strings using a standard for-loop
		for (int i = 0; i < names.size(); i++) {
			System.out.println(names.get(i));
		}
		
		//4. Print all the Strings using a for-each loop
		for(String name : names) {
			System.out.println(names);
		}
		
		//5. Print only the even numbered elements in the list.
		for (int i = 0; i < names.size(); i=i+2) {
			System.out.println(names.get(i));
		}
		
		//6. Print all the Strings in reverse order.
		for (int i = names.size() -1; i > -1; i--) {
			System.out.println(names.get(i));
		}
		
		//7. Print only the Strings that have the letter 'e' in them.
		for (int i = 0; i < names.size(); i++) {
			String currentName = names.get(i);
			if(currentName.contains("e")) {
				System.out.println(currentName);
			}
		}
	}
}
