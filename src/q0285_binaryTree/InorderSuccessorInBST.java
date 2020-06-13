package q0285_binaryTree;
class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) {
		val = x; 
	}
}
public class InorderSuccessorInBST {
	/**
	二叉搜索树中的顺序后继
	
	Given a binary search tree and a node in it, find the in-order successor of that node in the BST.

	Note: If the given node has no in-order successor in the tree, return null.
	
	Example 1:
	Input: root = [2,1,3], p = 1
	
	  2
	 / \
	1   3
	
	Output: 2
	
	
	Example 2:
	Input: root = [5,3,6,2,4,null,null,1], p = 6
	
	      5
	     / \
	    3   6
	   / \
	  2   4
	 /   
	1
	
	Output: null
	 */
	public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        //successor must be larger then the node itself, so:
        //if p is in root.left, root can be the successor, null cannot be
        //if p is in root.right, root can not be the successor, null can be
        if (root == null) return null;
        if (root.val <= p.val) {
            return inorderSuccessor(root.right, p);
        } else {
            TreeNode leftRes = inorderSuccessor(root.left, p);
            if (leftRes == null) return root;
            return leftRes;
        }
    }
}
