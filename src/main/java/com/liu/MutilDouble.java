package com.liu;

import java.math.BigDecimal;

/**
 * java double ��������
 * @author ��ͩΰ
 * @date 2013��8��5��
 */
public class MutilDouble {
	public static void main(String[] args) {
		double aa = 2.2d;
		String ab = aa + "";
		BigDecimal bigDecimal = new BigDecimal(ab);
		System.out.println(bigDecimal.multiply(new BigDecimal("100")));
	}
}
