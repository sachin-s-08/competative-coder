package com.coding.practice.coding.champ.matrix;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class SpiralMatrix {
	
	 // Driver Code
    public static void main(String[] args)
    {
        int R = 3;
        int C = 6;
        int a[][] = { { 1, 2, 3, 4, 5, 6 },
                      { 7, 8, 9, 10, 11, 12 },
                      { 13, 14, 15, 16, 17, 18 } };
        
        // Function Call
        spiralOrder(a);
    }
    

	 public static List<Integer> spiralOrder(int[][] arr) {
	        
	        /*  
	        k - starting row index
	        m - ending row index
	        l - starting column index
	        n - ending column index
	        
	        i - iterator
	        */
	        int m = arr.length;
	        int n = arr[0].length;
	        List<Integer> ret = new LinkedList<>();
	        
	        int k= 0, l=0;
	        
	        while(k < m && l < n){
	            
	            for (int i = k; i<n  ; ++i){
	            	System.out.println(arr[k][i] + " -> ");
	                ret.add(arr[k][i]);
	            }k++;
	            
	            for(int i =k; i<m ; ++i){
	            	System.out.println(arr[i][n-1] + " V ");
	                ret.add(arr[i][n-1]);
	            }n--;
	            
	            if(k<m){
	                for(int i= n-1; i>=l; --i){
	                	System.out.println(arr[m-1][i] + " <-");
	                    ret.add(arr[m-1][i]);
	                } m--;
	            }
	            
	            if(l < n){
	                for(int i = m-1; i >= k; --i){
	                	System.out.println(arr[i][l] + "^ ");
	                     ret.add(arr[i][l]);
	                }l++;
	            }
	            System.out.println("k , m , l , n " +k+m+l+n);
	        }
	        
	        
	        return ret;
	    }
}
