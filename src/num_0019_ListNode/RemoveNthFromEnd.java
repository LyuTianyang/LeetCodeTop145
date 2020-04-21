package num_0019_ListNode;

class ListNode{
    int val;
    ListNode next;
    ListNode(int x){
    	val=x;
    }
}

public class RemoveNthFromEnd {
	/**
	 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
	示例：
	
	给定一个链表: 1->2->3->4->5, 和 n = 2.
	
	当删除了倒数第二个节点后，链表变为 1->2->3->5.
	说明：
	
	给定的 n 保证是有效的。
	 */
	/*
	 * 定义指针fast, slow 。fast先移动n, 再和slow一起移动, 直道fast移动到最后一个节点,即fast.next = null
	 */
	public static ListNode removeNthFromEnd(ListNode head, int n){
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode fast = dummy;
		ListNode slow = dummy;
		for(int i=0;i<n;i++){
			fast = fast.next;
		}
		while(fast.next != null){
			fast = fast.next;
			slow = slow.next;
		}
		slow.next = slow.next.next;
		return dummy.next;
	}
	
	public static ListNode removeNthFromEnd1(ListNode head, int n){
		ListNode fast = head;
		ListNode slow = head;
		for(int i=0; i<n; i++){
			if(fast.next != null){
				fast = fast.next;
			}
		}
		while(fast.next != null){
			fast = fast.next;
			slow = slow.next;
		}
		slow.next = slow.next.next;
		return head;
	}
	
	
	public static void main(String[] args) {
		ListNode result = new ListNode(1);
		result.next = new ListNode(2);
		result.next.next = new ListNode(3);
		result.next.next.next= new ListNode(4);
		result.next.next.next.next= new ListNode(5);
		ListNode result1 = removeNthFromEnd1(result, 2);
		System.out.println(result1);
		
		
	}
}
