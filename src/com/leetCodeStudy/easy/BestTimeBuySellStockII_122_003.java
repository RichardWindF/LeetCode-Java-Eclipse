package com.leetCodeStudy.easy;

public class BestTimeBuySellStockII_122_003
{
	public static void prt(Object o)
	{
		System.out.println(o);
	}
	
	public static void main(String...args)
	{
		int[] prices1= {7,1,5,3,6,4};   //7
		int[] prices2= {1,2,3,4,5};    //4
		int[] prices3= {7,6,4,3,1};     //0
		
		  prt("maxProfit1最大收益："+new Solution1().maxProfit(prices1));
		  prt("maxProfit1最大收益："+new Solution1().maxProfit(prices2));
		  prt("maxProfit1最大收益："+new Solution1().maxProfit(prices3));
	}
}

//----------------------------------
class Solution1     //前面一个文件已经定义了类 Solution , 所以这里换个名字
{
    public int maxProfit(int[] prices)
    {
    	int maxProfit=0;
    	
    	for(int i=0;i<prices.length-1;i++)
    	{
    		if(prices[i+1]>prices[i])                               //此例其实就是把所有能产生的收益叠加即可，day by day
    		    maxProfit+=prices[i+1]-prices[i];
    	}
    	
		return maxProfit;
        
    }
}