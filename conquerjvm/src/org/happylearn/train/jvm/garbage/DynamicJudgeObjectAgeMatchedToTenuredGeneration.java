package org.happylearn.train.jvm.garbage;

// 动态对象年龄判定
// 同年龄段的对象大小总和达到Survivor空间的一半
// 年龄随着每次gc， +1
// 当前jvm参数： -verbose:gc -XX:+PrintGCDetails -XX:+UseParNewGC -XX:+UseConcMarkSweepGC -Xms20M -Xmx20M -Xmn10M -XX:SurvivorRatio=8 -XX:MaxTenuringThreshold=15
// -XX:+PrintTenuringDistribution
public class DynamicJudgeObjectAgeMatchedToTenuredGeneration {
	public static void main(String[] args) {
		byte[] allocation1, allocation2, allocation3, allocation4;
		allocation1 = new byte[1024*1024/4];
		allocation2 = new byte[1024*1024/4];
		allocation3 = new byte[4* 1024*1024];
		allocation4 = new byte[4* 1024*1024]; // 直接分配到老年代
		allocation4 = null;
		allocation4 = new byte[4* 1024*1024]; // 直接分配到老年代
		
	}
	
}
