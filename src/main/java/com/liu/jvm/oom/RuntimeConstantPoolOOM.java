package com.liu.jvm.oom;


/**
 * VM args: -XX:PermSize=10m -XX:MaxPermSize=10m
 * @author ¡ıÕ©Œ∞
 * @date 2014-1-19
 */
public class RuntimeConstantPoolOOM {
	/**
	 * diff result with jdk6&jdk7
	 * @param args
	 */
	public static void main(String[] args) {

		// jdk6 intern return perm address & jdk7 intern renturn
		// RuntimeConstantPool address,this is because jdk7 has removed RCP from
		// Permanent Generation.
		String str2 = new StringBuilder("j11ava").append("ss").toString();
		System.out.println(str2.intern() == str2);
		String str1 = new StringBuilder("ja").append("va").toString();
		System.out.println(str1.intern() == str1);
		// List<String> strings = new ArrayList<String>();
		// int i = 0;
		// while (true) {
		// strings.add(String.valueOf(i++).intern());
		// }
	}
}
