package com.leetCodeStudy.easy_middle_hard;

/**
 * 2 ways to resolve question --Minimum Window Substring --最小窗口子串
 * -由相同得字母不同得顺序组成得"最小子串"-hard (字谜--由相同得字母不同得顺序组成,与上一题得类同处，但解法好像没有相似处 )
 * 
 * 1st way: 字符串->数组->排序->比较
 * 
 * 2nd way: 暴力查询+计数
 *
 * @author Richard.F
 *
 */

public class MinimumWindowSubstring_076_018
{
	public static void prt(Object o)
	{
		System.out.println(o);
	}

	public static void main(String... args)
	{

		String s1 = "ADOBECODEBANC", t1 = "ABC"; // Output: "BANC"
		String s2 = "a", t2 = "a"; // Output: "a"
		String s3 = "a", t3 = "aa"; // Output: ""

		prt("resolved by 1st way:");
		prt(new Solution018().minWindow1(s1, t1)); //
		prt(new Solution018().minWindow1(s2, t2)); //
		prt(new Solution018().minWindow1(s3, t3)); //

		prt("----------------------------------------------------");
		// 数组需要重新赋值，再测才正确,但变量不用（传值，传地址）

		prt("resolved by 2nd way:");
		prt(new Solution018().minWindow2(s1, t1));
		prt(new Solution018().minWindow2(s2, t2));
		prt(new Solution018().minWindow2(s3, t3));
	}

}
//------------------------------------------------------

class Solution018
{
	public String minWindow1(String s, String t)
	{
		return null;

	}

	public String minWindow2(String s, String t)
	{
		return t;

	}
}
