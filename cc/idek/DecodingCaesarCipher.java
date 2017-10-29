package com.cc.idek;
import edu.duke.*;
public class DecodingCaesarCipher 
{

	public void WordLength(FileResource resource, int[] counts)
	{
		for(String words: resource.words())

		{
			if(words.length() == 1 && Character.isLetter(words.charAt(0)))	//if the character isn't a letter of size 1
				continue;
			else
			{
				
				String build = new String();
				for(int i = 0; i != words.length(); i++)
				{
					if((i == 0 || i == words.length() - 1) && !Character.isAlphabetic(words.charAt(i)))
							continue;
					else 
						build += words.charAt(i);		
				}
				
				//System.out.println(build);
				if(build.length() < counts.length)
					++counts[build.length()];
				else
					++counts[counts.length - 1];
				//if(!Character.isAlphabetic(words.charAt(0)) || !Character.isAlphabetic(words.charAt(0)))
			}
		}
		//return new int [21];
	}
	
	public int indexOfMax(int[] counts)
	{
		int max = Integer.MIN_VALUE;
		for(int i = 0 ; i != counts.length; i++)
		{
			if(counts[i] > max)
				max = counts[i];
		}
		return max;
	}
	
	public void testCountWordLengths()
	{
		FileResource fr;
		fr = new FileResource();
		int[] counts = new int[31];
		WordLength(fr, counts);
		int i = 0;
		for(int value : counts)
		{	
			if(value != 0)
				System.out.println(value + " words of length " + i);
			i++;
		}
		int max = indexOfMax(counts);
		System.out.println("maximum average word size is: " + max);
		
	}
	
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		DecodingCaesarCipher blyat = new DecodingCaesarCipher();
		blyat.testCountWordLengths();
	}

}
