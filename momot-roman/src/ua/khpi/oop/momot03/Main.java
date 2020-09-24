package ua.khpi.oop.momot03;

public class Main {

	public static void main(String[] args) {
		HelperClass help = new HelperClass();
		
		StringBuilder inputText = new StringBuilder(help.InputText());
		String lineToInsert = "INSERTED LINE";
		String endOfWord = "b";
		int lengthOfInsertedText = lineToInsert.length();
		
		System.out.print("\nProcessed text: ");
		help.OutputText(inputText);
		
		int index = 0;
		for (int i = 0; i >= 0; i++) 
		{
			index = inputText.indexOf(endOfWord, index+1);
			
			if(index == -1)
				i=-2;
			else
			{
				index++;
				
				if(inputText.charAt(index) == ' ' || inputText.charAt(index) == '.' || inputText.charAt(index) == ',' || inputText.charAt(index) == '!' || inputText.charAt(index) == ':'|| inputText.charAt(index) == ';' || inputText.charAt(index) == '?')
				{
					inputText.insert(index,lineToInsert);
					index += lengthOfInsertedText;
				}
				
			}
			
		}
		
		System.out.print("Result:\t\t");
		help.OutputText(inputText);

	}

}

