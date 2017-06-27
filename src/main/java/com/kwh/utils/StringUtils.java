package com.kwh.utils;

public abstract class StringUtils {

	public static boolean isNotBlank(String... str) {
		for (String string : str) {
			if (StringUtils.isBlank(string))
				return false;
		}
		return true;
	}
	
	public static boolean isBlank(String... str) {
		for (String string : str) {
			if (StringUtils.isBlank(string))
				return true;
		}
		return false;
	}

	private static boolean isBlank(String string) {
		return string == null || string.equals("") || string.trim().equals("") ? true : false;
	}
}
