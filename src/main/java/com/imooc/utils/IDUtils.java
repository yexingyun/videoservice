/**
 * @Title: IDUtils.java
 * @Package com.createid
 * @Description: TODO(用一句话描述该文件做什么)
 * @author Aaron·Li
 * @date 2017年9月20日 上午11:51:31
 * @version V1.0
 */
package com.imooc.utils;


/**
 * @author Aaron·Li
 * @date 2017年9月20日 上午11:51:31
 */
public class IDUtils {
	private static byte[] lock = new byte[0];

	// 位数，默认是8位
	private final static long w = 1000;

	public static String createID() {
		long r = 0;
		synchronized (lock) {
			r = (long) ((Math.random() + 1) * w);
		}
		String value = String.valueOf(System.currentTimeMillis());
		return value.substring(value.length()-6,value.length()) + String.valueOf(r).substring(1);
	}
	public static String createLongID() {
		long r = 0;
		synchronized (lock) {
			r = (long) ((Math.random() + 1) * w);
		}
		String value = String.valueOf(System.currentTimeMillis());
		return value.substring(3,value.length()) + String.valueOf(r).substring(1);
	}
}
