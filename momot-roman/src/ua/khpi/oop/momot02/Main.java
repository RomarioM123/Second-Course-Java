package ua.khpi.oop.momot02;

public class Main {
	static int value;
	static int length;
	static int minimalDigit;
	
	public static void main(String[] args) 
	{		
		System.out.println("| Number  |  Positions\t|");
		
		for (int i = 0; i < 10; i++) 
		{
			value = (int)(Math.random()*(99999-0))+0;
			System.out.print("| " + value + "\t  | ");
			FindLengthOfNumber();
			FindDigitPosition();
		}
		
	}
	
	static void FindLengthOfNumber()
	{
		int temp = value / 10;
		int tempDigit;
		minimalDigit = value % 10;
		length = 1;
		
		while(temp > 0)
		{
			tempDigit = temp % 10;
			if(minimalDigit > tempDigit)
				minimalDigit = tempDigit;
			
			temp /= 10;
			length++;
		}
		
	}
	
	static void FindDigitPosition()
	{
		int temp = value;
		int tempDigit;
		
		temp = value;
		System.out.print("    ");
        for (int i = 1; i <= length; i++) 
        {
        	tempDigit = temp % 10;
			if(minimalDigit == tempDigit)
				System.out.print(i + " ");
			
			temp /= 10;
		}
        System.out.print("\t|\n");
	}

}
