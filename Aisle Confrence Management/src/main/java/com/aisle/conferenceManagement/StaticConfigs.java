package com.aisle.conferenceManagement;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import com.aisle.conferenceManagement.util.ConferenceUtils;

public class StaticConfigs {
	public static final String CONFERENCE_DATA = "ConferenceData.txt";
	public static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("hh:mm a");
	public static final String LIGHTNING = "lightning";
	public static final int TOTAL_DURATION= 420;
	public static final int MORNING_SLOT= 180;
	public static final int AFTERNOON_SLOT= 240;
	public static final int LIGHTNING_DURATION= 5;
	public static Calendar START_TIME = ConferenceUtils.getCalendarTime(9, 0);;
	public static Calendar LUNCH_START_TIME = ConferenceUtils.getCalendarTime(12, 0);
	public static Calendar POST_LUNCH_START_TIME = ConferenceUtils.getCalendarTime(13, 0);
	public static Calendar NETWORKING_START_TIME = ConferenceUtils.getCalendarTime(17, 0);
	public static final int LUNCH_DURATION= 60;
	public static final int NETWORKING_DURATION= 60;
}
