package com.csist.util;

public class OPUtil {
	private OPUtil(){
		
	}
	
	/**
	 * 检测指定字符串是否为null或为空
	 * @param str 待检测字符串
	 * @return  true--非null非空；false--null或空
	 */
	public static boolean checkString(String str) {
		if(str!=null && str.trim().length()>0) {
			return true;
		}
		return false;
	}
}
