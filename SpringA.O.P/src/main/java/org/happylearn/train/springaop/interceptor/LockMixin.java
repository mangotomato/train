package org.happylearn.train.springaop.interceptor;

import org.aopalliance.intercept.MethodInvocation;
import org.happylearn.train.springaop.domain.Lockable;
import org.springframework.aop.support.DelegatingIntroductionInterceptor;

public class LockMixin extends DelegatingIntroductionInterceptor implements
		Lockable {

	private boolean locked;

	@Override
	public void lock() {
		this.locked = true;
	}

	@Override
	public void unlock() {
		this.locked = false;
	}

	@Override
	public boolean locked() {
		return this.locked;
	}

	public Object invoke(MethodInvocation invocation) throws Throwable {
		if (locked() && invocation.getMethod().getName().indexOf("set") == 0) {
			throw new Exception("don't modify");
		}
		return super.invoke(invocation);
	}

}
