package com.mmall.util;

import org.apache.commons.lang3.StringUtils;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.util.Date;

public class DateTimeUtil {
	public static final String STANDARD_FORMAT = "yyyy-MM-dd HH:mm:ss";
	//joda - time
	//str - date
	//date - str
	public static Date strToDate(String dateTimeStr) {
		DateTimeFormatter dateTimeFormatter = DateTimeFormat.forPattern(STANDARD_FORMAT);
		DateTime dateTime = dateTimeFormatter.parseDateTime(dateTimeStr);
		return dateTime.toDate();
	}

	public static String dateToStr(Date date) {
		if (date == null)
			return StringUtils.EMPTY;
		DateTime dateTime = new DateTime(date);
		return dateTime.toString(STANDARD_FORMAT);
	}

	public static void main(String[] args) {
		System.out.println(DateTimeUtil.dateToStr(new Date()));
		System.out.println(DateTimeUtil.strToDate("2010-11-11 01:21:22"));
	}
}
