package com.leetCodeStudy.easy_middle_hard;

import java.util.Arrays;

/**
 * 2 ways to resolve question
 *    此题的关键其实是遍历数组 从后-->前
 * 1st way:  【6.8.7.3】.【4，6，9，8，9】，【9，9，9】， 逢9进位
 * 
 * 2nd way:  (digits[i]+1)%10=0,进位，否则返回，，如果执行到循环结束后的语句，数组增长1位
 * 
 * 两种方法分开测试，（数组变换有影响）
 * 
 * @author Richard.F
 *
 */

public class PlusOne_066_009
{
	public static void prt(Object o)
	{
		System.out.println(o);
	}

	public static void main(String... args)
	{
		int[] digits1 = { 1, 2, 3 }; // Output: [1,2,4]
		int[] digits2 = { 4, 3, 2, 8 }; // Output: [4,3,2,9]
		int[] digits3 = { 2,3,9,9 }; // Output: [2,4,0,0]
		int[] digits4 = { 9,9,9 }; // Output: [1,0,0,0]

		prt("resolved by 1st way:");
		
		  prt(Arrays.toString(new Solution009().plusOne1(digits1))); //
		  prt(Arrays.toString(new Solution009().plusOne1(digits2))); //
		  prt(Arrays.toString(new Solution009().plusOne1(digits3))); //
		  prt(Arrays.toString(new Solution009().plusOne1(digits4)));
		 		

		prt("----------------------------------------------------");
		prt("resolved by 2nd way:");
		prt(Arrays.toString(new Solution009().plusOne2(digits1)));
		prt(Arrays.toString(new Solution009().plusOne2(digits2)));
		prt(Arrays.toString(new Solution009().plusOne2(digits3)));
		prt(Arrays.toString(new Solution009().plusOne2(digits4)));

	}

}

//---------------------------------------------------------------

//// Math.pow(a,b) a的b次方  这种方法来做此题，简单问题复杂化了，木必要：-）
class Solution009
{
	 //1st way:   【6.8.7.3】.【4，6，9，8，9】，【9，9，9】， 逢9进位
	
	public int[] plusOne1(int[] digits)
	{  //此题关键是反向遍历
		int len=digits.length-1;
		for (int i =len; i >=0; i--)
		{
			if(digits[i]<9)
			{
				digits[i]++; 
				return digits;
			}
			else  digits[i]=0;
		}
		
		//如果执行到循环结束后的语句，数组增长1位
		//  与下同效
		//digits[0]=1; digits=Arrays.copyOf(digits, digits.length+1); return digits;  //（digits已经全为0，）数组扩容的函数
		
		
		  int[] result=new int[digits.length+1]; 
		  result[0]=1; //其它位自动默认填0 
		  return result;
		 
	}

	//2nd way:  (digits[i]+1)%10=0,进位，否则返回，，如果执行到循环结束后的语句，数组增长1位
	
	public int[] plusOne2(int[] digits)
	{
		for(int i=digits.length-1;i>=0;i--)
		{
			digits[i]++;                         //如果后面进位，这里还是会运算了+1（进位）
			
			if(digits[i]%10==0)  digits[i]=0;
			else return digits;
			
		}
		
		int[] result=new int[digits.length+1];
		result[0]=1;
		return result;
	}
}