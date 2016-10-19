package org.happylearn.train.springioc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 测试 alias circle
 *
 */
public class IOCTest {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("application-config.xml");
		Object obj = context.getBean("bean1");
	}
}
