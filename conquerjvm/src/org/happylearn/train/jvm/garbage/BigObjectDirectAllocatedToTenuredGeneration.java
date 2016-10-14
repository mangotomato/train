package org.happylearn.train.jvm.garbage;

// 演示： 大对象直接在老年代分配
// 原因： 年轻代使用Copying算法，为了避免大量对象的来回拷贝
// 当前jvm参数： -verbose:gc -XX:+PrintGCDetails  -Xms20M -Xmx20M -Xmn10M -XX:SurvivorRatio=8 -XX:PretenureSizeThreshold=1048576
// 注意： Parallel Scavenge收集器不受此影响，如需要测试，将收集器设置为Serial或者Parnew
// 如： 这里使用Parnew收集器来回收年轻代-XX:+UseParNewGC ，使用CMS来回收老年代-XX:+UseConcMarkSweepGC
public class BigObjectDirectAllocatedToTenuredGeneration {
	public static void main(String[] args) {
		byte[] allocation;
		allocation = new byte[1024*1024]; // 直接在老年代分配
	}
}
