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
		System.out.println("����� ��������: ����� �����, ʲ�-119�.");
		System.out.println("������ �����. ϳ��� ������� ����� ������, �� ���������� ������� ��������, �������� ���������� �����. ������� ���������� ����� �� ���������.");
		System.out.println("������� �������, ��� ������ ��������: task.");
		System.out.println("� ���� ���������� ����������� ����������� ������� �� �������� ���� �����. ���� �� ����� �������, �� ���������� �������.");
		System.out.println();
	}

}
