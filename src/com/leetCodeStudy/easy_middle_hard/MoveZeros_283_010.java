package com.leetCodeStudy.easy_middle_hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 2 ways to resolve question
 * 1st way:   遍历，非0加入ArrayList+0个数计数
 * 
 * 2nd way:  双指针遍历，有0就换？
 * 
 *
 * @author Richard.F
 *
 */

public class MoveZeros_283_010
{
	public static void prt(Object o)
	{
		System.out.println(o);
	}
	
	public static void main(String[] args)
	{
		
		int[] digits1 = {0,1,0,3,12}; // Output: [1,3,12,0,0]
		int[] digits2 = {0}; // Output: [0]

		prt("resolved by 1st way:");
		
		/*
		 * new Solution010().moveZeroes1(digits1); // new
		 * Solution010().moveZeroes1(digits2); //
		 */
		prt("----------------------------------------------------");
		prt("resolved by 2nd way:");
		new Solution010().moveZeroes2(digits1);
		new Solution010().moveZeroes2(digits2);

		
	}

}

//------------------------------------------------------
class Solution010 {
	
	// 1st way:   遍历，非0加入ArrayList+0个数计数
    public void moveZeroes1(int[] nums) {
        
    	List<Integer> mList=new ArrayList<>();
    	int zeroNum=0;
    	
    	for(int mInt:nums)
    	{
    		if(mInt==0) zeroNum++;
    		else mList.add(mInt);
    	}
    	
    	for(int i=0;i<zeroNum;i++) mList.add(0);      //尾部填0
    	
    	
    	for(int i=0;i<nums.length;i++) nums[i]=mList.get(i);    //赋值回原数组，在提交环境下需要还原到原数组
        
    	System.out.println(Arrays.toString(nums));  
    	
    }
    
    // 2nd way:  双指针遍历，有0就换-此处不要考虑太复杂，不需要嵌套，一次遍历即可

	public void moveZeroes2(int[] nums)
	{
		int left=0;
		for(int right=0;right<nums.length;right++)
			{
				if(nums[right]!=0) 
					{
					  swap(nums,left,right);
//					int temp=nums[left];
//					nums[left]=nums[right];
//					nums[right]=temp;
					
					left++;
					}
			}
    	System.out.println(Arrays.toString(nums));  
	}


	private void swap(int[] nums,int left, int right)
	{ //注意子函数的 数组传址， 传值 问题，此题如果传值，就不工作
//		int temp;
//		temp=i;
//		i=j;
//		j=temp;
		int temp=nums[left];
		nums[left]=nums[right];
		nums[right]=temp;
	}
}
