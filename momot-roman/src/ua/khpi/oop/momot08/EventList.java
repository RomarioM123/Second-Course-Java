package ua.khpi.oop.momot08;

public class EventList {
	private int size = 0;
	Event[] array = new Event[size];
	
	
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}

	public void addEl(Event event)
	{
		Event[] newArray = new Event[size+1];
		for (int i = 0; i < size; i++) {
			newArray[i] = array[i];
		}
		
		newArray[size] = event;
		size++;
		array = newArray;
	}
	public void deleteEl(int position)
	{
		if(size != 0)
		{
			Event[] newArray = new Event[size-1];
			for (int i = 0; i < position-1; i++) {
				newArray[i] = array[i];
			}
			for (int i = position-1, j = position; j < size; i++, j++) {
				newArray[i] = array[j];
			}
			
			size--;
			array = newArray;
		}
		else
		{
			System.out.println("Array is empty");
		}
	}
}
