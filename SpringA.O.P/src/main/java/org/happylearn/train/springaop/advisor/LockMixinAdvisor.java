package org.happylearn.train.springaop.advisor;

import org.happylearn.train.springaop.domain.Lockable;
import org.happylearn.train.springaop.interceptor.LockMixin;
import org.springframework.aop.support.DefaultIntroductionAdvisor;

public class LockMixinAdvisor extends DefaultIntroductionAdvisor {
	public LockMixinAdvisor() {
		super(new LockMixin(), Lockable.class);
	}
}
