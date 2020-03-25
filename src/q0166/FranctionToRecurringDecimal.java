package q0166;

import java.util.HashMap;
import java.util.Map;

public class FranctionToRecurringDecimal {
	/**
	给定两个整数，分别表示分数的分子 numerator 和分母 denominator，以字符串形式返回小数。

	如果小数部分为循环小数，则将循环的部分括在括号内。
	
	示例 1:
	
	输入: numerator = 1, denominator = 2
	输出: "0.5"
	示例 2:
	
	输入: numerator = 2, denominator = 1
	输出: "2"
	示例 3:
	
	输入: numerator = 2, denominator = 3
	输出: "0.(6)"
	
	1.正负号
	2.整数
	3.小数->循环
	
	 */
	public static String fractionToDecimal(int numerator, int denominator) {
		if(numerator == 0 || denominator == 0) return "0";
		StringBuilder res = new StringBuilder();
		if(numerator<0 ^ denominator<0){
			res.append("-");
		}
		long num = Math.abs((long)numerator);
		long den = Math.abs((long)denominator);
		res.append(num/den);
		long remain = num%den;
		if(remain == 0){
			return res.toString();
		}
		res.append(".");
		Map<Long, Integer> map = new HashMap<Long, Integer>();
		while(remain != 0){
			if(map.containsKey(remain)){
				res.insert(map.get(remain), "(");
				res.append(")");
				break;
			}
			map.put(remain, res.length());
			remain *= 10;
			res.append(remain/den);
			remain %= den;
		}
		return res.toString();
    }
	public static String fractionToDecimal1(int numerator, int denominator) {
		if(numerator==0 || denominator==0) return "0";
		StringBuilder res = new StringBuilder();
		if(numerator<0 ^ denominator<0) res.append("-");
		long num = (long)Math.abs(numerator);
		long den = (long)Math.abs(denominator);
		res.append(num/den);
		long remain = num%den;
		if(remain == 0) return res.toString();
		res.append(".");
		Map<Long, Integer> map = new HashMap<Long, Integer>();
		while(remain>0){
			if(map.containsKey(remain)){
				res.insert(map.get(remain),"(");
				res.append(")");
				return res.toString();
			}
			map.put(remain, res.length());
			remain = remain*10;
			res.append(remain/den);
			remain = remain%den;
		}
		return res.toString();
	}
	public static void main(String[] args) {
		String res = fractionToDecimal1(5,3);
		System.out.println(res);
	}
}
