package packag;

import java.util.Comparator;

	public abstract class AbstractPriorityQueue<K, V> implements PriorityQueue<K, V> {

		/**
		 * A class which implements the Entry interface
		
		 */
		protected static class PQEntry<K,V> implements Entry<K,V>{
			private K key;
			
			private V value;
			
			public PQEntry(K key, V value){
				
				this.key=key;
				
				this.value=value;
			}
			
			protected void setKey(K k){
				
				this.key=k;
			}
			
			protected void setValue(V v){
				
				this.value=v;
			}
			
			@Override
			public K getKey() {
				
				return this.key;
			}

			@Override
			public V getValue() {
				
				return this.value;
			}
		}
		private Comparator<K> comp;
		
		/**
		 * A constructor which initializes the AbstrectPriorityQueue as  part of the
		 * object which is used by other classes 
		 * 
		 */
		protected AbstractPriorityQueue(Comparator<K> c){
			comp=c;
		}
		
		
		protected AbstractPriorityQueue(){
			
			this(new DefaultComparator<K>());
		}
		
		/**
		 * Compares two entries and returns the result as an integer
		 * 
		 * 
		 * 
		 */
		protected int compare(Entry<K,V> a, Entry<K,V> b){
			
			return comp.compare(a.getKey(), b.getKey());
		}
		
		/**
		 * Checks to see if the key is valid or not
		 * 
		 * 
		 * 
		 */
		protected boolean checkKey(K key) throws IllegalArgumentException{
			try{
				
				return(comp.compare(key, key)==0);
				
			}catch(ClassCastException e){
				
				throw new IllegalArgumentException("Invalid key");
				
			}
		}

		@Override
		
		public boolean isEmpty() {
			
			return size()==0;
		}
	}

