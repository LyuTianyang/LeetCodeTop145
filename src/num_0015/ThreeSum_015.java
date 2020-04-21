package num_0015;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader.Array;

public class ThreeSum_015 {
	/**
	双指针
	
	给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。

	注意：答案中不可以包含重复的三元组。
	
	例如, 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
	
	满足要求的三元组集合为：
	[
	  [-1, 0, 1],
	  [-1, -1, 2]
	]
	 */
	public List<List<Integer>> threeSum(int[] nums){
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		if(nums == null || nums.length<3) return res;
		Arrays.sort(nums);
		int i=0;
		int n = nums.length;
		while(i<n-2){
			int base = nums[i];
			int left = i+1;
			int right = n-1;
			while(left<right){
				int target = base+nums[left]+nums[right];
				if(target == 0){
					List<Integer> cur = new ArrayList<Integer>();
					cur.add(base);
					cur.add(nums[left]);
					cur.add(nums[right]);
					res.add(cur);
					left = plusLeft(nums, left+1);
					right = minusRight(nums, right-1);
				}else if(target<0){
					left = plusLeft(nums, left+1);
				}else if(target>0){
					right = minusRight(nums, right-1);
				}
			}
			i = plusLeft(nums, i+1);
		}
		return res;
	}
	public int plusLeft(int[] nums, int left){
		while(left == 0 || (left<nums.length-1 && nums[left-1] == nums[left])){
			left++;
		}
		return left;
	}
	
	public int minusRight(int[] nums, int right){
		while(right == nums.length-1 || (right>0 && nums[right] == nums[right+1])){
			right--;
		}
		return right;
	}
	
	public static void main(String[] args) {
		int[] nums = new int[]{-2,-2,-1,-1,-1,0,1,2,2,3,3,3};
		ThreeSum_015 t = new ThreeSum_015();
		System.out.println(t.threeSum(nums));
		//[[-2, -1, 3], [-2, 0, 2], [-1, -1, 2], [-1, 0, 1]]
	}
}
