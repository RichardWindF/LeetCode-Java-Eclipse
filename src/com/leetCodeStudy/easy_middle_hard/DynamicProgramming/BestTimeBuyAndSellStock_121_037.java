package com.leetCodeStudy.easy_middle_hard.DynamicProgramming;


/**
 * Dynamic Programming--动态规划 A: 状态b：初始化c：转化方程d：结果
 * 
 * * 2 ways to resolve question-Best Time to Buy and Sell Stock--股票买卖的最好时间
 * --//与数组第2题相同？
 * 
 * 1st way: 暴力遍历？
 * 
 * 
 * 
 * 2nd way: Dynamic Programming--动态规划的方法--贪心算法
 * minPrice  maxProfit
 *
 *
 * @author Richard.Feng
 */

public class BestTimeBuyAndSellStock_121_037
{
	public static void prt(Object o) {System.out.println(o);}
	
	public static void main(String...args)
	{
       int[] prices1 = {7,1,5,3,6,4};    // 5
       
       int[] prices2= {1,2,3,4,5,9};     //8
       int[] prices3 = {7,6,4,3,1};     // 0
   	    
	
	
	prt("maxProfit1最大收益："+new Solution037().maxProfit1(prices1));
	prt("maxProfit1最大收益："+new Solution037().maxProfit1(prices2));
	prt("maxProfit1最大收益："+new Solution037().maxProfit1(prices3));
	//-----------------------------------------------
	prt("-----------------------------------------------------");
	  prt("maxProfit2最大收益："+new Solution037().maxProfit2(prices1));
	  prt("maxProfit2最大收益："+new Solution037().maxProfit2(prices2));
	  prt("maxProfit2最大收益："+new Solution037().maxProfit2(prices3));
	 
	
	}


}

//------------------------------------------------------------
class Solution037
{
	//1st way: 暴力遍历？
	public int maxProfit1(int[] prices)
	{
		int maxProfit=0;
		int i=0,j=1;
		
		for(i=0;i<prices.length;i++)
		  for(j=i+1;j<prices.length;j++)
		  {
			  maxProfit=Math.max(maxProfit, prices[j]-prices[i]);
		  }
		
		return maxProfit;
	}

	//2nd way: Dynamic Programming--动态规划的方法--贪心算法
	public int maxProfit2(int[] prices)
	{
		int minPrice=Integer.MAX_VALUE;     //初值设个最大，一会儿要取小值
		int maxProfit=0;
		
		for(int i=0;i<prices.length;i++)
		{
			minPrice=Math.min(minPrice,prices[i]);
			maxProfit=Math.max(maxProfit, prices[i]-minPrice);
		}
		
		return maxProfit;
	
	}
}
