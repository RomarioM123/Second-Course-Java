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
		
		String inputText = scan.nextLine();
		
		return inputText;
	}
	
	public void mainTask(StringBuilder processedText, StringBuilder lineToInsert, String endOfWord)
	{
		int lengthOfInsertedText = lineToInsert.length();
		int index = 0;
		boolean stop = false;
		
		while(!stop)
		{
			index = processedText.indexOf(endOfWord, index+1);
			
			if(index == -1) stop = true;
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
