package ua.khpi.oop.momot16.model;

import java.io.Serializable;
import java.time.LocalDate;

import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import ua.khpi.oop.momot16.util.LocalDateAdapter;

public class Event implements Serializable{
	private LocalDate	startTime;	//время начала
	private int 		duration;	//длительность
	private String		address;	//место проведения
	private String		description;//описание события
	private String 		people;		//имена участников
	
	private static final long serialVersionUID = -2695756355710063349L;

	public Event(LocalDate startTime, int duration, String address, String description, String people) {
		super();
		this.startTime = startTime;
		this.duration = duration;
		this.address = address;
		this.description = description;
		this.people = people;
	}

	public Event() {
		super();
	}

	@XmlJavaTypeAdapter(LocalDateAdapter.class)
	public LocalDate getStartTime() {
		return startTime;
	}
	
	@XmlJavaTypeAdapter(LocalDateAdapter.class)
	public void setStartTime(LocalDate startTime) {
		this.startTime = startTime;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPeople() {
		return people;
	}

	public void setPeople(String people) {
		this.people = people;
	}
	
	public ObjectProperty<LocalDate> startTimeProperty() {
		return new SimpleObjectProperty<LocalDate>(startTime);
	}

	public IntegerProperty durationProperty() {
		return new SimpleIntegerProperty(duration);
	}

	public StringProperty addressProperty() {
		return new SimpleStringProperty(address);
	}

	public StringProperty descriptionProperty() {
		return new SimpleStringProperty(description);
	}

	public StringProperty peopleProperty() {
		return new SimpleStringProperty(people);
	}

	
}