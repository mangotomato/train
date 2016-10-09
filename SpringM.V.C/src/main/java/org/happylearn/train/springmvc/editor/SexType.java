package org.happylearn.train.springmvc.editor;

public class SexType {
	
	public static final SexType MALE = new SexType("男士");
	public static final SexType FEMALE	= new SexType("女士");
	
	private String value;
	 
	public SexType(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	 
	 
}
