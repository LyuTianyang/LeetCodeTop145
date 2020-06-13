package q0038_countAndSay;

public class CountAndSay {
	/**
	 报数序列是一个整数序列，按照其中的整数的顺序进行报数，得到下一个数。其前五项如下：
	    1.     1
		2.     11
		3.     21
		4.     1211
		5.     111221
		1 被读作  "one 1"  ("一个一") , 即 11。
		11 被读作 "two 1s" ("两个一"）, 即 21。
		21 被读作 "one 2",  "one 1" （"一个二" ,  "一个一") , 即 1211。
		
		给定一个正整数 n（1 ≤ n ≤ 30），输出报数序列的第 n 项。
		
		注意：整数顺序将表示为一个字符串。
	 */
	public static String countAndSay(int n) {
        if(n<=0) return "";
        String str = "1";
        if(n==1) return str;
        for(int i=1; i<n; i++){
        	int count = 0;
        	char prev = '.';
        	StringBuilder sb = new StringBuilder();
        	for(int idx=0;idx<str.length();idx++){
        		//如果prev等于'.' 或者str的当前字符等于prev，pre+1
        		if(str.charAt(idx)==prev || prev=='.'){
        			count++;
        		}else{//当前字符和之前字符不一样
        			sb.append(count+String.valueOf(prev));
        			count = 1;
        		}
        		//prev永远等于当前的字符
        		prev = str.charAt(idx);
        	}
        	//把字符串的最后一组加上，比如 12311，把11加上
        	sb.append(count+String.valueOf(prev));
        	str = sb.toString();
        }
        return str;
    }
	
	public static void main(String[] args) {
		String result = countAndSay(7);
		System.out.println(result);
	}
}
