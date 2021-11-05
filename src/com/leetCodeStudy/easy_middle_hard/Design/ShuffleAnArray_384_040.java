package com.leetCodeStudy.easy_middle_hard.Design;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * Design--数学问题，洗牌问题
 * 
 * * 2 ways to resolve question--  Shuffle an Array--洗牌问题
 * 
 * 1st way: 一个原始数组，一个拷贝数组
 *       this.original=nums;
        this.copy= Arrays.copyOf(nums, nums.length)；  //数组拷贝
        new Random().nextInt(5);   [0,5) 随机数
 * 
 * 2nd way: 借用LIST, 数组填入随机的
 *
 * 
 * @author Richard.Feng
 */

public class ShuffleAnArray_384_040
{
	public static void prt(Object o) {System.out.println(o);}
	
	public static void prt(int[] mInt)             //其实可以 array.toString()打印，不用写这个函数
	{
		
		System.out.print("[");
		for(int i=0;i<mInt.length;i++)
		{
			System.out.print(mInt[i]+",");
		}
		System.out.print("]\n");
	}
	
	public static void main(String...args)
	{
//		Input
//		["Solution", "shuffle", "reset", "shuffle"]
//		[[[1, 2, 3]], [], [], []]
//		Output
//		[null, [3, 1, 2], [1, 2, 3], [1, 3, 2]]
	//
//		Explanation
//		Solution solution = new Solution([1, 2, 3]);
//		solution.shuffle();    // Shuffle the array [1,2,3] and return its result.
//		                       // Any permutation of [1,2,3] must be equally likely to be returned.
//		                       // Example: return [3, 1, 2]
//		solution.reset();      // Resets the array back to its original configuration [1,2,3]. Return [1, 2, 3]
//		solution.shuffle();    // Returns the random shuffling of array [1,2,3]. Example: return [1, 3, 2]
		
		int[] nums1= {1,2,3,4,5,6,7,8};
		
		prt("---1st way to reslove the questions:---");
		prt(nums1);
		prt(new Solution040(nums1).shuffle1());
		prt(new Solution040(nums1).reset1());
	
		prt("-------------------------------------------");
		prt("---2nd way to reslove the questions:---");
		prt(nums1);
		prt(new Solution040(nums1).shuffle2());
		prt(new Solution040(nums1).reset2());
	
	}

}


//------------------------------------------------------
class Solution040 {

	int[] original;            //原始数组
	int[] copy;                //拷贝数组
	
    public Solution040(int[] nums) {
        this.original=nums;
        this.copy= Arrays.copyOf(nums, nums.length);
    }
    
    //1st way: 一个原始数组，一个拷贝数组
//    *       this.original=nums;
//    this.copy= Arrays.copyOf(nums, nums.length)；  //数组拷贝
//    new Random().nextInt(5);   [0,5) 随机数

    public int[] reset1() {
    	
		return original;
        
    }
    
    public int[] shuffle1() {
    	
        for(int i=0;i<copy.length;i++)
        {
        	
        	int temp;
        	int index1=new Random().nextInt(copy.length);           //[0,copy.length) 之间的随机数
        	int index2=new Random().nextInt(copy.length);
        	
        	temp=copy[index1];
        	copy[index1]=copy[index2];
        	copy[index2]=temp;
        }
		return copy;
        
    }
    
    //-------------------------------------------------
    //2nd way: 借用List随机添加形成新数组即可
    
    public int[] reset2() {
		return original;
        
    }
    
    public int[] shuffle2() {
    	
    	List<Integer> mList=new ArrayList<>();
    	for(int i=0;i<copy.length;i++)                            //数组到LIST 的转换
    	{
    		mList.add(copy[i]);
    	}
    	
        for(int i=0;i<copy.length;i++)
    	{
    		int index=new Random().nextInt(mList.size());                //这样不行，因为有重复，错
    		copy[i]=mList.get(index);
    		mList.remove(index);
    	}
    	
		/*
		 * Integer[] result= mList.toArray(new Integer[mList.size()]); //List 到数组的转换
		 * int[] result1=new int[result.length]; //Integer[]-->int[] 转换 for(int
		 * i=0;i<result1.length;i++) { result1[i]=result[i]; }
		 */
    	return copy;
    	
        
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */