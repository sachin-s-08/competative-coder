/**
 * 
 */
package com.practice.tutorial.Tutorial;

/**
 * @author ss
 *Find if the linked list is cyclic or not.
 *
 *Time complex O(n)
 *Auxilary Complex O(1)
 */
public class CyclicLinkedList {

	class Node {
		Node next;
		String val;
	}
	
	public static boolean isCyclic (Node list) {
		Node slow, fast;
		slow = list;fast=list;
		
		while (slow != null && fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			
			if(slow == fast) {
				return true;
			}
		}
		return false;
		
	}
	
}
