package com.coding.practice.coding.champ.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ThreeSum {
	
//	private class Triplets {
//		int a, b , c;
//		
//		
//
//		public Triplets(int a, int b, int c) {
//			super();
//			this.a = a;
//			this.b = b;
//			this.c = c;
//		}
//
//		/* (non-Javadoc)
//		 * @see java.lang.Object#equals(java.lang.Object)
//		 */
//		@Override
//		public boolean equals(Object obj) {
//			Triplets tri = (Triplets) obj;
//			return tri.a == this.a && this.b == tri.b && this.c == tri.c;
//		}
//
//		/* (non-Javadoc)
//		 * @see java.lang.Object#hashCode()
//		 */
//		@Override
//		public int hashCode() {
//			return a * b * c;
//		}
//		
//		
//	}
	
	
	public static void main (String[] args) {
		ThreeSum ts = new ThreeSum();
		ts.threeSumLeetSolution(new int[] {-1,0,1,2,-1,-4});
		System.out.println("Completed");
	}
	
	
	  public List<List<Integer>> threeSumLeetSolution(int[] nums) {
	        
			Arrays.sort(nums);
	 
	    ArrayList<List<Integer>> result = new ArrayList<>();
	 
	    for (int i = 0; i < nums.length; i++) {
	        int j = i + 1;
	        int k = nums.length - 1;
	 
	        if (i > 0 && nums[i] == nums[i - 1]) {
	            continue;
	        }
	 
	        while (j < k) {
	            if (k < nums.length - 1 && nums[k] == nums[k + 1]) {
	                k--;
	                continue;
	            }
	 
	            if (nums[i] + nums[j] + nums[k] > 0) {
	                k--;
	            } else if (nums[i] + nums[j] + nums[k] < 0) {
	                j++;
	            } else {
	                ArrayList<Integer> l = new ArrayList<>();
	                l.add(nums[i]);
	                l.add(nums[j]);
	                l.add(nums[k]);
	                result.add(l);
	                j++;
	                k--;
	            }
	        }
	    }
	 
	    return result;

		
	    }
	  
	  
	  public void setZeroes(int[][] matrix) {
	        Set<Integer> row = new HashSet<>();
	        Set<Integer>  col = new HashSet<>();
	        
	        int n = matrix.length;
	        int m = matrix[0].length;
	        
	        for(int i =0 ; i< n; i++){
	            for(int j=0; j < m; j++){
	                if(matrix[n][m] == 0){
	                    row.add(n);
	                    col.add(m);
	                    break;
	                }
	                    
	            }
	        }
	        
	        
	        for(int i =0 ; i< n; i++){
	            for(int j=0; j < m; j++){
	                if(row.contains(i) || col.contains(j)){
	                    matrix[i][j] =0;
	                }
	                    
	            }
	        }
	            
	    }
	  
	  

	public List<List<Integer>> threeSum(int[] nums) {

		List<List<Integer>> ret = new ArrayList<>();
		Arrays.sort(nums);
		for (int i = 0; i < nums.length; i++) {
			int target = 0 - nums[i];
			int low = i + 1;
			int high = nums.length - 1;
			
			if (i > 0 && nums[i] == nums[i -1]) {
                continue;
            }

			while (low < high) {
				
				if (high < nums.length - 1 && nums[high] == nums[high + 1]) {
	                high--;
	                continue;
	            }
				
				if (nums[low] + nums[high] == target) {
//					List<Integer> asList = ;
					ret.add(Arrays.asList(new Integer[] { nums[i], nums[low], nums[high] }));
					low++;
					high--;
				} else if (nums[low] + nums[high] > target) {
					high--;
				} else {
					low++;
				}
			}
		}
		return ret;

	}
}
