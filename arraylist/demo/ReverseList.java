package arraylist.demo;
/**
 * 
 * @author FHY
 *	��ת����
 */
public class ReverseList {
	public static void main(String[] args) {
		//����һ����������
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
		ListNode pre = null; //ָ��ǰһ��Ԫ�ص�ָ��
        
		if(head==null || head.next==null){
			return head;
		}
		ListNode flag = head;//ָ��ǰԪ�ص�ָ��
		ListNode next = head.next;//ָ����һ��Ԫ��
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
