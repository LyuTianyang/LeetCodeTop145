package num_0023_hard_ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;

class ListNode{
    int val;
    ListNode next;
    ListNode(int x){
    	val=x;
    }
}

class NodeComparator implements Comparator<ListNode>{
	public int compare(ListNode l1, ListNode l2) {
		return l1.val - l2.val;
	}
}

public class MergeKSortedList {
	/**
	 * 给出K个排好序的listNode,合成一个排好序的listNode
	 * 1-2-5
	 * 2-3-6
	 * 4-5-7
	 * 
	 * result 1-2-2-3-4-5-5-6-7
	 * 使用队列，把首个节点放入队列，使用PriorityQueue和排序规则cmp，小的数排在队列前面
	 */
	public static ListNode mergeKSortedList(ListNode[] lists){
		if(lists == null || lists.length == 0) return null;
		ListNode dummy = new ListNode(0);
		ListNode curr = dummy;
		NodeComparator cmp = new NodeComparator();
		//使用PriorityQueue和排序规则cmp, 小的数排在队列前面, java 1.8之后才能这样写
		PriorityQueue<ListNode> queue = new PriorityQueue<ListNode>(cmp);
		for(int i=0; i<lists.length; i++){
			queue.add(lists[i]);
		}
		while(queue.size() > 0){
			ListNode tmp = queue.poll();
			curr.next = new ListNode(tmp.val);
			curr = curr.next;
			if(tmp.next != null){
				queue.add(tmp.next);
			}
		}
		return dummy.next;
	}
	
	public static void main(String[] args) {
		
		ListNode l1 = new ListNode(1);
		l1.next = new ListNode(2);
		l1.next.next = new ListNode(5);
		
		ListNode l2 = new ListNode(2);
		l2.next = new ListNode(3);
		l2.next.next = new ListNode(6);
		l2.next.next.next= new ListNode(7);
		
		ListNode l3 = new ListNode(4);
		l3.next = new ListNode(5);
		l3.next.next = new ListNode(6);
		l3.next.next.next= new ListNode(8);
		
		ListNode[] lists = new ListNode[]{l1,l2,l3};
		
		ListNode result = mergeKSortedList(lists);
		System.out.println(result);
	}
	
}
