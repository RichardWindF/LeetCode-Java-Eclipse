package com.leetCodeStudy.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * 两个数组的交集 2 ways to resolve question 
 * 1st way: HashSet-里面没有重复元素（但List and Map
 * 均可以有） 
 * 2nd way: 暴力查询+HashSet
 * 
 * @author Richard F.
 *
 */
public class IntersectionTwoArraysI_349_007
{
	public static void prt(Object o)
	{
		System.out.println(o);
	}

	public static void main(String... args)
	{
		int[] nums1 = { 1, 2, 2, 1 }, nums2 = { 2, 2 }; // Output: [2]
		int[] nums3 = { 4, 9, 5 }, nums4 = { 9, 4, 9, 8, 4 }; // Output: [4,9], Explanation: [9,4] is also accepted.

		prt("resolved by 1st way:");
		prt(Arrays.toString(new Solution007().intersect1(nums1, nums2)));
		prt(Arrays.toString(new Solution007().intersect1(nums3, nums4)));

		prt("----------------------------------------------------");
		prt("resolved by 2nd way:");
		prt(Arrays.toString(new Solution007().intersect2(nums1, nums2)));
		prt(Arrays.toString(new Solution007().intersect2(nums3, nums4)));

	}

}

//------------------------------------------
class Solution007
{
	// 1st way, HashSet
	public int[] intersect1(int[] nums1, int[] nums2)
	{
		Set<Integer> mSet = new HashSet<>();
		for (int mInt : nums1)
		{
			mSet.add(mInt); // 此处加入的根据Set的特性，重复元素只存入了一次,重复的元素没有存储
		}

		List mList = new ArrayList<>();
		for (int mInt : nums2)
		{
			if (mSet.contains(mInt))
			{// 找出相同元素，加入结果列表，并且从Set 删除
				mList.add(mInt);
				mSet.remove(mInt);
			}
		}
		// IntersectionTwoArraysI_349_007.prt(nums2);

		int[] result = new int[mList.size()];
		for (int i = 0; i < result.length; i++)
		{
			result[i] = (int) mList.get(i);
		}
		return result;
	}

	// 2nd way, 暴力查询？

	public int[] intersect2(int[] nums1, int[] nums2)
	{
		Set<Integer> mSet = new HashSet<>();
		
		for (int i = 0; i < nums1.length; i++)
			for (int j = 0; j < nums2.length; j++)
			{
				if (nums1[i] == nums2[j])
					mSet.add(nums1[i]);
			}

		
		int[] result = new int[mSet.size()];
		
		int i=0;		
		for(int mInt:mSet)
		{
			result[i++] = mInt;
		}
		return result;
	}
}
