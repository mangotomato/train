package org.happylearn.train.formatter;

import java.text.ParseException;
import java.util.Date;
import java.util.Locale;

import org.springframework.format.Formatter;

public class CustomDateFormatter implements Formatter<Date>{
	
	@Override
	public String print(Date object, Locale locale) {
		return "this is date local...";
	}

	@Override
	public Date parse(String text, Locale locale) throws ParseException {
		return new Date();
	}

}
