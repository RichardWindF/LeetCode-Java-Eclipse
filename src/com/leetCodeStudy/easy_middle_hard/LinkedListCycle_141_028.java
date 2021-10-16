package com.leetCodeStudy.easy_middle_hard;

import java.util.Vector;

/**
 * 自定义链表和 Java定义得 LinkedList （操作类ArrayList,函数功能已封装）, 最好不要混用，容易误解！ 故本链表得测试
 * 独立函数不好写（自实现链表增删查改很多函数）， 可以就在leetCode 上用局部类来测试还容易些：-）
 * 
 * 测试主函数还是写的有点问题？--leetCode 中测木有问题，但这里运行反而不对：-）
 * 
 * Node节点类（常常head,tail,val,next 4个成员特性）
 * 
 * * 2 ways to resolve question --Linked List Cycle--判断是否有环形链表
 * 
 * 1st way: 典型得快慢 双指针， 每次快指针进2步，慢指针进一半，他们如果能相遇，就是环形链表
 * （那能不能快指针每次3步呢，逻辑上只要是整数均可，只是判断条件得时候，为了每步都不空，判断条件麻烦！） -另外一般 head=null,
 * head.next=null,（即 空链表或者单个 节点的而情况） 要单独考虑
 * 
 * 2nd way:
 * 
 *
 *
 * @author Richard.Feng
 *
 */

public class LinkedListCycle_141_028
{
	public static void prt(Object o)
	{
		System.out.println(o);
	}

	public static void main(Vector args)
	{
		int[] nodeValArr1 = { 3, 2, 0, -4 };
		int pos1 = 1;
		// Output: true

		int[] nodeValArr2 = { 1, 2 };
		int pos2 = 0;
		// Output: true

		int[] nodeValArr3 = { 1 };
		int pos3 = -1;
		// Output: false

	}

}

//节点定义--------------------------------------
class ListNode6
{
	int val;
	ListNode6 next;

	ListNode6(int x)
	{
		val = x;
		next = null;
	}
}

// 管理得类
class MyLinkedList
{

}

//-------------------------------------------------------------------------------
/**
 * Definition for singly-linked list. class ListNode { int val; ListNode next;
 * ListNode(int x) { val = x; next = null; } }
 */
class Solution028
{
	// 1st way: 典型得快慢 双指针， 每次快指针进2步，慢指针进一半，他们如果能相遇，就是环形链表
	public boolean hasCycle1(ListNode6 head)
	{

		ListNode6 fastP;
		ListNode6 slowP = fastP = head;

		while (fastP != null && fastP.next != null)
		{
			fastP = fastP.next.next; // 每次进2 步，所以要保证 fastP, fastP.next 两个指针指向的都不为空指针（确保了3个节点）
			slowP = slowP.next;
			
			if(fastP==slowP) return true;
		}
		
		//然后单独考虑空节点-此处返回false
		//单节点呢?,也是上面while条件不运行，也是返回 false

		return false;

	}

	public boolean hasCycle2(ListNode6 head)
	{
		return false;

	}
}