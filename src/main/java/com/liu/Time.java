package com.liu;

import java.util.Date;

/**
 * unix timestamp
 * @author 刘桐伟
 * @date 2013-8-20
 */
public class Time {
	public static void main(String[] args) {
		System.out.println(getUnixTimestamp());
		System.out.println(getDateFromUnixTimestamp(getUnixTimestamp()));
	}

	/**
	 * 获取当前unix时间戳
	 * @return
	 */
	public static long getUnixTimestamp() {
		return System.currentTimeMillis() / 1000L;
	}

	/**
	 * 根据unix时间戳获得date对象
	 * @param unixTimeStamp
	 * @return
	 */
	public static Date getDateFromUnixTimestamp(long unixTimeStamp) {
		return new Date((long) unixTimeStamp * 1000);
	}
}
