package com.cognizant.truyum.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
	public static Date convertToDate(String date) throws ParseException {
		Date date1 = new SimpleDateFormat("dd/MM/yyyy").parse(date);
		return date1;

	}

}
