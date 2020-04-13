package num_0011;

public class ContinerWithMostWater_011 {
	/**
	给定 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。
	在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。
	找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
	 */
	public static int maxArea(int[] height) {
		if(height == null || height.length<2){
			return 0;
		}
		int left = 0;
		int right = height.length-1;
		int area = 0;
		while(left<right){
			//获得最小的高度
			int minHeight = Math.min(height[left],height[right]);
			area = Math.max(area, (right-left)*minHeight);
			if(height[left]<height[right]){
				left++;
			}else if(height[left]>height[right]){
				right--;
			}else{
				left++;
				right--;
			}
		}
		return area;
    }
	
	
	public static void main(String[] args) {
		int[] height = new int[]{1,8,6,2,5,4,8,3,9};
		System.out.println(maxArea(height));
	}
	
}
