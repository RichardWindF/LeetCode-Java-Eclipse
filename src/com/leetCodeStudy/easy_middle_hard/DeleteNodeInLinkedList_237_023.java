package com.leetCodeStudy.easy_middle_hard;

import java.util.LinkedList;

/**
 * 2 ways to resolve question --Delete Node In Linked List
 * 
 * Node节点类（常常head,tail,val,next 4个成员特性）
 * 
 * 1st way:  此例中説法很奇怪， 自写主函数部分，不要用，直接在 leetCode 代码测试区去验证即可
 * 
 * 2nd way: 。
 * 
 *
 * @author Richard.F
 *
 */

public class DeleteNodeInLinkedList_237_023
{

	

	public static void prt(Object o)
	{
		System.out.println(o);
	}

	public static void main(String... args)
	{

		int[] head1 = { 4, 5, 1, 9 };
		int node1 = 5; // Output: [4,1,9]]
		int[] head2 = { 4, 5, 1, 9 };
		int node2 = 1; // Output: [4,5,9]]
		int[] head3 = { 1, 2, 3, 4 };
		int node3 = 3; // Output: [1,2,4]
		int[] head4 = { 0, 1 };
		int node4 = 0; // Output: [1]
		int[] head5 = { -3, 5, -99 };
		int node5 = -3; // Output: [5,-99]

		// LinkedList mList=new LinkedList();
		// SinglelyLinkedList

		LinkedList mList = new LinkedList();
		
		//ListNode node = new ListNode(head1.length);
		for (int i = 0; i < head1.length; i++)
		{
			mList.add(new ListNode(head1[i]));
		}

		/*
		 * for(int i=0;i<mList.size();i++) { if(mList.get(i).)==node1)) new
		 * Solution023().deleteNode1(mList.get(i)); }
		 */
		
		for(int i=0;i<mList.size();i++)
		{
			prt(mList.get(i).toString());
		}

	}
}

//---------------------------------------------------------------------------------------
// 用于 创建 链表 等的类(增删查改)
class SingleLinkedList
{
	private ListNode head = new ListNode(0); // 头节点方便查找，头节点中不存值（空值），但有指针next
	// head.next=new ListNode(1);

	public ListNode getHead()
	{
		return head;
	}

	// 添加节点--------------------------------------
	public void addListNode(ListNode listNode)
	{
		// 在整个链表中找到应该插入的位置，在尾部添加（不是插入）
		// head 节点不能动，需要一个辅助节点temp

		ListNode temp = head;

		while (true)
		{
			if (temp.next == null)
				break;
			temp = temp.next; // 指针前进（写法与c++区别挺大的：-）
		}

		temp.next = listNode;

		listNode.next = null; // 需要吗？
	}

	// 显示链表---------------------------------------
	public void showLinkedList(ListNode head)
	{
		if (head.next == null)
		{
			System.out.println("LinkedList is null");
			return;
		}

		// 头节点不动，辅助节点
		ListNode temp = head.next;
		while (true)
		{
			if (temp.next != null)
			{
				System.out.println(temp);
				temp = temp.next;
			} else
				break;
		}
	}

	// 修改链表节点数据----------------------------------------------------
	// if(temp.id==listNode.id) temp.val=listNode.val; //本例中无id属性，所有用val判断
	public void updateLinkedList(ListNode listNode) // listNode 是需要改成的结果
	{
		// 首先找到，然后修改
		ListNode temp = head.next;

		if (temp == null)
		{
			System.out.println("木有该记录");
			return;
		}
		while (true)
		{
			if (temp.val == listNode.val)
			{
				temp.val = 8888888;
				break;
			} else if (temp.next != null)
				temp = temp.next;
			else
			{
				System.out.println("木有该记录");
				break;
			}
		} // 如果没有怎么办呢？
	}

	// 删除链表节点------------------------------------------------------------
	public boolean deleteFromLinkedList(int val) // 删除某个具体节点，此处用val 属性，但一般是id
	{
		// 查找到并删除（要找到要删除节点的前一个节点）
		ListNode temp = head;

		boolean flag = false;

		if (temp == null)
		{
			System.out.println("木有该记录val 是：" + val);
			return false;
		}

		// 找到待删除的前一个节点
		while (true)
		{
			if (temp.next == null)
				break; // 已经遍历完链表，退出循环

			if (temp.next.val == val) // temp.next.val --节点的下个节点的val值
			{
				flag = true;
				break; // 找到 ,退出循环
			}
			temp = temp.next;
		}

		if (flag)
		{ // if(temp.next.val==val) 与下面这句 是关键
			temp.next = temp.next.next; // 待删除节点的后一个节点的地址赋值给待删除节点前一个节点的next值
			return true;
		} else

			System.out.println("木有该记录");
		return false;

	}

}

//--------------------------------
//---------------------------------------------------------------------
class ListNode // 链表的节点 类定义
{
	int val;
	ListNode next;

	ListNode(int x)
	{
		this.val = x;
	}

	public int getVal()
	{return val;
	} 
}

//----------------------------------------------------------------------------------------------------

/**
 * Definition for singly-linked list.  --单向链表定义
 * public class ListNode {
 *     int val;                                        //值
 *     ListNode next;                             //java 中的“指针”：-),指向下个节点
 *     ListNode(int x) { val = x; }               //单参构造
 * }
 */
class Solution023                 //此例并没有给你head 指针
{
	public void deleteNode1(ListNode node)      
	//此处描述得不是清楚得，参数node 是指向要删除节点得指针 c++得表头：void deleteNode(ListNode* node)
	{

	  node.val=node.next.val;
	  node.next=node.next.next;                 //类似脑筋急转弯，删除后面一个节点

	}

	public void deleteNode2(ListNode node)
	{

	}
}
