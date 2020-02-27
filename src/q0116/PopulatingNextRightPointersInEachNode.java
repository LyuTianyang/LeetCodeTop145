package q0116;

public class PopulatingNextRightPointersInEachNode {
	/**
	给定一个完美二叉树，其所有叶子节点都在同一层，每个父节点都有两个子节点。二叉树定义如下：

	struct Node {
	  int val;
	  Node *left;
	  Node *right;
	  Node *next;
	}
	填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL。
	
	初始状态下，所有 next 指针都被设置为 NULL。
			   1
		      / \
		    2     3
		   / \   / \
		  4   5 6   7
			   1
		      / \
		    2  ->  3
		   / \    / \
		  4 ->5->6-> 7
	 */
	public Node connect(Node root) {
        if(root == null) return root;
        //link 2-3
        if(root.left != null){
        	root.left.next = root.right;
        }
        //link 5-6
        if(root.next != null && root.right != null){
        	root.right.next = root.next.left;
        }
        connect(root.left);
        connect(root.right);
        return root;
    }
}
