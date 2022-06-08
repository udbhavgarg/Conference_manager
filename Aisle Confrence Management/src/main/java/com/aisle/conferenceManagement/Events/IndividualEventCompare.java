package com.aisle.conferenceManagement.Events;

import java.util.Comparator;

public class IndividualEventCompare implements Comparator<IndividualEvent> {

	@Override
	public int compare(IndividualEvent t1, IndividualEvent t2) {
		if (t1.getDuration() < t2.getDuration()) {
			return 1;
		} else {
			return -1;
		}
	}
}
