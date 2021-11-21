package com.leetCodeStudy.easy_middle_hard.Others;

//import com.leetCodeStudy.easy_middle_hard.Math.Solution045;

/**
 * Others
 * 
 * * 2 ways to resolve question-- Number of 1 Bits--
 * 
 * 
 * 
 * 1st way: 用Integer 本身的函数转成字符串，然后数1的个数即可
 *      String str=Integer.toBinaryString(n);
 *       if(str.charAt(i)=='1') count++;
 *       
 *       // 数字前 0B， 0O, 0D,0X--java 中好像是放前面
 * 
 * 2nd way:
 * 
 * 
 * 
 * @author Richard.Feng
 */
public class NumberOf1Bits_191_046
{
	public static void prt(Object o) {System.out.println(o);}
	
	public static void main(String...args)
	{
//		Input: n = 00000000000000000000000000001011
//				Output: 3
//				Explanation: The input binary string 00000000000000000000000000001011 has a total of three '1' bits.
//				Example 2:
//
//				Input: n = 00000000000000000000000010000000
//				Output: 1
//				Explanation: The input binary string 00000000000000000000000010000000 has a total of one '1' bit.
//				Example 3:
//
//				Input: n = 11111111111111111111111111111101
//				Output: 31
//				Explanation: The input binary string 11111111111111111111111111111101 has a total of thirty one '1' bits.
		
		int iBinary1=00000000000000000000000000001011;
		int iBinary2=00000000000000000000000010000000;
		int iBinary3=0B11111111111111111111111111111101;
		//int iBinary3=11111111111111111111111111111101B;  //放后面不对
		
		int iBinary4=0xabcdef;
		
		prt("-------------------------------------------");
		prt("---1st way to reslove the questions:---");
        prt(new Solution046().hammingWeight(iBinary1));
        prt(new Solution046().hammingWeight(iBinary2));
        prt(new Solution046().hammingWeight(iBinary3));
        prt(new Solution046().hammingWeight(iBinary4));

		prt("-------------------------------------------");
		prt("---2nd way to reslove the questions:---");

		prt("-------------------------------------------");
		prt("---3rd way to reslove the questions:---");
		
		
		
	}

}

//------------------------------------------------------
class Solution046
{
    // you need to treat n as an unsigned value
	
	
	//1st way: 用Integer 本身的函数转成字符串，然后数1的个数即可
    public int hammingWeight(int n) {
    	
    	String str=Integer.toBinaryString(n);
    	int count=0;
    	
    	for(int i=0;i<str.length();i++)
    	{
    		if(str.charAt(i)=='1') count++;
    	}
    		
    		
		return count;
        
    }
}
