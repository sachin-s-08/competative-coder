package com.coding.practice.coding_champ.implementations;


 /**
 * @author ss
 * Problem find an element in sorted and rotated array.
 *
 */
public class SortedAndRotatedArray {

	//Sorted and rotated array
	int[] a = {9,12,13,15,17,22,25,3,5,6};
	
	
	public static void main(String[] args) {
		SortedAndRotatedArray sr = new SortedAndRotatedArray();
		int findPivotElement = sr.findPivotElement(0, sr.a.length-1, sr.a);
		int ele = 15;
		if(ele >= sr.a[findPivotElement] && ele <= sr.a[sr.a.length-1] ) {
			sr.findBinaySearch(findPivotElement,sr.a.length-1,sr.a,ele);
		}else {
			sr.findBinaySearch(0,findPivotElement-1,sr.a,ele);
		}
		
		System.out.println("pivot ele : "+sr.a[findPivotElement]);
	}
	
	public void findBinaySearch(int s, int l , int[] arr, int ele) {
		int idx = -1;
		while (s <= l) {
			int m = s+l/2;
			if(arr[m]==ele) {
				idx = m ; break;
			}else {
				if(arr[m]< ele) {
					s = m+1;
				}else {
					l = m-1;
				}
			}
			
		}
		
		if(idx == -1 || s > l) {
			System.out.println("Element not found");
		} else {
			System.out.println("Element : "+arr[idx]);
		}
	}
	
	

	
	public boolean findElementUsingBinaySearch (int ele,int[] arr) {
	
		return true;
	}
	
	public int findPivotElement (int s, int l, int[] arr) {
		//Find pivot element through binary search
//		int s= 0,l=arr.length;
		int m = (s+l)/2;
		
		if(arr[m] > arr[m+1]) {
			return m+1;
		}else {
			if(arr[s] > arr[m]) {
				//Pivot is in this part
				return findPivotElement(s, m-1, arr);
			}else {
				//Povit is in this part
				return findPivotElement(m+1, l, arr);
			}
		}
		
		
		
	}
	
	public boolean findElement (int ele,int[] arr) {
		///Normal search
		arr = arr==null ? a : arr;
		boolean ret= false;
		int prev = arr[0];
		boolean startReached = false;
		for (int i = 0; i < arr.length; i++) {
			
			if(ele == arr[i]) {
				return true;
			}else if(i!=0 && arr[i-1] > arr[i]) {
				startReached = true;
			}
			
			if(startReached && ele < arr[i]) {
				return false;
			}
		}
		
		return false;
	}
	
}
