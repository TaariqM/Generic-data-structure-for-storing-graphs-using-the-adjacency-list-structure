package packag;

public interface AdaptablePriorityQueue<K, V> extends PriorityQueue<K,V> {
	
	/**
	 * Removes and returns any key within the priority queue.
	 * 
	 * 
	 */
	public void remove(Entry<K,V> e) throws IllegalArgumentException;
	
	/**
	 * Replaces the key of an entry
	 * 
	 * 
	 * 
	 */
	public void replaceKey(Entry<K,V> e, K key) throws IllegalArgumentException;
	
	/**
	 * Replaces the value of an entry
	 * 
	 * 
	 * 
	 */
	public void replaceValue(Entry<K,V> e, V value) throws IllegalArgumentException;
}


