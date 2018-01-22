package com.cc.idek;

public class CaesarCipherTwo 
{
	public CaesarCipherTwo(int key1, int key2)
	{	
		alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		encryptedForm = new String[2];
		encryptedForm[0] = alphabet.substring(key1, 26) + alphabet.substring(0, key1);
		encryptedForm[1] = alphabet.substring(key2, 26) + alphabet.substring(0, key2);
		mainKey1 = key1;
		mainKey2 = key2;
	}
	
	public String encrypt(String input)
	{
		StringBuilder ret = new StringBuilder(input);
		for(int i = 0; i != ret.length(); i++)
		{
			if(Character.isAlphabetic(ret.charAt(i)))
			{
				if(Character.isUpperCase(ret.charAt(i)))
					ret.setCharAt(i, encryptedForm[i%2].charAt(ret.charAt(i) - 'A'));
				else
					ret.setCharAt(i, Character.toLowerCase(encryptedForm[i%2].charAt(Character.toUpperCase(ret.charAt(i)) - 'A')));
			}
		}
		return ret.toString();
	}
	
	public String decrypt(String input)
	{
        CaesarCipherTwo cct = new CaesarCipherTwo(26 - mainKey1, 26 - mainKey2);
        return cct.encrypt(input);
	}
	private String alphabet;
    private String[] encryptedForm;
    private int mainKey1;
    private int mainKey2;
}
