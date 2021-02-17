package ua.khpi.oop.momot16.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class EventArrayListWrapper implements Serializable{
	private static final long serialVersionUID = -7828421510884530218L;
	private ArrayList<Event> events;

	public ArrayList<Event> getEvents() {
		return events;
	}

	public void setEvents(List<Event> ev) {
		this.events = new ArrayList<Event>(ev);
	}
}