package com.leetCodeStudy.easy;

import java.util.Arrays;

/**
 * 2 ways to resolve question
 * 
 * 1st way: 关键要明白这个90度的顺时针旋转=斜下对角线翻转+中轴翻转
 * 
 * 2nd way:
 * 
 *
 * @author Richard.F
 *
 */

public class RotateImage_048_013
{
	public static void prt(Object o)
	{
		System.out.println(o);
	}

	public static void main(String... args)
	{

		prt("resolved by 1st way:");
		new Solution013().rotate1(Datas013.matrix1);
		new Solution013().rotate1(Datas013.matrix2);
		new Solution013().rotate1(Datas013.matrix3);
		new Solution013().rotate1(Datas013.matrix4);

		prt("----------------------------------------------------");
		prt("resolved by 2nd way:");
		new Solution013().rotate2(new Datas013().matrix1);
		// new Solution013().rotate2(Datas013.matrix1);
		// prt(new Solution013().rotate2(Datas.matrix1));
		new Solution013().rotate2(Datas013.matrix2);
		new Solution013().rotate2(Datas013.matrix3);
		new Solution013().rotate2(Datas013.matrix4);

	}

}

//-----------------------------------------------------------------------
class Solution013
{
	// 1st way: 关键要明白这个90度的顺时针旋转=斜下对角线翻转+中轴翻转

	public void rotate1(int[][] matrix)
	{

		// rotateOnColMidAxis(rotateOnDiagonal(matrix));

		RotateImage_048_013.prt(Arrays.deepToString(matrix)); // 注意该法
		RotateImage_048_013.prt(Arrays.deepToString(rotateOnColMidAxis(rotateOnDiagonal(matrix)))); // 注意该法
	}

	private int[][] rotateOnColMidAxis(int[][] matrix)
	{
		for (int i = 0; i < matrix.length; i++)
			for (int j = 0; j < matrix[0].length/2; j++)
			{
				int temp; // 两边值横向中轴对应交换
				temp = matrix[i][j];
				matrix[i][j] = matrix[i][matrix[0].length - j - 1];
				matrix[i][matrix[0].length - j - 1] = temp;

			}

		return matrix;
	}

	private int[][]  rotateOnDiagonal(int[][] matrix)
	{

		for (int i = 0; i < matrix.length; i++)
			for (int j = 0; j < matrix[0].length; j++)
			{
				if (i <= j)
				{
					int temp; // 对角线两边值对应交换
					temp = matrix[i][j];
					matrix[i][j] = matrix[j][i];
					matrix[j][i] = temp;
				}
			}

		return matrix;
	}

	// ------------------------------------------------

	public void rotate2(int[][] matrix)
	{

	}

}

//---------------------------------
class Datas013
{
	public static int[][] matrix1 = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } }; // Output: [[7,4,1],[8,5,2],[9,6,3]]

	public static int[][] matrix2 =
			{ { 5, 1, 9, 11 }, { 2, 4, 8, 10 }, { 13, 3, 6, 7 }, { 15, 14, 12, 16 } };
        	// Output: [[15,13,2,5],[14,3,4,1],[12,6,8,9],[16,7,10,11]]

	public static int[][] matrix3 = { { 1 } }; // Output: [[1]]

	public static int[][] matrix4 = { { 1, 2 }, { 3, 4 } }; // Output: {{3,1},{4,2}}

}