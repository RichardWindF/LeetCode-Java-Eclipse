package com.leetCodeStudy.easy_middle_hard;

/**
 * 2 ways to resolve question --String to Integer --给定一个字符串，转成数字，（必须是数字或者+-号开头）
 * 
 * 
 * 1st way: 暴力查询,trim()...
 * 
 * 2nd way:  一个个查询--为社么LEETCODE 上提交有问题，但这里运行都正常？
 *
 * @author Richard.F
 *
 */

public class StringToInteger_008_019
{
	public static void prt(Object o) {System.out.println(o);}
	
	public static void main(String... args)
	{
		String s1 = "42";                                       //Output: 42 range [-231, 231 - 1
		String s2 = "        -42";                                    // Output: -42
		String s3 = "4193 with words";                         //"Output: 4193"; 
		String s4 = "words and 987";                           //"Output: 0; 
		String s5 = "-91283472332";                            //Output: -2147483648=2^31-1
		
		prt("resolved by 1st way:");
		prt(new Solution019().myAtoi1(s1));
		prt(new Solution019().myAtoi1(s2)); //
		prt(new Solution019().myAtoi1(s3)); //
		prt(new Solution019().myAtoi1(s4)); //
		prt(new Solution019().myAtoi1(s5)); //


		prt("----------------------------------------------------");
		prt("resolved by 2nd way:");
		prt(new Solution019().myAtoi2(s1));
		prt(new Solution019().myAtoi2(s2));
		prt(new Solution019().myAtoi2(s3));
		prt(new Solution019().myAtoi2(s4));
		prt(new Solution019().myAtoi2(s5));

	}

}

//-----------------------------------------------------
class Solution019
{
	public int myAtoi1(String s)
	{
		if(s==null) return 0;
		s=s.trim();                               //去首尾空格后必须赋值给原串才可以
		if(s.length()==0) return 0;
		
		//int res=0;
		long res=0;
		int i=0;
		int flag=1;  //正数
		
		if(s.charAt(i)=='+') {flag=1; i++;}    //正负号
		else if(s.charAt(i)=='-') {flag=-1;i++;}
		
		for(;i<s.length();i++)                                       //抽出结果数字res
		{
			if(!Character.isDigit(s.charAt(i))) break;     //return (int)res*flag;--后面考虑返回
			//else 
			res=res*10+(s.charAt(i)-'0');
			if(res>Integer.MAX_VALUE) break;
		}
		
		      
		if(flag*res>Integer.MAX_VALUE) return Integer.MAX_VALUE;   //int 越界问题
		if(flag*res<Integer.MIN_VALUE) return Integer.MIN_VALUE;   //int 越界问题
		
		
		
		return flag==1?(int)res:-(int)res;

	}

	public int myAtoi2(String s)
	{
		if(s==null) return 0;
		
		int flag=1;                                   //默认正数
		//int result=0;
		long result=0;
		int i=0;
		for(;i<s.length();i++)                 //去掉前面空格
		{
			if(s.charAt(i)!=' ') break; //i++;
		}
		
		     //判断正负号 (第一个非空字符)
		if(s.charAt(i)=='+') {i++;}
		else if (s.charAt(i)=='-') {flag=-1;i++;}
		
		for(int j=i;j<s.length();j++)                    //判断数字或字母,并抽取
		{
			if(!Character.isDigit(s.charAt(j))) break;
			result=result*10+(s.charAt(j)-'0');
			if(result>Integer.MAX_VALUE) break;
		}
		
		//整数越界问题  
		if(flag*result>Integer.MAX_VALUE) return Integer.MAX_VALUE;
		if(flag*result<Integer.MIN_VALUE) return Integer.MIN_VALUE;
		
		return (int)result*flag;

	}
}
