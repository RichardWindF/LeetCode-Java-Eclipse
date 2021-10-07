package com.leetCodeStudy.easy_middle_hard;

/**
 * 2 ways to resolve question --Implement strStr()--返回 haystack 中第一次出现针的索引，如果针不是
 * haystack 的一部分， 则返回 -1。 查找空串返回0
 * 
 * 
 * 1st way: 使用Java 串的库函数 str.contains(subStr), str.indexOf(subStr) 
 * 
 * 2nd way: Java中的子串
 *     str.contains(needle),str.substring(i,subStr.length()+i);  //注意参数意义， 从i位--后面-1位 的子串
 *
 * @author Richard.F
 *
 */
public class Implement_strStr_028_020
{
	public static void prt(Object o)
	{
		System.out.println(o);
	}

	public static void main(String... args)
	{
		String haystack1 = "hello", needle1 = "ll";
		// Output: 2

		String haystack2 = "aaaaa", needle2 = "bba";
		// Output: -1

		String haystack3 = "", needle3 = "";
		// Output: 0

		prt("resolved by 1st way:");
		prt(new Solution020().strStr1(haystack1, needle1));
		prt(new Solution020().strStr1(haystack2, needle2)); //
		prt(new Solution020().strStr1(haystack3, needle3)); //

		prt("----------------------------------------------------");
		prt("resolved by 2nd way:");
		prt(new Solution020().strStr2(haystack1, needle1));
		prt(new Solution020().strStr2(haystack2, needle2)); //
		prt(new Solution020().strStr2(haystack3, needle3)); //

	}

}

//-----------------------------------------------------------

class Solution020
{
	// 1st way: 使用Java 串的库函数 str.contains(subStr), str.indexOf(subStr) 
	public int strStr1(String haystack, String needle)
	{
		int result;

		if (needle == null)
			return 0;
		if (haystack.contains(needle))
			result = haystack.indexOf(needle);
		else
			return -1;

		return result;

	}

	//2nd haystack.contains(needle),haystack.substring(i,needle.length()+i);  //注意参数意义， 从i位--后面-1位 的子串
	public int strStr2(String haystack, String needle)
	{
		if (needle == null)
			return 0;
		//char[] dst = new char[needle.length()];
		if (haystack.contains(needle))
			for (int i = 0; i < haystack.length(); i++)                
			{
				String result=haystack.substring(i,needle.length()+i);  //注意参数意义， 从i位--后面-1位 的子串
				
				if (result.equals(needle))
					{
					//new Implement_strStr_028_020().prt("result="+result);
					return i;
					}
				
			}
		else
			return -1;
		return 0;

	}

}