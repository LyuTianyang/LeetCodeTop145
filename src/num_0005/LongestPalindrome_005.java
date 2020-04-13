package num_0005;

public class LongestPalindrome_005 {
	/**
	Q0005 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。

	示例 1：
	
	输入: "babad"
	输出: "bab"
	注意: "aba" 也是一个有效答案。
	示例 2：
	
	输入: "cbbd"
	输出: "bb"
	 */
	public static String longestPalindrome(String s){
		if(s==null || s.length()<=1) return s;
		int start = 0;
		int end = 0;
		for(int i=0; i<s.length();i++){
			int len1 = palindrome(s,i,i);
			int len2 = palindrome(s,i,i+1);
			int max = Math.max(len1, len2);
			if(max > end-start){
				start = i - (max-1)/2;
				end = i + max/2;
			}
		}
		return s.substring(start,end+1);
	}
	public static int palindrome(String s, int left, int right){
		while(left>=0 && right<s.length() && s.charAt(left) == s.charAt(right)){
			left--;
			right++;
		}
		return right-left-1;
	}
	
	public static void main(String[] args) {
		System.out.println(longestPalindrome("babab"));
	}
}
