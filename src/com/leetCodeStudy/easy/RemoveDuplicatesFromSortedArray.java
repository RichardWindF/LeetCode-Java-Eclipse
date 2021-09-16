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
		int elementNum = removeDuplicates(nums);
		int elementNum2 = removeDuplicates2(nums1);

		//System.out.println("数组长度=" + elementNum);
	}

	// 方法1： 有外部 List, 遍历一次，重复不加入
	//这个方法最后结果在列表中mList, 测试环境如果是leetCode,返回就可能不对
	public static int removeDuplicates(int[] nums)
	{
		
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
	
	
	// 方法2: 用双重指针，快慢两个指证针，
	//normalPoint-可插值的位置, fastPoint--数组扫描指针
	//这个方面没有用额外的存储空间，是在原数组上改动
	public static int removeDuplicates2(int[] nums)   //函数返回的是数组最后长度
	{
		if(nums.length==0)return 0;
		
		int normalP=1;//fastP;
		normalP=1;//fastP=0;
		int temp;
		
		for(int fastP=1;fastP<nums.length;fastP++)
		{
			if(nums[fastP]!=nums[normalP-1])
			{
				//temp=nums[normalP];
				nums[normalP]=nums[fastP];
				
				normalP++;        //最后位置在 修正后数组的有效位下一位的地方
			}
		}
		
		System.out.print("[");
		for(int i=0;i<normalP;i++)
		{
			System.out.print(nums[i]+",");
		}
		System.out.println("]");
		System.out.println("数组长度=" + normalP);
		
		
		return normalP;
		
	}
}


