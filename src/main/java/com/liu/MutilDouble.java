package com.liu;

import java.math.BigDecimal;

/**
 * java double 精度问题
 * @author 刘桐伟
 * @date 2013年8月5日
 */
public class MutilDouble {
	public static void main(String[] args) {
		double aa = 2.2d;
		String ab = aa + "";
		BigDecimal bigDecimal = new BigDecimal(ab);
		System.out.println(bigDecimal.multiply(new BigDecimal("100")));
	}
}
