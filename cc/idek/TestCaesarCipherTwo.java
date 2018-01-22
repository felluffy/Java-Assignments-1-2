package com.cc.idek;

import edu.duke.FileResource;

public class TestCaesarCipherTwo 
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
	}
	
	public void breakCaesarCipher(String input)
	{
        String h1 = halfOfString(input, 0);
        String h2 = halfOfString(input, 1);
        int key1 = getKey(h1);
        int key2 = getKey(h2);
        CaesarCipherTwo cct = new CaesarCipherTwo(key1,key2);
        System.out.println("Two keys found: key1= " + key1 + ", key2= " + key2);
        System.out.println("Decrypted message:" + cct.decrypt(input));
}
	
	void simpleTests()
	{
		FileResource fr = new FileResource();
		String message = fr.asString();
		CaesarCipherTwo cc = new CaesarCipherTwo(17, 3);
		String en = cc.encrypt(message);
		System.out.println(en);

		//decrypt
		en = cc.decrypt(en);
		System.out.println(en);
		breakCaesarCipher("XJWW USCW AF LZW UGFXWJWFUW JGGE!");
	}
	
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		TestCaesarCipherTwo tcct = new TestCaesarCipherTwo();
		tcct.simpleTests();

	}

}
