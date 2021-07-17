/**
 * 
 */
package com.practice.tutorial.Tutorial;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * @author ss
 *
 *Q) https://www.geeksforgeeks.org/minimum-number-swaps-required-sort-array/
 *
 *
 */
public class MinSwaps {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		MinSwaps ms = new MinSwaps();
		
		int[] arr = { 101, 758, 315, 730, 472,
                619, 460, 479 };
		
		int minSwaps = ms.getMinSwaps(arr);
		System.out.println("Minimum swaps : "+ minSwaps);
	}
	
	class Node {
		public int val;
		public int pos;
		public Node(int val, int pos) {
			super();
			this.val = val;
			this.pos = pos;
		}
		@Override
		public String toString() {
			return "Node [val=" + val + ", pos=" + pos + "]";
		}
		
		
	}
	
	
	public int getMinSwaps(int[] arr) {
		ArrayList<Node> list = new ArrayList<>();
		int i =0;
		
		for (int ele : arr) {
			Node node = new Node(ele, i);
			i++;
			list.add(node);
		}
		
		
		Collections.sort(list, new Comparator<Node>() {
			@Override
			public int compare(Node o1, Node o2) {
				return String.valueOf(o1.val).compareTo(String.valueOf(o2.val));
			}
		});
		
		int swaps = 0;
		
		for (int j = 0; j < arr.length; j++) {
			Node node = list.get(j);
			
//			int tempPos = j;
			
			while(node.pos!= j) {
				//swap to correct position
				swaps++;
				
				Node tempNode = list.get(node.pos);//
				list.set(node.pos, list.get(j));
				list.set(j, tempNode);
				
				node = list.get(j);
//				tempPos = node.pos;
			}
		}
		
		return swaps;
	}

}
