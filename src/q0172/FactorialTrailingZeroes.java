package q0172;

public class FactorialTrailingZeroes {
	/**
	 给定一个整数 n，返回 n! 结果尾数中零的数量。

	示例 1:
	
	输入: 3
	输出: 0
	解释: 3! = 6, 尾数中没有零。
	示例 2:
	
	输入: 5
	输出: 1
	解释: 5! = 120, 尾数中有 1 个零.
	说明: 你算法的时间复杂度应为 O(log n) 。
	
	2*5 = 10
	大于等于5，就会有0
	 */
	public static int trailingZeroes1(int n) {
		int count = 0;
		for(int i=1; i<=n; i++){
			int num = i;
			while(num > 0){
				if(num % 5 == 0){
					count++;
					num = num/5;
				}else{
					break;
				}
			}
		}
		return count;
	}
	public static int trailingZeroes2(int n) {
		int count = 0;
		while(n > 0){
			count += n/5;
			n = n/5;
		}
		return count;
	}
	public static void main(String[] args) {
		int res = trailingZeroes1(11);
		System.out.println(res);
	}
}
