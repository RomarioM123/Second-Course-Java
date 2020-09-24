package ua.khpi.oop.momot03;
import java.util.Scanner;


public class HelperClass {

	public void OutputText(StringBuilder line)
	{
		System.out.println(line);
	}
	
	public String InputText()
	{
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter text: ");
		
		String inputText = scan.nextLine();
		
		scan.close();
		return inputText;
	}

}
