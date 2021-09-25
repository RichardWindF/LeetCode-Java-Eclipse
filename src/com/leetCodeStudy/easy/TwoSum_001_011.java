package com.leetCodeStudy.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 2 ways to resolve question 1st way: 暴力查询-双层嵌套
 * 
 * 2nd way: HashMap<target-元素, 下标>
 * 
 *
 * @author Richard.F
 *
 */

public class TwoSum_001_011
{
	public static void prt(Object o)
	{
		System.out.println(o);

	}

	public static void main(String... args)
	{
		// 元素也可以是负数的
		int[] nums1 = { 2, 7, 11, 15 }; // target = 9 output [0,1]
		int[] nums2 = { 3, 2, 4 }; // target = 6 output [1,2]
		int[] nums3 = { 3, 3 }; // target = 6 output [0,1]

		int target[] = { 9, 6, 6 };

		prt("resolved by 1st way:");

		prt(Arrays.toString(new Solution011().twoSum1(nums1, target[0]))); //
		prt(Arrays.toString(new Solution011().twoSum1(nums2, target[1]))); //
		prt(Arrays.toString(new Solution011().twoSum1(nums3, target[2]))); //

		prt("----------------------------------------------------");
		prt("resolved by 2nd way:");
		prt(Arrays.toString(new Solution011().twoSum2(nums1, target[0])));
		prt(Arrays.toString(new Solution011().twoSum2(nums2, target[1])));
		prt(Arrays.toString(new Solution011().twoSum2(nums3, target[2])));

	}
}

//-------------------------------------------------------------

class Solution011
{

	// 1st way: 暴力查询
	public int[] twoSum1(int[] nums, int target) // 返回数组中存有 结果下标 对
	{
		int[] result = new int[2];
		for (int i = 0; i < nums.length; i++)
			for (int j = 1; j < nums.length; j++)
				if (i != j && nums[i] + nums[j] == target)
				{
					result[0] = i;
					result[1] = j;
					break;
				}
		return result;
	}

	// 2nd way: HashMap<target-元素, 下标> //注意这个target-元素值 是唯一的，所可以当KEY //MAP
	// 不好从value取到KEY ，因为可以重复
	public int[] twoSum2(int[] nums, int target)
	{
		Map<Integer, Integer> mMap = new HashMap<>();
		for (int i = 0; i < nums.length; i++)
		{
			if (mMap.containsKey(target - nums[i]))
				return new int[] { mMap.get(target - nums[i]), i };

			mMap.put(nums[i], i);    //数组元素有重复值，覆盖后面没关系
		}

		return null;  //因为题目说有一个答案，不会到此

	}
}
