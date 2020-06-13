package num_0033_BinarySearch;

public class SearchInRotatedSortedArray {
	/**
	假设按照升序排序的数组在预先未知的某个点上进行了旋转。
	( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
	
	搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。
	
	你可以假设数组中不存在重复的元素。
	
	你的算法时间复杂度必须是 O(log n) 级别。
	
	示例 1:
	
	输入: nums = [4,5,6,7,0,1,2], target = 0
	输出: 4
	示例 2:
	
	输入: nums = [4,5,6,7,0,1,2], target = 3
	输出: -1
	 */
	public static int searchInRotatedSortedArray(int[] nums, int target) {
		if(nums == null || nums.length == 0) return -1;
		//下标
        int start = 0;
        int end = nums.length-1;
        //当start, end指针相邻，循环结束
        while(start+1 < end){
        	//避免overflow
        	int mid = start + (end-start)/2;
        	if(nums[mid] == target) return mid;
        	if(nums[start] < nums[mid]){//中间的数大于最左边 3,4,5,6,7,0,1,2
        		if(nums[start] <= target && target <= nums[mid]){
        			end = mid;
        		}else{
        			start = mid;
        		}
        	}else if(nums[mid] < nums[end]){//中间的数小于最右边 5,6,7,0,1,2,3,4
        		if(nums[mid]<=target && target<=nums[end]){
        			start = mid;
        		}else{
        			end = mid;
        		}
        	}
        }
        if(nums[start] == target) return start;
        if(nums[end] == target) return end;
        return -1;
    }
	
	public static void main(String[] args) {
		int[] nums = {4,5,6,7,0,1,2};
		int result = searchInRotatedSortedArray(nums,1);
		System.out.println(result);
	}

}
