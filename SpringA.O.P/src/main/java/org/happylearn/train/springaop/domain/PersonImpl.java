package org.happylearn.train.springaop.domain;

public class PersonImpl implements Person{
	
	private String name;
	private int age;
	public PersonImpl() {
		
	}
	
	public PersonImpl(String name, int age) {
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


	@Override
	public void earn() {
		System.out.println("we should work hard and make enough money for financial freedom");
	}

}
