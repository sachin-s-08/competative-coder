package com.coding.practice.coding.champ.linkedlist;

public class Palindrome {

	
	
	 /**
	  * O(1) space complexity and O(n time complexity)
	 * @param head
	 * @return
	 */
	public boolean isPalindrome(ListNode head) {
	        ListNode first = head, second = head;
	        
	        while(first.next != null && first.next.next != null){
	            first = first.next.next;
	            second = second.next;
	        }
	        
	          ListNode secondHead = second.next;
	          second.next = null;
	        
	       //reverse second part of the list
	    ListNode p1 = secondHead;
	    ListNode p2 = p1.next;
	 
	    while(p1!=null && p2!=null){
	        ListNode temp = p2.next;
	        p2.next = p1;
	        p1 = p2;
	        p2 = temp;
	    }
	 
	    secondHead.next = null;
	        
	        
	        ListNode p = (p2==null?p1:p2);
	    while(p != null && head != null){
	        if(p.val != head.val){
	            return false;
	        }
	        
	        p = p.next;
	        head = head.next;
	        
	    }
	        
	        return true;
	        
	    }
	 
	 
	 /**
	  * By using another list
	 * @param head
	 * @return
	 */
	public boolean isPalindromeList(ListNode head) {
	        ListNode rev = new ListNode();
	       
	        ListNode h = head;
	        
	        while (head != null){
	            ListNode temp = new ListNode(head.val);
	            temp.next = rev;
	            
	            rev = temp;
	            
	            head = head.next;
	            
	        }
	        
	        
	        while(h != null){
	            if(h.val != rev.val){
	                return false;
	            }
	            
	            h = h.next;
	            rev = rev.next;
	        }
	        
	        return true;
	        
	        
	    }
}
