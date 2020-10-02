/**
 * 
 */
package com.coding.practice.coding_champ.implementations;

/**
 * @author ss
 *https://practice.geeksforgeeks.org/problems/sort-an-array-of-0s-1s-and-2s4231/1
 *Sort an array of 0s, 1s and 2s
 */
public class SortArrayof012 {

	public static void main(String[] args) {
		
		int[] arr1 = {0,1,0,2,0,1,0,2,2,1,0,1,0,0,1,2};
		sort012(arr1,16);
		
		
	}
	
	
	public static void sort012(int a[], int n){
	    
	    //Idea: Whenever you see 0, push it to front & inc front;
	    //Whenever you see 2 , push it to last & dec last;
	    int first=0;
	    int last=n-1;
	    int i=0;
	    while(i<=last)
	    {
	        if(a[i]==2)
	        {
	            int temp=a[last];
	            a[last]=a[i];
	            a[i]=temp;
	            last--;
	        }
	        else if(a[i]==0)
	        {
	            int temp=a[first];
	            a[first]=a[i];
	            a[i]=temp;
	            first++;
	            i++;
	        }
	        else
	        {
	            i++;
	        }
	    }
	    
	    
	    System.out.println("arr"+ a);
	   
	}
	
}
