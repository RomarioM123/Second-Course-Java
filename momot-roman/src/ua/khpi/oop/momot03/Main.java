package ua.khpi.oop.momot03;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		HelperClass help = new HelperClass();
		Scanner scan = new Scanner(System.in);
		
		System.out.print("Enter processed text: ");
		StringBuilder inputText = new StringBuilder(help.inputText());
		
		System.out.print("\nProcessed text: ");
		help.outputText(inputText);
		
		help.task(inputText);
		
		System.out.print("Result:\t\t");
		help.outputText(inputText);
		
		scan.close();
	}

}

