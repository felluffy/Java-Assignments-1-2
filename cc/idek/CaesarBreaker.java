package com.cc.idek;

public class CaesarBreaker 
{
	public int[] countLetters(String message)
	{
		String alph = "abcdefghijklmnopqrstuvwxyz";
		int[] counts = new int[26];
		for(int k = 0; k < message.length(); k++)
		{
			char ch = Character.toLowerCase(message.charAt(k));
			int dex = alph.indexOf(ch);
			if(dex != -1)
				counts[dex] += 1;
		}
		return counts;
	}
	
	public int maxIndex(int[] vals)
	{
		int maxDex = 0;
		for(int k = 0; k < vals.length; k++)
		{
			if(vals[k] > vals[maxDex])
				maxDex = k;
		}
		return maxDex;
	}
	
	
	//Works apparently only for common e 
	public String decrypt(String encrypted)
	{
		CaesarCipher cc = new CaesarCipher();
		int[] freqs = countLetters(encrypted);
		int maxDex = maxIndex(freqs);
		int dkey = maxDex - 4;
		if(maxDex < 4)
			dkey = 26 - (4 - maxDex);
		return cc.encrypt(encrypted, 26-dkey);
	}
	
	public String halfOfString(String message, int start)
	{
		String answer = "";   
        for (int i= start; i < message.length() ; i += 2) 
        {
            answer += message.charAt(i);    	
        }
        return answer;
	}
	
	public int getKey(String s)
	{
		int[] freqs = countLetters(s);
		int maxDex = maxIndex(freqs);
		int dkey = maxDex - 4;
		if(maxDex < 4)
			dkey = 26 - (4 - maxDex);
		return dkey;
//		return maxDex;
	}
	
	//Works apparently only for common e  as well..
	public String decryptTwoKeys(String encrypted)
	{
		String h1 = halfOfString(encrypted, 0);
        String h2 = halfOfString(encrypted, 1);
        System.out.println(h1);
        System.out.println(h2);
        int key1 = getKey(h1);
        int key2 = getKey(h2);
        System.out.println("Two keys found: key1= " + key1 + ", key2= " + key2);
        CaesarCipher cc = new CaesarCipher();
        return (cc.encryptTwoKeys(encrypted, 26-key1, 26-key2));
	}
	
	public static void main(String[] args) 
	{
		CaesarBreaker cb = new CaesarBreaker();
		CaesarCipher cc = new CaesarCipher();
//		String encrypted = cc.encrypt("eel fishies are nice fishies", 23);
		String encrypted = cc.encryptTwoKeys("FIRST LEGION ATTACK EAST FLANK blyat eeeeee!", 23, 17);
		System.out.println(encrypted);
		String decrypted = cb.decryptTwoKeys(encrypted);
		System.out.println(decrypted);
	}

}
