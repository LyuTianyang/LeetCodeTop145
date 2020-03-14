package q0378;

public class kthSmallestInMatrix {
	/**
	给定一个 n x n 矩阵，其中每行和每列元素均按升序排序，找到矩阵中第k小的元素。
	请注意，它是排序后的第k小元素，而不是第k个元素。
	
	示例:
	
	matrix = [
	   [ 1,  5,  9],
	   [10, 11, 13],
	   [12, 13, 15]
	],
	k = 8,
	
	返回 13。
	说明:
	你可以假设 k 的值永远是有效的, 1 ≤ k ≤ n2 
	 */
	public static int kthSmallest(int[][] matrix, int k) {
		if(matrix == null || matrix.length==0 || matrix[0].length == 0) return 0;
		int n = matrix.length;
		int left = matrix[0][0];
		int right = matrix[n-1][n-1];
		while(left<right){
			int mid = left+(right-left)/2;
			int count = 0;
			int j = matrix[0].length-1;
			for(int i=0; i<matrix.length; i++){
				while(j>=0 && matrix[i][j]>mid){
					j--;
				}
				count+=(j+1);
			}
			if(count<k){
				left = mid+1;
			}else{
				right = mid;
			}
		}
		return left;
    }
	public static void main(String[] args) {
		int[][] matrix = new int[][]{{1,  5,  9},
									 {10, 11, 13},
									 {12, 13, 15}};
		int res = kthSmallest(matrix, 8);
		System.out.println(res);
	}
}
