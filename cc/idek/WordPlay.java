package com.cc.idek;

public class WordPlay {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WordPlay test = new WordPlay();
		System.out.println(test.isVowel('a') + " " + test.isVowel('F'));
		System.out.println(test.replaceVowels("Hello World", '*'));
	}

	boolean isVowel(char ch)
	{
		char chCopy = Character.toLowerCase(ch);
		if(chCopy == 'a' || chCopy == 'e' || chCopy == 'i' || chCopy == 'o' || chCopy == 'u')
			return true;
		return false;
	}
	
	String replaceVowels(String phrase, char ch)
	{
		StringBuilder ret = new StringBuilder(phrase);
		for(int i = 0; i != ret.length(); i++)
		{
			if(isVowel(ret.charAt(i)))
				ret.setCharAt(i, ch);
		}
		return ret.toString();
	}
}
