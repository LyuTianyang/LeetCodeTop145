package num_0002_ListNode;

class ListNode{
    int val;
    ListNode next;
    ListNode(int x){
    	val=x;
    }
}

public class AddTwoNumbers_002 {
	/**
	 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
	如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
	您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
	
	   Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
	   Output: 7 -> 0 -> 8
	   Explanation: 342 + 465 = 807.
	 */
	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		if(l1 == null) return l2;
		if(l2 == null) return l1;
		ListNode dummy = new ListNode(0);
		ListNode curr = dummy;
		int carry = 0;
		while(l1 != null && l2 != null){
			int tmp = l1.val + l2.val + carry;
			int value = tmp%10;
			carry = tmp/10;
			ListNode newNode = new ListNode(value);
			curr.next = newNode;
			curr = curr.next;
			l1 = l1.next;
			l2 = l2.next;
		}
		while(l1 != null){
			int tmp = l1.val + carry;
			int value = tmp%10;
			carry = tmp/10;
			ListNode newNode = new ListNode(value);
			curr.next = newNode;
			curr = curr.next;
			l1 = l1.next;
		}
		while(l2 != null){
			int tmp = l2.val + carry;
			int value = tmp%10;
			carry = tmp/10;
			ListNode newNode = new ListNode(value);
			curr.next = newNode;
			curr = curr.next;
			l2 = l2.next;
		}
		if(carry > 0){
			curr.next = new ListNode(carry);
		}
		
		return dummy.next;
	}
	
	public static void main(String[] args) {
		ListNode l1 = new ListNode(1);
		l1.next = new ListNode(2);
		l1.next.next = new ListNode(5);
		
		ListNode l2 = new ListNode(3);
		l2.next = new ListNode(4);
		l2.next.next = new ListNode(6);
		l2.next.next.next= new ListNode(7);
		
		ListNode result = addTwoNumbers(l1,l2);
		System.out.println(result.val);
	}
	
}
