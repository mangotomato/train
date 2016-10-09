package org.happylearn.train.springmvc.editor;

import java.beans.PropertyEditorSupport;

public class CustomSexTypePropertyEditor extends PropertyEditorSupport{
	
		
	@Override
	public void setValue(Object value) {
		super.setValue(value);
	}
	
	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		if(text.equals("male")) {
			setValue(SexType.MALE);
		} else if(text.equals("female")) {
			setValue(SexType.FEMALE);
		}
		
	}
	
	@Override
	public String getAsText() {
		return ((SexType)getValue()).getValue();
	}

}
