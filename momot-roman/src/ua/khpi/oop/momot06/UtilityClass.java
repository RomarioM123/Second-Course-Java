package ua.khpi.oop.momot06;

import java.util.Scanner;

public class UtilityClass {
	
	public void mainTask(MyContainer container)
	{
		char endOfWord = '$';
		StringBuilder insertedText = new StringBuilder();
		Scanner scan = new Scanner(System.in);
		StringBuilder temp = new StringBuilder();
		int lengthOfInsertedText;
		int index = 0;
		boolean stop = false;
		
		System.out.print("\nEnter inserted text: ");
		insertedText = new StringBuilder(scan.nextLine());
		lengthOfInsertedText = insertedText.length();
		
		System.out.print("Enter end of word: ");
		temp = new StringBuilder(scan.next());
		endOfWord = temp.charAt(0);
		
		for(int i = 0; i < container.size(); i++)
		{
			stop = false;
			temp = new StringBuilder(container.getLine(i)); 
			while(!stop)
			{
				
				index = temp.indexOf(String.valueOf(endOfWord), index+1);
				
				if(index == -1) 
					stop = true;
				else
				{
					index++;
					if(index >= temp.length() || temp.charAt(index) == ' ' || temp.charAt(index) == '.' || temp.charAt(index) == ',' || temp.charAt(index) == '!' || temp.charAt(index) == ':'|| temp.charAt(index) == ';' || temp.charAt(index) == '?')
					{
						
						temp.insert(index,insertedText);
						index += lengthOfInsertedText;
					}
				}
			}
			
			System.out.println(i+1 + ". " + temp);
		}
		
		System.out.print("\n");
	}
}
