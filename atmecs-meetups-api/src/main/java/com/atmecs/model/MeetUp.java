package com.atmecs.model;

import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="meetups")
public class MeetUp {

	@Id
	//@GeneratedValue(strategy=GenerationType.IDENTITY)
	private String title;
	
	@NotNull
	private String presenter;
	
	@NotNull
	private Date date;
	
	@NotNull
	private String description;
	
	@NotNull
	private String chiefGuest;
	
	@NotNull
	private Time startTime,endTime;
	
	@ManyToMany(targetEntity=com.atmecs.model.Guest.class,fetch=FetchType.EAGER)
	//@JsonIgnore
	@JoinTable(name="meetup_attendees",joinColumns = {
			@JoinColumn(name = "title", nullable = false, updatable = false) },
			inverseJoinColumns = { @JoinColumn(name = "guestId",
					nullable = false, updatable = false) })
	private List<Guest> listOfGuests;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getPresenter() {
		return presenter;
	}

	public void setPresenter(String presenter) {
		this.presenter = presenter;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getChiefGuest() {
		return chiefGuest;
	}

	public void setChiefGuest(String chiefGuest) {
		this.chiefGuest = chiefGuest;
	}

	public Time getStartTime() {
		return startTime;
	}

	public void setStartTime(Time startTime) {
		this.startTime = startTime;
	}

	public Time getEndTime() {
		return endTime;
	}

	public void setEndTime(Time endTime) {
		this.endTime = endTime;
	}

	public List<Guest> getListOfGuests() {
		return listOfGuests;
	}

	public void setListOfGuests(List<Guest> listOfGuests) {
		this.listOfGuests = listOfGuests;
	}

	public MeetUp(String title, String presenter, Date date, String description, String chiefGuest,
			Time startTime, Time endTime) {
		super();
		this.title = title;
		this.presenter = presenter;
		this.date = date;
		this.description = description;
		this.chiefGuest = chiefGuest;
		this.startTime = startTime;
		this.endTime = endTime;
		this.listOfGuests = new ArrayList<>();
	}

	public MeetUp() {
		super();
	}
	
	
	
	
	
}
