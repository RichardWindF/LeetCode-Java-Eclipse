package com.leetCodeStudy.easy_middle_hard;

/**
 * 
 * 
 * * 2 ways to resolve question- First Bad Version--第一个错误的版本
 * 
 * 1st way: 暴力查询，?--超过时间限制，不是本例的要求
 * 
 * 
 * 2nd way: 二分法查询
 *
 * @author Richard.Feng
 */

public class FirstBadVersion_278_035
{
	public static void prt(Object o) {System.out.println(o);}
	
	public static void main(String...args)
	{
		int n1 = 5, bad1 = 4;
//				Output: 4
//				Explanation:
//				call isBadVersion(3) -> false
//				call isBadVersion(5) -> true
//				call isBadVersion(4) -> true
//				Then 4 is the first bad version.
				
		int n2 = 1, bad2 = 1;
				//Output: 1
		
		new Solution035().firstBadVersion1(5);
	}

}

//---------------------------------------------------------
/*
 * The isBadVersion API is defined in the parent class VersionControl. boolean
 * isBadVersion(int version);
 */
class VersionControl
{
	 public boolean isBadVersion(int version) {return false;};

}

class Solution035 extends VersionControl
{
	public int firstBadVersion1(int n)
	{
		if(n<1||n>Integer.MAX_VALUE) return -1;
		boolean result;
		int i;
		for(i=0;i<=n;i++)
		{
			result=isBadVersion(i);
			if(result) return i;
		}
		return 1;
	}
	
	public int firstBadVersion2(int n)
	{
		int begin=0,end=n;
		//int mid=(begin+end)/2;
		
		//for(begin=0;begin<end;begin++)                       //边界在循环中要改变，所以不用FOR 用while
		while(begin<=end)                       //边界在循环中要改变，所以不用FOR 用while
		{
			                                       //int mid=(begin+end)/2;--这个写法可能会溢出
			int mid=begin+(end-begin)/2;
			if(isBadVersion(mid)) end= mid;                   //先右后左-二分法
			else begin=mid+1;                                //2分法的边界好像比较模糊，几个不同的版本
			
		}
		
		
		
		return begin;

	}

	
}
