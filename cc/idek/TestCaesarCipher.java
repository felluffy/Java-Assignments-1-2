package com.cc.idek;

import edu.duke.FileResource;

public class TestCaesarCipher 
{

	private int[] countLetters(String message)
	{
		String alph = "abcdefghijklmnopqrstuvwxyz";
		int[] counts = new int[26];
		for (int k = 0; k < message.length(); k++) {
			char ch = Character.toLowerCase(message.charAt(k));
			int dex = alph.indexOf(ch);
			if (dex != -1) 
			{
				counts[dex] += 1;
			}
		}
		return counts;
	}
	
	private int maxIndex(int[] values)
	{
        int max=0;
        for(int i=0; i< values.length;i++)
        {
            if(values[i] > values[max])
            {
                max = i;
            }  
        }    
        return max;
	}
	
	public void breakCaesarCipher(String input)
	{
        int[] letterFreqs = countLetters(input);
        int maxindex = maxIndex(letterFreqs);
        int dkey = maxindex - 4;
        if (maxindex < 4) {
            dkey = 26 - (4-maxindex);
        }
        CaesarCipher c = new CaesarCipher(dkey);
        System.out.println("Encrypted message:\n" + input);
        System.out.println("\nkey:" + dkey);
        System.out.println("\nDecrypted message:\n" + c.decrypt(input));
	}
	
	void simpleTests()
	{
		FileResource fr = new FileResource();
		String message = fr.asString();
		CaesarCipher cc = new CaesarCipher(18);
		String en = cc.encrypt(message);
		System.out.println(en);

		//decrypt
		en = cc.decrypt(en);
		System.out.println(en);
		breakCaesarCipher("XJWW USCW AF LZW UGFXWJWFUW JGGE!");
	}
	
	public static void main(String[] args) 
	{
		TestCaesarCipher tcc = new TestCaesarCipher();
		tcc.simpleTests();
	}

}
