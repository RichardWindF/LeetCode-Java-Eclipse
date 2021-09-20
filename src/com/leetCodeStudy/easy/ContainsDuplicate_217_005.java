package com.leetCodeStudy.easy;

import java.util.HashSet;
import java.util.Set;

/**
 * 2 ways to resolved the question;
 * 
 * 1st: 暴力查询， 2个FOR嵌套 2nd: Set.contains()
 * 
 * @author fyhun
 *
 */

public class ContainsDuplicate_217_005
{
	public static void prt(Object o)
	{
		System.out.println(o);
	}

	public static void main(String[] args)
	{
		int nums1[] = { 1, 2, 3, 1 }; // true
		int nums2[] = { 1, 2, 3, 4 }; // false
		int nums3[] = { 1, 1, 1, 3, 3, 4, 3, 2, 4, 2 }; // true

		prt("resolved by 1st way:");
		prt(new Solution005().containsDuplicate1(nums1));
		prt(new Solution005().containsDuplicate1(nums2));
		prt(new Solution005().containsDuplicate1(nums3));

		prt("----------------------------------------------------");
		prt("resolved by 2nd way:");
		prt(new Solution005().containsDuplicate2(nums1));
		prt(new Solution005().containsDuplicate2(nums2));
		prt(new Solution005().containsDuplicate2(nums3));

	}

}

//-------------------------------------
class Solution005
{
	// 1st way : 暴力查询
	public boolean containsDuplicate1(int[] nums)
	{
		if (nums.length <= 1)
			return false;
		for (int i = 0; i < nums.length - 1; i++)
			for (int j = i + 1; j < nums.length; j++)
				if (nums[i] == nums[j])
					return true;
		// else return false;
		return false;

	}

	// --------------------------------------------
	// 2nd way : HashSet
	public boolean containsDuplicate2(int... nums)
	{
		//此例也可以用 HashSet 去做 set.contians()
		Set<Integer> set = new HashSet<>();

		for (int mInt : nums)
		{
			if (set.contains(mInt))
				return true;
			set.add(mInt);
		}

		//System.out.println(set.toString()); //
		return false;

	}

}


