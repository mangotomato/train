package org.happylearn.train.springaop;

import org.happylearn.train.springaop.advisor.LockMixinAdvisor;
import org.happylearn.train.springaop.advisor.MyAdvisor;
import org.happylearn.train.springaop.domain.Person;
import org.happylearn.train.springaop.domain.PersonImpl;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.interceptor.PerformanceMonitorInterceptor;

public class ProxyFactoryTest {
	public static void main(String[] args) {
		ProxyFactory pf = new ProxyFactory(new Class[]{Person.class});
		pf.addAdvisor(new MyAdvisor());
		pf.addAdvice(new PerformanceMonitorInterceptor());
		pf.addAdvisor(new LockMixinAdvisor()); // 引介增强通知器
		
		pf.setTarget(new PersonImpl("leejianhao",27));
		Person proxy = (Person) pf.getProxy();
		proxy.earn();
	}
}
