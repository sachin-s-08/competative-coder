/**
 * 
 */
package com.practice.tutorial.Tutorial;

/**
 * @author ss
 *
 *         The idea is to use an integer variable and uses bits in its binary
 *         representation to store whether a character is present or not.
 *         Typically an integer has at-least 32 bits and we need to store
 *         presence/absence of only 26 characters.
 *         
 *         
 *         time complexity O(n)
 *         Space complexity O(1)
 *         
 */
public class FirstRecurringChar {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String ip = "strsing";

		int val = getFirstRepeated(ip);

		if(val > -1) {
			System.out.println("Char found : "+ ip.charAt(val));
		} else {
			System.out.println("No repeating char found.");
		}
	}

	private static int getFirstRepeated(String ip) {
		int cnt = 0;

		for (int i = 0; i < ip.length(); i++) {

			int pos = (ip.charAt(i) - 'a');
			if ((cnt & (1 << pos)) > 0) {
				return i;
			}

			cnt = cnt | (1 << pos);
		}
		return -1;
	}

}
