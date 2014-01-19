package com.liu.jvm.oom;

/**
 * VM Args: -Xss128k 
 * note:-Xoss not work for hotspot
 * @author ¡ıÕ©Œ∞
 * @date 2014-1-19
 */
public class JavaVMStackSof {
	private int stackLength = 1;

	public void stackLeak() {
		stackLength++;
		stackLeak();
	}

	public static void main(String[] args) {
		JavaVMStackSof javaVMStackSof = new JavaVMStackSof();
		try {
			javaVMStackSof.stackLeak();
		} catch (Throwable e) {
			System.out.println(javaVMStackSof.stackLength);
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
