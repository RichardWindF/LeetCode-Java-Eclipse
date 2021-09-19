package com.leetCodeStudy.easy;

import java.util.Arrays;

/**
 * here are 2 ways to resolved this question 1: 暴力查询+额外空间 2： 3次反序数组及子数组完成
 * 
 * @author Richard F.
 *
 */

public class RotateArray_189_004
{
	public static void prt(Object o)
	{
		System.out.print(o);
	}

	public static void prtArray(int[] nums)
	{
		// 这个函数可以不用，因为等效于 System.out.println(Arrays.toString(nums));
		prt("result is: [");
		for (int mInt : nums)
		{
			prt(mInt + ",");
		} // output the result
		prt("] \n");
	}

	public static void main(String[] args)
	{
		int[] nums1 = { 1, 2, 3, 4, 5, 6, 7 };
		int k1 = 3; // result: [5,6,7,1,2,3,4]
		int[] nums2 = { -1, -100, 3, 99 };
		int k2 = 2; // result: [3,99,-1,-100]

		// ---------------------------------------------
		prt("original Array:\n ");
		prtArray(nums1);
		prtArray(nums2);
		prt("---------------------------------------------\n");

		// ---------------------------------------------------

		prt("Rotate Array by 1st way:\n");
		new Solution004().rotate1(nums1, k1); // Rotate Array by 1st way
		new Solution004().rotate1(nums2, k2);

		// -------------------------------------------------------------
		prt("---------------------------------------------\n");
		prt("Rotate Array by 2nd way:\n");
		new Solution004().rotate2(nums1, k1); // Rotate Array by 2nd way
		new Solution004().rotate2(nums2, k2);

	}

}

//----------------------------------------------------------
class Solution004
{

	// 1st way: 暴力查询+额外空间
	public void rotate1(int[] nums, int k)
	{
		int[] temp = new int[nums.length];

		for (int i = 0; i < nums.length; i++)
		{
			int mIndex = (i + k) % nums.length;
			temp[mIndex] = nums[i];
		}

		nums = temp;

		// -------------------------------------------------------------------------
		// 关于提交的几个说明， 因为这个中间无法识别数组的拷贝，非要你修改nums 在本函数中，所以，采用下面这段才可以修改，运行成功
		// nums=temp; // 哈哈，这个数组的复制，这里不工作？ eclipse 中工作
		// nums=Arrays.copyOf(temp,temp.length); 也不工作

//		 for(int i=0;i<nums.length;i++)
//		 {
//		 nums[i]=temp[i];
//		 }

		// -----------------------------------------------------------------------

		// -------------------------------------------------------------------------
		// RotateArray_189_004.prtArray(nums); //如果是代码提交，这句不需要，此处是显示运行结果，上下两句效果一样
		System.out.println(Arrays.toString(nums));
		// ---------------------------------------------------
	}

	// 2nd way: reverse
	public void rotate2(int[] nums, int k)
	{
		k = k % nums.length; // 当位移次数K 大于数组长度时候
		if (k == 0)
			return;

		reverse(nums, 0, nums.length - 1);
		reverse(nums, 0, k - 1);
		reverse(nums, k, nums.length - 1);
		// reverse(nums,k,nums.length-k);

		System.out.println(Arrays.toString(nums));

	}

	private void reverse(int[] nums, int begin, int end) // 方法2的关键
	{
		/*
		 * 
		 * for(int i=begin,j=end;i<j;i++,j--) //反转操作时候用前后两个指针去操作
		 * 
		 * { int temp; temp=nums[i]; nums[i]=nums[j]; nums[j]=temp;
		 * 
		 * 
		 * }
		 */
		
		while (begin < end) // 反转操作时候用前后两个指针去操作   //这两种循环写法均可
		{
			int temp;
			temp = nums[begin];
			nums[begin] = nums[end];
			nums[end] = temp;
			begin++;
			end--;
		}

	}
}