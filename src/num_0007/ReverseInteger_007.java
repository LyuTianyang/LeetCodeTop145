package num_0007;

public class ReverseInteger_007 {
	/**
	给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
	示例 1:
	
	输入: 123
	输出: 321
	 示例 2:
	
	输入: -123
	输出: -321
	示例 3:
	
	输入: 120
	输出: 21
	 */
	public static int reverse(int x){
		if(-9 <= x && x <= 9) return x;
		int rev = 0;
	    while(x!=0){
	    	int newRev = rev*10 + x%10;
	    	//上一步的你操作，验证是否overflow
	    	if((newRev-x%10)/10 != rev) return 0;
	    	rev = newRev;
	    	x = x/10;
	    }
	    return rev;
	}
	
	public static void main(String[] args) {
		System.out.println(reverse(-12345));
		
	}
}
