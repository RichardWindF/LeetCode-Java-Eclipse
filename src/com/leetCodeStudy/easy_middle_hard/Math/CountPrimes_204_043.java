package com.leetCodeStudy.easy_middle_hard.Math;

import java.util.ArrayList;
import java.util.List;

/**
 * Math--数学问题
 * 
 * * 3 ways to resolve question-- Count Primes-- prime numbers --质数（小于给定n)
 * 
 * -- 大于等于2， 只能被1及自身整除的 数，我们称为质数
 * 
 *  1st way: 根据概念， 写个判断质数的函数， 暴力解法，双套循环。
 * --但是在leetCode 环境下，运行超时--结果正确！ List 是可以直接打印的（内容），这个与数组名是不同的打印 prt(primesList);
 * prt(Arrays.toString(arrName));
 * 
 * 2nd way:埃拉托斯特尼篩法(Sieve of Eratosthenes)判断素数
 * 測試n是否為質數的最基本方法為試除法。此一程序將n除以每個大於1且小於等於n的平方根之整數m。 若存在一個相除為整數的結果，則n不是質數；反之則是個質數。
 * 上面两种方法的不同，就是 如何判断素数 的 方法不同而已！(运行超时--结果正确！)
 * 
 * 3rd way:空间换时间，定义一个大小为n 的数组，由小到大对每个数字标记！--这个运行不超时
 * 
 * @author Richard.Feng
 */

public class CountPrimes_204_043
{
//	Input: n = 10
//			Output: 4
//			Explanation: There are 4 prime numbers less than 10, they are 2, 3, 5, 7.
//			Example 2:
//
//			Input: n = 0
//			Output: 0
//			Example 3:
//
//			Input: n = 1
//			Output: 0

	public static void prt(Object o)
	{
		System.out.println(o);
	}

	public static void main(String... args)
	{
		prt("-------------------------------------------");
		prt("---1st way to reslove the questions:---");
		prt("Count primes:" + new Solution043().countPrimes1(10)); // 4
		prt("Count primes:" + new Solution043().countPrimes1(0)); // 0
		prt("Count primes:" + new Solution043().countPrimes1(1)); // 0
		prt("Count primes:" + new Solution043().countPrimes1(20)); // 8 [2, 3, 5, 7,11,13,17,19]

		prt("-------------------------------------------");
		prt("---2nd way to reslove the questions:---");
		prt("Count primes:" + new Solution043().countPrimes2(10)); // 4
		prt("Count primes:" + new Solution043().countPrimes2(0)); // 0
		prt("Count primes:" + new Solution043().countPrimes2(1)); // 0
		prt("Count primes:" + new Solution043().countPrimes2(20)); // 8 [2, 3, 5, 7,11,13,17,19]

		prt("-------------------------------------------");
		prt("---3rdd way to reslove the questions:---");
		prt("Count primes:" + new Solution043().countPrimes3(10)); // 4
		prt("Count primes:" + new Solution043().countPrimes3(0)); // 0
		prt("Count primes:" + new Solution043().countPrimes3(1)); // 0
		prt("Count primes:" + new Solution043().countPrimes3(20)); // 8 [2, 3, 5, 7,11,13,17,19]
	}

}

//----------------------------------------------
class Solution043
{
	// 1st way: 暴力解法，双套循环。 --但是在leetCode 环境下，运行超时--结果正确！
	public int countPrimes1(int n)
	{
		if (n <= 1)
			return 0;

		int count = 0;
		List<Integer> primesList = new ArrayList<>();

		for (int i = 0; i < n; i++)
		{
			if (isPrime1(i))
			{
				count++;
				primesList.add(i);
			}
		}

		CountPrimes_204_043.prt(primesList);

		return count;

	}

	private boolean isPrime1(int n)
	{
		if (n <= 1)
			return false;
		for (int i = 2; i < n; i++)
		{
			if (n % i == 0) // 非质数
				return false;
		}
		return true;
	}

	// --------------------------------------------
	// 2nd way:埃拉托斯特尼篩法(Sieve of Eratosthenes)
	// 測試n是否為質數的最基本方法為試除法。此一程序將n除以每個大於1且小於等於n的平方根之整數m。
	// 若存在一個相除為整數的結果，則n不是質數；反之則是個質數。

	public int countPrimes2(int n)
	{
		if (n <= 1)
			return 0;
		int count = 0;
		List<Integer> primesList = new ArrayList<>();
		for (int i = 0; i < n; i++)
		{
			if (isPrimes2(i))
			{
				count++;
				primesList.add(i);
			}
		}

		CountPrimes_204_043.prt(primesList);

		return count;

	}

	private boolean isPrimes2(int n)
	{
		if (n <= 1)
			return false;

		for (int i = 2; i <= Math.sqrt(n); i++)
		{
			if (n % i == 0)
				return false; // 非质数

		}
		return true;
	}

	// --------------------------------------------------------------
	// 3rd way:空间换时间，定义一个大小为n 的数组，由小到大对每个数字标记！

	public int countPrimes3(int n)
	{
		if (n <= 1)
			return 0;

		// 默认所有的元素都设置为false
		boolean[] isNotPrime = new boolean[n]; // 默认初值都是false,即假设都是质数
		isNotPrime[0] = isNotPrime[1] = true;

		for (int i = 2; i <= Math.sqrt(n); i++)
		{
			// 如果i是质数，i*2的倍数都为非质数
			// 如果i是合数，必定已设 true， 因为从2开始处理
			if (isNotPrime[i])
				continue; // 不是质数，继续

			for (int j = 2 * i; j < n; j += i) // 质数就处理
				// for(int j=i*i;j<n;j+=i) //质数就处理
				isNotPrime[j] = true;
		}

		// 统计质数个数
		int count = 0;
//        for(boolean b:isNotPrime)           //这个只统计数字可以，如果要内容，就用下面的
//        {
//			if(!b) count++;
//			//primesList.add(i);
//        }

		List<Integer> primesList = new ArrayList<>();
		for (int i = 0; i < isNotPrime.length; i++)
		{
			if (!isNotPrime[i])
			{
				count++;
				primesList.add(i);
			}

		}

		CountPrimes_204_043.prt(primesList);

		return count;

	}

}