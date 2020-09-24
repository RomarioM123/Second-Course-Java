package ua.khpi.oop.momot04;
import java.util.Scanner;

public class Main {
	public static HelperClass help = new HelperClass();
	public static boolean debugFlag = false;
	public static StringBuilder text = new StringBuilder("$$$");
	public static StringBuilder insertedText = new StringBuilder("$$$");
	public static StringBuilder result = new StringBuilder("$$$");
	
	public static void main(String[] args) {
		
		for(String str: args)
		{
			if(str.equals("-h") || str.equals("-help")) help.HelpInfo();
			if(str.equals("-d") || str.equals("-debug")) debugFlag = true;
		}
		
		Main.menu();
		
	}
	
	static void menu()
	{
		Scanner scan = new Scanner(System.in); 
		String choise;
		boolean stop = false;
		
		while(stop != true)
		{
			System.out.println("What to do?");
			System.out.println("1. Enter the data");
			System.out.println("2. Perfom a task");
			System.out.println("3. End program");
			System.out.println("=================");
			System.out.print("Your choise: ");
			
			choise = scan.nextLine();
			
			switch(choise) {
			case "1":
				
				System.out.print("Enter processed text: ");
				text = new StringBuilder(help.InputProcessedText());
				System.out.print("Enter inserted text: ");
				insertedText = new StringBuilder(help.InputProcessedText());
				System.out.println(" ");
				break;
				
			case "2":
				StringBuilder notFilledText = new StringBuilder("$$$");
				
				if (text.toString().equals(notFilledText.toString()) || insertedText.toString().equals(notFilledText.toString()))
					System.out.println("Error. Enter the data before.\n");
				else
					task();	
				
				break;
				
			case "3":
				stop = true;
				break;
				
			default:
				System.out.println("Error. Wrong command.\n");
				break;
			}
		}
		
		scan.close();
	}
	
	static void task()
	{
		String endOfWord = "b";
		
		System.out.print("\nProcessed text: ");
		help.OutputProcessedText(text);
		System.out.println( );
		
		int lengthOfInsertedText = insertedText.length();
		
		if(debugFlag)
		{
			System.out.println("Length of processed text: " + text.length());
			System.out.println("Length of inserted text: " + insertedText.length());
			System.out.print("\n\n");
		}
		
		int index = 0;
		for (int i = 0; i >= 0; i++) 
		{
			
			
			index = text.indexOf(endOfWord, index+1);
			
			if(index == -1)
			{
				i=-2;
				if(debugFlag) System.out.println("No more matches to insert text.");
			}	
			else
			{
				index++;
				
				if(text.charAt(index) == ' ' || text.charAt(index) == '.' || text.charAt(index) == ',' || text.charAt(index) == '!' || text.charAt(index) == ':'|| text.charAt(index) == ';' || text.charAt(index) == '?')
				{
					if(debugFlag) System.out.println("Index of place to insert: " + index);
					
					text.insert(index,insertedText);
					index += lengthOfInsertedText;
				}
				
			}
			
			if(debugFlag) System.out.print("Text in progress: " + text + "\n\n");
			
		}
		
		System.out.print("Result:\t\t");
		help.OutputProcessedText(text);
	}

}