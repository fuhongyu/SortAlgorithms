package arraylist.demo;

import java.awt.List;

import arraylist.demo.ListNode;

/**
 * 
 * @author FHY
 * 有序链表的合并
 */
public class MergeSortList {
	public static void main(String[] args) {
		ListNode l1 = new ListNode(1);
		l1.next = new ListNode(4);
		
		ListNode l2 = new ListNode(3);
		l2.next = new ListNode(9);
		ListNode result = mergeSortTwo(l1, l2);
		
		//链表输出
		while(result != null){
			System.out.println(result.value);
			result = result.next;
		}
	}

	private static ListNode mergeSortTwo(ListNode l1, ListNode l2) {
		if(l1 == null) return l2;
		if(l2 == null) return l1;
		
		ListNode p = l1;
		ListNode q = l2;
		ListNode head = null;
		
		//确定头结点的指向
		if(p.value <= q.value){
			head = p;
			p = p.next;
		}else{
			head = q;
			q = q.next;
		}
		
		//依次比较链表中的元素
		ListNode r = head;
		while(p != null && q != null){
			if(p.value < q.value){
				r.next = p;
				r = r.next;
				p = p.next;
			}else{
				r.next = q;
				r= r.next;
				q = q.next;
			}
		}
		
		//将链表中剩余元素插入
		if(p != null){
			r.next = p;
		}else{
			r.next = q;
		}
		
		return head;
	}

}

