/**
 * 
 */
package com.coding.practice.coding_champ.implementations;

/**
 * @author ss
 *To merge the sorted array
 */
public class MergeSortedArray {
	
	
	
	int[] a = {1,3,5,6,9};
	int[] b = {2,4,7,8,10,11,12,16};
	
	public int[] sortWithTimeComplex (int[] a,int[] b) {
		int[] res = new int[a.length+b.length];
		int i=0,j=0,k=0;
		while(i < a.length && j < b.length) {
			if(a[i] < b[j]) {
				res[k++] = a[i++];
			}else {
				res[k++] = b[j++];
			}
		}
		while (i < a.length) {
			res[k++] = a[i++];
		}
		while (j < b.length) {
			res[k++] = b[j++];
		}
		return res;
	}
	
	
	
	public int[] sortWithSpaceComplex (int[] a,int[] b) {
		
		//
		//TODO not possibe with time complex of O(n*m)
		//Do a insertion in swap
		return null;
	}
	
}
