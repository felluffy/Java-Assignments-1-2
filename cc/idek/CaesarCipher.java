package com.cc.idek;

public class CaesarCipher 
{
	CaesarCipher(int key)
	{
		mainKey = key;
		alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		shiftedAlphabet = alphabet.substring(key, 26) + alphabet.substring(0, key);
	}
	
	String encrypt(String input)
	{
		StringBuilder ret = new StringBuilder(input);
		for(int i = 0; i != ret.length(); i++)
		{
			if(Character.isAlphabetic(ret.charAt(i)))
			{
				if(Character.isUpperCase(ret.charAt(i)))
					ret.setCharAt(i, shiftedAlphabet.charAt(ret.charAt(i) - 'A'));
				else
					ret.setCharAt(i, Character.toLowerCase(shiftedAlphabet.charAt(Character.toUpperCase(ret.charAt(i)) - 'A')));
			}
		}
		return ret.toString();
	}
	
	String decrypt(String input)
	{
		CaesarCipher cc = new CaesarCipher(26 - mainKey);
		return cc.encrypt(input);
	}
	
	public static void main(String[] args) 
	{
		CaesarCipher cc = new CaesarCipher(23);
		System.out.println(cc.encrypt("First Legion"));
		System.out.println(cc.decrypt(cc.encrypt("First Legion")));
	}
	
	int mainKey;
	private String alphabet;
	private String shiftedAlphabet;
	
}
