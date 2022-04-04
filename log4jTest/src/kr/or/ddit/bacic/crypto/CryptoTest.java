package kr.or.ddit.bacic.crypto;

import kr.or.ddit.util.CryptoUtil;

public class CryptoTest {

	public static void main(String[] args) throws Exception{
		String plainText = "Hello, World! 가나다라 1234 %$%^%^&+";
		
		//암호화에 사용하는 key값 설정(16자리 이상으로 한다.)
		String key = "a1b3c34dsfkjs834";
		
		System.out.println("단반향 암호화 연습...");
		
		String result = CryptoUtil.sha512(plainText);
		System.out.println("원본데이터:"+ plainText);
		System.out.println("SHA-512방식:"+ result);

		
		System.out.println();
		System.out.println("-----------------------------------------------");
		
		
		System.out.println("양방향 암호화 연습(AES256방식)...");
		System.out.println("원본데이터:"+ plainText);
		String encryptedStr = CryptoUtil.encryptoAE256(plainText, key);
		System.out.println("AES-256암호화:"+ encryptedStr);
		
		String decryptedStr = CryptoUtil.decryptoAE256(encryptedStr, key);
		
		System.out.println("AES-256복호화:"+ decryptedStr);
		
	}

}
