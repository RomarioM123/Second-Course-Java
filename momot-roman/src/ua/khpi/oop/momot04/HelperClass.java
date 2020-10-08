package ua.khpi.oop.momot04;
import java.util.Scanner;

public class HelperClass {
	public StringBuilder mainTask(StringBuilder processedText, StringBuilder lineToInsert, String endOfWord, boolean debugFlag)
	{
		StringBuilder result = new StringBuilder(processedText);
		int lengthOfInsertedText = lineToInsert.length();
		int index = 0;
		boolean stop = false;
		
		if(debugFlag)
		{
			System.out.println("\nLength of processed text: " + processedText.length());
			System.out.println("Length of inserted text: " + lineToInsert.length());
			System.out.print("\n\n");
		}
		
		while(!stop)
		{
			index = result.indexOf(endOfWord, index+1);
			
			if(index == -1)
			{
				stop = true;
				if(debugFlag) System.out.println("No more matches to insert text.");
			}
			else
			{
				index++;
				
				if(result.charAt(index) == ' ' || result.charAt(index) == '.' || result.charAt(index) == ',' || result.charAt(index) == '!' || result.charAt(index) == ':'|| result.charAt(index) == ';' || result.charAt(index) == '?')
				{
					if(debugFlag) System.out.println("Index of place to insert: " + index);
					
					result.insert(index,lineToInsert);
					index += lengthOfInsertedText;
				}
			}
			
			if(debugFlag) System.out.print("Text in progress: " + result + "\n\n");
		}
		
		return result;
	}
	
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
	
	public void HelpInfo()
	{
		System.out.println("Автор програми: Момот Роман, КІТ-119а.");
		System.out.println("Ввести текст. Після кожного слова тексту, що закінчується заданим символом, вставити зазначений рядок. Вивести початковий текст та результат.");
		System.out.println("Основна функція, яка виконує завдання: task.");
		System.out.println("У циклі виконується знаходження необхідного символу та перевірка кінця слова. Якщо всі умови виконані, то виконується вставка.");
		System.out.println();
	}

}
