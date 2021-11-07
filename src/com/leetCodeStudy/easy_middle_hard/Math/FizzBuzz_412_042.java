package com.leetCodeStudy.easy_middle_hard.Math;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;


/**
 * Math--数学问题
 * 
 * * 3 ways to resolve question-- Fizz Buzz-- 正确理解题意很关键（这里是多重条件判断而已）
 * 
 *  0st way:   字符串数组，牵涉到字符，asc码的转换，
 * 
 * 1st way:  ArrayList, 判断条件，然后添加进去
 * 
 * 2nd way:
 * 
 * @author Richard.Feng
 */

public class FizzBuzz_412_042
{
//	Example 1:
//
//		Input: n = 3
//		Output: ["1","2","Fizz"]
//		Example 2:
//
//		Input: n = 5
//		Output: ["1","2","Fizz","4","Buzz"]
//		Example 3:
//
//		Input: n = 15
//		Output: ["1","2","Fizz","4","Buzz","Fizz","7","8","Fizz","Buzz","11","Fizz","13","14","FizzBuzz"]

	public static void prt(Object o)
	{
		System.out.println(o);
	}

	public static void main(String[] args)
	{

		prt("---0st way to reslove the questions:---");
		fizzBuzzFy();

		prt("-------------------------------------------");
		prt("---1st way to reslove the questions:---");    //测试，3，5，15 数组长度
		prt(new Solution042().fizzBuzz1(3));              //list 的打印是直接打出列表里面的内容 （非asc 码,不用转换）
		prt(new Solution042().fizzBuzz1(5));
		prt(new Solution042().fizzBuzz1(15));
		
		prt("-------------------------------------------");
		prt("---2nd way to reslove the questions:---");
		

	}
	
	  //0st way:   字符串数组，牵涉到字符，asc码的转换，
	  

	public static void fizzBuzzFy()
	{
		Scanner sc = new Scanner(System.in);
		prt("请输入 数组长度n:");
		int n = sc.nextInt();

		if (n <= 0)
			prt("Wrong number!");

		String intArr[] = new String[n];
		for (int i = 0; i < n; i++)
		{
			if ((i + 1) % 3 == 0 && (i + 1) % 5 == 0)
			{
				intArr[i] = "FizzBuzz";
				continue;
			}
			if ((i + 1) % 3 == 0)
			{
				intArr[i] = "Fizz";
				continue;
			}
			if ((i + 1) % 5 == 0)
			{
				intArr[i] = "Buzz";
				continue;
			}

			intArr[i] = i + '1' + ""; // 数字->字符->字符串
		}
		for (int i = 0; i < intArr.length; i++)
			// prt("["+Integer.parseInt(intArr[i])+"]");
			prt(intArr[i].length() > 2 ? intArr[i] : Integer.parseInt(intArr[i]) - 48);
		// 0-9 的 asc 码长度是2， ‘0’--48
		// prt(Arrays.toString(intArr));

		// ASC 码怎样字符串输出呢？,-48的数字
	}

}

//Given an integer n, return a string array answer (1-indexed) where:
//
//answer[i] == "FizzBuzz" if i is divisible by 3 and 5.
//answer[i] == "Fizz" if i is divisible by 3.
//answer[i] == "Buzz" if i is divisible by 5.
//answer[i] == i if non of the above conditions are true.

//---------------------------------------------
class Solution042
{
	
	// 1st way:  ArrayList, 判断条件，然后添加进去
	public List<String> fizzBuzz1(int n)
	{
		List<String> resultList = new ArrayList<>();

		for (int i = 0; i < n; i++)
		{
			if ((i + 1) % 3 == 0 && (i + 1) % 5 == 0)
			{
				resultList.add(i, "FizzBuzz");
				continue;
			}

			if ((i + 1) % 3 == 0)
			{
				resultList.add(i, "Fizz");
				continue;
			}

			if ((i + 1) % 5 == 0)
			{
				resultList.add(i, "Buzz");
				continue;
			}

			resultList.add(i, i + 1 + "");
		}

		return resultList;

	}
}