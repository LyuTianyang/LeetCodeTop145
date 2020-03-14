package q0326;

public class PowerOfThree {
	/**
	给定一个整数，写一个函数来判断它是否是 3 的幂次方。

	示例 1:
	
	输入: 27
	输出: true
	示例 2:
	
	输入: 0
	输出: false
	示例 3:
	
	输入: 9
	输出: true
	示例 4:
	
	输入: 45
	输出: false
	
	进阶：
	你能不使用循环或者递归来完成本题吗？
	 */
	public static boolean isPowerOfThree1(int n) {
		if(n < 1) return false;
		while(n%3==0){
			n/=3;
		}
		return n==1;
    }
	
	public static boolean isPowerOfThree2(int n) {
		return (Math.log10(n) / Math.log10(3)) % 1 == 0;
    }
	
	public static boolean isPowerOfThree3(int n) {
		return n > 0 && 1162261467 % n == 0;
    }
	
	public static void main(String[] args) {
		boolean b = isPowerOfThree2(27);
		System.out.println(b);
	}
}
