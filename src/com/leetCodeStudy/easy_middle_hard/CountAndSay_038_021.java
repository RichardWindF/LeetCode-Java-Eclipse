package com.leetCodeStudy.easy_middle_hard;

/**
 * 2 ways to resolve question --Count and
 * Say--统计连续字符出现的次数，说出这个字符是什么，把一个串这么统计并说出来。现在要知道 第n个串说出来
 * 
 * 
 * 1st way: 简单递归 ， 用stringBuilder.append() 等 //不是stringBuffer
 * 
 * 2nd way: 用 n 来控制次数， String.Valueof(int)....--整数转成串...等--这个方法好像有点问题，不对
 *
 * @author Richard.F
 *
 */
public class CountAndSay_038_021
{
	public static void prt(Object o)
	{
		System.out.println(o);
	}

	public static void main(String... args)
	{
		int n1 = 1;
		// Output: "1" Explanation: This is the base case.
		int n2 = 4;
//				Output: "1211"
//				Explanation:
//				countAndSay(1) = "1"
//				countAndSay(2) = say "1" = one 1 = "11"
//				countAndSay(3) = say "11" = two 1's = "21"
//				countAndSay(4) = say "21" = one 2 + one 1 = "12" + "11" = "1211"

		int nTest = 5; // 自设,111221

		prt("resolved by 1st way:");
		prt(new Solution021().countAndSay1(n1));
		prt(new Solution021().countAndSay1(n2)); //
		prt(new Solution021().countAndSay1(nTest)); //

		prt("----------------------------------------------------");
		prt("resolved by 2nd way:");
		prt(new Solution021().countAndSay2(n1));
		prt(new Solution021().countAndSay2(n2));
		prt(new Solution021().countAndSay2(nTest)); //

	}

}

//---------------------------------------

class Solution021
{
	//1st way: 简单递归 ， 用stringBuilder.append() 等 //不是stringBuffer
	public String countAndSay1(int n)
	{

		if (n <= 0)
			return "";
		if (n == 1)
			return "1";

		String str = countAndSay1(n - 1); // 先递归求出 n小1 的前面的 外观数列

		char currentChar = str.charAt(0); // 当前字符
		int count = 1; // 当前连续相同字符个数
		StringBuilder result = new StringBuilder(); // 用StringBuffer 最后结果 , 它有append()//注意是StringBuilder

		for (int i = 1; i < str.length(); i++) // 从下标为1的元素开始--？
		// for(int i=0;i<str.length();i++) //从下标为1的元素开始--？
		{
			if (str.charAt(i) == currentChar) // 当前字符等于 currentChar
			// if(str.charAt(i)==str.charAt(i+1))
			{
				count++;
			} else
			{
				result.append(count);
				// result.append(str.charAt(i));
				result.append(currentChar);
				count = 1;
				currentChar = str.charAt(i);
			}

		}

		result.append(count).append(currentChar); // 加上最后一个,?

		return result.toString();

	}

	//2nd way: 用 n 来控制次数， String.Valueof(int)....--整数转成串...等--这个好像有点问题
	public String countAndSay2(int n)
	{
		if (n == 1)
			{return "1";}
		else
		{
			String str = countAndSay2(n - 1);
			// char currentChar=str.charAt(0);
			int count = 1;
			String result = "";

			for (int i = 0; i < str.length()-1; i++)
			{
				if (str.charAt(i) == str.charAt(i++))
				{
					count++;
				} else
				{
					//result += count + str.charAt(i);
					 result=result+String.valueOf(count)+str.charAt(i);
					count = 1;
				}
			}
			
			//result+=count+str.charAt(str.length()-1);
			result=result+String.valueOf(count)+str.charAt(str.length()-1);
			return result;
		}
		

	}
}