package q0162;

public class FindPeakElement {
	/**
	峰值元素是指其值大于左右相邻值的元素。

	给定一个输入数组 nums，其中 nums[i] ≠ nums[i+1]，找到峰值元素并返回其索引。
	
	数组可能包含多个峰值，在这种情况下，返回任何一个峰值所在位置即可。
	
	你可以假设 nums[-1] = nums[n] = -∞。
	
	示例 1:
	
	输入: nums = [1,2,3,1]
	输出: 2
	解释: 3 是峰值元素，你的函数应该返回其索引 2。
	示例 2:
	
	输入: nums = [1,2,1,3,5,6,4]
	输出: 1 或 5 
	解释: 你的函数可以返回索引 1，其峰值元素为 2；
	     或者返回索引 5， 其峰值元素为 6。
	 */
	public static int findPeakElement1(int[] nums) {
		if(nums == null || nums.length == 0) return 0;
		int start = 0;
		int end = nums.length-1;
		while(start+1 < end){
			int mid = start+(end-start)/2;
			if(nums[mid]>nums[mid+1]){
				end = mid;
			}else{
				start = mid+1;
			}
		}
		return nums[start]>nums[end] ? start:end;
    }
	
	public static int findPeakElement2(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > nums[i + 1])
                return i;
        }
        return nums.length - 1;
    }
	
	public static int findPeakElement3(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[mid + 1]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
	
	public static void main(String[] args) {
		int[] nums = new int[]{1,2,1,3,5,6,4};
		int res = findPeakElement3(nums);
		System.out.println(res);
	}
}
