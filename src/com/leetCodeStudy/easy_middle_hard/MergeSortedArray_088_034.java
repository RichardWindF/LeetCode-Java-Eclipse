package com.leetCodeStudy.easy_middle_hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 
 * 
 * * 2 ways to resolve question- Merge Sorted Array--合并排序的数组
 * 
 * 1st way: 暴力查询，合并?
 * 
 * 
 * 
 * 2nd way: 用List?
 *
 * @author Richard.Feng
 */

public class MergeSortedArray_088_034
{
	public static void prt(Object o)
	{
		System.out.println(o);
	}

	public static void prt2(int[] a)
	{

		System.out.print("[");
		// for(int i=0;i<a.length;i++)
		for (int i : a)
		{
			// System.out.print(a[i]+",");
			System.out.print(i + ",");
		}
		System.out.print("]\n");

	}

	public static void main(String[] args)
	{
		int[] nums1 = { 1, 2, 3, 0, 0, 0 };
		int m1 = 3;
		int[] nums2 = { 2, 5, 6 };
		int n1 = 3;
		// Output: [1,2,2,3,5,6]

		int[] nums3 = { 1 };
		int m2 = 1;
		int[] nums4 = {};
		int n2 = 0;
		// Output: [1]

		int[] nums5 = {};
		int m3 = 0;
		int[] nums6 = { 1 };
		int n3 = 1;
		// Output: [1]

		
		  prt("resolved by 1st way:");
		  new Solution034().merge1(nums1, 3, nums2, 3);
		  new Solution034().merge1(nums3, 1, nums4, 0); 
		  new Solution034().merge1(nums5, 0, nums6, 1);
		 
		prt("----------------------------------------------------------\n");

		prt("resolved by 1st way:");
		new Solution034().merge2(nums1, 3, nums2, 3);
		new Solution034().merge2(nums3, 1, nums4, 0);
		new Solution034().merge2(nums5, 0, nums6, 1);

	}

}

//---------------------------------------------------------
class Solution034
{
	public void merge1(int[] nums1, int m, int[] nums2, int n)
	{
		
		  nums1=Arrays.copyOf(nums1, m+n);     //nums1数组 变长度
		  List<Integer> mList = new ArrayList<>();
		  
		  for (int i = 0; i < m; i++) { mList.add(nums1[i]); }
		  
		  for (int i = 0; i < n; i++) { mList.add(nums2[i]); }
		  
		  
		  for (int i = 0; i < m + n; i++) { nums1[i] = mList.get(i); }
		  
		  Arrays.sort(nums1);

		MergeSortedArray_088_034.prt2(nums1);

	}

	public void merge2(int[] nums1, int m, int[] nums2, int n)
	{
		  nums1=Arrays.copyOf(nums1, m+n);
		  for (int i = m; i < m + n; i++)
			{
				nums1[i] = nums2[i - m];
			}

			Arrays.sort(nums1);
			MergeSortedArray_088_034.prt2(nums1);

	}
}