package q0034_BinarySearch;

public class SearchForARange {
	/**
	 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
	你的算法时间复杂度必须是 O(log n) 级别。
	如果数组中不存在目标值，返回 [-1, -1]。
	
	输入: nums = [5,7,7,8,8,10], target = 8
	输出: [3,4]
	
	输入: nums = [5,7,7,8,8,10], target = 6
	输出: [-1,-1]
	
	使用两次 二分法查询
	 */
	public static int[] searchRange(int[] nums, int target) {
        int[] res = {-1,-1};
        if(nums == null || nums.length < 1){
        	return res;
        }
        //找到最左边的指针
        int start = 0;
        int end = nums.length - 1;
        int st_point = -1, end_point = -1;
        //当start, end指针相邻，循环结束
        while(start+1 < end){
        	//避免overflow
        	int mid = start + (end - start)/2;
        	if(target<=nums[mid]){
        		end = mid;
        	}else{
        		start = mid;
        	}
        }
        if(nums[start] == target) st_point = start;
        else if(nums[end] == target) st_point = end;
        if(st_point == -1) return res; 
        
        //找到最右边的指针
        start = 0;
        end = nums.length - 1;
        while(start+1 < end){
        	int mid = start + (end - start)/2;
        	if(target<nums[mid]){
        		end = mid;
        	}else{
        		start = mid;
        	}
        }
        if(nums[end] == target) end_point = end;
        else if(nums[start] == target) end_point = start;
        res[0] = st_point;
        res[1] = end_point;
        return res;
    }
	
	public static void main(String[] args) {
		int[] nums = {5,6,7,7,7,8,9,10};
		int[] result = searchRange(nums,7);
		for(int r : result){
			System.out.println(r);
		}
	}
	
}
