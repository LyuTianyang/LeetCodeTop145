package q0054;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
	/**
	给定一个包含 m x n 个元素的矩阵（m 行, n 列），请按照顺时针螺旋顺序，返回矩阵中的所有元素。

	示例 1:
	
	输入:
	[
	 [ 1, 2, 3 ],
	 [ 4, 5, 6 ],
	 [ 7, 8, 9 ]
	]
	输出: [1,2,3,6,9,8,7,4,5]
	示例 2:
	
	输入:
	[
	  [1, 2, 3, 4],
	  [5, 6, 7, 8],
	  [9,10,11,12]
	]
	输出: [1,2,3,4,8,12,11,10,9,5,6,7]
	 */
	public static List<Integer> spiralOrder(int[][] matrix) {
		List<Integer> res = new ArrayList<Integer>();
		if(matrix == null || matrix.length==0 || matrix[0].length==0) return res;
		int rowBegin = 0;
		int rowEnd = matrix.length-1;
		int colBegin = 0;
		int colEnd = matrix[0].length-1;
		while(rowBegin<=rowEnd && colBegin<=colEnd){
			for(int i=colBegin; i<=colEnd; i++){
				res.add(matrix[rowBegin][i]);
			}
			rowBegin++;
			
			for(int i=rowBegin; i<=rowEnd; i++){
				res.add(matrix[i][colEnd]);
			}
			colEnd--;
			
			if(rowBegin <= rowEnd){
				for(int i=colEnd; i>=colBegin; i--){
					res.add(matrix[rowEnd][i]);
				}
			}
			rowEnd--;
			
			if(colBegin<=colEnd){
				for(int i=rowEnd; i>=rowBegin; i--){
					res.add(matrix[i][colBegin]);
				}
			}
			colBegin++;
			
		}
		return res;
    }
	
	public static void main(String[] args) {
		int[][] matrix = {{1,2,3},
						  {4,5,6},
						  {7,8,9}};
		List<Integer> res = spiralOrder(matrix);
		System.out.println(res);
	}
}
