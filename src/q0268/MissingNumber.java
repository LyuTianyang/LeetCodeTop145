package q0268;

import java.util.Arrays;
import java.util.HashSet;

public class MissingNumber {
	/**
	给定一个包含 0, 1, 2, ..., n 中 n 个数的序列，找出 0 .. n 中没有出现在序列中的那个数。

	示例 1:
	
	输入: [3,0,1]
	输出: 2
	示例 2:
	
	输入: [9,6,4,2,3,5,7,0,1]
	输出: 8
	 */
	public static int missingNumber1(int[] nums) {
		if(nums == null || nums.length == 0) return -1;
		Arrays.sort(nums);
		if(nums[nums.length-1] != nums.length){
			return nums.length;
		}else if(nums[0] != 0){
			return 0;
		}
		for(int i=1; i<nums.length; i++){
			int res = nums[i-1]+1;
			if(nums[i] != res){
				return res;
			}
		}
		return -1;
    }
	
	public static int missingNumber2(int[] nums) {
		if(nums == null || nums.length == 0) return -1;
		HashSet<Integer> set = new HashSet<Integer>();
		for(int num: nums){
			set.add(num);
		}
		int count = nums.length+1;
		for(int i=0; i<count; i++){
			if(!set.contains(i)){
				return i;
			}
		}
		return -1;
	}
	public static int missingNumber3(int[] nums) {
        int missing = nums.length;
        for (int i = 0; i < nums.length; i++) {
            missing ^= i ^ nums[i];
        }
        return missing;
    }
	
	public static int missingNumber4(int[] nums) {
        int expectedSum = nums.length*(nums.length + 1)/2;
        int actualSum = 0;
        for (int num : nums) actualSum += num;
        return expectedSum - actualSum;
    }
	
	public static void main(String[] args) {
		int[] nums = new int[]{9,6,4,2,3,5,7,0,1};
		int res = missingNumber2(nums);
		System.out.println(res);
	}
}
