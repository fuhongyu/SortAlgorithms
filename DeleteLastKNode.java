package arraylist.demo;

/**
 * 
 * @author FHY
 * ɾ��������K�����
 */
public class DeleteLastKNode {
	
	public static void main(String[] args) {
		//mian�н��в���
		ListNode list = new ListNode(1);
		ListNode l1 = new ListNode(4);
		ListNode l2 = new ListNode(2);
		ListNode l3 = new ListNode(8);
		list.next = l1;
		l1.next = l2;
		l2.next = l3;
		printAll(list);
		ListNode result = deleteLastKNode(list,3);
		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
		printAll(result);
	}

	private static ListNode deleteLastKNode(ListNode list, int k) {
		int i = 1;
		ListNode fast = list;
		
		//��fast�ȶ�λ��������KԪ��
		while(i<k){
			fast = fast.next;
			i++;
		}
		
		//�����Ȳ���K��û��ɾ����ֱ�ӷ���
		if(fast == null) return list;
		
		ListNode slow = list;
		ListNode pre = null;
		
		//fast��slow���ò�K�� ��fastָ�����һ��Ԫ��ʱ��slow����ָ������KԪ��
		while(fast.next!=null){
			fast = fast.next;
			pre = slow;
			slow = slow.next;
		}
		
		if(pre == null){
			//preǡ���ǵ�����KԪ��
			return list.next;
		}else{
			//slowָ���KԪ��
			pre.next = pre.next.next;
		}
		return list;
	}
	
	public static void printAll(ListNode result){
		while(result!=null){
			System.out.println(result.value);
			result = result.next;
		}
	}
	
	

}
