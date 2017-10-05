package com.cc.idek;
import edu.duke.*;

public class CaesarCipher {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CaesarCipher test = new CaesarCipher();
		//System.out.println(test.encrypt("fIRST LeGION ATtACK EASp FLANk!", 23));
		test.testCaesar();
	}

	String encrypt(String input, int key)
	{
		StringBuilder ret = new StringBuilder(input);
		String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String encryptedForm = alphabet.substring(key, 26) + alphabet.substring(0, key);
		System.out.println(encryptedForm);
		for(int i = 0; i != ret.length(); i++)
		{
			if(Character.isAlphabetic(ret.charAt(i)))
			{
				if(Character.isUpperCase(ret.charAt(i)))
					ret.setCharAt(i, encryptedForm.charAt(ret.charAt(i) - 'A'));
				else
					ret.setCharAt(i, Character.toLowerCase(encryptedForm.charAt(Character.toUpperCase(ret.charAt(i)) - 'A')));
			}
		}
		return ret.toString();
	}
	
	void testCaesar()
	{
		int key = 23;
		FileResource fr = new FileResource();
		String message = fr.asString();
		String encrypted = encrypt(message, key);
		System.out.println("key is: " + key + "\n" + encrypted);
	}
}
