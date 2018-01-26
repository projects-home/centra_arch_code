package com.ai.runner.center.pay.web.business.payment.util.third.unionpay.sdk;

import java.security.NoSuchAlgorithmException;

import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;

public class CliperInstance {
	private static ThreadLocal<Cipher> cipherTL = new ThreadLocal<Cipher>() {
		@Override
		protected Cipher initialValue() {
			try {
				return Cipher
						.getInstance(
								"RSA/ECB/PKCS1Padding",
								new org.bouncycastle.jce.provider.BouncyCastleProvider());
			} catch (Exception e) {
				return null;
			}
		}
	};

	public static Cipher getInstance() throws NoSuchAlgorithmException,
			NoSuchPaddingException {
		return cipherTL.get();
	}
}
