package com.coding.practice.coding.champ.linkedlist;

public class RemoveNodeFromEnd {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
	}
	
	  public ListNode reverseList(ListNode head) {
	        ListNode slow = null;
	        ListNode fast = head;
	        ListNode temp = null; 
	        while(fast != null){
	            temp = fast.next;
	            fast.next = slow;
	            slow = fast;
	            fast = temp;
	            
	        }
	        return slow;
	    }
	
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummyHead = new ListNode(0);
        ListNode fast = dummyHead;
        ListNode slow = dummyHead;
        
        dummyHead.next = head;
        
        for(int i = 1; i<= n ; i++){
            fast = fast.next;
        }
        
        while(fast.next != null){
            fast = fast.next;
            slow = slow.next;
        }
        
       slow.next = slow.next.next;
        
        return dummyHead.next;
    }

}
