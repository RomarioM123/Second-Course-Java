package ua.khpi.oop.momot03;
import java.util.Scanner;

public class HelperClass {

	public void outputText(StringBuilder line)
	{
		System.out.println(line);
	}
	
	public String inputText()
	{
		Scanner scan = new Scanner(System.in);
		return scan.nextLine();
	}
	
	public void task(StringBuilder processedText)
	{
		int index = 0;
		boolean stop = false;
		
		System.out.print("Enter line to insert: ");
		Scanner sc = new Scanner(System.in);
		String lineToInsert = sc.nextLine();
		
		System.out.print("Enter the end of word: ");
		String endOfWord = sc.next();
		
		int lengthOfInsertedText = lineToInsert.length();
		
		while(!stop)
		{
			index = processedText.indexOf(endOfWord, index+1);
			
			if(index == -1) 
			{
				stop = true;
			}
			else
			{
				index++;
				
				if(processedText.charAt(index) == ' ' || processedText.charAt(index) == '.' || processedText.charAt(index) == ',' || processedText.charAt(index) == '!' || processedText.charAt(index) == ':'|| processedText.charAt(index) == ';' || processedText.charAt(index) == '?')
				{
					processedText.insert(index,lineToInsert);
					index += lengthOfInsertedText;
				}
			}
		}
	}

}
