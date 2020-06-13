package q0204;

import java.util.ArrayList;
import java.util.List;

public class CountPrimes {
	/**
	统计所有小于非负整数 n 的质数的数量。

	示例:
	
	输入: 10
	输出: 4
	解释: 小于 10 的质数一共有 4 个, 它们是 2, 3, 5, 7 。
	 */
	public static int countPrimes(int n){
		if(n<=1) return 0;
		boolean[] notPrime = new boolean[n];
		List<Integer> list = new ArrayList<>();
		int res = 0;
		for(int i=2; i<n; i++){
			if(notPrime[i] == false){
				list.add(i);
				res++;
				for(int j=2; i*j<n; j++){
					notPrime[i*j] = true;
				}
			}
		}
		System.out.println(list);
		return res;
    }
	public static void main(String[] args) {
		int res = countPrimes(10);
		System.out.println(res);
	}
}
