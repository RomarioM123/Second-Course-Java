package ua.khpi.oop.momot04;
import java.util.Scanner;

public class HelperClass {	
	public void OutputProcessedText(StringBuilder line)
	{
		System.out.println(line);
	}
	
	public String InputProcessedText()
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
