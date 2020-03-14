package q0371;

public class GetSum {
	/**
	不使用运算符 + 和 - ​​​​​​​，计算两整数 ​​​​​​​a 、b ​​​​​​​之和。

	示例 1:
	
	输入: a = 1, b = 2
	输出: 3
	示例 2:
	
	输入: a = -2, b = 3
	输出: 1
	 */
	public static int getSum(int a, int b) {
		while(b!=0){
			int tmp = a^b;
			b = (a&b)<<1;
			a = tmp;
		}
		return a;
    }
	
	public static void main(String[] args) {
		int res = getSum(-2,5);
		System.out.println(res);
	}
}
