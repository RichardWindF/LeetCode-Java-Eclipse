package com.leetCodeStudy.easy_middle_hard;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * 
 *   测试主函数还是写的有点问题？--leetCode 中测木有问题，但这里运行反而不对：-）
 *   
 * 3 ways to resolve question --Remove Nth Node From End of List
 * 
 * Node节点类（常常head,tail,val,next 4个成员特性）
 * 
 * 1st way: 用JAVA 自身定义号的 LinkedList及它的相关函数来完成的（但这个和给的样例表头不符合）
 * 
 * 2nd way: 暴力查询，找到 第Length-n+1（正向数）个元素，--就是倒数第n个元素，然后删除
 * 
 * 3rd way: 快慢指针 快慢指针之间为n长度，最后慢指针就是要删除的元素的前一个
 * （2，3法，leetCode 测试均通过）
 *
 * @author Richard.F
 *
 */

public class RemoveNthNodeFromEndOfList_019_024
{
	public static LinkedList<ListNode2> mList;

	public static void prt(Object o)
	{
		System.out.println(o);
	}

	public static void main(String[] args)
	{
		int[] head1 = { 1, 2, 3, 4, 5 };
		int n1 = 2;
		// Output: [1,2,3,5]

		int[] head2 = { 1 };
		int n2 = 1;
		// Output: []

		int[] head3 = { 1, 2 };
		int n3 = 1;
		// Output: [1]

		// LinkedList<ListNode>
		mList = new LinkedList<>();
		// 对head1,2,3
		for (int i = 0; i < head1.length; i++) // 添加生成链表
		// for(int i=0;i<=head2.length;i++) //添加生成链表
		// for(int i=0;i<head3.length;i++) //添加生成链表
		{
			mList.add(new ListNode2(head1[i]));
			// mList.add(new ListNode2(head2[i]));
			// mList.add(new ListNode2(head3[i]));

		}
//--------------------------------------------------------------------------------------
		// 法一：
		// 移除操作
		Scanner sc = new Scanner(System.in);
		prt("请输入要删除得元素(倒数第几个？)n:\n");
		int n = sc.nextInt();

//		if (n <= head1.length)
//			// if(n<head2.length)
//			// if(n<head3.length)
//			new Solution024().removeNthFromEnd1(mList.get(0), n);
//		else
//		{
//			prt("空");
//			return;
//		}
//
//		for (int i = 0; i < mList.size(); i++)
//		{
//			prt(mList.get(i).val);
//		}

//-------------------------------------------------------------------------------------------
		// 法2：
		prt(" 2nd way-----------------------------------------------------------");

		ListNode2 mLNode=new Solution024().removeNthFromEnd2(mList.get(0), n);
		
		while(mLNode!=null) {
			prt(mLNode.val);
			mLNode=mLNode.next;
		}
		
		
		//-------------------------------------------------------------------------------------------
				// 法3：
				prt(" 3rd way-----------------------------------------------------------");
				ListNode2 mLNode2=new Solution024().removeNthFromEnd2(mList.get(0), n);
				
				while(mLNode2!=null) {
					prt(mLNode2.val);
					mLNode=mLNode2.next;
				}	


	}

}

//节点类--------------------------------------------
class ListNode2
{
	int val;
	ListNode2 next;

	ListNode2()
	{
	}

	ListNode2(int val)
	{
		this.val = val;
	}

	ListNode2(int val, ListNode2 next)
	{
		this.val = val;
		this.next = next;
	}

}

//-------------------------------------------------------
/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode() {} ListNode(int val) { this.val = val; } ListNode(int val,
 * ListNode next) { this.val = val; this.next = next; } }
 */
class Solution024
{
	
	//1st way: 用JAVA 自身定义号的 LinkedList及它的相关函数来完成的（但这个和给的样例表头不符合）
	 
	public ListNode2 removeNthFromEnd1(ListNode2 head, int n)
	{
		// 这里依然是对主类得静态 mList 操作，与题意不是十分吻合，问题是解决了。
		int length = RemoveNthNodeFromEndOfList_019_024.mList.size();
		RemoveNthNodeFromEndOfList_019_024.mList.remove(length - n);

		return null;

	}
	
	
	// 2nd way: 暴力查询，找到 第Length-n+1（正向数）个元素，--就是倒数第n个元素，然后删除
	 
	public ListNode2 removeNthFromEnd2(ListNode2 head, int n) // 这返回得是个移除后的链表还是个节点呢？--理解为：头指针?
	{
		// if(head==null) return head;
		if (head == null)
			return null;

		ListNode2 temp = head;

		//-------------------------------------------------------------------------
		int count = 0; // head不算长度的 //遍历求出列表长度（尽管可以调用时候传入，但这里保存原题目题干，没有长度传入）
		while (true)
		{
			//if (temp.next == null)
			if (temp == null)             //判断的是节点为空，不是节点的next 为空
				break;
			else
			{
				count++;
				temp = temp.next;
			}
		}
		
		System.out.println("count=" + count);
		//------------------------------------------------------------------------------

		                                // 第一，和最后一个节点 要单独处理？--只第一个节点(它也可能被)
		temp = head; // 重新设置
		                                // 分析知要删除的点 是正向数 第 length-n+1 节点
		if (count - n + 1 == 1)
			return temp.next;            // 第一个节点删除后，返回指向第二个元素的指针
		                                  // if(count-n+1==count) {temp.next=null;return head;}

		// 非第一个节点
		/*
		 * for(int i=0;i<count-n+1;i++) //要删除的点 是正向数 第 length-n+1 节点 temp=temp.next;
		 * //到达了要删除得前一个点 temp
		 * 
		 * //temp.val=temp.next.val; temp.next=temp.next.next; //巧妙得转成删除它后面得一个点？/
		 */

		temp = head;
		int i = 0;
		while (temp != null)
		{
			i++;
			if (i == (count - n + 1) - 1) // 到达要删除元素的前一个(第几个)
			{
				temp.next = temp.next.next;
			}

			temp = temp.next; // 节点不为空时候指针前移
		}

		// return head;//temp;
		return head;
		// return dummyNode.next;

	}
	
	
	// 3rd way: 快慢指针 快慢指针之间为n长度，最后慢指针就是要删除的元素的前一个
	public ListNode2 removeNthFromEnd3(ListNode2 head, int n) 
	{
		if(head==null) return null;
		
		ListNode2 slow;
		ListNode2 fast=slow=head;
		
		//快指针先走n 步
		for(int i=0;i<n;i++) fast=fast.next;
		
		//如果删除的是第一个节点的话
		//if(fast.next==head) return head.next;             //第一个节点的判断，这个不对  
        if(fast==null) return head.next;                //第一个节点的判断!(节点为空)
		
		//然后快慢指针同时前进到末尾，那么慢指针就是要删除的 倒数第n个元素的前一个元素
		while(fast.next!=null)                         //节点的指针为空，代表最后一个
		{
			fast=fast.next;
			slow=slow.next;
		}
		
		slow.next=slow.next.next;   //删除了slow后面的元素，也就是倒数第n 个元素
		return head;                //头指针    --做指针为何eclipse 识别不了呢？
	}
}