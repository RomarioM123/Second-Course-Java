package ua.khpi.oop.momot04;
import java.util.Scanner;

public class Main {
	public static HelperClass help = new HelperClass();
	public static boolean debugFlag = false;
	public static StringBuilder text = new StringBuilder("$$$");
	public static StringBuilder insertedText = new StringBuilder("$$$");
	public static StringBuilder result = new StringBuilder("$$$");
	public static char endOfWord = '$';
	
	public static void main(String[] args) {
		
		for(String str: args)
		{
			if(str.equals("-h") || str.equals("-help")) help.HelpInfo();
			if(str.equals("-d") || str.equals("-debug")) debugFlag = true;
		}
		
		Main.menu();
		
	}
	
	public static void menu()
	{
		StringBuilder notFilledText = new StringBuilder("$$$");
		Scanner scan = new Scanner(System.in); 
		String temp;
		String choise;
		boolean stop = false;
		
		while(stop != true)
		{
			System.out.println("What to do?");
			System.out.println("1. Enter the data");
			System.out.println("2. Perfom a task");
			System.out.println("3. Output data");
			System.out.println("4. End program");
			System.out.println("=================");
			System.out.print("Your choise: ");
			
			choise = scan.nextLine();
			
			switch(choise) {
			case "1":
				
				System.out.print("\nEnter processed text: ");
				text = new StringBuilder(help.inputText());
				
				System.out.print("Enter inserted text: ");
				insertedText = new StringBuilder(help.inputText());
				
				System.out.print("Enter end of word: ");
				temp = help.inputText();
				endOfWord = temp.charAt(0);
				System.out.println( );
				
				if(!Character.isAlphabetic(endOfWord))
				{
					System.out.println("Error. You've entered not a character.");
					endOfWord = '$';
				}
				
				break;
				
			case "2":		
				if (text.toString().equals(notFilledText.toString()) || insertedText.toString().equals(notFilledText.toString()) || endOfWord == '$')
					System.out.println("Error. Enter the data before.\n");
				else
					result = help.mainTask(text, insertedText, Character.toString(endOfWord), debugFlag);	
				
				break;
			case "3":
				System.out.print("\nProcessed text: ");
				help.outputText(text);
				
				System.out.print("Text to instert: ");
				help.outputText(insertedText);
				
				System.out.print("End of word: ");
				help.outputText(new StringBuilder(Character.toString(endOfWord)));
				
				if(!(result.compareTo(notFilledText)==0))
				{
					System.out.print("Result: ");
					help.outputText(result);
				}
				System.out.println( );
				
				break;
				
			case "4":
				System.out.println("\nTerminating the program.");
				stop = true;
				break;
				
			default:
				System.out.println("Error. Wrong command.\n");
				break;
			}
		}
		
		scan.close();
	}

}