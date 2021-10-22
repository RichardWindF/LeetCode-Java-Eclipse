package com.leetCodeStudy.easy_middle_hard;

/**
 * 
 * 独立函数不好写（自实现树的增删查改很多函数）， 可以就在leetCode 上用局部类来测试还容易些：-）
 * 
 * 测试主函数还是写的有点问题？--leetCode 中测木有问题，但这里运行反而不对：-）
 * 
 * * 2 ways to resolve question- Convert Sorted Array to Binary Search Tree--将有序数组转换为二叉搜索树
 *       二叉树 广度优先的遍历（BFS-Breath First Search）--Queue
 *                 深度优先的遍历（DFS--Depth First Search）--递归
 * 
 * 1st way: 数组的中间点 为 根节点，然后再左边的中间点为根， 右边的中间点为根，。。。递归解决这个问题
 *         对树的问题，大部分可以思路--先处理当前节点问题，然后左右子树，接下来递归，注意一个Null的问题就OK了--模板思路
 *                 
 * 
 * 
 * 2nd way:
 *
 * @author Richard.Feng
 */
public class ConvertSortedArrayToBinarySearchTree_108_033
{

}

//----------------------------------------------------------
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
class Solution033 
{
//	1st way: 数组的中间点 为 根节点，然后再左边的中间点为根， 右边的中间点为根，。。。递归解决这个问题
//	   对树的问题，大部分可以思路--先处理当前节点问题，然后递归解决左右子树，注意一个Null的问题就OK了--模板思路
    public TreeNode sortedArrayToBST1(int[] nums) 
    {
		return helper(nums,0,nums.length-1);
    }
    
    private TreeNode helper(int[] nums, int left, int right)
    {
    	                            //int left, right;//左右节点在数组中的位置
    	if(left>right) return null;
    	
        int mid=(left+right)/2;
    	TreeNode root=new TreeNode(nums[mid]);
    	
    	root.left=helper(nums,left,mid-1);
    	root.right=helper(nums,mid+1,right);
//                              	root.left=helper(nums,0,mid-1);
//                                 	root.right=helper(nums,mid+1,nums.length-1);
    	
    	return root;
    	
    }
    //----------------------------------------------------------
    
    
 public TreeNode sortedArrayToBST2(int[] nums) {
	return null;
        
    }
}
