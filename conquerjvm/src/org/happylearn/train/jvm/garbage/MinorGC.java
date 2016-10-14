package org.happylearn.train.jvm.garbage;

// 演示：对象有限在Eden区分配
// 当前jvm参数： -verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:SurvivorRatio=8 -XX:+PrintGCDetails 
// -XX:+UseG1GC ,默认使用Parallel scavenge 收集器，使用PSYoungGen收回年轻代，使用 ParOldGen回收 老年代，使用PSPermGen回收永久代
public class MinorGC {
	private static final int _1MB = 1024*1024;
	
	public static void main(String[] args) {
		byte[] allocation1, allocation2, allocation3, allocation4;
		allocation1 = new byte[2*_1MB];
		allocation2 = new byte[2*_1MB];
		allocation3 = new byte[2*_1MB];
		allocation4 = new byte[2*_1MB]; //触发Minor GC
	}
	
}
