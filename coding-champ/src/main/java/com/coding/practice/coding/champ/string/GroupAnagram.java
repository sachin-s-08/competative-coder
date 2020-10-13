package com.coding.practice.coding.champ.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class GroupAnagram {

	
    public List<List<String>> groupAnagrams(String[] strs) {
        
    	Map<String,List<String>> map = new HashMap<>();

    	for (String str : strs) {
    		char[] charArray = str.toCharArray();
			Arrays.sort(charArray);
    		String temp = new String(charArray); 
    		if(map.containsKey(temp)) {
    			map.get(temp).add(str);
    		} else {
    			LinkedList<String> linkedList = new LinkedList<>();
    			linkedList.add(str);
				map.put(temp, linkedList);
    		}
			
		}
   
    	return new ArrayList<>(map.values());
    	
    }
    
}
