package com.leetCodeStudy.easy_middle_hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * 自定义链表和 Java定义得 LinkedList （操作类ArrayList,函数功能已封装）, 最好不要混用，容易误解！
 * 故本链表得测试 独立函数不好写（自实现链表增删查改很多函数）， 可以就在leetCode 上用局部类来测试还容易些：-）
 * 
 * 测试主函数还是写的有点问题？--leetCode 中测木有问题，但这里运行反而不对：-）
 * 
 * 2 ways to resolve question --ReverseLinkedList--反转链表
 * 
 * Node节点类（常常head,tail,val,next 4个成员特性）
 * 
 * 1st way:  遍历一遍到尾部， 用 previous, current, temp(next) 3 个指针来完成
 *          首先保存temp=curr.next， 再给 curr.next=previous赋值， 两个指针前行 previous=current, current=temp,//temp=current.next;
 *          return previous(移动到current=null)
 *          一般对首节点要操作得时候，我们都需要一个dummy节点，此例得previous
 *          LeetCode test passed! 
 * 
 * 2nd way:
 * 
 *
 *
 * @author Richard.F
 *
 */

public class ReverseLinkedList_206_025
{
	public static void prt(Object o)
	{
		System.out.println(o);
	}

	public static void mian(String... args)
	{
		int[] nodeValArr1 = { 1, 2, 3, 4, 5 }; // Output: [5,4,3,2,1]
		int[] nodeValArr2 = { 1, 2 }; // Output: [2,1]
		int[] nodeValArr3 = {}; // null?; //Output: [] //空得空

		//生成Node 节点数组
		ListNode3[] nodeArr1=new ListNode3[nodeValArr1.length];
		for(int i=0;i<nodeValArr1.length;i++)
		{
		   nodeArr1[i]=new ListNode3(nodeValArr1[i]);
		   
		}
		//---------------------
		//生成链表
		LinkedList mList=new LinkedList(Arrays.asList(nodeArr1));
		List mList2=new ArrayList(Arrays.asList(nodeArr1));
		for(int i=0;i<nodeArr1.length;i++)
		{
		mList.add(nodeArr1[i]);
		}
		//mList2.add(nodeArr1[i]); 
		
		//mList2=Arrays.asList(nodeArr1);
		
		
	    //mList.get(2)
		new ListNode3(nodeValArr1[3]).val=9;
		nodeArr1[0].val=4;
		//mList2.get(2). 
		//mList.get(0).next
		//转成 Java自定义列表（无论那种）后就无法访问到里面对象得属性了？--
		//说明列表中得元素如果是复杂得对象(比如里面有递归定义得，如链表)什么得，转换容易混淆出错！
		
	}
		
}

//-----------------------------------------------------
// 节点Node(得链表？？)-节点理解
	class ListNode3
	{
		 int val;
		ListNode3 next; // 指针

		public ListNode3()
		{
			super();
		}

		public ListNode3(int val)
		{
			super();
			this.val = val;
		}

		public ListNode3(int val, ListNode3 next)
		{
			this.val = val;
			this.next = next;
		}

			
	}

//-----------------------------------------------------
/**
 * 这个说明准确吗？ 是 单链表，还是Node(节点)定义？--节点理解
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode() {} ListNode(int val) { this.val = val; } ListNode(int val,
 * ListNode next) { this.val = val; this.next = next; } }
 */
class Solution025
{
	//1st way:  遍历一遍到尾部， 用 previous, current, temp(next) 3 个指针来完成
	public ListNode3 reverseList1(ListNode3 head) // head 指针，指向ListNode3 组成的链表 (这里不容易区分是 节点对象，还是指针)
	{
		if(head==null) return null;
		
		ListNode3 previousP=null;                //前一个指针，初值空
		ListNode3 currentP=head;                 //当前指针，初值头节点
		ListNode3 temp;//=currentP.next;            //零时存储当前节点得next指针
		
		while(currentP!=null)                    //循环到当前节点为null，返回previousP即可
		{
			
			temp=currentP.next;                 //保存当前节点得next指针
			currentP.next=previousP;           //这个就反向指了
			
			//指针前进
			previousP=currentP;
			currentP=temp;
		}
		return previousP;

	}
	
	public ListNode3 reverseList2(ListNode3 head) // head 指针，指向ListNode3 组成的链表
	{
		return head;

	}
}