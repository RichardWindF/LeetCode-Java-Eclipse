package com.leetCodeStudy.easy;


/**
 * 2 ways to resolve question  --整数的倒序
 * 
 * 1st way:  a/10-取整， a%0--取余，   循环中 result=result*10+ a%10
	     //-231 <= x <= 231 - 1
 * 
 * // 2nd way: 做字符串来反序，有相应的函数--不提倡这种方法
	// 整数-->字符串    String.valueOf(num)
	//字符串-->整数     Integer.parseInt(Str)
	// new StringBuffer(s).reverse()  //StringBuffer 有反序函数
 *   //负数的负号 转换字符时候，忽略不处理？
 *
 * @author Richard.F
 *
 */

public class ReverseInteger_007_015
{

	public static void prt(Object o)
	{
		System.out.println(o);
	}

	public static void main(String... args)
	{
		int s1=351;  	   //	Output: 153
		int s2 =-456;      //Output: -654
		
		prt("resolved by 1st way:");
		prt(new Solution015().reverseInteger1(s1)); //
		prt(new Solution015().reverseInteger1(s2)); //

		prt("----------------------------------------------------");
		//数组需要重新赋值，再测才正确,但变量不用（传值，传地址）
		
		prt("resolved by 2nd way:");
		prt(new Solution015().reverseInteger2(s1));
		prt(new Solution015().reverseInteger2(s2));

	}
}

//----------------------------------------------------------------
class Solution015
{
	
	// 1st way:  a/10-取整， a%0--取余，   循环中 result=result*10+ a%10
	     //-231 <= x <= 231 - 1
	
	public int reverseInteger1(int mInt)
	{
		//int result=0;
		long result=0;        //此处用long 来存储结果，如果最后不在INT 空间内，就返回0，否则。。
		while(mInt!=0)
		{
			result=result*10+mInt%10;    // 取出的个位依次放入result 中
			mInt/=10;                    //去掉最低位， 如: 123/10=12
		}
		
		if(result>Integer.MAX_VALUE||result<Integer.MIN_VALUE) return 0;     //判断范围是否合法
		else return (int)result;
	}

	// 2nd way: 做字符串来反序，有相应的函数--不提倡这种方法
	// 整数-->字符串    String.valueOf(num)
	//字符串-->整数     Integer.parseInt(Str)
	// new StringBuffer(s).reverse()  //StringBuffer 有反序函数
	
	public int reverseInteger2(int mInt)
	{
		String s=String.valueOf(mInt);
		
		if(mInt<0) s=s.substring(1);    //忽略负数的负号的字符转换!！！
		
		StringBuffer sbf=new StringBuffer(s);
		String str=sbf.reverse().toString();    //StringBuffer->String
		
		//if(Integer.parseInt(str)<Integer.MIN_VALUE||Integer.parseInt(str)>Integer.MAX_VALUE) return 0; //这里不用这个
		
		try {
			return mInt>0?Integer.parseInt(str):-1*Integer.parseInt(str);    //负数的返回
		}catch(Exception e)//(NumberFormatException e)
		{
			return 0;
		}
		
	}
}