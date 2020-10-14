package com.coding.practice.coding.champ.linkedlist;

public class LinkedListIntersection {

	  public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
	        String list = null;
	        int cnt = 0;
	        ListNode tail = null;
	        ListNode longer = headA;
	        ListNode small = null;
	        
	        ListNode a = headA;
	        ListNode b = headB;
	        ListNode ret = null;
	        
	        
	        while(headA != null && headB != null){
	            headA = headA.next;
	            headB = headB.next;
	        }
	        
	        longer = headA != null ? a : (headB != null ? b : longer);
	        tail = headA != null ? headA : (headB != null ? headB : null);
	        
	        small = longer == a ? b : a;
	        
      
	        while(tail != null){
	            cnt++;
	            tail = tail.next;
	        }
	        
	        while(longer != null){
	            if(longer == small){
	                return longer;
	            }
	            
	            if(cnt < 1){
	                small = small.next;
	            }
	            longer = longer.next;
              cnt--;
	        }
	        
	        
	        
	        return null;
	        
	    }
}
