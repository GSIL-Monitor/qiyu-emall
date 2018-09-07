package com.qiyu.emall.common.core.utils;

import java.util.Random;

public class MathUtil {

	public static String generateCode(Integer length) {
		String base = "0123456789";
		Random random = new Random();
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < length; i++) {
			int number = random.nextInt(base.length());
			sb.append(base.charAt(number));
		}
		return sb.toString();
	}

}
