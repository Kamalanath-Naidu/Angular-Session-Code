package com.player.management.pms.system.SecurityService;


import java.io.UnsupportedEncodingException;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class Pms_Encrypt_Decrypt {

private static final String key ="09897654321i235a";

//private static final String vector ="09897654321i235a";

private static final String stringRepo="asdfghjklzxcvbnmqwertyuiopASDFGHJKLQWERTYUIOPZMNBVXC1234567890";
public static String getRandomIVSecurityCode() {
	
	StringBuilder builder =new StringBuilder();
	int length=16;
	while(length-- !=0) {
		int charIndex=(int) (Math.random()*16);
		builder.append(stringRepo.charAt(charIndex));
	}
	return builder.toString();
	
}


public static String encrypt(String value) {
	
	try {
		
		String vector=getRandomIVSecurityCode();
		System.out.println("IV Random value(in Encrypt): "+vector);
		
		IvParameterSpec iv =new IvParameterSpec(vector.getBytes("UTF-8"));
		SecretKeySpec keySpec= new SecretKeySpec (key.getBytes("UTF-8"),"AES");
		
		Cipher cipher =Cipher.getInstance("AES/CBC/PKCS5PADDING");
		
		cipher.init(Cipher.ENCRYPT_MODE, keySpec, iv);
		
		byte[] encrypted= cipher.doFinal(value.getBytes());
		return Base64.getEncoder().encodeToString(encrypted);
		
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.getMessage();
	}	
	return null;
}

public static String decrypt(String value, String inputIv, String userkey) {
	
	try {
		String vector=inputIv;
		 for (var j = userkey.length(); j < 16; j++) {
			 userkey += 0;
		    }
System.out.println("userkay in decr:"+userkey);
		
		//
		System.out.println("IV Random value(in Decrypt): "+vector);
		System.out.println("value(in Decrypt): "+value);
		IvParameterSpec iv =new IvParameterSpec(vector.getBytes("UTF-8"));
		SecretKeySpec keySpec= new SecretKeySpec (userkey.getBytes("UTF-8"),"AES");
		
		Cipher cipher =Cipher.getInstance("AES/CBC/PKCS5PADDING");
		
		cipher.init(Cipher.DECRYPT_MODE, keySpec, iv);
		
		byte[] decrypted= cipher.doFinal(Base64.getDecoder().decode(value));
		return new String(decrypted);
		
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.getMessage();
	}	
	return null;
}



}
