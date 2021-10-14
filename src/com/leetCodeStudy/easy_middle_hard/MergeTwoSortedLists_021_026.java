package com.leetCodeStudy.easy_middle_hard;

import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * 自定义链表和 Java定义得 LinkedList （操作类ArrayList,函数功能已封装）, 最好不要混用，容易误解！ 故本链表得测试
 * 独立函数不好写（自实现链表增删查改很多函数）， 可以就在leetCode 上用局部类来测试还容易些：-）
 * 
 * 测试主函数还是写的有点问题？--leetCode 中测木有问题，但这里运行反而不对：-）
 * 
 * 3 ways to resolve question --Merge Two Sorted Lists--两个已排序列表合并
 * 
 * Node节点类（常常head,tail,val,next 4个成员特性）
 * 
 * 1st way: 在主函数中使用JAVA得 LinkedList 来实现这个合并功能 生成LinkedList, 排序，输出
 * 
 * 2nd way: 因为参数原因，。。在leetCode 环境下去测试 把链表 l2 并入到 链表 l1 中去--这个思路比较复杂，两个链表的指针来回切换，
 * 边界点不好控制
 * 
 * 3rd way: 用一个新的链表 dummy 开头，然后遍历链表l1 和链表 l2, val 值小的节点一个个分别加入到 dummy 后即可，
 * 返回dummy.next (也就是用dummy 来串起来链表l1 和l2 中的所有元素，最后把不空的剩下链表给接上) --
 * 对于头节点，空啊什么的处理比较麻烦，所以一般引入一个dummy Node 来处理
 *
 *
 * @author Richard.Feng
 *
 */

public class MergeTwoSortedLists_021_026
{
	public static void prt(Object o)
	{
		System.out.print(o);
	}

	public static void main(String[] args)
	{
		int[] nodeValArr1_l1 = { 1, 2, 4 }, nodeValArr1_l2 = { 1, 3, 4 };
		// Output: [1,1,2,3,4,4]

		int[] nodeValArr2_l1 = {}, nodeValArr2_l2 = {}; // []
		// Output: []

		int[] nodeValArr3_l1 = {}, nodeValArr3_l2 = { 0 };
		// Output: [0]

		prt("1st way-------------------------------------------------------\n");

		// 生成链表 LinkedList
		List mLinkedList = new LinkedList();

		for (int i = 0; i < nodeValArr1_l1.length; i++)
		// for (int i = 0; i < nodeValArr2_l1.length; i++)
		// for (int i = 0; i < nodeValArr3_l1.length; i++)
		{
			ListNode4 temp = new ListNode4(nodeValArr1_l1[i]);
			mLinkedList.add(temp);
		}

		for (int i = 0; i < nodeValArr1_l2.length; i++)
		// for (int i = 0; i < nodeValArr2_l2.length; i++)
		// for (int i = 0; i < nodeValArr3_l2.length; i++)
		{
			mLinkedList.add(new ListNode4(nodeValArr1_l2[i]));
		}

		mLinkedList.sort(new MyComparator());
		// for(int i=0;i<mLinkedList.size();i++)
		// prt(mLinkedList.get(0));

		// mList.get(2), for(ListNode4 node:mList) 都无法访问，只能迭代器访问如下
		Iterator<ListNode4> it = mLinkedList.iterator();
		while (it.hasNext())
		{
			prt(it.next().val + ",");
		}

		// --------------------------------------------------------------------
		prt("\n2nd way-------------------------------------------------------\n");

		// new Solution026().mergeTwoLists3(mList1,mList2);

	}

}

//---------------------------------------------
//Comparator--比较器
class MyComparator implements Comparator<ListNode4>
{
	@Override
	public int compare(ListNode4 o1, ListNode4 o2)
	{
		// TODO Auto-generated method stub
		return o1.val - o2.val;
	}

}

//---------------------------------------------------------
//节点定义
class ListNode4
{
	int val;
	ListNode4 next;

	ListNode4()
	{
	}

	ListNode4(int val)
	{
		this.val = val;
	}

	ListNode4(int val, ListNode4 next)
	{
		this.val = val;
		this.next = next;
	}

}
//--------------------------------------------------

/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode() {} ListNode(int val) { this.val = val; } ListNode(int val,
 * ListNode next) { this.val = val; this.next = next; } }
 */
class Solution026
{
	// 2nd way: 因为参数原因，。。在leetCode 环境下去测试
	// 把链表 l2 并入到 链表 l1 中去--这个思路比较复杂，两个链表的指针来回切换， 边界点不好控制
	public ListNode4 mergeTwoLists2(ListNode4 l1, ListNode4 l2)
	{
		ListNode4 headL1 = l1;
		ListNode4 headL2 = l2;

		ListNode4 nextL1 = headL1, nextL2 = headL2;
		ListNode4 temp1 = headL1, temp2 = headL2;

//		while(nextL1.next!=null)                   //L2并入L1 之中
//			while(nextL2.next!=null)
		while (nextL1.next != null && nextL2.next != null) // L2并入L1 之中,两个列表均不为空时候
		{
			if (nextL1.val <= nextL2.val)// &&nextL2.val<nextL1.next.val)
			{
				temp1 = nextL1.next;
				nextL1.next = nextL2;
				temp2 = nextL2.next;
				nextL2.next = temp1;

			}
			nextL2 = temp2;
			nextL1 = temp1;
		}

		return headL1;
	}

	// 3rd way: 用一个新的链表 dummy 开头，然后遍历链表l1 和链表 l2, val 值小的节点一个个分别加入到 dummy 后即可，
	// 返回dummy.next (也就是用dummy 来串起来链表l1 和l2 中的所有元素，最后把不空的剩下链表给接上)

	public ListNode4 mergeTwoLists3(ListNode4 l1, ListNode4 l2)
	{
		// 其实这里的l1,l2 就是指向链表的指针，明白了这个就不用定义temp了

		ListNode4 dummy = new ListNode4(-1);
		ListNode4 current = dummy; // 当前节点首先在dummy 上,指最后结果链表的当前指针

		while (l1 != null && l2 != null) // 两个链表均不为空时候
		{
			if (l1.val < l2.val)
			{
				current.next = l1;
				l1 = l1.next; // l1 和当前指针 都朝前进
				current = current.next;
			} else
			{
				current.next = l2;
				l2 = l2.next;
				current = current.next;
			}

		}
		
		//此时还要考虑 l1 或者 l2 剩下的不为空的情况,谁不为空，接入结果链表后面
		current.next=l1!=null? l1:l2;
		

		return dummy.next;

	}

}