package com.coding.practice.coding.champ.string;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class StringReverse {

	public static void main(String[] args) throws Exception {
//		reverse(1534236469);
		
		boolean[] brr = new boolean[3];
		int[] arr = new int[256];
		System.out.println(arr);
		char[] crr = {'s','a','b','c','z'};
		
		for (int i = 0; i < crr.length; i++) {
			arr[crr[i]]++;
			arr[crr[i]]--;
		}
		
		for (int c : arr) {
			if(c != 0) {
//				return false;
			}
		}
		
		
		System.out.println(crr);
		
		
		
	}

	public int firstUniqChar(String s) {
	       HashMap<Character,Integer> count= new HashMap<>();
	        for(int i=0;i<s.length();i++){
	            char c=s.charAt(i);
	            count.put(c,count.getOrDefault(c,0)+1);
	        }
	        for(int i=0;i<s.length();i++){
	            if(count.get(s.charAt(i))==1)
	                return i;
	        }
	        return -1;
	}

	public static int reverse(int x) {
		try {

			if (x < 0) {
				x = x * -1;
				return -1 * Integer.valueOf(new StringBuilder(String.valueOf(x)).reverse().toString());
			} else {
				return Integer.valueOf(new StringBuilder(String.valueOf(x)).reverse().toString());
			}
		} catch (Exception e) {
			return 0;
		}

	}

	public int reverseLeetCode(int x) {
		int reverse = 0;

		while (x != 0) {
			if (reverse > Integer.MAX_VALUE / 10 || (reverse == Integer.MAX_VALUE / 10 && x % 10 > 7))
				return 0;
			if (reverse < Integer.MIN_VALUE / 10 || (reverse == Integer.MIN_VALUE / 10 && x % 10 < -8))
				return 0;
			reverse = reverse * 10 + x % 10;
			x = x / 10;
		}
		return reverse;
	}
}
