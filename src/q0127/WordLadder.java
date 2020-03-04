package q0127;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class WordLadder {
	/**
	给定两个单词（beginWord 和 endWord）和一个字典，找到从 beginWord 到 endWord 的最短转换序列的长度。转换需遵循如下规则：

	每次转换只能改变一个字母。
	转换过程中的中间单词必须是字典中的单词。
	说明:
	
	如果不存在这样的转换序列，返回 0。
	所有单词具有相同的长度。
	所有单词只由小写字母组成。
	字典中不存在重复的单词。
	你可以假设 beginWord 和 endWord 是非空的，且二者不相同。
	示例 1:
	
	输入:
	beginWord = "hit",
	endWord = "cog",
	wordList = ["hot","dot","dog","lot","log","cog"]
	
	输出: 5
	
	解释: 一个最短转换序列是 "hit" -> "hot" -> "dot" -> "dog" -> "cog",
	     返回它的长度 5。
	示例 2:
	
	输入:
	beginWord = "hit"
	endWord = "cog"
	wordList = ["hot","dot","dog","lot","log"]
	
	输出: 0
	
	解释: endWord "cog" 不在字典中，所以无法进行转换
	 */
	public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
		HashSet<String> set = new HashSet<String>(wordList);
		if(set.contains(beginWord)){
			set.remove(beginWord);
		}
		Queue<String> queue = new LinkedList<String>();
		int level = 1;
		int curNum = 1;
		int nextNum = 0;
		queue.offer(beginWord);
		while(!queue.isEmpty()){
			String word = queue.poll();
			curNum--;
			//遍历单词中的每个字母
			for(int i=0; i<word.length(); i++){
				char[] wordUnit = word.toCharArray();
				//遍历26个字母
				for(char j='a'; j<='z'; j++){
					wordUnit[i] = j;
					String temp = new String(wordUnit);
					if(set.contains(temp)){
						if(temp.equals(endWord)){
							return level+1;
						}
						nextNum++;
						queue.offer(temp);
						set.remove(temp);
					}
				}
			}
			if(curNum == 0){
				curNum = nextNum;
				nextNum = 0;
				level++;
			}
		}
		return 0;
    }
	
	public static void main(String[] args) {
		String beginWord = "hit";
		String endWord = "cog";
		List<String> wordList = new ArrayList<String>();
		wordList.add("hot");
		wordList.add("dot");
		wordList.add("dog");
		wordList.add("lot");
		wordList.add("log");
		wordList.add("cog");
		int res = ladderLength(beginWord, endWord, wordList);
		System.out.println(res);
	}
}
