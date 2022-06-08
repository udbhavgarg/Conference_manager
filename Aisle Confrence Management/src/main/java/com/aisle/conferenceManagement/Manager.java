package com.aisle.conferenceManagement;

import com.aisle.conferenceManagement.Events.*;
import com.aisle.conferenceManagement.enums.DataOutputEnum;
import com.aisle.conferenceManagement.enums.DataSourceEnum;
import com.aisle.conferenceManagement.exceptions.UnsupportedDestinationException;
import com.aisle.conferenceManagement.exceptions.UnsupportedSourceException;
import com.aisle.conferenceManagement.io.ConferenceFileSourceManager;
import com.aisle.conferenceManagement.io.ConsoleOutputManager;
import com.aisle.conferenceManagement.util.ConferenceUtils;
import java.io.FileNotFoundException;
import java.util.*;

public class Manager {

	public List<IndividualEvent> fetchTalksListFromSource(DataSourceEnum dataSourceEnum)
			throws UnsupportedSourceException {
		if (dataSourceEnum.equals(DataSourceEnum.FILE)) {
			ConferenceFileSourceManager sourceManager = new ConferenceFileSourceManager();
			try {
				return sourceManager.fetchEvents();
			} catch (FileNotFoundException e) {

				return null;
			}
		} else {
			throw new UnsupportedSourceException("Source type not valid");
		}
	}

	public void outputConferenceSchedule(Conference conference, DataOutputEnum dataOutputEnum)
			throws UnsupportedDestinationException {
		if (dataOutputEnum.equals(DataOutputEnum.CONSOLE)) {
			ConsoleOutputManager outputManager = new ConsoleOutputManager();
			outputManager.printSchedule(conference);
		} else {
			throw new UnsupportedDestinationException("Destination not valid.");
		}
	}

	public Conference processAndScheduleEvents(List<IndividualEvent> talkList) {
		Conference conference = new Conference();
		Collections.sort(talkList, new IndividualEventCompare());
		int trackCount = 0;
		while (0 != talkList.size()) {
			Slot morningSlot = new Slot(StaticConfigs.MORNING_SLOT, StaticConfigs.START_TIME);
			fillSlot(morningSlot, talkList);
			Slot lunchSlot = new Slot(StaticConfigs.LUNCH_DURATION, StaticConfigs.LUNCH_START_TIME);
			lunchSlot.addEvent(new Lunch());
			Slot afternoonSlot = new Slot(StaticConfigs.AFTERNOON_SLOT, StaticConfigs.POST_LUNCH_START_TIME);
			fillSlot(afternoonSlot, talkList);
			Slot networkingSlot = new Slot(StaticConfigs.NETWORKING_DURATION, StaticConfigs.NETWORKING_START_TIME);
			networkingSlot.addEvent(new Networking());
			Track track = new Track(++trackCount);
			track.addSlot(morningSlot);
			track.addSlot(lunchSlot);
			track.addSlot(afternoonSlot);
			track.addSlot(networkingSlot);
			conference.addTrack(track);
		}

		return conference;
	}

	private void fillSlot(Slot slot, List<IndividualEvent> talks) {
		Calendar currentStartTime = slot.getStartTime();
		for (Iterator<IndividualEvent> talksIterator = talks.iterator(); talksIterator.hasNext();) {
			IndividualEvent events = talksIterator.next();
			if (slot.hasRoomFor(events)) {
				slot.addEvent(new Event(currentStartTime, events.getTitle(), events.getDuration()));
				currentStartTime = ConferenceUtils.getNextStartTime(currentStartTime, events);
				talksIterator.remove();
			}
		}
	}

}
