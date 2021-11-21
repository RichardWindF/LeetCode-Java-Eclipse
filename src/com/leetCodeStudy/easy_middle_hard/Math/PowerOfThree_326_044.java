package com.leetCodeStudy.easy_middle_hard.Math;

/**
 * Math--数学问题
 * 
 * * 3 ways to resolve question-- Power Of Three--3的次方
 * 
 * 
 * 1st way: log 的转换公式去做 double x=(Math.log(n)/Math.log(3));
 * if(Math.abs(x-Math.round(x))<1e-10) //关键,由题设 -231 <= n <= 231 - 1 ，数出是10 位
 * //此时认为是整数 //1e-10实际上是指1乘以10的-10次方
 * 
 * 2nd way: 纯数学方法考虑 if(Math.pow(3, 20)%n==0) return true; //自己去算出 Integer 的 3
 * 的最大幂次方 是20， 它能整除n,就表示n是3的幂次方
 * 
 * 3rd way:用计算机的循环去做,直到除到1 或者不是3 的幂次
 *       while (n > 1)
		{
			if(n%3!=0) return false;
			n /= 3;
		}
		
 * 
 * 
 * @author Richard.Feng
 */

public class PowerOfThree_326_044
{
	public static void prt(Object o)
	{
		System.out.println(o);
	}

	public static void main(String... args)
	{
//		Input: n = 27
//				Output: true
//				Example 2:
//
//				Input: n = 0
//				Output: false
//				Example 3:
//
//				Input: n = 9
//				Output: true
//				Example 4:
//
//				Input: n = 45
//				Output: false

		prt("-------------------------------------------");
		prt("---1st way to reslove the questions:---");
		prt(new Solution044().isPowerOfThree1(27));
		prt(new Solution044().isPowerOfThree1(45));
		prt(new Solution044().isPowerOfThree1(243));

		prt("-------------------------------------------");
		prt("---2nd way to reslove the questions:---");
		prt(new Solution044().isPowerOfThree2(27));
		prt(new Solution044().isPowerOfThree2(45));
		prt(new Solution044().isPowerOfThree2(243));

		prt("-------------------------------------------");
		prt("---3rd way to reslove the questions:---");
		prt(new Solution044().isPowerOfThree3(27));
		prt(new Solution044().isPowerOfThree3(45));
		prt(new Solution044().isPowerOfThree3(243));
	}

}

//------------------------------------------------
class Solution044
{
	// 1st way: log 的转换公式去做
	public boolean isPowerOfThree1(int n)
	{
		if (n <= 0)
			return false;

		double x = (Math.log(n) / Math.log(3)); // 如何判断是整数呢？

		// Math.round() 函数返回一个数字四舍五入后最接近的整数。
		// Math.abs函数是jdk中提供的一个用来返回入参绝对值的函数

		if (Math.abs(x - Math.round(x)) < 1e-10) // 关键,由题设 -231 <= n <= 231 - 1 ，算出是10 位
		{ // 此时认为是整数 //1e-10实际上是指1乘以10的-10次方
			return true;
		}
		return false;
	}

	// 2nd way: 纯数学方法考虑
	public boolean isPowerOfThree2(int n)
	{

		if (n <= 0)
			return false;

		if (Math.pow(3, 20) % n == 0)
			return true; // 自己去算出 Integer 的 3 的最大幂次方 是20， 它能整除n,就表示n是3的幂次方

		return false;

	}

	// 3rd way:用计算机的循环去做,直到除到1 或者不是3 的幂次
	public boolean isPowerOfThree3(int n)
	{
		if (n <= 0)
			return false;

		while (n > 1)
			//while (n > 0)
		{
			if(n%3!=0) return false;
			n /= 3;
		}
		
		return true;
		
	}
}