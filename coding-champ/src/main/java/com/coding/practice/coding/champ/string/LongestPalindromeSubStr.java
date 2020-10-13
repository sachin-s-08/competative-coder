package com.coding.practice.coding.champ.string;

public class LongestPalindromeSubStr {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String longestPalindrome = new LongestPalindromeSubStr().longestPalindrome("babs");
		System.out.println(longestPalindrome);
	}
	

    public String longestPalindrome(String s) {
    	int[][] table = new int[s.length()][s.length()];
        int maxLen = 1;
        
        int f=0,l=0;
    	for (int i = 0; i < table.length; i++) {
			table[i][i] = 1;
			if(i+1 < table.length) {
				table[i][i+1] = s.charAt(i) == s.charAt(i+1) ? 1 : 0;
				if(table[i][i+1] == 1) {
					if(maxLen < 2) {
						f = i ;
						l = i+1;
					}
					maxLen = Math.max(maxLen, 2);
				}
			}
		}
    	
    	for (int i = 2; i < table.length; i++) {
					for (int j = 0; j < table.length - i; j++) {
						int start = j;
						int end = j+i;
						if(s.charAt(start)== s.charAt(end) && table[start+1][end-1] == 1) {
							table[start][end] = 1;
							if(maxLen < i+1) {
								f = start ;
								l = end;
							}
							maxLen = Math.max(maxLen, i+1);
						} else {
							table[start][end] = 0;
						}
					}
		}
    	
    	return s.substring(f, l+1);
    }

}
