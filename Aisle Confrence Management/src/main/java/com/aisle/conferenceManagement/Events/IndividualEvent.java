package com.aisle.conferenceManagement.Events;

public class IndividualEvent {

	private int duration;
	private String title;

	public int getDuration() {
		return duration;
	}

	public String getTitle() {
		return title;
	}

	public IndividualEvent(String title, int duration) {
		this.duration = duration;
		this.title = title;
	}

}
