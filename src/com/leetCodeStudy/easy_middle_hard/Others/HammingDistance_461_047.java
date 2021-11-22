package com.leetCodeStudy.easy_middle_hard.Others;

/**
 * Others
 * 
 * * 2 ways to resolve question-- Hamming Distance--韩明距离，简单的位操作
 * 
 * 1st way:  转换为2进制，异或操作，然后数1即可?
 *        --Yes, correct.--运算时候不用转2进制，结果转，然后数1就可以了
 * 
 * 2nd way:  按位操作？-yes
 *     if((temp&1)==1) count++;
    		temp>>=1;     //右移1位
 * 
 * 
 * @author Richard.Feng
 */

public class HammingDistance_461_047
{
	public static void prt(Object o) {System.out.println(o);}

	public static void main(String...args)
	{
		
//		Input: x = 1, y = 4
//				Output: 2
//				Explanation:
//				1   (0 0 0 1)
//				4   (0 1 0 0)
//				       ↑   ↑
//				The above arrows point to positions where the corresponding bits are different.
//				Example 2:
//
//				Input: x = 3, y = 1
//				Output: 1
		
		int x1=1,y1=4;     //2
		
		int x2=3,y2=1;     //1
		
		int x3=0b00110011;
		int y3=0b11011100;   //7
		
		
		prt("-------------------------------------------");
		prt("---1st way to reslove the questions:---");
        prt(new Solution047().hammingDistance(x1, y1));
        prt(new Solution047().hammingDistance(x2, y2));
        prt(new Solution047().hammingDistance(x3, y3));

		prt("-------------------------------------------");
		prt("---2nd way to reslove the questions:---");
		prt(new Solution047().hammingDistance2(x1, y1));
        prt(new Solution047().hammingDistance2(x2, y2));
        prt(new Solution047().hammingDistance2(x3, y3));

		prt("-------------------------------------------");
		prt("---3rd way to reslove the questions:---");
	}
}


//----------------------------------------------------------------
class Solution047
{
//	1st way:  转换为2进制，异或操作，然后数1即可?
//			 *        --Yes, correct.--运算时候不用转2进制，结果转，然后数1就可以了
    public int hammingDistance(int x, int y) 
    {
    	int temp=x^y;
    	String resultStr=Integer.toBinaryString(temp);
    	int count=0;
    	
    	for(int i=0;i<resultStr.length();i++)
    	{
    		if(resultStr.charAt(i)=='1') count++;
    	}
    	
		return count;
        
    }
    
    //2nd way:  按位操作？--yes
    public int hammingDistance2(int x, int y) 
    {
    	int temp=x^y;
    	int count=0;
    	
    	for(int i=0;i<32;i++)
    	{
    		if((temp&1)==1) count++;
    		temp>>=1;
    	}
		return count;
    	
    }
}
