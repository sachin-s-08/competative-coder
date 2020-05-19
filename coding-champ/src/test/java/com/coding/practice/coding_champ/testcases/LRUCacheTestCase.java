package com.coding.practice.coding_champ.testcases;

import com.coding.practice.coding_champ.implementations.LRUCache;
import com.coding.practice.coding_champ.interfaces.ILRUCache;

/**
 * Hello world!
 *
 */
public class LRUCacheTestCase 
{
    public static void main( String[] args )
    {
    	
    	
    	ILRUCache cache = new LRUCache( 2 /* capacity */ );

    	cache.put(1, 1);
    	cache.put(2, 2);
    	cache.get(1);       // returns 1
    	cache.put(3, 3);    // evicts key 2
    	cache.get(2);       // returns -1 (not found)
    	cache.put(4, 4);    // evicts key 1
    	cache.get(1);       // returns -1 (not found)
    	cache.get(3);       // returns 3
    	cache.get(4);
        System.out.println( "Hello World!" );
    }
}
