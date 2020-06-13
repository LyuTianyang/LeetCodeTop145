package q0334;

public class IncreasingTripletSubsequence {
	/**
	给定一个未排序的数组，判断这个数组中是否存在长度为 3 的递增子序列。

	数学表达式如下:
	
	如果存在这样的 i, j, k,  且满足 0 ≤ i < j < k ≤ n-1，
	使得 arr[i] < arr[j] < arr[k] ，返回 true ; 否则返回 false 。
	说明: 要求算法的时间复杂度为 O(n)，空间复杂度为 O(1) 。
	
	示例 1:
	
	输入: [1,2,3,4,5]
	输出: true
	示例 2:
	
	输入: [5,4,3,2,1]
	输出: false
	 */
	public static boolean increasingTriplet(int[] nums) {
		if(nums == null || nums.length <= 2) return false;
		int a = Integer.MAX_VALUE;
		int b = Integer.MAX_VALUE;
		for(int i=0; i<nums.length; i++){
			if(nums[i]<=a){
				a = nums[i];
			}else if(nums[i]<=b){
				b = nums[i];
			}else{
				return true;
			}
		}
		return false;
	}
	/*
	3个连续递增子序列
	有3个槽位，a,b,c
	满足条件 a < b < c，即可
	需要将合适的元素填入这3个槽位
	 */
	
	public static void main(String[] args) {
		int[] nums = new int[]{3,2,1,5,7};
		boolean b = increasingTriplet(nums);
		System.out.println(b);
	}
}
