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
	public int firstUniqChar(String s) {
		if(s == null || s.length() == 0) return -1;
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		int n = s.length();
		// build hash map : character and how often it appears
		for(int i=0; i<n; i++){
			char c = s.charAt(i);
			map.put(c, map.getOrDefault(c, 0)+1);
		}
		// find the index
		for(int i=0; i<n; i++){
			if(map.get(s.charAt(i))==1){
				return i;
			}
		}
		return -1;
    }
}
