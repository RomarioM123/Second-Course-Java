package ua.khpi.oop.momot16.model;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Events")
public class EventListWrapper {
	private List<Event> event;

	@XmlElement(name = "event")
	public List<Event> getEvents() {
		return event;
	}
	
	public void setEvents(List<Event> event) {
		this.event = event;
	}
}