package com.leetCodeStudy.easy_middle_hard;

import java.util.Arrays;
import java.util.Collections;

/**
 * 2 ways to resolve question  --Valid Anagram (字谜--由相同得字母不同得顺序组成)
 * 
 * 1st way:  字符串->数组->排序->比较
 * 
 * 2nd way:  暴力查询+计数
 *
 * @author Richard.F
 *
 */

public class ValidAnagram_242_017
{
	public static void prt(Object o)
	{
		System.out.println(o);
	}
	
	public static void main(String...args)
	{
		String s1 = "anagram", t1 = "nagaram";  //Output: true
		String s2 = "rat", t2 = "car";			//Output: false
		
		prt("resolved by 1st way:");
		prt(new Solution017().isAnagram1(s1,t1)); //
		prt(new Solution017().isAnagram1(s2,t2)); //

		prt("----------------------------------------------------");
		//数组需要重新赋值，再测才正确,但变量不用（传值，传地址）
		
		prt("resolved by 2nd way:");
		prt(new Solution017().isAnagram2(s1,t1));
		prt(new Solution017().isAnagram2(s2,t2));
		
		
	}
}


//-------------------------------------------------------------;------------
class Solution017 {
	
	// 1st way:  字符串->数组->排序->比较
    public boolean isAnagram1(String s, String t) {
    	
    	if(s.length()!=t.length()) return false;
		
		  char[] s1=s.toCharArray(); 
		  char[] t1=t.toCharArray(); 
		  Arrays.sort(s1);
		  Arrays.sort(t1);   //这种转换时候，套叠得写法，容易出错，最好分开
    	
       return String.valueOf(s1).equals(String.valueOf(t1));
    }
    
    //2nd way:  暴力查询+计数
    public boolean isAnagram2(String s, String t) {
    	
    	if(s.length()!=t.length()) return false;
    	
    	char[]sArray=s.toCharArray();
    	char[]tArray=t.toCharArray();
    	
    	int[] count=new int[26];    //题设小写字母
    	
    	for(int i=0;i<s.length();i++)
    	{
    		count[sArray[i]-'a']++;
    	}
    	
    	for(int i=0;i<t.length();i++)
    	{
    		if(--count[tArray[i]-'a']<0) return false;        //通过上面生成得数组逐个减，最后全0，返回true
    	}
    	
    	return true;
    }
}
