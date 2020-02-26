package q0073;

import java.util.Arrays;

public class SetMatrixZeros {
	/**
	给定一个 m x n 的矩阵，如果一个元素为 0，则将其所在行和列的所有元素都设为 0。请使用原地算法。

	示例 1:
	
	输入: 
	[
	  [1,1,1],
	  [1,0,1],
	  [1,1,1]
	]
	输出: 
	[
	  [1,0,1],
	  [0,0,0],
	  [1,0,1]
	]
	示例 2:
	
	输入: 
	[
	  [0,1,2,0],
	  [3,4,5,2],
	  [1,3,1,5]
	]
	输出: 
	[
	  [0,0,0,0],
	  [0,4,5,0],
	  [0,3,1,0]
	]
	 */
	public static void setZeroes(int[][] matrix) {
		if(matrix == null || matrix.length == 0 || matrix[0].length == 0) return;
		int m = matrix.length;
		int n = matrix[0].length;
		boolean row = false;
		boolean col = false;
		for(int i=0; i<m; i++){
			for(int j=0; j<n; j++){
				if(matrix[i][j] == 0){
					matrix[0][j] = 0;
					matrix[i][0] = 0;
					if(i==0) row = true;
					if(j==0) col = true;
				}
			}
		}
		//row 从matrix[1][1]开始
		for(int i=1; i<m; i++){
			if(matrix[i][0] == 0){
				for(int j=1; j<n; j++){
					matrix[i][j] = 0;
				}
			}
		}
		//col 从matrix[1][1]开始
		for(int j=1; j<n; j++){
			if(matrix[0][j]==0){
				for(int i=1; i<m; i++){
					matrix[i][j] = 0;
				}
			}
		}
		//第0行
		if(row == true){
			for(int j=0; j<n; j++){
				matrix[0][j] = 0;
			}
		}
		//第0列
		if(col == true){
			for(int i=0; i<m; i++){
				matrix[i][0] = 0;
			}
		}
	}
	
	public static void main(String[] args) {
		int[][] matrix = {{0,1,2,0},
						  {3,4,5,2},
						  {1,3,1,5}};
		setZeroes(matrix);
		for(int i=0; i<matrix.length;i++){
			System.out.println(Arrays.toString(matrix[i]));
		}
	}
}
