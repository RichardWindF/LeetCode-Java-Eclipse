package com.leetCodeStudy.easy_middle_hard;

/**
 * 2 ways to resolve question --Longest Common Prefix-最长共同前缀
 * 
 * 
 * 1st way: 暴力查询, ，-运用String 的一些函数，并对它一个个字符缩短。
 * 
 * 2nd way: 还是暴力查询 找出最短串 运用String 的一些函数，以及 上面找到最短串后，并对它一个个字符缩短。。
 * 
 *
 * @author Richard.F
 *
 */
public class LongestCommonPrefix_014_022
{
	public static void prt(Object o)
	{
		System.out.println(o);
	}

	public static void main(String... args)
	{
		String[] strs1 = { "flower", "flow", "flight" }; // Output: "fl"

		String[] strs2 = { "dog", "racecar", "car" }; // Output: ""

		prt("resolved by 1st way:");
		prt(new Solution022().longestCommonPrefix1(strs1));
		prt(new Solution022().longestCommonPrefix1(strs2)); //

		prt("----------------------------------------------------");
		prt("resolved by 2nd way:");
		prt(new Solution022().longestCommonPrefix2(strs1));
		prt(new Solution022().longestCommonPrefix2(strs2));

	}

}

//--------------------------------------------------------
class Solution022
{
	public String longestCommonPrefix1(String[] strs)
	{
		if(strs==null || strs.length==0) return "";
		String result=strs[0];

		for(int i=1;i<strs.length;i++)
		{
			while(strs[i].indexOf(result)!=0)
				result=result.substring(0,result.length()-1);
		}
		
		return result;
	}

	public String longestCommonPrefix2(String[] strs)
	{
		if(strs==null||strs.length==0)return "";
		if(strs.length==1)return strs[0];
		 
		//找到的最短串，并对它一个个字符缩短。。--没有这个操作也是可以的
		int lengthStrMin = Integer.MAX_VALUE;    //求最小值嘛
		String result="";                        //假设下面求的最短串就是 最大前缀
		for (int i = 0; i < strs.length; i++)
		{
			if(lengthStrMin>strs[i].length())
			{
			lengthStrMin=strs[i].length();
			result=strs[i];
			}
		}
		
		//-------------------------------------------
		
		//对这个最短串一个个字符缩短处理
		for(int i=0;i<strs.length;i++)
		{
			while (!strs[i].startsWith(result))                 //直到找到最大前缀，再继续下一行
			{
				result=result.substring(0,lengthStrMin--);
				//result=result.substring(0,result.length()-1); //与上同
				
				if(result.isEmpty())break;
			}
			
		}
		
		
		return result; //prefix;

	}
}