package q0046_Recursion;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Permutation1 {
	/**
	Q0046_recursion 给定一个没有重复数字的序列，返回其所有可能的全排列。
	输入: [1,2,3]
	输出:
	[
	  [1,2,3],
	  [1,3,2],
	  [2,1,3],
	  [2,3,1],
	  [3,1,2],
	  [3,2,1]
	]
	*/
	public static List<List<Integer>> permute1(int[] nums) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		if(nums == null || nums.length == 0){
			return res;
		}
		List<Integer> curList = new ArrayList<Integer>();
		boolean[] used = new boolean[nums.length];
		//上面几行用于定义好需要用的集合和其他参数，之后进入helper方法
		helper(res, curList, nums, used);
		return res;
    }
	
	public static void helper(List<List<Integer>> res, List<Integer> curList, int[] nums, boolean[] used){
		if(curList.size() == nums.length){
			res.add( new ArrayList<Integer>(curList));
			return;
		}else{
			for(int i=0; i<nums.length; i++){
				if(used[i] == false){
					curList.add(nums[i]);
					used[i] = true;
					helper(res, curList, nums, used);
					used[i] = false;
					curList.remove(curList.size()-1);
					
				}
			}
		}
	}
	
	public static void main(String[] args) {
		int[] nums = {1,2,3};
		System.out.println(permute1(nums));
	}
}
