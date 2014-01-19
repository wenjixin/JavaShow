package com.liu.jvm.oom;

import java.util.ArrayList;
import java.util.List;

/**
 * VM args:-Xms20m -Xmx20m -XX:+HeapDumpOnOutOfMemoryError
 * @author ¡ıÕ©Œ∞
 * @date 2014-1-19
 */
public class HeapOOM {
	static class OOMObject {
	}

	public static void main(String[] args) {
		List<OOMObject> list = new ArrayList<HeapOOM.OOMObject>();
		
		for(;;){
			list.add(new OOMObject());
		}
	}
}
