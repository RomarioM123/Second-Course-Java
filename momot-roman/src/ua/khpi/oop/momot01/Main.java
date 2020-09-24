package ua.khpi.oop.momot01;

public class Main {
	public static void main(String[] args) {
		int recordBook = 0x0C1EC68; 		//i've used serial number of my student card
		long phoneNumber = 380951146301L;
		int twoDoubleNumbers = 0b11111;		//31
		int twoHexNumbers = 04631;
		int module = 13%26+1;				//variant 14
		char letter = 'N';
		
		countOddEven(recordBook);
		countOddEven(phoneNumber);
		countOddEven(twoDoubleNumbers);
		countOddEven(twoHexNumbers);
		countOddEven(module);
		countOddEven(letter);
		
		String value1 = Integer.toBinaryString(recordBook);
		String value2 = Long.toBinaryString(phoneNumber);
		String value3 = Integer.toBinaryString(twoDoubleNumbers);
		String value4 = Integer.toBinaryString(twoHexNumbers);
		String value5 = Integer.toBinaryString(module);
		String value6 = Integer.toBinaryString(letter);
		
		countOnes(value1);
		countOnes(value2);
		countOnes(value3);
		countOnes(value4);
		countOnes(value5);
		countOnes(value6);

	}
	
	static void countOddEven(long value)
	{
		int oddResult = 0, evenResult = 0;
		
		System.out.println("Число для подсчёта: " + value);
		
		while(value > 0)
		{
			if(value%2==0)
				evenResult++;
			else
				oddResult++;
			
			value /= 10;
		}
		
		System.out.println("Количество чётных цифр: " + evenResult);
		System.out.println("Количество нечётных цифр: " + oddResult + "\n");
	}
	
	static void countOnes(String value)
	{
		int result = 0;
		long numberDouble = Long.parseLong(value, 2);
		
		for(int i = 0; i < value.length(); i++)
			if(value.charAt(i)== '1')
				result++;
		
		System.out.println("Входное число: " + numberDouble);
		System.out.println("Числов в двоичной системе: " + value);
		System.out.println("Количество единиц: " + result + "\n");
	}
}

