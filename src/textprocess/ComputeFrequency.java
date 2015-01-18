package textprocess;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class ComputeFrequency {
	private static int longestpalindrome=17826; //length of the longest existing palindrome phrase
	public static Map<String,Integer> computeWordFrequencies(List<String> tokenlist)
	{
		Map<String,Integer> freqcount=new LinkedHashMap<String,Integer>();
		for(String str:tokenlist)
		{
			if(freqcount.containsKey(str))
			{
				freqcount.put(str,freqcount.get(str)+1);//if the token is already present, increase its count
			}
			else
			{
				freqcount.put(str, 1);//new token, count assigned to 1
			}
		}
		 
		 
			    
		return freqcount;
	}
	public static Map<String,Integer> computeTwoGramFrequencies(List<String> tokens)
	{
		Map<String,Integer> freqcount_2gram=new LinkedHashMap<String,Integer>();
		for(int i=0;i<tokens.size()-1;i++)
		{
			String str=tokens.get(i)+" "+tokens.get(i+1);//concatenating two adjacent strings to get the 2 grams
			if(freqcount_2gram.containsKey(str))
			{
				freqcount_2gram.put((str),freqcount_2gram.get(str)+1);//2-grams already present,increase the count
			}
			else
			{
				freqcount_2gram.put(str, 1);//new 2-gram, count assigned to 1
			}
		}
		 
		 
			    
		return freqcount_2gram;
		
		
	}
	public static Map<String,Integer> computePalindromeFrequencies(List<String> tokens)
	{
		Map<String,Integer> freqcount_palindromes=new LinkedHashMap<String,Integer>();
		int noOfTokens=tokens.size();
	
		for(int i=0;i<noOfTokens;i++)
		{
			StringBuilder strPal=new StringBuilder("");//String takes n square to concatenate,stringbuilder does in linear time
			
			for(int j=i;j<noOfTokens;j++)
			{
				if((j-i)>longestpalindrome)
					break;
				strPal.append(" ").append(tokens.get(j));
				
				if(palindromecheck(strPal))
				{
					String strPal_temp=strPal.toString().trim();//converting the stringbuilder back to string(only the palindromes are converted)
					if(strPal_temp.length()!=1)// single letter words are eliminated
					{
						if(freqcount_palindromes.containsKey(strPal_temp))
						{
							freqcount_palindromes.put((strPal_temp),freqcount_palindromes.get(strPal_temp)+1);//Palindrome already present,increase the count
						}
						else
						{
							freqcount_palindromes.put(strPal_temp, 1);//new palindrome, count assigned to 1
						}
					}
				}
			}
			
		}
		
		return freqcount_palindromes;
	}
	private static boolean palindromecheck(StringBuilder str)
	{
		int length=str.length();
	
		
		int i=0,j=length-1;
		while(i<j)
		{
			if(str.charAt(i)==' ')
				i++;
			if(str.charAt(j)==' ')
				j--;
			if(str.charAt(i)!=str.charAt(j))
			{
				return false;
			}
			i++;
			j--;
				
		}
		return true;
	}
}
