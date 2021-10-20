package com.leetCodeStudy.easy_middle_hard;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 
 * 独立函数不好写（自实现树的增删查改很多函数）， 可以就在leetCode 上用局部类来测试还容易些：-）
 * 
 * 测试主函数还是写的有点问题？--leetCode 中测木有问题，但这里运行反而不对：-）
 * 
 * * 2 ways to resolve question- Symmetric Tree-对称树
 *     （ recursively and iteratively?）
 *   
 * 1st way:  递归的方法 （recursively）--只考虑3层，其它的迭代
 *    
 * 
 * 2nd way:  迭代的方法，每次处理一层（iteratively）， 可以借助与一个队列
 *       Java 的 LinkedList，可以是列表List, 堆栈stack， 队列Queue 的实现 都用它
 *
 * @author Richard.Feng
 *
 */

public class SymmetricTree_101_031
{

}


//--------------------------------------------------------------

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
class Solution031
{
	// 1st way:  递归的方法 （recursively）--只考虑3层，其它的迭代
    public boolean isSymmetric1(TreeNode root) 
    {
    	if(root==null) return true;
    	
		return isSymmetric(root.left,root.right);
    }
    
    
    private boolean isSymmetric(TreeNode left, TreeNode right)
	{
    	if(left==null&&right==null) return true;                                                 //第2层
    	if(left==null||right==null||left.val!=right.val) return false;
    	
		return isSymmetric(left.left,right.right)&&isSymmetric(left.right,right.left);          //3层的情况即可，后面都是迭代
		
	}

    //---------------------------------------------------------------------

	//2nd way: 迭代的方法，每次处理一层（iteratively）， 可以借助与一个队列
    public boolean isSymmetric2(TreeNode root) 
    {
    	if(root==null)return true;
    	
    	Queue<TreeNode> mQueue=new LinkedList<>();
    	
    	mQueue.offer(root.left); //add
    	mQueue.offer(root.right);
    	
    	while(!mQueue.isEmpty())
    	{
    		TreeNode left=mQueue.poll();
    		TreeNode right=mQueue.poll();
    		
    		if(left==null&&right==null)  continue;   //此处要判断别的地方，因为是迭代，考虑的这一层，不是上面的递归，不能返回true
    		if(left==null||right==null||left.val!=right.val) return false;
    		
    		mQueue.add(left.left);
    		mQueue.add(right.right);                   //这是一对要比较的
    		
    		mQueue.add(left.right);
    		mQueue.add(right.left);                   //这是一对要比较的
    		
    		
    	}
		return true;
        
    }
}