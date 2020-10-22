package ua.khpi.oop.momot06;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.NotSerializableException;
import java.util.Iterator;
import java.util.Scanner;
import task6.HelperClass;

public class Main {

	public static void main(String[] args) {
		MyContainer array = new MyContainer();
		Scanner scan = new Scanner(System.in); 
		int number;
		boolean stop = false;
		String choise;
		String data;
		
		while(stop != true)
		{
			System.out.println("Enter your choise");
			System.out.println("1. Add data");
			System.out.println("2. Output data");
			System.out.println("3. Delete element");
			System.out.println("4. Find element");
			System.out.println("5. Personal task");
			System.out.println("6. Sort data");
			System.out.println("7. Compare arrays");
			System.out.println("8. Serialize data");
			System.out.println("9. Deserialize data");
			System.out.println("10. Terminate program");
			System.out.println("=====================");
			System.out.print("Your choise: ");
			choise = scan.nextLine();
			
			switch(choise) {
			case "1":
				System.out.print("\nEnter your processed text: ");
				array.add(scan.nextLine());
				System.out.print("\n");
				
				break;
				
			case "2":
				if(array.size() != 0)
				{
					System.out.println("\nData in array:");
					for (int i = 0; i < array.size(); i++) 
					{
						System.out.println(i+1 + ". " + array.getLine(i));
					}
					System.out.print("\n");
				}
				else
				{
					System.out.println("\nArray is empty.\n");
				}
				
				
				
				break;
				
			case "3":
				if(array.size() != 0)
				{
					System.out.print("\nEnter line to delete from array: ");
					array.remove(scan.nextLine());
				}
				else
				{
					System.out.println("\nArray is empty.\n");
				}
				
				break;
				
			case "4":
				if(array.size() != 0)
				{
					System.out.print("Enter line to find in array: ");
					
					if(array.contains(scan.nextLine()))
					{
						System.out.println("\nLine is found.\n");
					}
					else
					{
						System.out.println("\nLine not found.\n");
					}
				}
				else
				{
					System.out.println("\nArray is empty.\n");
				}
				
				
				break;
				
			case "5":
				if(array.size() != 0)
				{
					for (int i = 0; i < array.size(); i++) 
					{
						HelperClass.task(array.getLine(i));
						System.out.print("\n");
					}
				}
				else
				{
					System.out.println("\nArray is empty.\n");
				}
				
				break;
				
			case "6":
				if(array.size() != 0)
				{
					array.sort();
				}
				else
				{
					System.out.println("\nArray is empty.\n");
				}
				
				System.out.println("\nArray sorted\n");
				
				break;
				
			case "7":
				if(array.size() != 0)
				{
					System.out.print("Enter number of lines in compared array: ");
					number = scan.nextInt();
					
					if(number >= 0)
					{
						MyContainer arrayToCompare = new MyContainer();
						System.out.print("Enter your processed text: ");
						
						for (int i = 0; i < number; i++) 
						{
							System.out.print(i + ". ");
							arrayToCompare.add(scan.nextLine());
							System.out.println( );
						}
					}
				}
				else
				{
					System.out.println("\nArray is empty.\n");
				}
				
				break;
				
			case "8":
				if(array.size() != 0)
				{
					System.out.print("\nEnter file name: ");
					data = scan.nextLine();
					if(data.indexOf(".ser") == -1)
						data += ".ser";
					
					try
					{
						FileOutputStream file = new FileOutputStream(data);
						ObjectOutputStream serial = new ObjectOutputStream(file);
						serial.writeObject(array);
						serial.close();
						System.out.println("\nData serialized.\n");
					}
					catch(Exception ex)
					{
						System.out.println("\n" + ex.getMessage() + "\n");
					}
				}
				else
				{
					System.out.println("\nArray is empty.\n");
				}
				
				break;
				
			case "9":
				System.out.print("\nEnter file name: ");
				data = scan.nextLine();
				if(data.indexOf(".ser") == -1)
					data += ".ser";
				
				try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(data)))
		        {
					array = (MyContainer)ois.readObject();
					ois.close();
		        }
		        catch(Exception ex){
		             
		            System.out.println("\n" + ex.getMessage() + "\n");
		        }
				break;
				
			case "10":
				stop = true;
				break;
				
			default:
				System.out.println("Error. Wrong command.\n");
				break;
			}
		}

		System.out.println("\nTerminating the program.");
		array.clear();
		scan.close();
	}
	
}

