package q0179;

import java.util.Arrays;
import java.util.Comparator;

class NumberComparator implements Comparator<String>{
	@Override
	public int compare(String a, String b) {
		String order1 = a+b;
		String order2 = b+a;
		return order2.compareTo(order1);
	}
}

public class LargestNumber {
	/**
	给定一组非负整数，重新排列它们的顺序使之组成一个最大的整数。

	示例 1:
	
	输入: [10,2]
	输出: 210
	示例 2:
	
	输入: [3,30,34,5,9]
	输出: 9534330
	 */
	
	
	public static String largestNumber(int[] nums) {
		if(nums == null || nums.length == 0) return "";
		String[] res = new String[nums.length];
		for(int i=0; i<nums.length; i++){
			res[i] = String.valueOf(nums[i]);
		}
		Arrays.sort(res, new NumberComparator());
		
		if(res[0].equals("0")) return "0";
		String largestNumber = "";
		for(int i=0; i<res.length; i++){
			largestNumber+=res[i];
		}
		return largestNumber;
    }
	
	public static void main(String[] args) {
		int[] nums = new int[]{3,30,34,5,9};
		String largestNumber = largestNumber(nums);
		System.out.println(largestNumber);
	}
}
