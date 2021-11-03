package com.leetCodeStudy.easy_middle_hard.DynamicProgramming;

/**
 * Dynamic Programming--动态规划 A: 状态b：初始化c：转化方程d：结果
 * 
 * * 2 ways to resolve question--Maximum Subarray--最大子数组(数字之和)--最大子序和
 * 
 * 1st way: 动态规划， 3 要素：  方程式+初始值+终止值
 * 每一步找到自己最大子序列的和， 和前面合并，或者不和前面合并
 * max([i],max[i-1]+[i])
 * 
 * int[] nums1 = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
 *current:        -2  1  -2  4   3  5  6   1  5                              //取当前之和 或者 当前数组值
 *result:         -2  1  1   4   4  5  6   6  6                               //也可以这个时候去取第二行的最大值
 * 
 * 2nd way: 暴力解法: 找出每个子数组项目的和，求出最大值，
 *    双指针
 *
 * 
 * @author Richard.Feng
 */

public class MaximumSubarray_053_038
{
	public static void prt(Object o)
	{
		System.out.println(o);
	}

	public static void main(String... args)
	{

		
		int[] nums1 = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
		// Output: 6
		// Explanation: [4,-1,2,1] has the largest sum = 6.

		int[] nums2 = { 1 };
		// Output: 1

		int[] nums3 = { 5, 4, -1, 7, 8 };
		// Output: 23

		prt("---1st way to reslove the questions:---");
		prt(new Solution038().maxSubArray1(nums1));
		prt(new Solution038().maxSubArray1(nums2));
		prt(new Solution038().maxSubArray1(nums3));

		prt("-------------------------------------------");
		prt("---2nd way to reslove the questions:---");
		prt(new Solution038().maxSubArray2(nums1));
		prt(new Solution038().maxSubArray2(nums2));
		prt(new Solution038().maxSubArray2(nums3));

	}

}

//--------------------------------------------------

class Solution038
{
	
	//1st way: 动态规划， 3 要素：  方程式+初始值+终止值
	public int maxSubArray1(int[] nums)
	{
		if(nums==null||nums.length==0) return 0;
		
		int current; //当前和 
		int result=current=nums[0];
		 
		 for(int i=1;i<nums.length;i++) 
		 { 
		// current=Math.max(current, current+nums[i]);         //result=Math.max(current, nums[i]);
		 current=Math.max(nums[i], current+nums[i]);         //result=Math.max(current, nums[i]);
		 result=Math.max(result, current);
	
		 }
		 return result;
		
	}
	
	 //2nd way: 暴力解法: 找出每个子数组项目的和，求出最大值，

	public int maxSubArray2(int[] nums)
	{
		if(nums==null||nums.length==0) return 0;
		
		int result=Integer.MIN_VALUE;
		for(int i=0;i<nums.length;i++)
		{
			int sum=0;
			for(int j=i;j<nums.length;j++)
				//for(int j=i+1;j<nums.length;j++)     //这里边界错一位都不可以
			{
				sum+=nums[j];
				result=Math.max(sum,result);
			}
		}
		return result;
	}
}
