package com.liu.jvm.oom;

/**
 * VM args: -Xss2m
 * @author ¡ıÕ©Œ∞
 * @date 2014-1-19
 */
public class JavaVMStackOOM {
	private void dontStop() {
		while (true) {
		}
	}

	public void stackLeakByThread() {
		while (true) {
			Thread thread = new Thread(new Runnable() {
				public void run() {
					// TODO Auto-generated method stub
					dontStop();
				}
			});
			thread.start();
		}
	}

	public static void main(String[] args) {
		JavaVMStackOOM javaVMStackOOm = new JavaVMStackOOM();
		javaVMStackOOm.stackLeakByThread();
	}
}
