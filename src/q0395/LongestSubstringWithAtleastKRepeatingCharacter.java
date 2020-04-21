package q0395;

public class LongestSubstringWithAtleastKRepeatingCharacter {
	/**
	找到给定字符串（由小写字符组成）中的最长子串 T ， 要求 T 中的每一字符出现次数都不少于 k 。输出 T 的长度。

	示例 1:
	
	输入:
	s = "aaabb", k = 3
	
	输出:
	3
	
	最长子串为 "aaa" ，其中 'a' 重复了 3 次。
	示例 2:
	
	输入:
	s = "ababbc", k = 2
	
	输出:
	5
	
	最长子串为 "ababb" ，其中 'a' 重复了 2 次， 'b' 重复了 3 次。
	 */
	public static int longestSubstring(String s, int k) {
		if(s == null || s.length() == 0 || k > s.length()) return 0;
		int len = s.length();
		if(k<=1) return len;
		return count(s, k, 0, len-1);
    }
	public static int count(String s, int k, int left, int right){
		if(right-left+1<k) return 0;
		int[] times = new int[26];
		for(int i=left; i<=right; i++){
			times[s.charAt(i)-'a']++;
		}
		if(right-left+1>=k && times[s.charAt(left)-'a']<k){
			left++;
		}
		if(right-left+1>=k && times[s.charAt(right)-'a']<k){
			right--;
		}
		if(right-left+1<k) return 0;
		for(int i=left; i<=right; i++){
			if(times[s.charAt(i)-'a']<k){
				return Math.max(count(s, k, left, i-1), count(s, k, i+1, right));
			}
		}
		return right-left+1;
	}
	
	
	public static void main(String[] args) {
		String s = "aaabbc";
		int res = longestSubstring(s,3);
		System.out.println(res);
	}
}
