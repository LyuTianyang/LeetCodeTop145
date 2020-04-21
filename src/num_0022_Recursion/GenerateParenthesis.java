package num_0022_Recursion;

import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis {
	/**
	Q0022_recursion 给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。
	例如，给出 n = 3，生成结果为：
	[
	  "((()))",
	  "(()())",
	  "(())()",
	  "()(())",
	  "()()()"
	]
	 */
	public static List<String> generateParenthesis(int n){
		List<String> res =  new ArrayList<String>();
		if(n<=0) return res;
		int left=0;
		int right=0;
		String curr = "";
		helper(curr, res, n, left, right);
		return res;
	}
	
	//n:总括号数，left:正括号数，right:反括号数
	public static void helper(String curr, List<String> res, int n, int left, int right){
		//跳出递归的条件
		if(right == n){
			res.add(curr);
			return;
		}
		if(left < n){
			helper(curr+"(", res, n, left+1, right);
		}
		if(right < left){
			helper(curr+")", res, n, left, right+1);
		}
	}
	
	public static void main(String[] args) {
		List<String> res = generateParenthesis(3);
		System.out.println(res);
	}
}
