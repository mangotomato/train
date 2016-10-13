package org.happylearn.train.springaop.domain;

public interface Lockable {
	void lock();
	void unlock();
	boolean locked();
}
