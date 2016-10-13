package org.happylearn.train.springaop;

import org.happylearn.train.springaop.domain.Lockable;
import org.happylearn.train.springaop.domain.Person;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ProxyFactoryBeanTest {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("application-config.xml");
		Person person = context.getBean("person", Person.class);
		person.earn();
		Lockable lock = (Lockable) person;
		lock.lock();
	}
}
