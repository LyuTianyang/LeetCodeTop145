package q0387;

import java.util.HashMap;

public class FirstUniqueChar {
	/**
	给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。

	案例:
	
	s = "leetcode"
	返回 0.
	
	s = "loveleetcode",
	返回 2.
	 */
	public static int firstUniqChar(String s) {
		if(s == null || s.length() == 0) return -1;
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		int n = s.length();
		for(int i=0; i<n; i++){
			map.put(s.charAt(i), map.getOrDefault(s.charAt(i),0)+1);
		}
		for(int i=0; i<n; i++){
			if(map.get(s.charAt(i)) == 1){
				return i;
			}
		}
		return -1;
	}
	
	public static void main(String[] args) {
		int res = firstUniqChar("loveleetcode");
		System.out.println(res);
	}
}
