package org.happylearn.train.springaop.advisor;

import java.lang.reflect.Method;

import org.aopalliance.aop.Advice;
import org.springframework.aop.Advisor;
import org.springframework.aop.MethodBeforeAdvice;

public class MyAdvisor implements Advisor{

	@Override
	public Advice getAdvice() {
		return new MethodBeforeAdvice() {
			
			@Override
			public void before(Method method, Object[] args, Object target)
					throws Throwable {
				System.out.println("before enter method: "+method.getName());
			}
		};
	}

	@Override
	public boolean isPerInstance() {
		return false;
	}

}
