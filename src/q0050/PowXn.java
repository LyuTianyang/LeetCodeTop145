package q0050;

public class PowXn {
	/**
	Q0050  实现 pow(x, n) ，即计算 x 的 n 次幂函数。
	示例 1:
	输入: 2.00000, 10
	输出: 1024.00000
	示例 2:
	输入: 2.10000, 3
	输出: 9.26100
	示例 3:
	输入: 2.00000, -2
	输出: 0.25000
	解释: 2-2 = 1/22 = 1/4 = 0.25
	说明:
	
	-100.0 < power < 100.0
	n 是 32 位有符号整数，其数值范围是 [−231, 231 − 1] 。
	 */
	public static double myPow(double num, int power) {
		if(power>=100 || power<=-100) return 0;
        //分别处理指数等于0或1的特殊情况
		if(power==0 || num == 1) return 1;
		if(power==1) return num;
		//处理指数是负数的情况，由于可能出现负数最小值(-1)，所以把指数加一再相乘一次
		if(power<0) return 1/(num*myPow(num, -(power+1)));
		double result = 1;
		while(power>1){
			if(power%2 == 1){
				result = result * num;
			}
			num = num * num;
			power = power/2;
		}
		result = result*num;
		return result;
    }
	public static void main(String[] args) {
		double result = myPow(2.00000,10);
		System.out.println(result);
	}
}
