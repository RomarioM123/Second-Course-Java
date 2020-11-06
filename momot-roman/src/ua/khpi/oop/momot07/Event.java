package ua.khpi.oop.momot07;
import java.util.GregorianCalendar;

public class Event {
	private GregorianCalendar startTime;	//время начала
	private int duration;					//длительность
	private String address;					//место проведения
	private String description;				//описание события
	private String[] people;				//имена участников
	
	public GregorianCalendar getStartTime() {
		return startTime;
	}
	public void setStartTime(GregorianCalendar startTime) {
		this.startTime = startTime;
	}
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
	public String getDescription()
	{
		return description;
	}
	public void setDescription(String description)
	{
		this.description = description;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String[] getPeople() {
		return people;
	}
	public void setPeople(String[] people) {
		this.people = people;
	}
	public Event(GregorianCalendar date, int length, String address, String[] people, String description)
	{
		startTime = date;
		duration = length;
		this.address = address;
		this.people = people;
		this.description = description;
	}
	
	public void outputData()
	{
		System.out.println("Event start time: " + startTime.getTime());
		System.out.println("Duration of the event (in minutes): " + duration);
		System.out.println("Event address: " + address);
		System.out.println("Event description: " + description);
		System.out.println("List of participants: ");
		for (int i = 0; i < people.length; i++) {
			System.out.println(i+1 + ". " + people[i]);
		}
	}
}
