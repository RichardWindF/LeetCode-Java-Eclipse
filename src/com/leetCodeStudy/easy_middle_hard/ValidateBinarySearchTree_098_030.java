package com.leetCodeStudy.easy_middle_hard;

import java.util.Stack;

/**
 * 自定义链表和 Java定义得 LinkedList （操作类ArrayList,函数功能已封装）, 最好不要混用，容易误解！ 故本链表得测试
 * 独立函数不好写（自实现链表增删查改很多函数）， 可以就在leetCode 上用局部类来测试还容易些：-）
 * 
 * 测试主函数还是写的有点问题？--leetCode 中测木有问题，但这里运行反而不对：-）
 * 
 * Node节点类（常常head,tail,val,next 4个成员特性）
 * 
 * * 2 ways to resolve question 
 * 
 * --Validate Binary Search Tree--验证二叉搜索树
 * The left subtree of a node contains only nodes with keys less than the node's key.
 * The right subtree of a node contains only nodes with keys greater than the node's key.
 * Both the left and right subtrees must also be binary search trees.
 *  
 * 1st way:  
 *     每个节点的值都有一个范围 根节点（-无穷， +无穷），然后左子节点范围（-无穷，该节点的val ）， 右子节点范围（该节点的val,+无穷）....
 *       以此类推--引入边界值的递归
 *       --递归算法-自己调用自己 1：出口--往往在边界， 2：递归常要写辅助函数（helper）什么的
 *       
 * 
 * 2nd way:  
 *
 * @author Richard.Feng
 *
 */

public class ValidateBinarySearchTree_098_030
{
//	root = [2,1,3]
//			Output: true
//			
//	root=[5,1,4,null,null,3,6]
//					 Output: false 

}

//------------------------------------------------------------------
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

class Solution030 
{
    public boolean isValidBST1(TreeNode root) {
    	        //if(root==null) return true;   //这个判断在子函数中去做
    	        //根节点，  无穷大这里不能定义为Integer,而是Long才可以,因为题设中是可以取到 Integer的两个边界的
    	        //return isValidBST1(root,Integer.MIN_VALUE,Integer.MAX_VALUE);          
    	return isValidBST1(root,Long.MIN_VALUE,Long.MAX_VALUE);          
    }
    
    private boolean isValidBST1(TreeNode root,long min,long max)                 //方法重载overloading
    {
    	if(root==null) return true;                     //空树认为是2叉排序树（定义之一）      //出口
    	                             //if(root.left.val>=root.val||root.val>=root.right.val)  return false;     
    	                             //出口,--这里应该一层层考虑，要不有空指针问题
    	if(min>=root.val||root.val>=max)  return false;     //出口
    	else 
    		return(isValidBST1(root.left,min,root.val)&&isValidBST1(root.right,root.val,max));    //递归
    }
    
    //gggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggg
    
    public boolean isValidBST2(TreeNode root) 
    {
		return helper(root,Long.MIN_VALUE, Long.MAX_VALUE);
    }

	private boolean helper(TreeNode root, long min, long max)
	{
		if(root==null) return true;
		if(root.val>=max||root.val<=min)  return false;
		else return(helper(root.left,min,root.val)&&helper(root.right,root.val,max));
	}
	
	//----------------------------------------------------------------------
}