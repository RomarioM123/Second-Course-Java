package ua.khpi.oop.momot03;

public class Main {

	public static void main(String[] args) {
		HelperClass help = new HelperClass();
		
		System.out.print("Enter processed text: ");
		StringBuilder inputText = new StringBuilder(help.inputText());
		
		System.out.print("Enter inserted text: ");
		StringBuilder lineToInsert = new StringBuilder(help.inputText());
		String endOfWord = "b";
		
		
		
		System.out.print("\nProcessed text: ");
		help.outputText(inputText);
		
		help.mainTask(inputText, lineToInsert, endOfWord);
		
		System.out.print("Result:\t\t");
		help.outputText(inputText);

	}

}

