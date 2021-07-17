/**
 * 
 */
package com.practice.tutorial.Tutorial;

import java.util.LinkedHashMap;
import java.util.Map.Entry;

/**
 * @author ss
 *
 *Find the first non repeating character in string
 *
 *time complexity O(n)
 *Space complexity O(n)
 */
public class FirstNonRepeatingChar {
	
	public static void main (String[] args) {
		String ip = "geegsForgeegs";
		char firstNonRepeating = firstNonRepeating(ip);
		System.out.println(firstNonRepeating);
		System.out.println("Completed!!!");
	}
	
	
	public static char firstNonRepeating(String str) {
		
		LinkedHashMap<Character, Integer> cntMap = new LinkedHashMap<>();
		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			if(cntMap.containsKey(ch)) {
				Integer count = cntMap.get(ch);
				cntMap.put(ch, ++count);
			}else {
				cntMap.put(ch, 1);
			}
		}
		
		
		for ( Entry<Character, Integer> entry : cntMap.entrySet()) {
			if(entry.getValue() == 1) {
				return entry.getKey();
			}
		}
		
		return ' ';
		
	}


}
