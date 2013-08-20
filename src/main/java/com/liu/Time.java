package com.liu;

import java.util.Date;

/**
 * unix timestamp
 * @author ��ͩΰ
 * @date 2013-8-20
 */
public class Time {
	public static void main(String[] args) {
		System.out.println(getUnixTimestamp());
		System.out.println(getDateFromUnixTimestamp(getUnixTimestamp()));
	}

	/**
	 * ��ȡ��ǰunixʱ���
	 * @return
	 */
	public static long getUnixTimestamp() {
		return System.currentTimeMillis() / 1000L;
	}

	/**
	 * ����unixʱ������date����
	 * @param unixTimeStamp
	 * @return
	 */
	public static Date getDateFromUnixTimestamp(long unixTimeStamp) {
		return new Date((long) unixTimeStamp * 1000);
	}
}
