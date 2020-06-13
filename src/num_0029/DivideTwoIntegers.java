package num_0029;

public class DivideTwoIntegers {
	/**
	 * 给定两个整数，被除数 dividend 和除数 divisor。将两数相除，要求不使用乘法、除法和 mod 运算符。

	       返回被除数 dividend 除以除数 divisor 得到的商。
	 */
	public static int divide(int dividend, int divisor) {
		if(divisor == 0) return Integer.MAX_VALUE;
		if (dividend == Integer.MIN_VALUE){
			if(divisor == -1) return Integer.MAX_VALUE;
			else if(divisor == 1) return Integer.MIN_VALUE;
		}
		//转化成long，防止overflow
		long divd = (long)dividend;
		long divs = (long)divisor;
		//判断正负号
		int sign = 1;
		if(divd<0){
			divd = -divd;
			sign = -sign;
		}
		if(divs < 0){
			divs = -divs;
			sign = -sign;
		}
		int res = 0;
		//<< shift,  乘以2的几次方
		while(divs<=divd){
			int shift = 0;
			while((divs << shift) <= divd){
				shift++;
			}
			res += 1 << (shift-1);
			divd -= divs << (shift-1);
		}
		return sign * res;
	}
	
	public static void main(String[] args) {
		int result = divide(97,3);
		System.out.println(result);
	}
	
}
