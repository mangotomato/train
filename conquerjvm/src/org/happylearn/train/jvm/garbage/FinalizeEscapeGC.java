package org.happylearn.train.jvm.garbage;

/**
 * 演示: 
 * 1.对象可以在GC时自我拯救
 * 2.这种自我拯救只有一次,因为对象的finalize只能被系统自动调用一次
 * 
 * 说明：仅为了做技术研究演示，实际开发中应避免使用finalize方法
 * @author 周志明
 *
 */
public class FinalizeEscapeGC {
	private static FinalizeEscapeGC STRONG_REFERENCE = null;
	
	public void isAlive() {
		System.out.println("yes, i am still alive.");
	}
	
	@Override
	protected void finalize() throws Throwable {
		super.finalize();
		System.out.println("finalize method executed.");
		STRONG_REFERENCE = this; // 重新关联引用，GC Root关联到
	}
	
	public static void main(String[] args) throws InterruptedException {
		STRONG_REFERENCE = new FinalizeEscapeGC();
		
		// 对象第一次成功自我拯救
		STRONG_REFERENCE = null;
		System.gc();
		
		Thread.sleep(1000); // Finalize线程级别很低，睡眠1s等待线程执行
		if(STRONG_REFERENCE != null) {
			STRONG_REFERENCE.isAlive();
		} else {
			System.out.println("no, i am dead.");
		}
		
		// 一下代码和上述代码相同，但这次拯救失败了，因为finalize方法只能被系统调用一次
		STRONG_REFERENCE = null;
		System.gc();
		
		Thread.sleep(1000); // Finalize线程级别很低，睡眠1s等待线程执行
		if(STRONG_REFERENCE != null) {
			STRONG_REFERENCE.isAlive();
		} else {
			System.out.println("no, i am dead.");
		}
	}
}
