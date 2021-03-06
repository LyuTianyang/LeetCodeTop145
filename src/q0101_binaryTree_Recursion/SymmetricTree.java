package q0101_binaryTree_Recursion;

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) {
		val = x; 
	}
}

public class SymmetricTree {
	/**
	给定一个二叉树，检查它是否是镜像对称的。

	例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
	
	    1
	   / \
	  2   2
	 / \ / \
	3  4 4  3
	但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
	
	    1
	   / \
	  2   2
	   \   \
	   3    3
	 */
	public boolean isSymmetric(TreeNode root) {
		if(root == null) return true;
		return helper(root, root);
    }

	private boolean helper(TreeNode t1, TreeNode t2) {
		if (t1 == null && t2 == null) return true;
		if(t1 == null && t2 != null) return false;
		if(t1 != null && t2 == null) return false;
	    return (t1.val == t2.val) && helper(t1.left,t2.right) && helper(t1.right, t2.left);
	}
}
