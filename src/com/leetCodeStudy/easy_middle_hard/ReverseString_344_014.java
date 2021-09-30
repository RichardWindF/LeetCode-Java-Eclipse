package com.leetCodeStudy.easy_middle_hard;

import java.util.Arrays;

/**
 * 2 ways to resolve question
 * 
 * 1st way:  互换 s[i] 和 s[s.length-1-i];     //遍历为数组长度的一半（整个的就又换回去了：-））
 * 
 * 2nd way:  双指针，头尾到重合
 * 
 *
 * @author Richard.F
 *
 */

public class ReverseString_344_014
{
	public static void prt(Object o) {System.out.println(o);}
	
	public static void main(String...args)
	{
		char [] s1= {'h','e','l','l','o'};  	   //String [] s1= {'h','e','l','l','o'};    //	Output: ['o','l','l','e','h']
		char [] s2 = {'H','a','n','n','a','h'};    //Output: ['h','a','n','n','a','H']
		
		prt("resolved by 1st way:");
		new Solution014().reverseString1(s1); //
		new Solution014().reverseString1(s2); //

		prt("----------------------------------------------------");
		//数组需要重新赋值，再测才正确
		
		s1=new char[] {'h','e','l','l','o'};  	   //String [] s1= {'h','e','l','l','o'};    //	Output: ['o','l','l','e','h']
		s2 = new char[]{'H','a','n','n','a','h'};    //Output: ['h','a','n','n','a','H']
		prt("resolved by 2nd way:");
		new Solution014().reverseString2(s1);
		new Solution014().reverseString2(s2);

		
	}
}

//----------------------------------------------------
class Solution014
{
	//1st way:  互换 s[i] 和 s[s.length-1-i];     //遍历为数组长度的一半（整个的就又换回去了：-））
    public void reverseString1(char[] s)
    {
    	   for(int i=0;i<s.length/2;i++)
           {
               char temp=s[i];
               s[i]=s[s.length-1-i];
               s[s.length-1-i]=temp;
           }
    	   
    	   ReverseString_344_014.prt(Arrays.toString(s));
        
    }
    
    //2nd way:  双指针，头尾到重合
    public void reverseString2(char[] s)
    {
    	//int headP=0,endP=s.length-1;
    	for(int headP=0,endP=s.length-1;headP<=endP;headP++,endP--)
    	{
    		char temp=s[headP];
    		s[headP]=s[endP];
    		s[endP]=temp;
    		//headP++;endP--
    	}
    	
    	ReverseString_344_014.prt(Arrays.toString(s));
    }
}