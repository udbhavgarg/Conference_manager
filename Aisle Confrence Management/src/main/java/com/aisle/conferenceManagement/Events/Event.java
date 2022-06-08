package com.aisle.conferenceManagement.Events;

import java.util.Calendar;

public class Event {

	private Calendar startTime;
	private int duration;
	private String title;

	public Event(Calendar startTime, String title, int duration) {
		this.startTime = startTime;
		this.title = title;
		this.duration = duration;
	}

	public Calendar getStartTime() {
		return startTime;
	}

	public int getDuration() {
		return duration;
	}

	public String getTitle() {
		return title;
	}

}
