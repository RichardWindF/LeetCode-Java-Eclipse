package com.leetCodeStudy.easy;

import java.util.ArrayList;
import java.util.List;

public class RemoveDuplicatesFromSortedArray
{
	// Remove Duplicates from Sorted Array
	// 删除排序数组中的重复项

	public static void main(String[] args)
	{
		 int[] nums = { 0, 0, 1, 2, 3, 3, 5,6,7,7,8,8,9,9,9,9 };
		int[] nums1 = { 1, 1, 2 };
		int elementNum = removeDuplicates(nums1);

		//System.out.println("数组长度=" + elementNum);
	}

	public static int removeDuplicates(int[] nums)
	{
		// 方法1： 有外部 List, 遍历一次，重复不加入
		List<Integer> mList = new ArrayList<>();
		
		if(nums.length==0)return 0;
		mList.add(nums[0]);
		for (int i = 0; i <nums.length; i++)
		{
			 if(nums[i]!=mList.get(mList.size()-1))
			{
				mList.add(nums[i]);
			}
		}

		System.out.println(mList.toString());
		System.out.println("数组长度为：="+mList.size());
		

		return mList.size();
	}

}
