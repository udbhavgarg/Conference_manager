package com.aisle.conferenceManagement;

import java.io.FileNotFoundException;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;

import com.aisle.conferenceManagement.Events.IndividualEvent;
import com.aisle.conferenceManagement.io.ConferenceFileSourceManager;

public class ConferenceFileSourceManagerTest {

	ConferenceFileSourceManager manager = new ConferenceFileSourceManager();

	@Test(expected = FileNotFoundException.class)
	public void testFetchEventFileNotFound() throws FileNotFoundException {
		manager.fetchEvents("input-test-event-random-file.txt");
	}

	@Test
	public void testFetchEventValidFile() throws FileNotFoundException {
		List<IndividualEvent> events = manager.fetchEvents("input-test-two-event.txt");
		Assert.assertEquals(2, events.size());
	}

	@Test
	public void testFetchEventEmptyFile() throws FileNotFoundException {
		List<IndividualEvent> events = manager.fetchEvents("input-test-event-empty.txt");
		Assert.assertEquals(0, events.size());
	}

	@Test(expected = NumberFormatException.class)
	public void testFetchEventInvalidFile() throws FileNotFoundException {
		List<IndividualEvent> events = manager.fetchEvents("input-test-invalid-event.txt");
	}

}