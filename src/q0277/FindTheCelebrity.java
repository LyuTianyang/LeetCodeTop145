package q0277;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Relation{
	boolean knows(int a, int b){
		return false;
	}
}
/* The knows API is defined in the parent class Relation.
      boolean knows(int a, int b); */
public class FindTheCelebrity extends Relation{
	/**
	Suppose you are at a party with n people (labeled from 0 to n - 1) and among them, there may exist one celebrity. The definition of a celebrity is that all the other n - 1 people know him/her but he/she does not know any of them.

	Now you want to find out who the celebrity is or verify that there is not one. The only thing you are allowed to do is to ask questions like: "Hi, A. Do you know B?" to get information of whether A knows B. You need to find out the celebrity (or verify there is not one) by asking as few questions as possible (in the asymptotic sense).
	
	You are given a helper function bool knows(a, b) which tells you whether A knows B. Implement a function int findCelebrity(n), your function should minimize the number of calls to knows.
	
	Note: There will be exactly one celebrity if he/she is in the party. Return the celebrity's label if there is a celebrity in the party. If there is no celebrity, return -1.
	
	题目标签：Array
	
	　　题目给了我们一个n， 代表 有n个人，从0 到n-1。其中可能会有一个明星，或者没有明星，让我们通过，问每个人问题的方式，找到谁是明星或者没人是明星。问题的方式是：问A，你认识B吗？ 可以得到是 或者 不是的回答。明星的定义是：明星不认识任何人，但是所有人都要认识明星。
	
	　　我们可以利用遍历n两次来找出谁是明星：
	
	　　第一次遍历：假设第一个人是明星；所有人站一排0 到 n-1。
	
	　　　　　　　　依次问每一个人X，你认识下一个人吗？
	
	　　　　　　　　　　如果认识： 假设下一个人是明星；
	
	　　　　　　　　　　如果不认识：假设不变，X依然是。
	
	　　如果有明星再这一排人里的话，当问到明星前面一个人的时候，肯定会把明星设为假设，而之后问明星 认不认识 之后的所有人的时候，得到的肯定是 否定的回答，所以假设会留在明星这里。
	
	　　第二次遍历：因为不一定有明星，所以还要遍历一次来确定假设的是不是明星。
	
	　　　　　　　　依次问每一个人X（除了假设的明星之外）， X认识假设的明星吗 还要问 假设的明星 认识X吗？
	
	　　　　　　　　　　如果不是真的明星，他/她 不会被所有人认识 或者 他/她 会认识一些人。
	 */
	public int findCelebrity1(int n){
		int res = 0;
		for(int i=1; i<=n; i++){
			if(knows(res, 1)){
				res = i;
			}
		}
		for(int i=0; i<n; i++){
			if(i==res){
				continue;
			}
			if(!knows(i, res) || knows(res, i)){
				return -1;
			}
		}
		return res;
	}
	public int findCelebrity2(int n) {
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < n-1; i++) {
            for (int j = i+1; j < n; j++) {
                if (knows(i, j)) {
                    map.put(j, map.getOrDefault(j, 0)+1);
                }
                if (knows(j, i)) {
                    map.put(i, map.getOrDefault(i, 0)+1);
                }
                if (map.containsKey(i) && map.get(i) == n-1) res.add(i);
                if (map.containsKey(j) && map.get(j) == n-1) res.add(j);
            }
        }
        if (res.size() == 0 || res.size() > 1) return -1;
        return res.get(0);
    }
}
