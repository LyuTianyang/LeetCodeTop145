package q0412;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FizzBuzz {
	/**
	 * 写一个程序，输出从 1 到 n 数字的字符串表示。
	 * 
	 * 1. 如果 n 是3的倍数，输出“Fizz”；
	 * 
	 * 2. 如果 n 是5的倍数，输出“Buzz”；
	 * 
	 * 3.如果 n 同时是3和5的倍数，输出 “FizzBuzz”。
	 * 
	 * 示例：
	 * 
	 * n = 15,
	 * 
	 * 返回: [ "1", "2", "Fizz", "4", "Buzz", "Fizz", "7", "8", "Fizz", "Buzz",
	 * "11", "Fizz", "13", "14", "FizzBuzz" ]
	 */
	public static List<String> fizzBuzz1(int n) {
		List<String> ans = new ArrayList<String>();
		if (n < 1) return ans;
		for (int i = 1; i <= n; i++) {
			boolean divs3 = (i % 3 == 0);
			boolean divs5 = (i % 5 == 0);
			if (divs3 && divs5) {
				ans.add("FizzBuzz");
			} else if (divs3) {
				ans.add("Fizz");
			} else if (divs3) {
				ans.add("Buzz");
			} else {
				ans.add(Integer.toString(i));
			}
		}
		return ans;
	}
	public static List<String> fizzBuzz2(int n) {
		List<String> ans = new ArrayList<String>();
		if (n < 1) return ans;
		HashMap<Integer, String> map = new HashMap<Integer, String>();
		map.put(3, "Fizz");
		map.put(5, "Buzz");
		for (int num = 1; num <= n; num++) {
			String numAnsStr = "";
			//divs by 3 or 5
			for (Integer key : map.keySet()) {
				if (num % key == 0) {
					numAnsStr += map.get(key);
				}
			}
			if (numAnsStr.equals("")) {
				numAnsStr += Integer.toString(num);
			}
			ans.add(numAnsStr);
		}
		return ans;
	}
	
	public static void main(String[] args) {
		List<String> ans = fizzBuzz2(15);
		System.out.println(ans);
	}
}
