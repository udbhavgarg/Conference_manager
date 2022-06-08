package com.aisle.conferenceManagement.Events;

import com.aisle.conferenceManagement.StaticConfigs;

public class Lunch extends Event {
	public Lunch() {
		super(StaticConfigs.LUNCH_START_TIME, "Enjoy The lunch hosted by our Executive Chef At Aisle Coperation ",
				StaticConfigs.LUNCH_DURATION);
	}
}
