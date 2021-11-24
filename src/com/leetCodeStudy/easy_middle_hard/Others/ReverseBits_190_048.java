package com.leetCodeStudy.easy_middle_hard.Others;

import java.util.Arrays;

/**
 * Others
 * 
 * * 3 ways to resolve question--Reverse Bits--此处默认 无符号32 位（2进制）
 * 
 * 1st way:  先转未 2进制字符串， 再StringBuffer.reverse()反转， 再将二进制字符串变为整数返回--此方法测试总有点问题，最后那步
 * 
 * 2nd way--Integer.reverse()--本身的反转函数--关键要知道这个
 * 
 * 3rd way: 按位操作
 *          mask=(n&1);              //取出最低位
 *           n>>=1;                   //n 右移一位，赋值给自身
    	     result<<=1;             //res左移一位，赋值给自身
    		//result=result<<1;      //res左移一位，赋值给自身
 * 
 * 
 * @author Richard.Feng
 */

public class ReverseBits_190_048
{
	public static void prt(Object o) {System.out.println(o);}
	
	public static void main(String...args)
	{
		
     	int n1 = 0B00000010100101000001111010011100;
//				Output:    964176192 (00111001011110000010100101000000)
//				Explanation: The input binary string 00000010100101000001111010011100 represents the unsigned integer 43261596, so return 964176192 which its binary representation is 00111001011110000010100101000000.
//				Example 2:
//
		int n2 =0B11111111111111111111111111111101;
//				Output:   3221225471 (10111111111111111111111111111111)
		
		prt("-------------------------------------------");
		prt("---1st way to reslove the questions:---");
		prt(new Solution048().reverseBits1(n1));
		prt(new Solution048().reverseBits1(n2));
        

		prt("-------------------------------------------");
		prt("---2nd way to reslove the questions:---");
		prt(new Solution048().reverseBits2(n1));
		prt(new Solution048().reverseBits2(n2));
	

		prt("-------------------------------------------");
		prt("---3rd way to reslove the questions:---");
		prt(new Solution048().reverseBits3(n1));
		prt(new Solution048().reverseBits3(n2));
	}

}

//-----------------------------------------
class Solution048
{
    // you need treat n as an unsigned value   (32位)
    public int reverseBits1(int n) 
    {
    	
    	String str=Integer.toUnsignedString(n);
    	//String str=Integer.toBinaryString(n);
    	
    	StringBuffer strBuffer=new StringBuffer(str).reverse();
    	
//        String str2=new String(strBuffer);   //与上句同
//    	
//    	int mInt=Integer.parseInt(str2);
    

    	String str2=strBuffer.toString();
    	
    	int mInt=Integer.parseUnsignedInt(str2,10);//10进制的解析？
    	
		return mInt;
		
    }
    
    
    //2nd way--Integer.reverse()--本身的反转函数
    public int reverseBits2(int n) 
    {
    	return Integer.reverse(n);
        
    }
   
    // 3rd way --按位操作（32位）
    public int reverseBits3(int n) 
    {
    	int result=0;
    	int mask;//=1;
    	
    	for(int i=0;i<32;i++)
    	{
    		mask=(n&1);              //取出最低位
    		n>>=1;                   //n 右移一位，赋值给自身
    	
    	     result<<=1;             //res左移一位，赋值给自身
    		//result=result<<1;      //res左移一位，赋值给自身
    		result+=mask;
    	}
    	
		return result;
    	
//    	int res=0;
//    	int mask=1;
//    	int count=32;
//    	while(count-->0)
//    	{
//    		res=res<<1;         //res左移一位，赋值给自身
//    		res+=(mask&n);
//    		n>>=1;              //n 右移一位，赋值给自身
//    	}
//    	return res;
//    	
    }
}
