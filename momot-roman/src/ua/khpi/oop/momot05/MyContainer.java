package ua.khpi.oop.momot05;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyContainer {
	private String[] array;
	private int size;
	
	public String toString()
	{
		StringBuilder string = new StringBuilder();
		
		for(int i = 0; i < size; i++)
			string.append(array[i] + " ");
		
		return string.toString();
	}
	
	public void add(String string)
	{
		String[] newArray = new String[size+1];
		
		for (int i = 0; i < size; i++) 
			newArray[i] = array[i];
		
		size++;
		newArray[size - 1] = string;
		array = newArray;
	}
	
	public void clear()
	{
		for(int i = 0; i < size; i++)
			array[i] = null;
		
		size = 0;
		
	}
	
	public boolean remove(String string)
	{
		boolean result = false;
		int position = 0;
		
		for (int i = 0; i < size; i++) 
			if(array[i].equals(string))
			{
				result = true;
				position = i;
				break;
			}
		
		if(result)
		{
			String[] newArray = new String[size-1];
			
			for (int i = 0; i < position; i++)
				newArray[i] = array[i];
			for (int i = position; i+1 < size; i++)
				newArray[i]=array[i+1];
			
			size--;
			array=newArray;
		}
		
		return result;
	}
	
	public Object[] toArray()
	{
		Object[] object = new Object[size];
		
		for (int i = 0; i < size; i++)
			object[i]=array[i];
		
		return object;
	}
	
	public int size()
	{
		return size;
	}
	
	public boolean contains(String string)
	{
		for (int i = 0; i < size; i++)
			if (array[i].equals(string))
				return true;
		
		return false;
	}
	
	public String getLine(int index)
	{
		return array[index];
	}
	
	public boolean containsAll(MyContainer container)
	{
		boolean result = false;
		
		for (int i = 0; i < size; i++) 
		{
			result = false;
			
			for (int j = 0; j < container.size(); j++)
			{
				if(array[i].equals(container.getLine(j)))
				{
					result = true;
					break;
				}
			}
			
			if(!result)
			{
				return false;
			}
			
		}
		
		return result;
	}
	
	public MyContainer(String... strings)
	{
		if(strings.length > 0)
		{
			size = strings.length;
			array = new String[size];
			
			for (int i = 0; i < size; i++) 
				array[i]=strings[i];
		}
	}
	
	public MyIterator<String> getIterator()
	{
		return new MyIterator<String>();
	}
	
	private class MyIterator<String> implements Iterator {
		int index;

		@Override public boolean hasNext()
		{
			if(index < size)
				return true;
			else
				return false;
		}
		
		@Override public Object next()
		{
			if(index==size)
				throw new NoSuchElementException();
			
			return array[index++];
		}
		
		@Override public void remove()
		{
			MyContainer.this.remove(array[--index]);
		}
	}
}


