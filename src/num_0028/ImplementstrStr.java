package num_0028;

public class ImplementstrStr {
	/**
	 实现 strStr() 函数。

	给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。
	
	示例 1:
	
	输入: haystack = "hello", needle = "ll"
	输出: 2
	示例 2:
	
	输入: haystack = "aaaaa", needle = "bba"
	输出: -1
	 */
	public static int strStr(String haystack, String needle) {
		if(needle == null || needle.equals("") || haystack.equals(needle)){
			return 0;
		}
		if(haystack == null || haystack.equals("") || !haystack.contains(needle)){
			return -1;
		}
		int n1 = haystack.length();
        int n2 = needle.length();
        for (int i = 0; i < n1 - n2 + 1; i++ ){
            if (haystack.substring(i, i+n2).equals(needle)) return i;
        }
        return -1;
    }
	
	public static void main(String[] args) {
		int result = strStr("mississippi","issip");
		System.out.println(result);
	}
}
