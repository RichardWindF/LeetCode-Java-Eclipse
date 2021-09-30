package com.leetCodeStudy.easy_middle_hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 
 * 两个数组的交集,只是重复的数字要分别记载
 *  2 ways to resolve question 
 *  
 * 1st way:用排序+List (因爲可以重復，不用Set)
 * 2nd way: HashMap-<key,value>,HashMap<数据，数据出现的次数>--复习map时候建议看看
 * 
 * @author Richard F.
 * 
 */

public class IntersectionTwoArraysII_350_008
{
	public static void prt(Object o)
	{
		System.out.println(o);
	}
	
	public static void main(String...args)
	{
		int[] nums1 = { 1, 2, 2, 1 }, nums2 = { 2, 2 }; // Output: [2,2]
		int[] nums3 = { 4, 9, 5 }, nums4 = { 9, 4, 9, 8, 4 }; // Output: [4,9], Explanation: [9,4] is also accepted.
		
		prt("resolved by 1st way:");
		prt(Arrays.toString(new Solution008().intersect1(nums1, nums2)));
		prt(Arrays.toString(new Solution008().intersect1(nums3, nums4)));

		prt("----------------------------------------------------");
		prt("resolved by 2nd way:");
		prt(Arrays.toString(new Solution008().intersect2(nums1, nums2)));
		prt(Arrays.toString(new Solution008().intersect2(nums3, nums4)));

	}

}

//---------------------------------------------------------------------------
class Solution008
{
	//1st way:用排序+List (因爲可以重復，不用Set)
    public int[] intersect1(int[] nums1, int[] nums2)
    {
    	List<Integer> mList=new ArrayList<>();
    
	    Arrays.sort(nums1);                      //注意數組排序方法
	    Arrays.sort(nums2);
		
    	/*for(int i=0;i<nums1.length;i++)               //排序了，不用暴力查询
    		for(int j=0;j<nums2.length;j++)*/
    	
	    int i=0,j=0;
	    while(i<nums1.length&&j<nums2.length)
    		{
    			if(nums1[i]==nums2[j])
    			{
    				mList.add(nums1[i]);
    				i++;j++;
    				continue;
    			}
    			
    			if(nums1[i]>nums2[j]) j++;
    			else i++;
    		}
    	
    	int[]result=new int[mList.size()];
    	
    	for( i=0;i<mList.size();i++)
    	{
    		result[i]=mList.get(i);
    	}
	        return result;
	}
    
    //2nd way: HashMap<数据，数据出现的次数>
    //  先遍历第一个数组，统计出 数据+出现个数，存入MAP 中， 
    //然后遍历第二个数组，如果map中存在且个数>0,则加入结果列表中
    public int[] intersect2(int[] nums1, int[] nums2)
    {
    	Map<Integer,Integer> mMap=new HashMap<>();
    	List<Integer> resultList=new ArrayList<>();
    	
    	for(int mInt:nums1)
    	{
    		if(mMap.containsKey(mInt)) mMap.put(mInt,mMap.get(mInt)+1);
    		else mMap.put(mInt, 1);
    	}
    	
    	for(int mInt:nums2)
    	{
    		if(mMap.containsKey(mInt)&&(mMap.get(mInt)>0))
    		{
    			resultList.add(mInt);
    			mMap.put(mInt,mMap.get(mInt)-1);
    		}
    	}
		
    	int[] resultArr=new int[resultList.size()];
    	
    	//for(int i=0;i<resultArr.length;i++)  // 两个函数头功能一样
    	int i=0;
    	for(int mInt:resultList)
    	{
    		resultArr[i]=resultList.get(i);
    		i++;
    	}
	        return resultArr;
	}
    
}