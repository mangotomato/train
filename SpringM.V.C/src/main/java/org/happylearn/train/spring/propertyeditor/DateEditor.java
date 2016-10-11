package org.happylearn.train.spring.propertyeditor;

import java.beans.PropertyEditorSupport;
import java.text.ParseException;
import java.util.Date;

import org.happylearn.train.common.DateUtils;
import org.springframework.util.StringUtils;

public class DateEditor extends PropertyEditorSupport{
	
	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		if(!StringUtils.hasText(text)) {
			setValue(null);
		}else {
			try {
				System.out.println(this.getClass().getSimpleName()+" is handling the convert.");
				setValue(DateUtils.parseDate(text));
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
	}
	
	@Override
	public String getAsText() {
		Object value = getValue();
		if (value == null) {
			return "";
		}
		
		return DateUtils.getDateString((Date)value);
	}
}
