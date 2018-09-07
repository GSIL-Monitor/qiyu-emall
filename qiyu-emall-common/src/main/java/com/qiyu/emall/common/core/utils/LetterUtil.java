package com.qiyu.emall.common.core.utils;

public class LetterUtil {

	public static final String generatorLetter(Integer length) {
		StringBuilder sb = new StringBuilder();
		char c;
		for (int i=0;i<length;i++) {
			c = (char) (int) (Math.random() * 26 + 97);
			sb.append(c);
		}
		return sb.toString();
	}
}
