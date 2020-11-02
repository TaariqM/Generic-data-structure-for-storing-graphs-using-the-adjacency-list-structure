package packag;

public interface PositionalList<E> {
	
	/**
	 * Returns the number of elements in the list.
	 * 
	 * 
	 */
	int size();
	
	/**
	 * checks to see if the list is empty .
	 * 
	 * 
	 */
	boolean isEmpty();
	
	/**
	 * Returns the first Position in the list or null, if it is empty. 
	 * 
	 * 
	 */
	Position<E> first();

	/**
	 * Returns the last Position in the list or null, if it is  empty).
	 * 
	 * 
	 */
	Position<E> last();
	
	/**
	 * Returns the Position immediately before Position p or null, if p is first 
	 * 
	 * 
	 */
	Position<E> before(Position<E> p) throws InvalidPositionException;
	
	/**
	 * Returns the Position immediately after Position p or null, if p is the  last.
	 * 
	 * 
	 * 
	 */
	Position<E> after(Position<E> p) throws InvalidPositionException;
	
	/**
	 * Inserts element e at the front of the list and returns its new Position.
	 * 
	 * 
	 * 
	 */
	Position<E> addFirst(E e);
	
	/**
	 * Inserts element e at the back of the list and returns its new Position.
	 * 
	 * 
	 * 
	 */
	Position<E> addLast(E e);
	
	/**
	 * Inserts element e immediately before Position p and returns its new Position.
	 * 
	 * 
	 */
	Position<E> addBefore(Position<E> p, E e) throws InvalidPositionException;
	
	/**
	 * Replaces the element stored at Position p and returns the replaced element.
	 * 
	 * 
	 * 
	 */
	Position<E> addAfter(Position<E> p, E e) throws InvalidPositionException;
	
	/**
	 * Replaces the element stored at Position p and returns the replaced element.
	 * 
	 * 
	 * 
	 */
	E set(Position<E> p, E e) throws InvalidPositionException;
	
	/**
	 * Removes the element stored at Position p and returns it
	 * 
	 * 
	 * 
	 */
	E remove(Position<E> p) throws InvalidPositionException;	
}
