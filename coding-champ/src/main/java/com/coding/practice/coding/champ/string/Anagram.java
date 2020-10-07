/**
 * 
 */
package com.coding.practice.coding.champ.string;

/**
 * @author ss
 *
 */
public class Anagram {

	public static void main(String[] args) {
		isAnagram("a", "b");
	}
	
	public int strStr(String haystack, String needle) {
       if(needle != null && !needle.isEmpty()) {
    	   for (int i = 0; i < haystack.length(); i++) {
			if(haystack.substring(i, i+needle.length()).equals(needle)){
				return i;
			}
		}
       }
       return -1;
		
    }

    public static boolean isAnagram(String s, String t) {
     
    	if(s.length() != t.length()) {
    		return false;
    	}
    	
    	
    	char ch = 'b';
    	
    	if(ch >= 'a' && ch <= 'z') {
    		
    	}
    	
    	int[] cnt = new int[26];
    	for (int i = 0; i < s.length(); i++) {
			cnt[s.charAt(i)%26]++;
			cnt[t.charAt(i)%26]--;
		}
    	
    	for (int i : cnt) {
			if(i != 0) {
				return false;
			}
		}
    	return true;
    }
	
}
