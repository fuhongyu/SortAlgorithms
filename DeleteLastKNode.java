package arraylist.demo;

/**
 * 
 * @author FHY
 * 删除倒数第K个结点
 */
public class DeleteLastKNode {
	
	public static void main(String[] args) {
		//mian中进行测试
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
		
		//将fast先定位到正数第K元素
		while(i<k){
			fast = fast.next;
			i++;
		}
		
		//链表长度不足K，没法删除，直接返回
		if(fast == null) return list;
		
		ListNode slow = list;
		ListNode pre = null;
		
		//fast和slow正好差K， 即fast指向最后一个元素时，slow正好指向倒数第K元素
		while(fast.next!=null){
			fast = fast.next;
			pre = slow;
			slow = slow.next;
		}
		
		if(pre == null){
			//pre恰好是倒数第K元素
			return list.next;
		}else{
			//slow指向第K元素
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
