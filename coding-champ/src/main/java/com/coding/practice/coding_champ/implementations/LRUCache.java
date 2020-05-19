/**
 * 
 */
package com.coding.practice.coding_champ.implementations;

import java.util.HashMap;
import java.util.Map;

import com.coding.practice.coding_champ.interfaces.ILRUCache;

/**
 * @author ss
 *This is a LRU cache implementations example
 */
public class LRUCache implements ILRUCache{
	
	int cacheSize;
	
//	HashSet<Integer> hashSet;
	
	Map<Integer,Node> map = new HashMap<>();
	
	Node head = new Node ();
	Node tail = new Node();
	
	class Node {
		int key;
		int value;
		
		Node prev;
		Node next;
	}
	
	
	public LRUCache(int cacheSize) {
		super();
		this.cacheSize = cacheSize;
//		this.hashSet = new HashSet<>(cacheSize);
		map = new HashMap<>(cacheSize);
		
		head.next = tail;
		tail.prev = head;
	}

	public int get(int key) {
		//If the key is there is map
		Node node = map.get(key);
		if(node != null) {
			//Remove the node and add it to head
			delete(node);
			addToHead(node);
		}else {
			//If the key is not there in map
			return -1;
		}
		return node.value;
	}

	public void put(int key, int value) {
		Node node = map.get(key);
		if(null == node) {
			node = new Node();node.key=key;node.value=value;
		} else {
			node.value = value;
		}
		if(map.size() < cacheSize && map.get(key) == null) {
			//Adding first time to map when map is not filled
			map.put(key, node);
		}else if(map.get(key) == null){
			//Adding first time to map when map is filled
			//Remove the tail node and add this node to head
			map.remove(tail.prev.key);
			map.put(key, node);
			delete(tail.prev);
		} else if (map.get(key) != null ){
			//When the map already has the value
			//remove this node and add the same to head
			delete(node);
		}
		
		
		addToHead(node);
	}

	public void addToHead (Node node) {
		Node oldNode = head.next;
		head.next = node;
		node.prev = head;
		
		node.next = oldNode;
		oldNode.prev = node;
	}
	
	public void delete (Node node) {
		node.next.prev = node.prev;
		node.prev.next = node.next;
	}
};
