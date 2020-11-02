package packag;

public interface PriorityQueue<K, V> {
		
		/**
		 * Gets the size of the priority queue.
		 * 
		 * 
		 * 
		 */
		public int size();
		
		/**
		 * Returns whether or not the priority queue is empty
		 * 
		 * 
		 * 
		 */
		public boolean isEmpty();
		
		/**
		 * Inserts an entry in the priority queue based on ordering
		 * 
		 * 
		 * 
		 */
		public Entry<K,V> insert(K key, V value) throws IllegalArgumentException;
		
		/**
		 * 
		 * 
		 */
		public Entry<K,V> min();
		
		/**
		 *
		 *
		 * 
		 */
		public Entry<K,V> removeMin();
	}

