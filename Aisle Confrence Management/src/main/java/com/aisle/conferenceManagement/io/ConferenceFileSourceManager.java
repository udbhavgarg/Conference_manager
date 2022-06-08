package com.aisle.conferenceManagement.io;

import com.aisle.conferenceManagement.StaticConfigs;
import com.aisle.conferenceManagement.Events.IndividualEvent;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class ConferenceFileSourceManager {

	@SuppressWarnings({ "resource" })
	public List<IndividualEvent> fetchEvents(String fileName) throws FileNotFoundException {
		FileInputStream fstream = null;
		List<IndividualEvent> eventList = new ArrayList<>();

		try {
			fstream = new FileInputStream(fileName);
		} catch (FileNotFoundException e) {
			System.err.println("File Not Found ");
			throw e;
		}
		BufferedReader br = new BufferedReader(new InputStreamReader(fstream));

		String strLine;
		int intMinutes;
		try {
			while ((strLine = br.readLine()) != null) {
				if (strLine.contains("//") || strLine.isEmpty())
					continue;
				String title = strLine.substring(0, strLine.lastIndexOf("-"));
				String minutesString = strLine.substring(strLine.lastIndexOf(" ") + 1);
				if (StaticConfigs.LIGHTNING.equals(minutesString)) {
					intMinutes = StaticConfigs.LIGHTNING_DURATION;
				} else {
					try {
						String minutes = minutesString.replaceAll("\\D+", "");
						intMinutes = Integer.parseInt(minutes);
					} catch (NumberFormatException e) {
						System.err.println("Could not parse the line : " + strLine);
						throw e;
					}
				}
				title = title.trim();
				IndividualEvent singleTalk = new IndividualEvent(title, intMinutes);
				eventList.add(singleTalk);

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				fstream.close();
				br.close();
			} catch (Exception e) {
				System.err.println(e.getMessage());
			}
		}
		return eventList;
	}

	public List<IndividualEvent> fetchEvents() throws FileNotFoundException {
		return fetchEvents(StaticConfigs.CONFERENCE_DATA);
	}
}
