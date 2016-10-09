package org.happylearn.train.common;

import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class DateUtils {
		
	
	public static final String DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";
	
	public static String getDateString(Date date) {
		return new SimpleDateFormat(DATE_FORMAT).format(date);
	}
}
