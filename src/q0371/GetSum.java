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
	public static int getSum1(int a, int b) {
		while(b!=0){
			int tmp = a^b;
			b = (a&b)<<1;
			a = tmp;
		}
		return a;
    }
	
	public static int getSum2(int a, int b) {
	    if (a==0) return b;
	    if (b==0) return a;
	    int lower;
	    int carrier;
	    while (true) {
	        lower = a^b;    // 计算低位
	        carrier = a&b;  // 计算进位
	        if (carrier==0) break;
	        a = lower;
	        b = carrier<<1;
	    }
	    return lower;
	}
	
	public static void main(String[] args) {
		int res = getSum2(-2,5);
		System.out.println(res);
	}
}
