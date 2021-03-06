package num_0001_easy;

import java.util.HashMap;
import java.util.Map;

public class TwoSum_001 {
	/**
     * 给定 nums = [2, 7, 11, 15], target = 9
	       因为 nums[0] + nums[1] = 2 + 7 = 9
	       所以返回 [0, 1]
     */
	public static int[] twoSum1(int[] nums, int target) {
		if(nums == null || nums.length < 2) return null;
		//以nums[i]的值为key，下标i为value
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for(int i=0;i<nums.length;i++){
			if(map.containsKey(target - nums[i])){
				return new int[]{map.get(target - nums[i]), i};
			}
			map.put(nums[i], i);
		}
		return null;
	}
	 public int[] twoSum2(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] == target - nums[i]) {
                    return new int[] { i, j };
                }
            }
        }
        return null;
    }
	public static void main(String[] args) {
		int[] nums = new int[]{1,3,5,6,8};
		int target = 8;
		int[] result = twoSum1(nums, target);
		
		System.out.println(Arrays.toString(result));
		
		
		
	}
}
