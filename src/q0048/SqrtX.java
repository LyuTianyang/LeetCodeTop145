package q0048;

import java.util.Arrays;

public class SqrtX {
	/**
	Q0048 给定一个 n × n 的二维矩阵表示一个图像。
	将图像顺时针旋转 90 度。
	说明：你必须在原地旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要使用另一个矩阵来旋转图像。
	
	给定 matrix =
	[
	  [ 5, 1, 9,11],
	  [ 2, 4, 8,10],
	  [13, 3, 6, 7],
	  [15,14,12,16]
	], 
	
	原地旋转输入矩阵，使其变为:
	[
	  [15,13, 2, 5],
	  [14, 3, 4, 1],
	  [12, 6, 8, 9],
	  [16, 7,10,11]
	]
	
	[
	  [ 1, 2, 3, 4],
	  [ 5, 6, 7, 8],
	  [ 9,10,11,12],
	  [13,14,15,16]
	]
	
	 */
	public static void rotate(int[][] matrix) {
		if(matrix == null || matrix.length == 0 || matrix[0].length == 0) return;
		int n = matrix.length;
		int top = 0;
		int bottom = n-1;
		int left = 0;
		int right = n-1;
		
		while(n>1){
			//先四个角顺时针调换，再考虑顺时针的位移,下标top,bottom要在前边
			for(int i=0 ; i< n-1; i++){
				int tmp = matrix[top][left+i];
				matrix[top][left+i] = matrix[bottom-i][left];
				matrix[bottom-i][left] = matrix[bottom][right-i];
				matrix[bottom][right-i] = matrix[top+i][right];
				matrix[top+i][right] = tmp;
				
			}
			top++;
			bottom--;
			left++;
			right--;
			n-=2;
		}
    }
	
	public static void main(String[] args) {
		int[][] matrix = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
		rotate(matrix);
		for(int i=0; i<matrix.length; i++){
			System.out.println(Arrays.toString(matrix[i]));
		}
		
	}
}
