package ua.khpi.oop.momot01;

public class Main {
	public static void main(String[] args) {
		int recordBook = 0x0C1EC68; 		//i've used serial number of my student card
		long phoneNumber = 380951146301L;
		int twoDoubleNumbers = 0b11111;		//31
		int twoHexNumbers = 04631;
		int module = 13%26+1;				//variant 14
		char letter = (char) (64 + module);
		
		countOddEven(recordBook);
		countOddEven(phoneNumber);
		countOddEven(twoDoubleNumbers);
		countOddEven(twoHexNumbers);
		countOddEven(module);
		countOddEven(letter);
		
		System.out.println("============");
		
		countOnes(recordBook);
		countOnes(phoneNumber);
		countOnes(twoDoubleNumbers);
		countOnes(twoHexNumbers);
		countOnes(module);
		countOnes(letter);

	}
	
	static void countOddEven(long value)
	{
		int oddResult = 0, evenResult = 0;
		
		System.out.println("Value to count: " + value);
		
		while(value > 0)
		{
			if(value%2==0)
				evenResult++;
			else
				oddResult++;
			
			value /= 10;
		}
		
		System.out.println("Number of even digits: " + evenResult);
		System.out.println("Number of odd digits: " + oddResult + "\n");
	}
	
	static void countOnes(long value)
	{
		long bit;   
        int result = 0;
        
        System.out.println("\nInput number: " + value);
        System.out.print("Number in binary system: ");
         
        while(value !=0 ) 
        {   
        	bit = value%2;  
        	System.out.print(bit);
        	if(bit==1) result++;
        	value /= 2;  
        }  
        
        System.out.println("\nNumber of ones: " + result);
	}
}

