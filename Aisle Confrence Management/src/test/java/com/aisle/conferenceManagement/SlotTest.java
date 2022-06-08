package com.aisle.conferenceManagement;

import com.aisle.conferenceManagement.Events.IndividualEvent;
import com.aisle.conferenceManagement.Events.Slot;
import com.aisle.conferenceManagement.util.ConferenceUtils;

import org.junit.Assert;
import org.junit.Test;

import java.util.Calendar;

public class SlotTest {

	@Test
	public void testHasRoomForEvent() {

		Calendar slotStartTime = ConferenceUtils.getCalendarTime(9, 00);
		Slot slot = new Slot(50, slotStartTime);

		IndividualEvent event1 = new IndividualEvent("Valid Event", 45);
		Assert.assertTrue(slot.hasRoomFor(event1));

		IndividualEvent event2 = new IndividualEvent("InValid Event", 60);
		Assert.assertFalse(slot.hasRoomFor(event2));

	}
}
