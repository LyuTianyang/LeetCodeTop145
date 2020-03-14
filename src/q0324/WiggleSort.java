package q0324;

import java.util.Arrays;

public class WiggleSort {
	/**
	给定一个无序的数组 nums，将它重新排列成 nums[0] < nums[1] > nums[2] < nums[3]... 的顺序。

	示例 1:
	
	输入: nums = [1, 5, 1, 1, 6, 4]
	输出: 一个可能的答案是 [1, 4, 1, 5, 1, 6]
	示例 2:
	
	输入: nums = [1, 3, 2, 2, 3, 1]
	输出: 一个可能的答案是 [2, 3, 1, 3, 1, 2]
	说明:
	你可以假设所有输入都会得到有效的结果。
	
	进阶:
	你能用 O(n) 时间复杂度和 / 或原地 O(1) 额外空间来实现吗？
	 */
	public static void wiggleSort1(int[] nums) {
		if(nums == null || nums.length == 0) return;
		int[] tmp = Arrays.copyOf(nums, nums.length);
		Arrays.sort(tmp);
		int index = (nums.length+1)/2;
		for(int i=0, j=nums.length; i<nums.length-1; i=i+2){
			nums[i] = tmp[--index];
			nums[i+1] = tmp[--j];
		}
		if(nums.length % 2 == 0){
			nums[nums.length-1] = nums[nums.length-1];
		}else{
			nums[nums.length-1] = tmp[0];
		}
    }
	
	public static int n;
	    
    public static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
    
    public static int getLess(int x, int[] nums) {
        int lessNum = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] <= x) {
                lessNum++;
            }
        }
        return lessNum;
    }
    
    public static int getMid(int[] nums, int ma, int mi) {
        int l = mi, r = ma, mid = 0, ans = 0, lessNum = 0;
        while (l <= r) {
            mid = (l >> 1) + (r >> 1) + (l & r & 1);
            lessNum = getLess(mid, nums);
            if (lessNum <= (n >> 1)) {
                l = mid + 1;
            } else {
                r = mid - 1;
                ans = mid;
            }
        }
        return ans;
    }
    
    public static int vi(int x) {
        return (x << 1 | 1) % (n | 1); 
    }
    
    public static void wiggleSort2(int[] nums) {
    	if(nums == null || nums.length == 0) return;
        n = nums.length;
        int ma = nums[0], mi = nums[0];
        for (int i = 0; i < n; i++) {
            ma = Math.max(ma, nums[i]);
            mi = Math.min(mi, nums[i]);
        }
        int tmid = getMid(nums, ma, mi);
        int mid = nums[0], minDiff = ma - mi;
        for (int i = 0; i < n; i++) {
            if (nums[i] >= tmid && nums[i] - tmid < minDiff) {
                minDiff = nums[i] - tmid;
                mid = nums[i];
            }
        }
        int l = 0, r = n - 1;
        for (int i = 0; i <= r; i++) {
            if (nums[vi(i)] > mid) {
                swap(nums, vi(i), vi(l));
                l++;
            } else if (nums[vi(i)] < mid) {
                swap(nums, vi(i), vi(r));
                i--;
                r--;
            }
        }
    }
	
	public static void main(String[] args) {
		int[] nums = new int[]{1, 3, 2, 2, 3, 1};
		wiggleSort2(nums);
		System.out.println(Arrays.toString(nums));
	}
}
