package org.happylearn.train.javacore.jdk5.enumclass;


/**
 * 功能： 演示枚举桥接方法
 *
 */
public class EnumBridgeMethodTest {
	
	public static void main(String[] args) {
		SuperClass superClass = new SubClass();
		superClass.test("123");
		superClass.test(new Object());
	}
}
