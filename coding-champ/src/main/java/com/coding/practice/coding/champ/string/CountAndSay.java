/**
 * 
 */
package com.coding.practice.coding.champ.string;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @author ss The count-and-say sequence is the sequence of integers with the
 *         first five terms as following:
 * 
 *         1. 1 2. 11 3. 21 4. 1211 5. 111221 1 is read off as "one 1" or 11. 11
 *         is read off as "two 1s" or 21. 21 is read off as "one 2, then one 1"
 *         or 1211.
 * 
 *         Given an integer n where 1 ≤ n ≤ 30, generate the nth term of the
 *         count-and-say sequence. You can do so recursively, in other words
 *         from the previous member read off the digits, counting the number of
 *         digits in groups of the same digit.
 * 
 *         Note: Each term of the sequence of integers will be represented as a
 *         string.
 * 
 * 
 * 
 *         Example 1:
 * 
 *         Input: 1 Output: "1" Explanation: This is the base case. Example 2:
 * 
 *         Input: 4 Output: "1211" Explanation: For n = 3 the term was "21" in
 *         which we have two groups "2" and "1", "2" can be read as
 */
public class CountAndSay {
	
	public static void main(String[] args) {
		CountAndSay c = new CountAndSay();
		
		String countAndSay = c.countAndSay1(3);
		
		System.out.println(countAndSay);
	}

	public String countAndSay(int n) {
        
        if(n == 1){
            return "1";
        }
        
   return null;
    }


    public String longestCommonPrefix(String[] strs) {
    	
    	String ret = "";
    	int cnt = 0;
    	for (char ch : strs[0].toCharArray()) {
    		for (int i = 1; i < strs.length; i++) {

    			if(cnt < strs[i].length() && ch != strs[i].charAt(cnt)) {
    				break;
    			}
				
			}
    		cnt++;
		}
    	
    	if(cnt > 0) {
    		ret = strs[0].substring(0, cnt);
    	}
    	
    	return ret;
    }
    
	public String countAndSay1(int n) {        
		String res = "1";
    while(n > 1){
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i< res.length(); i++){
            int cnt = 1;
            
            while(i+1<res.length() && res.charAt(i) == res.charAt(i+1)){
                cnt++;
                i++;
            }
            sb.append(cnt).append(res.charAt(i));
            
            
            
        }
        res = sb.toString();
        n--;
    }
    return res;
	}

}
