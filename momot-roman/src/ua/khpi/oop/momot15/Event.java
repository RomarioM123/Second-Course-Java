package ua.khpi.oop.momot15;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.GregorianCalendar;

public class Event implements Serializable{
	private GregorianCalendar 	startTime;	//врем€ начала
	private int 				duration;	//длительность
	private String 				address;	//место проведени€
	private String 				description;//описание событи€
	private ArrayList<String> 	people;		//имена участников
	
	private static final long serialVersionUID = -2695756355710063349L;
	
	public void deletePerson(int id) {
		if(id <= people.size()) {
			people.remove(id);
		}
		else {
			System.out.println("Ќеверный индекс элемента.");
		}
	}
	public void deletePerson(String name) {
		if(people.contains(name)) {
			deletePerson(people.indexOf(name));
		} else {
			System.out.println("“акой человек отсутствует.");
		}
	}
	
	public Event() { super(); }
	
	public GregorianCalendar getStartTime() { return startTime; }
	public int getDuration() { return duration; }
	public String getDescription() { return description; }
	public String getAddress() { return address; }
	public ArrayList<String> getPeople() { return people; }
	public int getNumberOfPeople() { return people.size(); }
	
	public void setStartTime(GregorianCalendar startTime) { this.startTime = startTime; }
	public void setDuration(int duration) { this.duration = duration; }
	public void setDescription(String description) { this.description = description; }
	public void setAddress(String address) { this.address = address; }
	public void setPeople(ArrayList<String> people) { this.people = people; }
	
	public Event(GregorianCalendar date, int length, String address, ArrayList<String> people, String description) {
		startTime = date;
		duration = length;
		this.address = address;
		this.people = people;
		this.description = description;
	}
	
	public void outputData() {
		System.out.println("Event start time: " + startTime.getTime());
		System.out.println("Duration of the event (in minutes): " + duration);
		System.out.println("Event address: " + address);
		System.out.println("Event description: " + description);
		System.out.println("List of participants: ");
		
		for (int i = 0; i < people.size(); i++) {
			System.out.println(i+1 + ". " + people.get(i));
		}
	}
	
	@Override
	public String toString() {
		return "Start time: " + startTime.getTime() + "\nDuration: " + duration + "\nAddress: " + address + "\nDescription: " + description + "List of participants: " + people + "\n";
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