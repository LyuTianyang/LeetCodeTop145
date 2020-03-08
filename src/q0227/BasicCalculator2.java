package q0227;

import java.util.Stack;

public class BasicCalculator2 {
	/**
	实现一个基本的计算器来计算一个简单的字符串表达式的值。

	字符串表达式仅包含非负整数，+， - ，*，/ 四种运算符和空格  。 整数除法仅保留整数部分。
	
	示例 1:
	
	输入: "3+2*2"
	输出: 7
	示例 2:
	
	输入: " 3/2 "
	输出: 1
	示例 3:
	
	输入: " 3+5 / 2 "
	输出: 5
	 */
	public static int calculate(String s) {
		if(s == null || s.length() == 0) return 0;
		Stack<Integer> stack = new Stack<Integer>();
		int res = 0;
		char sign = '+';
		int num = 0;
		for(int i=0; i<s.length(); i++){
			if(Character.isDigit(s.charAt(i))){
				num = s.charAt(i) - '0';
				while(i+1<s.length() && Character.isDigit(s.charAt(i+1))){
					num = num*10 + s.charAt(i+1)-'0';
					i++;
				}
			}
			if(!Character.isDigit(s.charAt(i)) && s.charAt(i) != ' ' || i == s.length()-1){
				if(sign == '+') stack.push(num);
				if(sign == '-') stack.push(-num);
				if(sign == '*') stack.push(stack.pop()*num);
				if(sign == '/') stack.push(stack.pop()/num);
				sign = s.charAt(i);
				num = 0;
			}
		}
		for(int i : stack){
			res += i;
		}
		return res;
    }
	
	public static void main(String[] args) {
		String s = " 3+5 / 2";
		int res = calculate(s);
		System.out.println(res);
	}
}
