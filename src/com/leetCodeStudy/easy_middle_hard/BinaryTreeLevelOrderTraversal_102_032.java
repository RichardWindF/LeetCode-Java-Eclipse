package com.leetCodeStudy.easy_middle_hard;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 
 * 独立函数不好写（自实现树的增删查改很多函数）， 可以就在leetCode 上用局部类来测试还容易些：-）
 * 
 * 测试主函数还是写的有点问题？--leetCode 中测木有问题，但这里运行反而不对：-）
 * 
 * * 2 ways to resolve question- Binary Tree Level Order Traversal-二叉树的层次遍历
 *       二叉树 广度优先的遍历（BFS-Breath First Search）--Queue
 *                 深度优先的遍历（DFS--Depth First Search）--递归
 * 
 * 1st way: 二叉树 广度优先的遍历（BFS-Breath First Search）--Queue, 正好是一层层，符合本题的愿望
 *                 
 * 
 * 
 * 2nd way:
 *
 * @author Richard.Feng
 */

public class BinaryTreeLevelOrderTraversal_102_032
{

}

//-----------------------------------------------

class TreeNode
{
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode()
	{
	}

	TreeNode(int val)
	{
		this.val = val;
	}

	TreeNode(int val, TreeNode left, TreeNode right)
	{
		this.val = val;
		this.left = left;
		this.right = right;
	}
}
//--------------------------------------------------------------

/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode() {} TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left
 * = left; this.right = right; } }
 */
class Solution032
{
	public List<List<Integer>> levelOrder1(TreeNode root)
	{

		Queue<TreeNode> mQueue = new LinkedList<>();
		List<List<Integer>> result = new LinkedList<>();      //这里用ArrayList 一样的，无所谓

		

		if (root == null)
		//return null                       //不可以
        //return (List<List<Integer>>)null;  //不可以
        return result;     //默认会是空列表（里面元素是列表，列表里面是整数）
		
		
		if (root.left == null && root.right == null) // 一个元素的时候                   //此题不用把单个元素的情况单列，可删这里
		{
			List<Integer> mList = new LinkedList<>();         //这里用ArrayList 一样的，无所谓
			mList.add(root.val);
			result.add(mList);
			return result;
		}

		
		mQueue.offer(root);
		while (!mQueue.isEmpty()) // 每层的遍历，退出，及压入---整个？每层？
		{
			// ---------------------------------
			int size = mQueue.size();
			List<Integer> mList = new LinkedList<>();

			for (int i = 0; i < size; i++)                      //每层
			{
				TreeNode node = mQueue.poll();
				mList.add(node.val);
				
				if(node.left!=null) mQueue.add(node.left);
				if(node.right!=null) mQueue.add(node.right);
			}

			result.add(mList);                              //一层结束后加入
			// ------------------------------------
//			TreeNode left = mQueue.poll();                 //这里处理不分左右子树
//			TreeNode right = mQueue.poll();
//
//			List<Integer> mList = new LinkedList<>();
//			mList.add(left.val);
//			mList.add(right.val);
//			result.add(mList);
//
//			mQueue.offer(left.left);
//			mQueue.offer(right.right);
		}

		return result;

	}

	public List<List<Integer>> levelOrder2(TreeNode root)
	{
		return null;

	}
}
