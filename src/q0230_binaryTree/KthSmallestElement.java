package q0230_binaryTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) {
		val = x; 
	}
}
public class KthSmallestElement {
	/**
	给定一个二叉搜索树，编写一个函数 kthSmallest 来查找其中第 k 个最小的元素。

	说明：
	你可以假设 k 总是有效的，1 ≤ k ≤ 二叉搜索树元素个数。
	
	示例 1:
	
	输入: root = [3,1,4,null,2], k = 1
	   3
	  / \
	 1   4
	  \
	   2
	输出: 1
	示例 2:
	
	输入: root = [5,3,6,2,4,null,null,1], k = 3
	       5
	      / \
	     3   6
	    / \
	   2   4
	  /
	 1
	输出: 3
	 */
	public static int kthSmallest1(TreeNode root, int k) {
		Stack<TreeNode> stack = new Stack<TreeNode>();
		while(true){
			while(root != null){
				stack.push(root);
				root = root.left;
			}
			root = stack.pop();
			if(--k == 0) return root.val;
			root = root.right;
		}
    }
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(3);
		root.right = new TreeNode(6);
		root.left.left = new TreeNode(2);
		root.left.right = new TreeNode(4);
		root.left.left.left = new TreeNode(1);
		int res = kthSmallest1(root,3);
		System.out.println(res);
	}
	
	public static int kthSmallest2(TreeNode root, int k) {
	   List<Integer> nums = inorder(root, new ArrayList<Integer>());
	   return nums.get(k - 1);
	}
	
	public static List<Integer> inorder(TreeNode root, List<Integer> arr) {
	   if (root == null) return arr;
	   inorder(root.left, arr);
	   arr.add(root.val);
	   inorder(root.right, arr);
	   return arr;
	}
}
