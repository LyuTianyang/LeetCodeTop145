package q0131;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {
	/**
	给定一个字符串 s，将 s 分割成一些子串，使每个子串都是回文串。

	返回 s 所有可能的分割方案。
	
	示例:
	
	输入: "aab"
	输出:
	[
	  ["aa","b"],
	  ["a","a","b"]
	]
	 */
	public static List<List<String>> partition(String s) {
		List<List<String>> res = new ArrayList<List<String>>();
		if(s == null || s.length() == 0) return res;
		int len = s.length();
		int start = 0;
		List<String> list = new ArrayList<String>();
		helper(s, start, len, list, res);
		return res;
    }
	public static void helper(String s, int start, int len, List<String> list, List<List<String>> res){
		if(start == len){
			res.add(new ArrayList<String>(list));
			return;
		}
		for(int i=start; i<len; i++){
			if(!isPalindrome(s, start, i)) continue;
			list.add(s.substring(start, i+1));
			helper(s, i+1, len, list, res);
			list.remove(list.size()-1);
		}
	}
	public static boolean isPalindrome(String s, int left, int right){
		while(left<right){
			if(s.charAt(left) != s.charAt(right)){
				return false;
			}
			left++;
			right--;
		}
		return true;
	}
	
	public static void main(String[] args) {
		String s = "abcbaz";
		List<List<String>> res = partition(s);
		System.out.println(res);
	}
}
