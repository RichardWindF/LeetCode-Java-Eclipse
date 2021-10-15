package com.leetCodeStudy.easy_middle_hard;

import java.util.LinkedList;
import java.util.List;

/**
 * 自定义链表和 Java定义得 LinkedList （操作类ArrayList,函数功能已封装）, 最好不要混用，容易误解！ 故本链表得测试
 * 独立函数不好写（自实现链表增删查改很多函数）， 可以就在leetCode 上用局部类来测试还容易些：-）
 * 
 * 测试主函数还是写的有点问题？--leetCode 中测木有问题，但这里运行反而不对：-）
 * 
 * Node节点类（常常head,tail,val,next 4个成员特性）
 * 
 * * 2 ways to resolve question --Palindrome Linked List--判断是否回文链表(单向链表怎样从后面向前移动指针呢-无法回溯)
 * 
 * 1st way: // 在功能函数中，把 LinkedList 模拟 堆栈 stack 来使用，一半入堆栈， 然后和剩下一般比较值即可--//不用这么麻烦，全部入堆栈！
 * 
 * 2nd way: //暴力遍历--，抽出各个节点得Val 值形成数组，两个指针一头一个尾部， 判断分别相同，到中间完成
 * 
 *
 *
 * @author Richard.Feng
 *
 */

public class PalindromeLinkedList_234_027
{
	public static void prt(Object o)
	{
		System.out.println(o);
	}

	public static void main(String... args)
	{
		int[] nodeValArr1 = { 1, 2, 2, 1 };
		// Output: true
		int[] nodeValArr2 = { 1, 2 };
		// Output: false

		// 生成链表-------------------------------------------------
		LinkedList<ListNode5> mLinkedList = new LinkedList();
		//for (int i = 0; i < nodeValArr1.length; i++)
		for (int i = 0; i < nodeValArr2.length; i++)
		{
			//mLinkedList.add(new ListNode5(nodeValArr1[i]));
			mLinkedList.add(new ListNode5(nodeValArr2[i]));
		}

		// ------------------------------------------------
		prt("1st way-------------------------------------------------------\n");
		prt(new Solution027().isPalindrome1(mLinkedList.getFirst()));
		
		prt("2nd way-------------------------------------------------------\n");
		prt(new Solution027().isPalindrome2(mLinkedList.getFirst())); 
		//prt(new Solution027().isPalindrome2(mLinkedList.get(0))); 
		     // 链表的头指针传入,这个方法在子方法中统计节点数是不对，因为结构问题？
		    //mLinkedList.get(0)并不是头指针吗？？ 上面两个都不对！
		      // 在leetCode 测试环境是木问题得：-）--终究混用比较麻烦
		  //上面两者测试都不对，在leetCode 测试木问题！
	
		
		

	}
}

//--节点定义----------------------------------------

class ListNode5
{
	int val;
	ListNode5 next;

	// 3个构造函数
	public ListNode5()
	{
		super();
	}

	public ListNode5(int val)
	{
		super();
		this.val = val;
	}

	public ListNode5(int val, ListNode5 next)
	{
		super();
		this.val = val;
		this.next = next;
	}

}

//----------------------------------------------------
/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode() {} ListNode(int val) { this.val = val; } ListNode(int val,
 * ListNode next) { this.val = val; this.next = next; } }
 */
class Solution027
{

	//1st way:  在功能函数中，把 LinkedList 模拟 堆栈 stack 来使用，一半入堆栈， 然后和剩下一般比较值即可
	//不用这么麻烦，全部入堆栈！
	
	public boolean isPalindrome1(ListNode5 head)
	{
		if(head==null||head.next==null) return true;     //链表空或者单节点，都是回文链表
		
		//使用堆栈-Java中就是用LinkedList 来模拟得、
		LinkedList<Integer> stack=new LinkedList<>();
		ListNode5 current=head;
		
		while(current!=null)
		{
			stack.push(current.val);    //一次遍历压栈，第2次比较
			current=current.next;
		}
		
		current=head;
		while(current!=null)           //第二次遍历第2次比较
		{
			if(current.val!=stack.pop())      // 用 stack.peek();也可以，这个是弹出元素，但不移除元素,  pop()=弹出+移除
				return false;
			current=current.next;
		}
		
		return true;

	}
	
	//2nd: 暴力遍历--，抽出各个节点得Val 值形成数组，两个指针一头一个尾部， 判断分别相同，到中间完成

	public boolean isPalindrome2(ListNode5 head)
	{

		// 一次遍历，抽出里面的val 存入数组，然后比较数组即可

		ListNode5 current = head;

		if(current==null)return false;
		int nodeCount = 0;
		while (current != null)                //算出链表长度（节点个数） nodeCount, //从1开始数的第 几个！
		{
			nodeCount++;                     //这两句顺序别搞反了
			current = current.next;
		}
		
		System.out.println("nodeCount="+nodeCount);
		
		if(nodeCount==1)return true;
		/*
		 * if (nodeCount % 2 != 0) return false; // 长度不是偶数，不是回文 --错，比如 【1，0，1】 是回文,这里删掉即可
		 */
		int[] temp1 = new int[nodeCount ];

		current = head;
		for (int i = 0; i < nodeCount; i++)             //全部节点的VAL 值放入数组temp1
		{
				temp1[i] = current.val;
				current = current.next;
		}
		
		
		for (int i = 0,j=nodeCount-1; i < nodeCount / 2; i++,j--)
		{
			if (temp1[i]==temp1[j])continue;
			else return false;
		}

		return true;

	}
}