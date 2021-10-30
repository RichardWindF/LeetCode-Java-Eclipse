package com.leetCodeStudy.easy_middle_hard.DynamicProgramming;


/**
 * Dynamic Programming--动态规划
 *A: 状态b：初始化c：转化方程d：结果
 * 
 * * 2 ways to resolve question- Climbing Stairs--爬楼梯
 * 
 * 1st way: Dynamic Programming--动态规划的方法
 * 
 *   A: 状态 f(i) b：初始化 f(1)=1 f(2)=2  c：转化方程 f(i)=f(i-1)+f(i-2) d：结果 f(i)
 * 
 * 
 * 2nd way: 递归 f(i)=f(i-1)+f(i-2)
 *
 *
 * @author Richard.Feng
 */

public class ClimbingStairs_070_036
{
	public static void prt(Object o)
	{
		System.out.println(o);
	}

	public static void main(String...args)
	{
		int floors1 = 2;
		// Output: 2
//				Explanation: There are two ways to climb to the top.
//				1. 1 step + 1 step
//				2. 2 steps
		int floors2 = 3;
		// Output: 3
//				Explanation: There are three ways to climb to the top.
//				1. 1 step + 1 step + 1 step
//				2. 1 step + 2 steps
//				3. 2 steps + 1 step
		
		 prt("resolved by 1st way:");
		 prt(new Solution036().climbStairs1(floors1));
		 prt(new Solution036().climbStairs1(floors2));
		 prt(new Solution036().climbStairs1(8));
		 
		prt("----------------------------------------------------------\n");

		prt("resolved by 2nd way:");
		 prt(new Solution036().climbStairs2(floors1));
		 prt(new Solution036().climbStairs2(floors2));
		 prt(new Solution036().climbStairs2(8));
		

	}

}

//----------------------------------------------

class Solution036
{

	 //1st way: Dynamic Programming--动态规划的方法
	 // A: 状态 f(i) b：初始化 f(1)=1 f(2)=2  c：转化方程 f(i)=f(i-1)+f(i-2) d：结果 f(i)
	
	public int climbStairs1(int n)
    {
    	//if(n<=1) return 0;
    	if(n<=2)  return n;    //1 或 2
    	
        int pre1=2;            //2阶时,  前一阶
        int pre2=1;            //1阶时， 前两阶
       	
    	int current=0;
    	for(int i=3;i<=n;i++)
    	{
    		current=pre1+pre2;
    		
    		pre2=pre1;
    		pre1=current;
    	}
    		
    	
    	
		return current;
        
    }
	
	// 2nd way: 递归 f(i)=f(i-1)+f(i-2)
	public int climbStairs2(int n)
	{
		if(n==1) return 1;
		if(n==2) return 2;
		
//		int result=climbStairs2(n-1)+climbStairs2(n-2);
//		return result;
		//结果 climbStairs2(n)=climbStairs2(n-1)+climbStairs2(n-2);
		
		return climbStairs2(n-1)+climbStairs2(n-2);

	}
}