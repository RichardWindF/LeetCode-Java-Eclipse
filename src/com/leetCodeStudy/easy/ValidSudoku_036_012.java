package com.leetCodeStudy.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 2 ways to resolve question
 * 
 * 1st way: 行标+行set, 列+列set, boxs+boxSet, Set[] set 数组
 * 
 * 2nd way: HashMap<行标,Set<行中内容>>--key 是 行，列，BOX 各自的Map 及判断
 * 
 *
 * @author Richard.F
 *
 */

public class ValidSudoku_036_012
{
	public static void prt(Object o)
	{
		System.out.println(o);
	}

	public static void main(String[] args)
	{

		prt("resolved by 1st way:");
		prt(new Solution012().isValidSudoku1(Datas.board1));
		prt(new Solution012().isValidSudoku1(Datas.board2));

		prt("----------------------------------------------------");
		prt("resolved by 2nd way:");
		//prt(new Solution012().isValidSudoku2(new Datas().board1));
		prt(new Solution012().isValidSudoku2(Datas.board1));
		prt(new Solution012().isValidSudoku2(Datas.board2));
	}

}

//----------------------------------------------------

class Solution012
{

//1st way: 行标+行set, 列+列set, boxs+boxSet,
//	          Set[] set 数组
	public boolean isValidSudoku1(char[][] board)
	{
		// 行，列，及方块 准备的各自Set
		// Set[] rowSet = new HashSet[9]; //注意泛型
		Set<Character>[] rowSet = new HashSet[9];
		Set<Character>[] colSet = new HashSet[9];
		Set<Character>[] boxSet = new HashSet[9]; // 这个每个3X3 的方块下标确定比较麻烦

		// 初始化--这个容易忘记
		for (int i = 0; i < 9; i++)
		{
			rowSet[i] = new HashSet<Character>();
			colSet[i] = new HashSet<Character>();
			boxSet[i] = new HashSet<Character>();
		}

		// 要行，列，及方块 都符合规则，才可以返回true
		for (int i = 0; i < 9; i++) // 行
			for (int j = 0; j < 9; j++) // 列
			{
				if (board[i][j] != '.')
				{
					if (rowSet[i].contains(board[i][j]))
						return false;
					if (colSet[j].contains(board[i][j]))
						return false;
					if (boxSet[i / 3 * 3 + j / 3].contains(board[i][j]))
						return false;
				}

				// 如果没有重复，满足条件，修正及存储到对应行,列,块
				rowSet[i].add(board[i][j]);
				colSet[j].add(board[i][j]);
				boxSet[i / 3 * 3 + j / 3].add(board[i][j]);   //关键确定那个块
			}

		return true;

	}
	
	//2nd way: HashMap<行标,Set<行中内容>>--key 是 行，列，BOX 各自的Map 及判断

	public boolean isValidSudoku2(char[][] board)
	{
		Map<Integer,Set<Character>> rowSetMap=new HashMap<>();      // <行标,Set<行中内容>>
		Map<Integer,Set<Character>> colSetMap=new HashMap<>();
		Map<Integer,Set<Character>> boxSetMap=new HashMap<>();
		
		//for(int i=0;i<board.length;i++)         //行--9
			for(int i=0;i<9;i++)         //行--9
			for(int j=0;j<board[0].length;j++)    //列--9
			{
				char curChar=board[i][j];
				if(curChar=='.') continue;
				
				//行Set 初始化 rowSet
				Set<Character> rowSet=rowSetMap.get(i);
				if(rowSet==null)
				{
					rowSet=new HashSet<>();
					rowSetMap.put(i, rowSet);
				}
				
				//列Set 初始化 colSet
				Set<Character> colSet=colSetMap.get(j);
				if(colSet==null)
				{
					colSet=new HashSet<>();
					colSetMap.put(j, colSet);
				}
				
				//box 初始化 boxSet
				Set boxSet=boxSetMap.get(i/3*3+j/3);        //确定是那个BOX 的下标
				if(boxSet==null)
				{
					boxSet=new HashSet<>();
					boxSetMap.put(i/3*3+j/3, boxSet);
				}
				
				// 判断3个条件都成立，返回true
				
				if(!rowSet.add(curChar)||!colSet.add(curChar)||!boxSet.add(curChar))  return false;
					//任何一个加不成功（返回false,有重复项）
				
			}
		
		return true;    //能到这里
	}
}

