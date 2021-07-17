/**
 * 
 */
package com.practice.tutorial.Tutorial;

/**
 * @author ss
 *
 *         https://www.geeksforgeeks.org/count-number-of-occurrences-or-frequency-in-a-sorted-array/
 *
 *
 *         Find the number of occurences in sorted array
 *
 *
 *         Time complexity O(log n) Space O(1)
 *
 *         Logic 1) Use Binary search to get index of the first occurrence of x
 *         in arr[]. Let the index of the first occurrence be i. 2) Use Binary
 *         search to get index of the last occurrence of x in arr[]. Let the
 *         index of the last occurrence be j. 3) Return (j – i + 1);
 */
public class FindOccurenceInSortedArray {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] ip = { 1, 1, 1, 4, 4, 4, 5, 5, 5, 7, 7, 8, 10 };
		 
		
		int cnt = getFrequency(ip, 11);
		
		
		
//		int lastIndex = binayRecursiveSearch(ip, 10, 0, ip.length-1);
		System.out.println("Frequency count : "+ cnt);
	}

	public static int getFrequency(int[] arr, int x) {

		// Find starting index

		int firstIdx = binaySearch(arr, x, 0, arr.length-1);
		System.out.println("First index : " + firstIdx);
		int cnt = 0;
		
		if(firstIdx > -1) {
			//Find the last index
			int lastIndex = binayRecursiveSearch(arr, x, firstIdx, arr.length-1);
			System.out.println("Last Index : "+ lastIndex);
			cnt = (lastIndex - firstIdx)+1;
		}
		
		return cnt;
	}

	public static int binaySearch(int[] arr, int x, int start, int end) {

		while (start <= end) {
			int mid = (start + end) / 2;

			// When element is found
			if ((mid == 0 && arr[mid] == x) || (arr[mid] == x && arr[mid - 1] != x)) {
				return mid;
			}

			if (x <= arr[mid]) {
				// lower bound
				end = mid - 1;
			} else {
				// higher bound
				start = mid + 1;
			}

		}

		return -1;
	}

	/**
	 * @param arr
	 * @param ele
	 * @param low
	 * @param high
	 * @return
	 * 
	 * 		recusively find the last index of matched element
	 */
	static int binayRecursiveSearch(int[] arr, int ele, int low, int high) {

		if (high >= low) {
			int mid = (low + high) / 2;
			if((arr[mid] == ele && mid == arr.length-1) || (arr[mid] == ele && arr[mid+1] != ele) ) {
				return mid;
			}
			
			if(arr[mid] <= ele) {
				return binayRecursiveSearch(arr, ele, mid+1, high);
			}else {
				return binayRecursiveSearch(arr, ele, low, mid-1);
			}
		}

		return -1;
	}

}
