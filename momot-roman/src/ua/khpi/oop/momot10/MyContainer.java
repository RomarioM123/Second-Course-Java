package ua.khpi.oop.momot10;

import java.io.Serializable;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyContainer<T> implements Iterable<T>, Serializable {
	public Node<T> head;
	private int size;
	
	private static final long serialVersionUID = -6153946567197878052L;
	
	public MyContainer() { 
		super(); 
	}

	public int getSize() { return size; }
	public void setSize(int size) { this.size = size; }
	public T getElement(int id) {
		if(id < 0 || id >= size) {
			System.out.println("Wrong id.");
			return null;
		}
		
		Node<T> temp = head;
		for(int i = 0; i < id; i++) {
			temp = temp.next;
		}
		return temp.element;
	}
	
	public void add(T el) {
		Node<T> temp = new Node<T>();
		
		if(head == null) {
			head = new Node<T>(el);
		}
		else {
			temp = head;
			while(temp.next != null) {
				temp = temp.next;
			}
			temp.next = new Node<T>(el);
		}
		size++;
	}
	
	public void delete(int id) {
		Node<T> temp = head;
		
		if(head != null) 
		{
			if(id == 0) {
				head = head.next;
			}
			else {
				for(int i = 0; i < id - 1; i++) {
					temp = temp.next;
				}
				
				if(temp.next != null) {
					temp.next = temp.next.next;
				}
				else {
					temp.next = null;
				}
			}
			
			size--;
		}
		else {
			System.out.println("Container is empty.");
		}
	}
	
	public void clear() {
		this.head = null;
		size = 0;
	}
	
	public Object[] toArray() {
		Object[] arr = new Object[size];
		for(int i = 0; i < size; i++) {
			arr[i] = getElement(i);
		}
		
		return arr;
	}
	
	public String toString() {
		StringBuilder str = new StringBuilder();
		for(T value : this) {
			str.append(value + "\n");
		}
		
		return str.toString();
	}
	
	public boolean checkExistance(T el) {
		for(T element : this) {
			if(element.equals(el)) {
				return true;
			}
		}
		
		return false;
	}
	
	public boolean isEmpty() {
		if(size == 0)
			return true;
		else
			return false;
	}
	
	@SuppressWarnings("unchecked")
	public void sort(Comparator<T> comp) {
		Object[] arr = this.toArray();
		Object temp;
		boolean pr;
		
		do {
			pr = false;
			for(int i = 0; i < size - 1; i++) {
				if(comp.compare((T)arr[i], (T)arr[i+1]) == 1) {
					temp = arr[i];
					arr[i] = arr[i+1];
					arr[i+1] = temp;
					pr = true;
				}
			}
		}while(pr == true);
		
		this.clear();
		for (Object i : arr) {
			this.add((T) i);
		}
	}
	
	public Iterator<T> iterator(){
		return new Iterator<T>() {
			int index = 0;
			boolean check = false;
			
			@Override
			public boolean hasNext() {
				return index < size;
			}

			@Override
			public T next() {
				if (index == size) {
					throw new NoSuchElementException();
				}
				check = true;
				return getElement(index++);
			}
			
			@Override
			public void remove() {
				if (check) {
					MyContainer.this.delete(index - 1);
					check = false;
				} else {
					throw new IllegalStateException();
				}
			}
		};
	}
}

class EventDateComparator implements Comparator<Event>{
	public int compare(Event o1, Event o2) {
		if(o1.getStartTime().getTimeInMillis() > o2.getStartTime().getTimeInMillis())
			return 1;
		else if(o1.getStartTime().getTimeInMillis() < o2.getStartTime().getTimeInMillis())
			return -1;
		else
			return 0;
	}
}
class EventLengthComparator implements Comparator<Event>{
	public int compare(Event o1, Event o2) {
		if(o1.getDuration() > o2.getDuration())
			return 1;
		else if(o1.getDuration() < o2.getDuration())
			return -1;
		else
			return 0;
	}
}
class EventPeopleNumberComparator implements Comparator<Event>{
	public int compare(Event o1, Event o2) {
		if(o1.getNumberOfPeople() > o2.getNumberOfPeople())
			return 1;
		else if(o1.getNumberOfPeople() < o2.getNumberOfPeople())
			return -1;
		else
			return 0;
	}
	
}
