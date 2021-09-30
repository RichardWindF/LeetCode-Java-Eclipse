package com.leetCodeStudy.easy_middle_hard;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * 2 ways to resolve question :Single Number in Array
 * 
 * 1st :  用“异或^” 操作，同为0，异为1， -找出数组中只出现一次的元素的最好方法（其它最少出现2次）
 * 2nd: HastSet
 * 
 * @author fyhun
 *
 */

public class SingleNumber_136_006
{
	public static void prt(Object o)
	{
		System.out.println(o);
	}

	public static void main(String... args)
	{
		int [] nums1= {2,2,1};     //1
		int [] nums2= {4,1,2,1,2}; //4
		int [] nums3= {1};         //1
		
		
		
		prt("resolved by 1st way:");
		prt(new Solution006().SingleNumber1(nums1));
		prt(new Solution006().SingleNumber1(nums2));
		prt(new Solution006().SingleNumber1(nums3));

		prt("----------------------------------------------------");
		prt("resolved by 2nd way:");
		prt(new Solution006().singleNumber2(nums1));
		prt(new Solution006().singleNumber2(nums2));
		prt(new Solution006().singleNumber2(nums3));
	}

}

//------------------------------------------
class Solution006
{
	// 1st way--用“异或^” 操作，同为0，异为1， -找出数组中只出现一次的元素的最好方法（其它最少出现2次）
	public int SingleNumber1(int... nums) // 返回该数组中出现一次的元素值
	{
		int temp=0;
		for(int mInt:nums)
		{
			temp^=mInt;
		}
		return temp;

	}

	// ---------------------
	// 2nd way--HashSet?
	public int singleNumber2(int[] nums)
	{
		Set<Integer> mSet=new HashSet<>();
		
		for (int mInt:nums) // 
		{
			if (mSet.contains(mInt))
				 mSet.remove(mInt);
			else mSet.add(mInt);
		}
		
		/* 这个和下面 迭代器方法效果一样
		 * for(int mInt:mSet) { return mInt; }
		 */
		
		Iterator iterator=mSet.iterator();
		while(iterator.hasNext())
		{
			return (int) iterator.next();
		}
		return 0;

	}
}
