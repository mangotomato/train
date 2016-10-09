package org.happylearn.train.springmvc.domain;

import org.hibernate.validator.constraints.NotEmpty;


public class Teacher {
	
	@NotEmpty(message="{user.name.notempty}")
	private String name;
	private int age;
	
	
	public Teacher() {
		super();
	}
	public Teacher(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	
}
