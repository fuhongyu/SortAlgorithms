package arraylist.demo;
/**
 * 
 * @author FHY
 *	反转链表
 */
public class ReverseList {
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
		ListNode result = reverseList(head);
		while(result!=null){
			System.out.println(result.value);
			result = result.next;
			
		}
	}
	public static ListNode reverseList(ListNode head) {
		ListNode pre = null; //指向前一个元素的指针
        
		if(head==null || head.next==null){
			return head;
		}
		ListNode flag = head;//指向当前元素的指针
		ListNode next = head.next;//指向下一个元素
		while(next!=null){
			flag.next = pre;
			pre = flag;
			flag = next;
			next = next.next;          
		}
			flag.next = pre;
			return flag;
	}
	

}
