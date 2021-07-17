package com.coding.practice.coding.champ.string;

public class TwoSum {
	
	public int[] twoSum(int[] ip , int target) {
		int low = 0, high = ip.length-1;
		
		while(low < high) {
			if(ip[low] + ip[high] == target) {
				return new int[] {ip[low], ip[high]};
			}
			else if(ip[low] + ip[high] > target) {
				low++;
			} else {
				high --;
			}
		}
		
		throw new IllegalAccessError();
	}
	
	

}
