package num_0014;

public class LongestCommonPrefix {
	/**
	编写一个函数来查找字符串数组中的最长公共前缀。

	如果不存在公共前缀，返回空字符串 ""。
	
	示例 1:
	
	输入: ["flower","flow","flight"]
	输出: "fl"
	示例 2:
	
	输入: ["dog","racecar","car"]
	输出: ""
	解释: 输入不存在公共前缀。
	 */
	public static String longestCommonPrefix(String[] strs) {
        if(strs == null || strs.length == 0) return "";
        for(int i=0; i<strs[0].length() ; i++){
        	char c = strs[0].charAt(i);
        	for(int j=1 ; j<strs.length; j++){
        		if(i== strs[j].length() || strs[j].charAt(i) !=c){
        			return strs[0].substring(0,i);
        		}
        	}
        }
        return strs[0];
    }
	
	public static String longestCommonPrefix1(String[] strs) {
		if(strs == null || strs.length == 0) return "";
		if(strs.length == 1) return strs[0];
		int count = 0;
		for(int i=0; i<strs[0].length(); i++){
			char c = strs[0].charAt(i);
			for(int j=1; j<strs.length; j++){
				count = i;
				if(i== strs[j].length() || strs[j].charAt(i) !=c) break;
			}
		}
		return strs[0].substring(0, count+1);
	}
	
	
	public static void main(String[] args) {
		String[] strs = {"flowwwer","floww","flowwight"};
		String result = longestCommonPrefix(strs);
		System.out.println(result);
	}
}
