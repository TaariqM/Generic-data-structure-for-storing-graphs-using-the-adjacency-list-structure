package packag;

public interface Map<K, V> {
	
	/**
	 * Returns the size of the map
	 * 
	 * 
	 * 
	 */
	public int size();
	
	/**
	 * returns true if the map is empty and false if otherwise.
	 * 
	 * 
	 */
	public boolean isEmpty();
	
	/**
	 * Creates a new Entry ie if one does not exist already and adds it to the map.
	 * Otherwise, updates the value of the existing entry.
	 */
	public V put(K key, V value) throws InvalidKeyException;
	
	/**
	 * Removes an already-existing entry.
	 * 
	 * 
	 * 
	 */
	public V remove(K key) throws InvalidKeyException;
	
	/**
	 * Returns the value associated with key.
	 *
	 *
	 *
	 */
	public V get(K key) throws InvalidKeyException;
	
	/**
	 * Returns the collection of keys for iteration
	 * 
	 * 
	 */
	public Iterable<K> keySet();
	
	/**
	 * Returns the collection of values for iteration
	 * 
	 * 
	 */
	public Iterable<V> values();
	
	/**
	 * Returns the set of entries for iteration
	 * 
	 * 
	 */
	public Iterable<Entry<K,V>> entrySet();
	
	
}