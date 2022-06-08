package com.aisle.conferenceManagement.io;

import com.aisle.conferenceManagement.StaticConfigs;
import com.aisle.conferenceManagement.Events.*;

import java.text.SimpleDateFormat;
import java.util.List;

public class ConsoleOutputManager {

	public void printSchedule(Conference conference) {

		SimpleDateFormat date = StaticConfigs.DATE_FORMAT;
		System.out.println("Output:");
		System.out.println();
		for (Track track : conference.getTracks()) {
			System.out.println("Track " + track.getTrackId());
			List<Slot> slots = track.getSlots();
			System.out.println("");
			for (Slot slot : slots) {
				for (Event event : slot.getEvents()) {
					if (event.getDuration() != 0) {
						if (event.getDuration() == 5) {
							System.out.println(date.format(event.getStartTime().getTime()) + " " + event.getTitle()
									+ " lightning");
						} else {
							System.out.println(date.format(event.getStartTime().getTime()) + " " + event.getTitle()
									+ " " + event.getDuration() + "mins");
						}
					} else {
						System.out.println(date.format(event.getStartTime().getTime()) + " " + event.getTitle());

					}
				}
			}
			System.out.println();
		}
	}

}
