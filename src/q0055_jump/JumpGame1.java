package q0055_jump;

public class JumpGame1 {
	/**
	Q0055: 给定一个非负整数数组，你最初位于数组的第一个位置。数组中的每个元素代表你在该位置可以跳跃的最大长度。判断你是否能够到达最后一个位置。
	
	示例 1:
	输入: [2,3,1,1,4]
	输出: true
	解释: 从位置 0 到 1 跳 1 步, 然后跳 3 步到达最后一个位置。
	
	示例 2:
	输入: [3,2,1,0,4]
	输出: false
	解释: 无论怎样，你总会到达索引为 3 的位置。但该位置的最大跳跃长度是 0 ， 所以你永远不可能到达最后一个位置。
	 */
	public static boolean canJump1(int[] nums) {
		if(nums == null || nums.length < 2) return true;
        int length = nums.length;
        int reach = 0;
        for(int i=0; i<length && i<=reach;i++){
        	//最远位置reach, 下标
        	reach = Math.max(nums[i]+i, reach);
        	if(reach >= nums.length-1){
        		return true;
        	}
        }
        return false;
    }
	
	public static boolean canJump2(int[] nums) {
		if(nums == null || nums.length < 2) return true;
        int max = 0;
        for(int i=0; i<nums.length; i++){
        	if(i>max) return false;
        	max = Math.max(max, nums[i]+i);
        }
        return true;
	}
	
	public static void main(String[] args) {
		int[] nums = {2,3,1,1,4};
		boolean result = canJump1(nums);
		System.out.println(result);
	}
}
