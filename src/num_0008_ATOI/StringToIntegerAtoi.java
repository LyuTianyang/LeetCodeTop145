package num_0008_ATOI;

public class StringToIntegerAtoi {
	/**
	 示例 1:
	输入: "42"
	输出: 42
	示例 2:
	
	输入: "   -42"
	输出: -42
	解释: 第一个非空白字符为 '-', 它是一个负号。
	     我们尽可能将负号与后面所有连续出现的数字组合起来，最后得到 -42 。
	示例 3:
	
	输入: "4193 with words"
	输出: 4193
	解释: 转换截止于数字 '3' ，因为它的下一个字符不为数字。
	示例 4:
	
	输入: "words and 987"
	输出: 0
	解释: 第一个非空字符是 'w', 但它不是数字或正、负号。
	     因此无法执行有效的转换。
	示例 5:
	
	输入: "-91283472332"
	输出: -2147483648
	解释: 数字 "-91283472332" 超过 32 位有符号整数范围。 
	     因此返回 INT_MIN (−231) 。
	 */
	public static int myAtoi(String str) {
		if(str == null) return 0;
		str = str.trim();
		if(str.length() == 0) return 0;
		int sign = 1;//正负号
		int index = 0;
		if(str.charAt(0) == '-'){
			sign = -1;
			index++;
		}else if(str.charAt(0) == '+'){
			index++;
		}
        long res = 0;
        for(int i=index; i<str.length();i++){
        	if(!Character.isDigit(str.charAt(i))){
        		return (int) res * sign;
        	}
        	res = res * 10 + str.charAt(i) - '0';
        	if (sign == 1 && res > Integer.MAX_VALUE)
                return Integer.MAX_VALUE;
            if (sign == -1 && res > Integer.MAX_VALUE)
                return Integer.MIN_VALUE;

        }
        return (int) res*sign;
    }
	public static int myAtoi1(String str) {
		if(str == null) return 0;
		str = str.trim();
		if(str.length()==0) return 0;
		int sign = 1;
		int index = 0;
		if(str.charAt(index) == '-'){
			sign = (-1)*sign;
			index++;
		}else if(str.charAt(index) == '+'){
			index++;
		}
		long res = 0;
		while(index<str.length()){
			if(!Character.isDigit(str.charAt(index))){
				return (int)res*sign;
			}
			res = res*10 + (str.charAt(index)-'0');
			if(sign==1 && res>=Integer.MAX_VALUE){
				return Integer.MAX_VALUE;
			}else if(sign == -1 && res>=Integer.MAX_VALUE){
				return Integer.MIN_VALUE;
			}
		}
		return (int)res*sign;
	}
	public static void main(String[] args) {
		int result = myAtoi("-2147483647");
		System.out.println(result);
	}
	/*
	 此题解用到了64位环境变量，面试官如果未要求环境变量，这种题解是一种不错的解法，可以借鉴来看一下。
	1.首先去除字符串左右空格,不符合条件的直接return 0;
	2.sign是符号位,start指针指向第一个数字的位置,如果第一位为数字,则sign=1,start=0,否则firstChar接收字符串第一个字符,若为“+”、“-”,sign分别赋值1、-1,start自增1,
	3.从字符串第一个为数字的位置开始遍历,res为无符号结果,如果res大于Integer最大值且sign=1,输出Integer的最大值,反之输出Integer最小值,如果遍历到不为数字的字符,则直接返回res*sign;
	4.如果遍历时该字符串未超范围,且无非数字字符,则返回res * sign;
	5.完结。
	 */
}
