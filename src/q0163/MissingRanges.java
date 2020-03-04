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
		 List<String> ranges = new ArrayList<String>();
		 if(nums == null || nums.length == 0){
			 ranges.add(range(lower, upper));
			 return ranges;
		 }
		 //Arrays.sort(nums);
		 if(lower<nums[0]) ranges.add(range(lower, nums[0]-1));
		 for(int i=0; i<nums.length-1; i++){
			 if(nums[i]+1<nums[i+1]){
				 ranges.add(range(nums[i]+1, nums[i+1]-1));
			 }
		 }
		 if(nums[nums.length-1]<upper) ranges.add(range(nums[nums.length-1]+1, upper));
		 return ranges;
	 }
	 
	 public static String range(int lower, int upper){
		 if(lower == upper) return Integer.toString(lower);
		 return lower+"->"+upper;
	 }
	 
	 public static void main(String[] args) {
		int[] nums = new int[]{0, 1, 3, 50, 75};
		List<String> res = findMissingRanges(nums, 0, 99);
		System.out.println(res);
	}
}
