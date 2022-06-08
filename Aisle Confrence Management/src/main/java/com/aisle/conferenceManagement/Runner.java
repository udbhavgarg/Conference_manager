package com.aisle.conferenceManagement;

import com.aisle.conferenceManagement.Events.Conference;
import com.aisle.conferenceManagement.Events.IndividualEvent;
import com.aisle.conferenceManagement.enums.DataOutputEnum;
import com.aisle.conferenceManagement.enums.DataSourceEnum;
import com.aisle.conferenceManagement.exceptions.UnsupportedDestinationException;
import com.aisle.conferenceManagement.exceptions.UnsupportedSourceException;
import com.aisle.conferenceManagement.util.ConferenceUtils;
import java.util.List;

public class Runner {
	public static void main(String[] args) {
		Manager conferenceManager = new Manager();
		List<IndividualEvent> eventList = null;
		try {
			eventList = conferenceManager.fetchTalksListFromSource(DataSourceEnum.FILE);
		} catch (UnsupportedSourceException e) {
			System.err.println(e.getMessage());
		}
		if (eventList == null || eventList.size() == 0)
			return;
		ConferenceUtils.printEvents(eventList);
		Conference conference = conferenceManager.processAndScheduleEvents(eventList);
		try {
			conferenceManager.outputConferenceSchedule(conference, DataOutputEnum.CONSOLE);
		} catch (UnsupportedDestinationException e) {
			System.err.println(e.getMessage());
		}

	}
}
