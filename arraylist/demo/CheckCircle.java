package arraylist.demo;
/**
 * 
 * @author FHY
 *	检测链表有没有环 
 */
public class CheckCircle {
	public static void main(String[] args) {
		//生成一个测试链表
		ListNode head = new ListNode(1);
		ListNode node1= new ListNode(2);
		head.next = node1;
		ListNode node2 = new ListNode(3);
		node1.next = node2;
		ListNode node3 = new ListNode(4);
		node2.next = node3; 
		ListNode node4 = new ListNode(5);
		node3.next = node4;
		node4.next = head;
		boolean result = checkIfCircle(head);
		System.out.println(result);
	}
	public static boolean checkIfCircle(ListNode head){
		if(head == null || head.next == null)
			return false;
		ListNode slow = head;
		ListNode fast = head.next;
		while(fast != null && fast.next != null){
			slow = slow.next;
			fast = fast.next.next;
			if(fast==slow) return true;
		}
		return false;
	}

}
