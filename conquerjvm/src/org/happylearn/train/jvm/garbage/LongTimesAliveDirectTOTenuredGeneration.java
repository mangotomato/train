package org.happylearn.train.jvm.garbage;

// 演示： 长期存活的对象直接进老年代
//当前jvm参数： -verbose:gc -XX:+PrintGCDetails  -Xms20M -Xmx20M -Xmn10M -XX:SurvivorRatio=8 -XX:MaxTenuringThreshold=1
// -XX:+PrintTenuringDistribution
public class LongTimesAliveDirectTOTenuredGeneration {
	public static void main(String[] args) {
		byte[] allocation1, allocation2,allocation3;
		allocation1 = new byte[4*1024];
		allocation2 = new byte[4*1024*1024];
		allocation3= new byte[4*1024*1024];  // 开始minorgc
		allocation3 = null;
		allocation3= new byte[4*1024*1024];  // 开始minorgc
	}
}
