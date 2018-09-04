package com.qiyu.emall.utils;

import org.apache.commons.codec.binary.Base64;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.security.AlgorithmParameters;
import java.security.Key;
import java.security.Security;

public class AES128Util {
	// 算法名
	public static final String KEY_NAME = "AES";
	// 加解密算法/模式/填充方式
	// ECB模式只用密钥即可对数据进行加密解密，CBC模式需要添加一个iv
	public static final String CIPHER_ALGORITHM = "AES/CBC/PKCS7Padding";

	/**
	 * 微信 数据解密<br/>
	 * 对称解密使用的算法为 AES-128-CBC，数据采用PKCS#7填充<br/>
	 * 对称解密的目标密文:encrypted=Base64_Decode(encryptData)<br/>
	 * 对称解密秘钥:key = Base64_Decode(session_key),aeskey是16字节<br/>
	 * 对称解密算法初始向量:iv = Base64_Decode(iv),同样是16字节<br/>
	 *
	 * @param encrypted 目标密文
	 * @param session_key 会话ID
	 * @param iv 加密算法的初始向量
	 */
	public static String wxDecrypt(String encrypted, String session_key, String iv) {
		String json = null;
		byte[] encrypted64 = Base64.decodeBase64(encrypted);
		byte[] key64 = Base64.decodeBase64(session_key);
		byte[] iv64 = Base64.decodeBase64(iv);
		byte[] data;
		try {
			init();
			json = new String(decrypt(encrypted64, key64, generateIV(iv64)));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return json;
	}

	/**
	 * 初始化密钥
	 */
	public static void init() throws Exception {
		Security.addProvider(new org.bouncycastle.jce.provider.BouncyCastleProvider());
		KeyGenerator.getInstance(KEY_NAME).init(128);
	}

	/**
	 * 生成iv
	 */
	public static AlgorithmParameters generateIV(byte[] iv) throws Exception {
		// iv 为一个 16 字节的数组，这里采用和 iOS 端一样的构造方法，数据全为0
		// Arrays.fill(iv, (byte) 0x00);
		AlgorithmParameters params = AlgorithmParameters.getInstance(KEY_NAME);
		params.init(new IvParameterSpec(iv));
		return params;
	}

	/**
	 * 生成解密
	 */
	public static byte[] decrypt(byte[] encryptedData, byte[] keyBytes, AlgorithmParameters iv)
			throws Exception {
		Key key = new SecretKeySpec(keyBytes, KEY_NAME);
		Cipher cipher = Cipher.getInstance(CIPHER_ALGORITHM);
		// 设置为解密模式
		cipher.init(Cipher.DECRYPT_MODE, key, iv);
		return cipher.doFinal(encryptedData);
	}

	public static void main(String[] args) throws  Exception{
		// 微信demo中的测试数据
		String encrypted = "jY0spHCIa9oS5Pezk2Tkihiu/PPB+/Db1b6OZb+tCtq10Yef5Mi5F1q1azyCN9oXrU/RgJ3R6KPfh4o3z3uGsaZ0CxFZoEj58ge55I64mYkACOalctypveFXc64oKKklO7cFKaBeQzQR4D3zQhuuq7EbXBDMaq70joS3qLfNhr7wZE3M/chwhO9k9LqLUYivnqTVqO6VRGklKCFNgQgUcA==";
		encrypted = URLEncoder.encode(encrypted,"UTF-8");
		encrypted = URLDecoder.decode(encrypted,"UTF-8");
		String session_key ="D90ckUXWINige0z\\/IEEcrw==";
	   String iv = "7d7Kj61iucVx6/9u+Z74cA==";
		iv = URLEncoder.encode(iv,"UTF-8");

/*
		String encrypted ="yqqnPpsJC4ah4ocyo4LztlwN1J%2Fhy3ttAIqjlx0dATvD7ZFdwNEqyiCwdtilFf%2F7qRusm9%2FMaEgWSiOuhWGTTxKl%2Bbab86lBTwV3HYxYt3zes9JmeeMXxGJVaChUdu01VkwojonEpmyhbctfendjTRH314erlPSLb5IyVs5N6O2D6Ag1nbgJy1rAs7khBAkYX8%2FYqyvpaXLIrp%2BHcbvty%2B9U%2FTSNdAdt8kbZnuiS39NLrz8QHFfRtHsWZ%2FjmVXVjKt6S4AoussKa68X9Mpj9G4zhEpfkxzMIlBitLc3g1lqfkk6lEydeHQdwi3awoMb1zj1P%2BScZUEPup7yeP412LtYB4qS022xfhAbCBnLRCVv7ZOpTrFvzEzM0nSEqG4w2kThzmXTub3O%2Bj5UVHg4gIbl1szeN5WFzVkNH5pRJ1OJJvpO%2FcBnvtVAQ2%2FjPdKGNQLmYHv1fIBA%2Br10cOAgz6vx0KRnTkecXuujl6fo%2FrzM%3D";
		String session_key = "56SOkQyA2GSrpHPvRaeWWA==";
		encrypted = URLDecoder.decode(encrypted,"UTF-8");
		String iv = "lyBuHmLyqyG3grYTDFi7dg%3D%3D";*/
		String json = wxDecrypt(encrypted, session_key, URLDecoder.decode(iv,"UTF-8"));
		System.out.println(json);

		// 微信demo中的测试数据
		/*String encrypted = "CiyLU1Aw2KjvrjMdj8YKliAjtP4gsMZM" + "QmRzooG2xrDcvSnxIMXFufNstNGTyaGS" + "9uT5geRa0W4oTOb1WT7fJlAC+oNPdbB+" + "3hVbJSRgv+4lGOETKUQz6OYStslQ142d" + "NCuabNPGBzlooOmB231qMM85d2/fV6Ch" + "evvXvQP8Hkue1poOFtnEtpyxVLW1zAo6" + "/1Xx1COxFvrc2d7UL/lmHInNlxuacJXw" + "u0fjpXfz/YqYzBIBzD6WUfTIF9GRHpOn" + "/Hz7saL8xz+W//FRAUid1OksQaQx4CMs" + "8LOddcQhULW4ucetDf96JcR3g0gfRK4P" + "C7E/r7Z6xNrXd2UIeorGj5Ef7b1pJAYB" + "6Y5anaHqZ9J6nKEBvB4DnNLIVWSgARns" + "/8wR2SiRS7MNACwTyrGvt9ts8p12PKFd" + "lqYTopNHR1Vf7XjfhQlVsAJdNiKdYmYV" + "oKlaRv85IfVunYzO0IKXsyl7JCUjCpoG" + "20f0a04COwfneQAGGwd5oa+T8yO5hzuy" + "Db/XcxxmK01EpqOyuxINew==";
		String session_key = "tiihtNczf5v6AKRyjwEUhQ==";
		String iv = "r7BXXKkLb8qrSNn05n0qiA==";
		String json = wxDecrypt(encrypted, session_key, iv);
		System.out.println(json);*/
	}
}