//--------------------------------------------------------------------
/*
 * 
 * Input: board =
 * 
 */
class Datas
{

	/*
	 * //注意这里 “ ” 当字符串处理，eclipse java 不识别，但在 代码测试网站上 提交就不用考虑这个数据问题，能通过 public static
	 * char[][] board1 = { // Output: true { "5", "3", ".", ".", "7", ".", ".", ".",
	 * "." }, { "6", ".", ".", "1", "9", "5", ".", ".", "." }, { ".", "9", "8", ".",
	 * ".", ".", ".", "6", "." }, { "8", ".", ".", ".", "6", ".", ".", ".", "3" }, {
	 * "4", ".", ".", "8", ".", "3", ".", ".", "1" }, { "7", ".", ".", ".", "2",
	 * ".", ".", ".", "6" }, { ".", "6", ".", ".", ".", ".", "2", "8", "." }, { ".",
	 * ".", ".", "4", "1", "9", ".", ".", "5" }, { ".", ".", ".", ".", "8", ".",
	 * ".", "7", "9" } };
	 * 
	 * public static String[][] board2 = { // Output: false { "8", "3", ".", ".",
	 * "7", ".", ".", ".", "." }, { "6", ".", ".", "1", "9", "5", ".", ".", "." }, {
	 * ".", "9", "8", ".", ".", ".", ".", "6", "." }, { "8", ".", ".", ".", "6",
	 * ".", ".", ".", "3" }, { "4", ".", ".", "8", ".", "3", ".", ".", "1" }, { "7",
	 * ".", ".", ".", "2", ".", ".", ".", "6" }, { ".", "6", ".", ".", ".", ".",
	 * "2", "8", "." }, { ".", ".", ".", "4", "1", "9", ".", ".", "5" }, { ".", ".",
	 * ".", ".", "8", ".", ".", "7", "9" } };
	 */
	public static char[][] board1 = { // Output: true
			{ '5', '3', '.', '.', '7', '.', '.', '.', '.' }, { '6', '.', '.', '1', '9', '5', '.', '.', '.' },
			{ '.', '9', '8', '.', '.', '.', '.', '6', '.' }, { '8', '.', '.', '.', '6', '.', '.', '.', '3' },
			{ '4', '.', '.', '8', '.', '3', '.', '.', '1' }, { '7', '.', '.', '.', '2', '.', '.', '.', '6' },
			{ '.', '6', '.', '.', '.', '.', '2', '8', '.' }, { '.', '.', '.', '4', '1', '9', '.', '.', '5' },
			{ '.', '.', '.', '.', '8', '.', '.', '7', '9' } };

	public static char[][] board2 = { // Output: false
			{ '8', '3', '.', '.', '7', '.', '.', '.', '.' }, { '6', '.', '.', '1', '9', '5', '.', '.', '.' },
			{ '.', '9', '8', '.', '.', '.', '.', '6', '.' }, { '8', '.', '.', '.', '6', '.', '.', '.', '3' },
			{ '4', '.', '.', '8', '.', '3', '.', '.', '1' }, { '7', '.', '.', '.', '2', '.', '.', '.', '6' },
			{ '.', '6', '.', '.', '.', '.', '2', '8', '.' }, { '.', '.', '.', '4', '1', '9', '.', '.', '5' },
			{ '.', '.', '.', '.', '8', '.', '.', '7', '9' } };

}