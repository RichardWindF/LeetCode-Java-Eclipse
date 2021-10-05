package com.leetCodeStudy.easy_middle_hard;


/**
 * 2 ways to resolve question --Valid Palindrome
 * --给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写(但标点什么得要考虑)
 * 
 * 
 * 1st way: 暴力查询,辅助空间
 * 
 * 2nd way: StringBuffer辅助空间--主要看这个方法
 *
 * @author Richard.F
 *
 */

public class ValidPalindrome_125_018
{
	public static void prt(Object o)
	{
		System.out.println(o);
	}

	public static void main(String... args)
	{

		String s1 = "A man, a plan, a canal: Panama"; // Output: true, "amanaplanacanalpanama" is a palindrome.
		String s2 = "race a car"; // Output: false, Explanation: "raceacar" is not a palindrome.

		prt("resolved by 1st way:");
		prt(new Solution018().isPalindrome01(s1));
		prt(", is " + (!new Solution018().isPalindrome01(s1) ? "not a palindrome." : "a palindrome.")); //

		prt(new Solution018().isPalindrome01(s2));
		prt(", is " + (!new Solution018().isPalindrome01(s2) ? "not a palindrome." : "a palindrome.")); //

		prt("----------------------------------------------------");
		prt("resolved by 2nd way:");
		prt(new Solution018().isPalindrome02(s1));
		prt(", is " + (!new Solution018().isPalindrome02(s1)? "not a palindrome." : "a palindrome.")); //

		prt(new Solution018().isPalindrome02(s2));
		prt(", is " + (!new Solution018().isPalindrome02(s2)? "not a palindrome." : "a palindrome.")); //

	}

}

//--------------------------------------------------------

class Solution018
{

	private String removeMarks(String s)
	{
		// s.replace(" ",""); //并没有更改s 中得数据，所有下面还是调用得老数据
		StringBuffer str = new StringBuffer(s); // 此时调用得还是有空格得老数据？

		for (int i = 0; i < str.length(); i++)
		{
			char key = str.charAt(i);

			
			if (!(key <= '9' && key >= '0' || key >= 'a' && key <= 'z' // ||key!=' '))
					|| key >= 'A' && key <= 'Z'))
				str.deleteCharAt(i); // 空格为何没有取掉呢？ 此函数不可以去掉空格？

			// if(key>126||key<33)str.deleteCharAt(i);
		}

		return str.toString();
	}

	public boolean isPalindrome01(String s)
	{
		// s去除标点符号等等
		// s.trim(); //这个只取首尾空格
		s = s.replace(" ", "");

		String str = removeMarks(s.toLowerCase());
		StringBuffer strr = new StringBuffer(str);
		String str2 = strr.reverse().toString();

		return str.equals(str2); // 用String 得比较函数

	}

	public boolean isPalindrome02(String s)
	{
		// 字符和数字得ascII 码是：0-9,a-z,A-Z
		StringBuffer sbf=new StringBuffer();
		
		for(int i=0;i<s.length();i++)
		{
			char mChar=s.charAt(i);
			if(Character.isLetterOrDigit(mChar))
			{
				mChar=Character.toLowerCase(mChar);
				sbf.append(mChar);
			}
		}
		
		//StringBuffer sbfReverse=new StringBuffer(sbf.reverse());                //这个表示方法出错，为何呢？
		StringBuffer sbfReverse=new StringBuffer(sbf).reverse();       //要先转再反序
		
		//return sbf.equals(sbfReverse);                                //尽量用String比较，不是StringBuffer比较
		return sbf.toString().equals(sbfReverse.toString());

	}
}
