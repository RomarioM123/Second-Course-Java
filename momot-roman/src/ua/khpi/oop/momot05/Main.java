package ua.khpi.oop.momot05;
import java.util.Iterator;

public class Main {

	public static void main(String[] args) {
		MyContainer array = new MyContainer("Hello", "My name is Roma", "I'm 18 years old.");
		Iterator<String> it = array.getIterator();
		String line;
		
		System.out.println("Output array using while():");
		while(it.hasNext())
		{
			line = it.next();
			System.out.println(line);
		}
		
		System.out.println("\nAdding new element");
		array.add("I like bananas.");
		System.out.println("\nOutput array using for:");
		it = array.getIterator();
		for(int i = 1;it.hasNext();i++)
		{
			line = it.next();
			System.out.println(i + ". " + line);
		}
		
		System.out.print("\nTrying to find line \"My name is Roma\": " + array.contains("My name is Roma"));
		
		System.out.println("\n\nArray contains all lines of data from other array: " + array.containsAll(new MyContainer("Hello", "I like bananas.", "My name is Roma", "I'm 18 years old.", "Today is friday")));
		
		System.out.println("\nSize of array: " + array.size() + "\nDeleting one element");
		array.remove("I like bananas.");
		System.out.println("Size of array: " + array.size() + "\n");

		System.out.println("Terminating the program.");
		array.clear();
	}

}

