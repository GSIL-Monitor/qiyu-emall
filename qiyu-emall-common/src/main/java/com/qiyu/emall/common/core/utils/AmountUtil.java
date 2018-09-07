package com.qiyu.emall.common.core.utils;

import java.math.BigDecimal;

public class AmountUtil {

	/**
	 * 元转为分
	 * 
	 * @param yuan
	 *            元
	 * @return int
	 */
	public static int changYuanToFen(Double yuan) {
		return new BigDecimal(yuan).multiply(new BigDecimal(100)).setScale(0, BigDecimal.ROUND_HALF_UP).intValue();
	}


	public static BigDecimal yuanToFen(Double yuan) {
		return new BigDecimal(yuan).multiply(new BigDecimal(100)).setScale(0, BigDecimal.ROUND_HALF_UP);
	}

	/**
	 * 分转为元
	 * 
	 * @param fen
	 *            分
	 * @return double
	 */
	public static double changFenToYuan(Integer fen) {
		if (fen == null)
			return 0L;
		return new BigDecimal(fen).divide(new BigDecimal(100), 2, BigDecimal.ROUND_HALF_UP).doubleValue();
	}

	public static BigDecimal changFenToYuan(BigDecimal fen) {
		if (fen == null)
			return new BigDecimal(0);
		return fen.divide(new BigDecimal(100), 2, BigDecimal.ROUND_HALF_UP);
	}

	public static double changFenToYuan(Double fen) {
		if (fen == null) {
			return 0L;
		} else {
			Integer fenInt = fen.intValue();
			return new BigDecimal(fenInt).divide(new BigDecimal(100), 2, BigDecimal.ROUND_HALF_UP).doubleValue();
		}

	}
}
