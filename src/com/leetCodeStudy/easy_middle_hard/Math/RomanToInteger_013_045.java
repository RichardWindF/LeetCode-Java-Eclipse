package com.leetCodeStudy.easy_middle_hard.Math;

import java.util.HashMap;
import java.util.Map;

/**
 * Math--数学问题
 * 
 * * 2 ways to resolve question-- Roman to Integer-- 罗马数转整型
 * 
 * 思路： 
 * --挨个比较，遇见小于自己的符号+， 遇见大的-(后面一位决定当前的正负，)--下面程序反之为什么通不过呢？
 * --形成对应的MAP<Charter,Integer> 
 * Symbol   Value
 *  I 1 
 *  V 5
 *  X 10
 *  L 50
 *  C 100
 *  D 500 
 *  M 1000
 * 
 * 思路中的两点执行即可！
 * 
 * 1st way:
 * 
 * 2nd way:
 * 
 * 3rd way:
 * 
 * 
 * @author Richard.Feng
 */

public class RomanToInteger_013_045
{
	public static void prt(Object o)
	{
		System.out.println(o);
	}

	public static void main(String... args)
	{
//		Input: s = "III"
//				Output: 3
//				Example 2:
//
//				Input: s = "IV"
//				Output: 4
//				Example 3:
//
//				Input: s = "IX"
//				Output: 9
//				Example 4:
//
//				Input: s = "LVIII"
//				Output: 58
//				Explanation: L = 50, V= 5, III = 3.
//				Example 5:
//
//				Input: s = "MCMXCIV"
//				Output: 1994
//				Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.

		prt("-------------------------------------------");
		prt("---1st way to reslove the questions:---");
		prt(new Solution045().romanToInt1("III"));
		prt(new Solution045().romanToInt1("IV"));
		prt(new Solution045().romanToInt1("IX"));
		prt(new Solution045().romanToInt1("LVIII"));
		prt(new Solution045().romanToInt1("MCMXCIV"));

		prt("-------------------------------------------");
		prt("---2nd way to reslove the questions:---");

		prt("-------------------------------------------");
		prt("---3rd way to reslove the questions:---");
	}

}

//---------------------------------------------------------------------------
class Solution045
{
	public int romanToInt1(String s)
	{
		Map<Character, Integer> mMap = new HashMap<>();
//    	Symbol       Value
//    	I             1
//    	V             5
//    	X             10
//    	L             50
//    	C             100
//    	D             500
//    	M             1000
//    	
		mMap.put('I', 1);
		mMap.put('V', 5);
		mMap.put('X', 10);
		mMap.put('L', 50);
		mMap.put('C', 100);
		mMap.put('D', 500);
		mMap.put('M', 1000);

		int sum = 0;
		for (int i = 0; i < s.length(); i++)
		{

			int cur=mMap.get(s.charAt(i));
			
			//if ( i + 1 < s.length() && cur>= mMap.get(s.charAt(i + 1)))    //i + 1 < s.length() 不能放在后面
			//sum += cur;
			//else                           //下面就可以，这里判断>=就不可以，为何？--因为“最后一位”应该是加                             
			//sum -= cur;
	//------------------------------------------------------------------------------
			if ( i + 1 < s.length() && cur< mMap.get(s.charAt(i + 1)))
				sum -= cur;
			else
				sum += cur;
		}
		return sum;
	}

	// ----------------------------------
	public int romanToInt2(String s)
	{
		return 0;

	}
}