package com.aisle.conferenceManagement.util;

import java.util.Calendar;
import java.util.List;

import com.aisle.conferenceManagement.Events.IndividualEvent;

public class ConferenceUtils {

	public static Calendar getCalendarTime(int hours, int minutes) {
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.HOUR_OF_DAY, hours);
		cal.set(Calendar.MINUTE, minutes);
		return cal;
	}

	public static Calendar getNextStartTime(Calendar currentStartTime, IndividualEvent currentTalk) {
		Calendar newTime = Calendar.getInstance();
		newTime.set(Calendar.HOUR_OF_DAY, currentStartTime.get(Calendar.HOUR_OF_DAY));
		newTime.set(Calendar.MINUTE, currentStartTime.get(Calendar.MINUTE));
		newTime.add(Calendar.MINUTE, currentTalk.getDuration());
		return newTime;
	}

	public static void printEvents(List<IndividualEvent> talkList) {
		System.out.println("Input Events:");
		System.out.println();
		for (IndividualEvent events : talkList) {
			System.out.println(events.getTitle() + " " + events.getDuration()+"mins");
		}
		System.out.println();
		System.out.println();
	}

}
