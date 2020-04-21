package num_0021_ListNode;

class ListNode{
    int val;
    ListNode next;
    ListNode(int x){
    	val=x;
    }
}

public class MergeTwoSortedList {
	
	/**
	 * 给出两个排好序的listNode,合成一个排好序的listNode
	 * 1-2-5
	 * 3-4-6-7
	 * 
	 */
	public static ListNode mergeTwoSortedList(ListNode l1, ListNode l2){
		if(l1 == null) return l2;
		if(l2 == null) return l1;
		ListNode dummy = new ListNode(0);
		ListNode curr = dummy;
		while(l1 != null && l2 != null){
			if(l1.val <= l2.val){
				//curr.next = l1; 这样也可以
				curr.next = new ListNode(l1.val);
				l1 = l1.next;
			}else{
				curr.next = new ListNode(l2.val);
				l2 = l2.next;
			}
			curr = curr.next;
		}
		if(l1 != null) curr.next = l1;
		if(l2 != null) curr.next = l2;
		return dummy.next;
	}
	public static void main(String[] args) {
		ListNode l1 = new ListNode(1);
		l1.next = new ListNode(2);
		l1.next.next = new ListNode(5);
		
		ListNode l2 = new ListNode(3);
		l2.next = new ListNode(5);
		l2.next.next = new ListNode(6);
		l2.next.next.next= new ListNode(7);
		
		ListNode result = mergeTwoSortedList(l1, l2);
		System.out.println(result);
	}
	
}
