package com.leetCodeStudy.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 2 ways to resolve question  --FirstUniqueCharacterInString
 * 
 * 1st way:  HashMap<字母，出现频率>，一次遍历字符串存值，二次遍历图
 * 
 * 2nd way: 题设假设全部小写字母，26个字母-‘a'为下标得数组各自存储出现次数（两次遍历对同一数组）
 *
 * @author Richard.F
 *
 */

public class FirstUniqueCharacterInString_387_016
{
	public static void prt(Object o) {System.out.println(o);}
	
	public static void main(String...args)
	{
		String s1 = "leetcode";    // 0
		String s2 = "loveleetcode"; //Output: 2
		String s3 = "aabb";       //	Output: -1
		
		prt("resolved by 1st way:");
		prt(new Solution016().firstUniqChar1(s1)); //
		prt(new Solution016().firstUniqChar1(s2)); //
		prt(new Solution016().firstUniqChar1(s3)); //

		prt("----------------------------------------------------");
		//数组需要重新赋值，再测才正确,但变量不用（传值，传地址）
		
		prt("resolved by 2nd way:");
		prt(new Solution016().firstUniqChar2(s1));
		prt(new Solution016().firstUniqChar2(s2));
		prt(new Solution016().firstUniqChar2(s3));

	}

}


//--------------------------------------------------
class Solution016 
{
	//1st way:  HashMap<字母，出现频率>,一次遍历字符串存值，二次遍历图
    public int firstUniqChar1(String s) {
		/*
		 * Set<Character> mSet=new HashSet<>(); for(int i=0;i<s.length();i++) {
		 * //if(!mSet.add(s.charAt(i))) return i; //第一个重复的(没加成功)，如果题目改为第一个重复的
		 * 
		 * } return -1;
		 */  
    	
    	Map <Character,Integer> mMap=new HashMap<>();
    	
    	for(int i=0;i<s.length();i++)                               //一次遍历字符串存值
    	{
    		//mMap.put(s.charAt(i), mMap.get(s.charAt(i))+1);
    		mMap.put(s.charAt(i), mMap.getOrDefault(s.charAt(i), 0)+1);  //后面那个函数很关键，用上面的那个出错,由KEY得value
    	}
    	
    	for(int i=0;i<s.length();i++)
    	{                                                        //二次遍历图
    		if(mMap.get(s.charAt(i))==1) return i;               //由KEY 得 value
    	}
    
    	return -1;
    }
    
    
   //2nd way:  26个字母-‘a'为下标得数组各自存储出现次数（两次遍历对同一数组）
    public int firstUniqChar2(String s) 
    {
    	//if(s==null||s.length()==0)return -1;
    	
    	int[] result=new int[26];  //a~z, 26个字母，97-, 数组里面存得 个数
    	for(int i=0;i<s.length();i++)
    	{
    		result[s.charAt(i)-'a']++;
    	}
    	
    	//for(int i=0;i<result.length;i++)   // 下标越界
    		for(int i=0;i<s.length();i++)
    	{
    		//if(result[i]==1) return i;   //这句访问了那些不存在字母得数组成员
    		if(result[s.charAt(i)-'a']==1) return i;
    	}
		
    	return -1;
        
    }
}