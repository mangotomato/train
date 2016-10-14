package org.happylearn.train.jvm.garbage;

// 演示： 空间分配担保
// 原因： 在发生minor gc时，虚拟机会检测每次晋升到老年代的平均大小是否大于老年代的剩余空间大小，如果大于，则进行一次full gc.
// 如果小于，则查看HandlePromotionFailure设置是否允许担保；如果允许，只进行一次MinorGC;如果不允许，则进行一次FullGC

// 如果每次minor gc后，存活对象激增，造成担保失败，则会在失败后重新发一起Major gc.

// 建议将handlepromotionfailure开关打开，避免频繁full gc

// 当前jvm参数：-XX:+UseParNewGC -XX:+UseConcMarkSweepGC -XX:MaxTenuringThreshold=15 -XX:+PrintGCDetails -verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:SurvivorRatio=8
// -XX:-HandlePromotionFailure

// Java HotSpot(TM) 64-Bit Server VM warning: ignoring option HandlePromotionFailure=false; support was removed in 6.0_24
public class MemoryGuarantee {
	
	public static void main(String[] args) {
		byte[] allocation1, allocation2, allocation3, allocation4,allocation5, allocation6, allocation7;
		
		allocation1 = new byte[2*1024*1024];
		allocation2 = new byte[2*1024*1024];
		allocation3 = new byte[2*1024*1024];
		allocation1 = null;
		allocation4 = new byte[2* 1024*1024]; 
		allocation5 = new byte[2* 1024*1024]; 
		allocation6 = new byte[2* 1024*1024]; 
		allocation4 = null;
		allocation5 = null;
		allocation6 = null;
		allocation7 = new byte[2*1024*1024];
	}

}
