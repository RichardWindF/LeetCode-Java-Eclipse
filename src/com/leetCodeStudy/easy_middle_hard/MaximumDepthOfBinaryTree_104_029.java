package com.leetCodeStudy.easy_middle_hard;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 自定义链表和 Java定义得 LinkedList （操作类ArrayList,函数功能已封装）, 最好不要混用，容易误解！ 故本链表得测试
 * 独立函数不好写（自实现链表增删查改很多函数）， 可以就在leetCode 上用局部类来测试还容易些：-）
 * 
 * 测试主函数还是写的有点问题？--leetCode 中测木有问题，但这里运行反而不对：-）
 * 
 * Node节点类（常常head,tail,val,next 4个成员特性）
 * 
 * * 2 ways to resolve question --Maximum Depth Of Binary Tree--2叉树的最大高度？
 *       
 *       //关于等比数列的问题：--计算出所以节点个数，然后用等比数列的求出高度？--不可以
 *        an=a1*q^n-1,   Sn=a1*(1-q^n)/(1-q)  q是公比，本例为2
 *       2^0=1, 2^1=2, 2^2=4 ...(1,2,4,8,....元素个数)--本例中求和元素个数 Sn=1*(1-2^n)/(1-2)=2^n-1  //求出这里的n 就是层数
 *       //这个方法不对 ，因为 二叉树并不保证是 “满”树，上面这个是满树的情况
 * 
 * 对树的操作一般都会先考虑到递归的算法 1：一定要有出口 2：出口往往在边界点
 * 
 * 1st way:  递归的方法，左右子树求高度，取大值+1（根的那一层）
 * 
 * 2nd way:  迭代的方法，使用辅助  Queue  来做
 *     Queue<TreeNode> mQueue=new LinkedList<>();       //先进先出-队列Queue
 *     size=mQueue.size();      //每层的节点个数（每层的长度）--为何？-提供的值是每层的
 *     
 *
 * @author Richard.Feng
 *
 */

public class MaximumDepthOfBinaryTree_104_029
{

	//root = [3,9,20,null,null,15,7]
	//		Output: 3
	
//	 root = [1,null,2]
//			 Output: 2
	
//	root = []
//			Output: 0
	
//	 root = [0]
//			 Output: 1
}

//树节点定义--------------------------------------------

class TreeNode11
{
	int val;
	TreeNode11 left;
	TreeNode11 right;
	
	TreeNode11(){};
	 TreeNode11(int val) { this.val = val; };
	 TreeNode11(int val, TreeNode11 left, TreeNode11 right) {
		 this.val = val;
		 this.left = left;
		 this.right = right;
	 }
}

//-------------------------------------------------------
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution029 
{
	//1st way:  递归的方法，左右子树求高度，取大值+1（根的那一层）
	
    public int maxDepth1(TreeNode11 root) 
    {
    	if(root==null) return 0;           //根节点是否存在
    	
    	int leftH=maxDepth1(root.left);
    	int rightH=maxDepth1(root.right);
    	return Math.max(leftH, rightH)+1;
    }   //  return Math.max(maxDepth1(root.left), maxDepth1(root.right)); //等价上面3句
    
    
    //2nd way:  迭代的方法，使用辅助  Queue  来做
     public int maxDepth2(TreeNode11 root) 
     {
    	if(root==null) return 0;
    	
    	Queue<TreeNode11> mQueue=new LinkedList<>();       //先进先出-队列Queue
    	int depth=0, size=0;     //depth 最后高度，size 树每一层的节点数！
    	mQueue.offer(root);      //树的根节点插入队列，--默认广度优先 存储遍历?
    	
    	while(!mQueue.isEmpty())     //判断 整个树 的节点被遍历完
    	{
    		size=mQueue.size();      //每层的节点个数（每层的长度）--下面每层的左右放入。。。
    		while(size>0)            //判断 每一层 的节点被遍历完
    		{
    			TreeNode11 node=mQueue.poll();          //从队列中取出节点
    			size--;
    			if(node.left!=null) mQueue.offer(node.left);
    			if(node.right!=null) mQueue.offer(node.right);
    		}
    		depth++;
    	}
		return depth;
    }
}