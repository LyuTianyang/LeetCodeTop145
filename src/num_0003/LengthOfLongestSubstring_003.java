package num_0003;

import java.util.HashSet;
import java.util.Set;

public class LengthOfLongestSubstring_003 {
	/**
	 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。 acbdbe
	 */
	public static int lengthOfLongestSubstring1(String s){
		if(s == null || s.length() == 0) return 0;
		boolean[] used = new boolean[128];
		int left = 0;
		int right = 0;
		int n = s.length();
		int max = 0;
		while(right < n){
			if(used[s.charAt(right)] == false){
				used[s.charAt(right)] = true;
				right++;
			}else{
				max = Math.max(max, right-left);
				while( left<right && s.charAt(right)!=s.charAt(left)){
					used[s.charAt(left)] = false;
					left++;
				}
				left++;
				right++;
			}
		}
		max = Math.max(max, right-left);
		return max;
	}
	public static void main(String[] args){
		System.out.println(lengthOfLongestSubstring1("abcdbe"));
		
	}
	
	/*
	 * 暴力法，效率差
	 */
	public static int lengthOfLongestSubstring2(String s) {
        int n = s.length();
        int ans = 0;
        for (int i = 0; i < n; i++)
            for (int j = i + 1; j <= n; j++)
                if (allUnique(s, i, j)) ans = Math.max(ans, j - i);
        return ans;
    }

    public static boolean allUnique(String s, int start, int end) {
        Set<Character> set = new HashSet<Character>();
        for (int i = start; i < end; i++) {
            Character ch = s.charAt(i);
            if (set.contains(ch)) return false;
            set.add(ch);
        }
        return true;
    }
}
