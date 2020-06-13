package q0163;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MissingRanges {
	/**
	Given a sorted integer array where the range of elements are [lower, upper] inclusive, return its missing ranges.

	For example, given [0, 1, 3, 50, 75], lower = 0 and upper = 99, return ["2", "4->49", "51->74", "76->99"].

	 */
	 public static List<String> findMissingRanges(int[] nums, int lower, int upper) {
		 List<String> res = new ArrayList<String>();
		 if(nums == null || nums.length == 0){
			 res.add(range(lower,upper));
			 return res;
		 }
		 //Arrays.sort(nums);
		 int n = nums.length;
		 if(lower<nums[0]) res.add(range(lower,nums[0]-1));
		 for(int i=0; i<n-1; i++){
			 if(nums[i]+1<nums[i+1]){
				 res.add(range(nums[i]+1,nums[i+1]-1));
			 }
		 }
		 if(nums[n-1]<upper) res.add(range(nums[n-1]+1, upper));
		 return res;
	 }
	 public static String range(int lower, int upper){
		 if(lower == upper) return String.valueOf(lower);
		 return lower+"->"+upper;
	 }
	 
	 public static void main(String[] args) {
		int[] nums = new int[]{0, 1, 3, 50, 75};
		List<String> res = findMissingRanges(nums, 0, 99);
		System.out.println(res);
	}
}
