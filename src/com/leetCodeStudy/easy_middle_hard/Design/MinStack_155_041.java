package com.leetCodeStudy.easy_middle_hard.Design;

import java.util.Stack;

/**
 * Design--数学问题
 * 
 * * 2 ways to resolve question-- Min Stack--最小栈
 * 正确理解题意很关键
 * 
 * 1st way:  普通栈+ 辅助栈（最小栈）
 *         stack+minStack
 * 
 * 2nd way:
 * 
 * @author Richard.Feng
 */

public class MinStack_155_041
{
	public static void prt(Object o) {System.out.println(o);}
	
	public static void main(String...args)
	{
		/*
		 * Input
	["MinStack","push","push","push","getMin","pop","top","getMin"]
	[[],[-2],[0],[-3],[],[],[],[]]

	Output
	[null,null,null,null,-3,null,0,-2]  * */

	MinStack041 minStack = new MinStack041();
	minStack.push(-2);
	minStack.push(0);
	minStack.push(-3);
	prt(minStack.getMin()); // return -3
	minStack.pop();
	prt(minStack.top());    // return 0
	prt(minStack.getMin()); // return -2
		 
	}

	
}

//-----------------------------------------------
class MinStack041
{ // Solution041

	Stack<Integer> stack; // =new Stack<>(); //普通
	Stack<Integer> minStack;// =new Stack<>(); //辅助,只存最小值

	public MinStack041()
	{

		stack = new Stack<>();
		minStack = new Stack<>();
	}

	public void push(int val)
	{

		stack.push(val);

//    	int min=Integer.MAX_VALUE;
//    	min=Math.min(minStack.peek(), val);
//    	minStack.push(min);

		if (minStack.isEmpty())
			minStack.push(val);
		else
		{
			int min = Math.min(minStack.peek(), val);
			minStack.push(min);
		}

	}

	public void pop()
	{
		stack.pop();
		minStack.pop();

	}

	public int top()
	{
		return stack.peek();

	}

	public int getMin()
	{
		return minStack.peek();

	}
}

/**
 * Your MinStack object will be instantiated and called as such: MinStack obj =
 * new MinStack(); obj.push(val); obj.pop(); int param_3 = obj.top(); int
 * param_4 = obj.getMin();
 */
