package com.leetCodeStudy.easy_middle_hard.DynamicProgramming;

/**
 * Dynamic Programming--动态规划 A: 状态b：初始化c：转化方程d：结果
 * 
 * * 2 ways to resolve question--House Robber--打家劫舍：-）
 * 
 * 1st way: 动态规划， 3 要素： 方程式+初始值+终止值
 *      [i-2] [i-1], [i], --确定数组中第i个位置，究竟时拿下  【当前-2】+【当前】， 还是【i-1】，从左侧考虑，循环向右
 *      dp[i]=max(dp[i-2]+nums[i],dp[i-1]);
 * 
 * 2nd way: 
 *
 * 
 * @author Richard.Feng
 */

public class HouseRobber_198_039
{
	public static void prt(Object o)
	{
		System.out.println(o);
	}

	public static void main(String... args)
	{
		int[] nums1 = {1,2,3,1};
				//Output: 4
				//Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
				//Total amount you can rob = 1 + 3 = 4.
		int[] nums2 = {2,7,9,3,1};
				//Output: 12
				//Explanation: Rob house 1 (money = 2), rob house 3 (money = 9) and rob house 5 (money = 1).
				//Total amount you can rob = 2 + 9 + 1 = 12.
		
		prt("---1st way to reslove the questions:---");
		prt(new Solution039().rob1(nums1));
		prt(new Solution039().rob1(nums2));

		prt("-------------------------------------------");
		prt("---2nd way to reslove the questions:---");
		prt(new Solution039().rob2(nums1));
		prt(new Solution039().rob2(nums2));

	}

}

//-------------------------------------------------------------
class Solution039
{
	
	//1st way: 动态规划， 3 要素： 方程式+初始值+终止值
	 //      [i-2] [i-1], [i], --确定数组中第i个位置，究竟时拿下  【当前-2】+【当前】， 还是【i-1】，从左侧考虑，循环向右
	 //      dp[i]=max(dp[i-2]+nums[i],dp[i-1]);
	public int rob1(int[] nums)
	{
		/*
		 * // int sumG; //奇偶数这种做法是 不对的， 比如 【2，1，1，2】 ，应该是4，可以间隔2个1 // int sumO=sumG=0;
		 * // for(int i=0;i<nums.length;i++) // { // if(i%2==0) sumO+=nums[i]; // else
		 * sumG+=nums[i]; // } // return sumG>sumO? sumG:sumO;
		 */		
		if(nums.length==0) return 0;
		if(nums.length==1) return nums[0];
		//if(nums.length==2) return Math.max(nums[0], nums[1]);   //此句不必须
		
		int[] memo=new int[nums.length];               //该数组存储偷窃第 i 间房时候的，得到金钱的最大数(两种方案的最大值)
		memo[0]=nums[0];                               //第一间
		memo[1]=Math.max(nums[0], nums[1]);            //第二间
		
		for(int i=2;i<memo.length;i++)                 //第3间开始
		{
			//memo[i]=Math.max(memo[i]+memo[i-2],memo[i-1]);
			memo[i]=Math.max(memo[i-2]+nums[i],memo[i-1]);
			
		}
		
		return memo[memo.length-1];

	}

	public int rob2(int[] nums)
	{
		return 0;

	}
	
}