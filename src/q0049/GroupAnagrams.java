package q0049;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams {
	/**
	Q0049 给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
	
	输入: ["eat", "tea", "tan", "ate", "nat", "bat"],
	输出:
	[
	  ["ate","eat","tea"],
	  ["nat","tan"],
	  ["bat"]
	]
	 */
	public static List<List<String>> groupAnagrams(String[] strs) {
		List<List<String>> results = new ArrayList<List<String>>();
		if(strs == null || strs.length == 0) return results;
		Map<String, List<String>> map = new HashMap<String, List<String>>();
		for(int i=0; i<strs.length; i++){
			char[] curr = strs[i].toCharArray();
			Arrays.sort(curr);
			String key = String.valueOf(curr);
			if(!map.containsKey(key)){
				map.put(key, new ArrayList<String>());
			}
			map.get(key).add(strs[i]);
		}
		return new ArrayList<List<String>>(map.values());
	}
	public static void main(String[] args) {
		String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
		List<List<String>> results = groupAnagrams(strs);
		System.out.println(results);
	}
}
