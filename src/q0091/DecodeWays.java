package q0091;

public class DecodeWays {
	/**
	一条包含字母 A-Z 的消息通过以下方式进行了编码：

	'A' -> 1
	'B' -> 2
	...
	'Z' -> 26
	给定一个只包含数字的非空字符串，请计算解码方法的总数。
	
	示例 1:
	
	输入: "12"
	输出: 2
	解释: 它可以解码为 "AB"（1 2）或者 "L"（12）。
	示例 2:
	
	输入: "226"
	输出: 3
	解释: 它可以解码为 "BZ" (2 26), "VF" (22 6), 或者 "BBF" (2 2 6) 。
	 */
	public static int numDecodings1(String s) {
		if(s == null || s.length()==0) return 0;
		int n = s.length();
		int[] dp = new int[n+1];
		dp[0] = 1;
		dp[1] = s.charAt(0)=='0'? 0:1;
		for(int i=2; i<=n; i++){
			int first = Integer.valueOf(s.substring(i-1,i));
			int second = Integer.valueOf(s.substring(i-2,i));
			if(first >= 1 && first <= 9){
				dp[i] += dp[i-1];
			}
			if(second >= 10 && second <= 26){
				dp[i] += dp[i-2];
			}
		}
		return dp[n];
    }
	
	public static int numDecodings2(String s) {
		if(s == null || s.length()==0) return 0;
		int c1 = 1;
		int c2 = 1;
		for(int i=1; i<s.length(); i++){
			if(s.charAt(i) == '0'){
				c1 = 0;
			}
			if(s.charAt(i-1)=='1' || (s.charAt(i-1)=='2'&& s.charAt(i)<='6')){
				c1 = c1+c2;
				c2 = c1-c2;
			}else{
				c2 = c1;
			}
		}
		return c1;
    }
	public static void main(String[] args) {
		int res = numDecodings1("226");
		System.out.println(res);
	}
}
