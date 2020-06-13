package num_0026_removeElement;

import java.util.Arrays;

public class RemoveDuplicatesFromSortedArray {

	/**
	 *  给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
	 *  [1,1,2,2,3,4,4]
	 *  不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
	 */
	public static int removeDuplicates(int[] nums) {
		if(nums == null || nums.length == 0) return 0;
        int slow = 1;
         for(int fast = 1;fast<nums.length;fast++){
        	if(nums[fast-1]!=nums[fast]){
        		//nums[slow++] = nums[fast]; 这一行等于下面两行
        		nums[slow] = nums[fast];
        		slow++;
        	}
        }
		return slow;
    }
	
	public static int removeDuplicates1(int[] nums) {
		if(nums == null || nums.length == 0) return 0;
		int count = 1;
		for(int i = 1; i<nums.length; i++){
			if(nums[i] != nums[i-1]){
				count = count+1;
			}
		}
		return count;
	}
	
	//找出不重复元素的下标
	public static int findNoneDuplicate(int[] nums) {
		if(nums == null || nums.length == 1) return -1;
		Arrays.sort(nums);
		int n = nums.length;
		if(nums.length == 1) return 0;
		if(nums[0] != nums[1]) return 0;
		for(int i=1; i<n-1; i++){
			if(nums[i] != nums[i-1] && nums[i]!=nums[i+1]){
				return i;
			}
		}
		if(nums[n-1]!=nums[n-2]) return n-1;
		return -1;
	}
	
	public static void main(String[] args) {
		int[] nums = new int[]{1,1,2,2,3,4,4};
		int result = removeDuplicates(nums);
		System.out.println(result);
	}
}
