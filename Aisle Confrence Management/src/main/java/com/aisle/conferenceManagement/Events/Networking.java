package com.aisle.conferenceManagement.Events;

import com.aisle.conferenceManagement.StaticConfigs;

public class Networking extends Event {

	public Networking() {
		super(StaticConfigs.NETWORKING_START_TIME, "Networking Event Hosted By Asile To Meet People At Conference", 0);
	}
}
