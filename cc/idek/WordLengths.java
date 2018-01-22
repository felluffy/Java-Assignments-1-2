package com.cc.idek;
import edu.duke.*;
public class WordLengths
{

	public void countWordLengths(FileResource resource, int[] counts)
	{
		for(String words: resource.words())
		{
			//boolean fl = false;
			//System.out.println(words);
			words = words.trim();
			if(words.length() == 0 || words.length() == 1 && !Character.isLetter(words.charAt(0)))	//if the character isn't a letter of size 1
			{
				continue;
			}
			else
			{
				
				String build = new String();
				for(int i = 0; i != words.length(); i++)
				{
					if((i == 0 || i == words.length() - 1) && !Character.isAlphabetic(words.charAt(i)))
					{	
						//fl = true; 
						//System.out.println(words.charAt(i));
						continue;
					}
					else 
						build += words.charAt(i);		
				}
				if(build.length() < counts.length)
					++counts[build.length()];
				else
					++counts[counts.length - 1];
			}
		}
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
		countWordLengths(fr, counts);
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
		WordLengths blyat = new WordLengths();
		blyat.testCountWordLengths();
	}

}
