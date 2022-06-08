package com.aisle.conferenceManagement.Events;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Slot {

	private List<Event> events;
	private int remainingDuration;
	private Calendar startTime;

	public List<Event> getEvents() {
		return events;
	}

	public void addEvent(Event event) {
		this.events.add(event);
		this.remainingDuration -= event.getDuration();
	}

	public Calendar getStartTime() {
		return startTime;
	}

	public Slot(int duration, Calendar startTime) {
		events = new ArrayList<>();
		this.remainingDuration = duration;
		this.startTime = startTime;
	}

	public boolean hasRoomFor(IndividualEvent talk) {
		return remainingDuration >= talk.getDuration();
	}
}
