package q0384_design;

import java.util.Arrays;
import java.util.Random;

public class ShuffleArray {
	
	/**
	 打乱一个没有重复元素的数组。

	示例:
	
	// 以数字集合 1, 2 和 3 初始化数组。
	int[] nums = {1,2,3};
	Solution solution = new Solution(nums);
	
	// 打乱数组 [1,2,3] 并返回结果。任何 [1,2,3]的排列返回的概率应该相同。
	solution.shuffle();
	
	// 重设数组到它的初始状态[1,2,3]。
	solution.reset();
	
	// 随机返回数组[1,2,3]打乱后的结果。
	solution.shuffle();
	 */
	
	private int[] array;
    private int[] original;

    Random rand = new Random();

    private int randRange(int min, int max) {
        return rand.nextInt(max - min) + min;
    }

    private void swapAt(int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public ShuffleArray(int[] nums) {
        array = nums;
        original = nums.clone();
    }
    
    public int[] reset() {
        array = original;
        original = original.clone();
        return original;
    }
    
    public int[] shuffle() {
        for (int i = 0; i < array.length; i++) {
            swapAt(i, randRange(i, array.length));
        }
        return array;
    }
    
    public static void main(String[] args) {
    	int[] nums = new int[]{1,2,3,4,5};
    	ShuffleArray solution = new ShuffleArray(nums);
    	System.out.println(Arrays.toString(solution.shuffle()));
    	System.out.println(Arrays.toString(solution.reset()));
	}
}
