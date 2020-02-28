package q0103_binaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) {
		val = x; 
	}
}
public class BinaryTreeZigzagLevelOrderTraversal {
	/**
	给定一个二叉树，返回其节点值的锯齿形层次遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。

	例如：
	给定二叉树 [3,9,20,null,null,15,7],
	
	    3
	   / \
	  9  20
	    /  \
	   15   7
	返回锯齿形层次遍历如下：
	
	[
	  [3],
	  [20,9],
	  [15,7]
	]
	 */
	static List<List<Integer>> res = new ArrayList<List<Integer>>();
	
	public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		if(root == null) return res;
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.offer(root);
		int level = 0;
		while(!queue.isEmpty()){
			int size = queue.size();
			for(int i=0; i<size; i++){
				TreeNode node = queue.poll();
				insert(node, level);
				if(node.left != null) queue.offer(node.left);
				if(node.right != null) queue.offer(node.right);
			}
			level++;
		}
		return res;
    }
	
	private static void insert(TreeNode node, int level) {
		List<Integer> list = new ArrayList<Integer>();
        if(level < res.size()){
        	list = res.get(level);
        }else{
        	list = null;
        }
        if (list == null) {
            list = new ArrayList<Integer>();
            list.add(node.val);
            res.add(list);
        } else {
            boolean isOdd = false;
            if(level % 2 == 1) isOdd = true;
            list.add(isOdd ? 0 : list.size(), node.val);
        }
    }
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(9);
		root.right = new TreeNode(20);
		root.right.left = new TreeNode(15);
		root.right.right = new TreeNode(7);
		List<List<Integer>> res = zigzagLevelOrder(root);
		System.out.println(res);
	}
}
