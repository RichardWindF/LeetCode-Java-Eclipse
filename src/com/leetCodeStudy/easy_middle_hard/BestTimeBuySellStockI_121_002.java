package com.leetCodeStudy.easy_middle_hard;

 
public class BestTimeBuySellStockI_121_002
{
	public static void prt(Object o)
	{
		System.out.println(o);
	}
	
	public static void main(String...args)
	{
		int[] prices1= {7,1,5,3,6,4};   //5
		int[] prices2= {1,2,3,4,5};    //4
		int[] prices3= {7,6,4,3,1};     //0
		
		
		prt("maxProfit1最大收益："+new Solution002().maxProfit1(prices1));
		prt("maxProfit1最大收益："+new Solution002().maxProfit1(prices2));
		prt("maxProfit1最大收益："+new Solution002().maxProfit1(prices3));
		//-----------------------------------------------
		prt("-----------------------------------------------------");
		  prt("maxProfit2最大收益："+new Solution002().maxProfit2(prices1));
		  prt("maxProfit2最大收益："+new Solution002().maxProfit2(prices2));
		  prt("maxProfit2最大收益："+new Solution002().maxProfit2(prices3));
		 
	}

}


//--------------------------
class Solution002 {
	
	//方法1： 暴力查询
	//两个指针，嵌套双层循环，找出最大盈利
    public int maxProfit1(int[] prices) 
    {
    	int maxProfit=0; 
    	for(int i=0;i<prices.length-1;i++ )               //获得第i天的股票价格（最后留一天卖出才可以）
    		for(int j=i+1;j<prices.length;j++)         //i天后的股票价格
    		{
    			if(prices[i]<prices[j])
    			{
    				maxProfit=Math.max(maxProfit, prices[j]-prices[i]);
    				//break;
    			}
    		}
		return maxProfit;
    	
    }
    
    //方法2： 贪心算法？
    //只遍历一次， minPrice, maxProfit(最小价格，最大盈利)
    public int maxProfit2(int[] prices) 
    {
    	int minPrice=Integer.MAX_VALUE;   //这里因为每次比较存储最小价格，所以初值设为最大（因为股票价格无上限）
    	int maxProfit=0;
    	
    	for(int price:prices)
    	{
    			//maxProfit=Math.max(maxProfit, price-minPrice);
    			minPrice=Math.min(minPrice,price);
    			maxProfit=Math.max(maxProfit, price-minPrice);
    	}
    			
		return maxProfit;
        
    }
}