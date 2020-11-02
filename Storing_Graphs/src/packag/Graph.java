package packag;


public interface Graph<V, E> {
	
	/**
	 * Returns an array of the two end vertices of the assigned  edge
	 *  
	 */
	public Vertex<V>[] endVertices(Edge<E> e);
	
	/**
	 * Returns the vertex opposite to v on the same edge
	 * 
	 */
	public Vertex<V> opposite(Vertex<V> v, Edge<E> e);
	
	/**
	 * Returns a boolean value representing whether two vertices are adjacent
	
	 */
	public boolean areAdjacent(Vertex<V> u, Vertex<V> v);
	
	/**
	 * Replace the vertex or the edge with another edge or vertex.
	 * 
	 */
	public Object replace(Position<?> p, Object o);
	
	/**
	 * Replaces the element of the passed vertex
	 * 
	 * 
	 * 
	 */
	public V replace(Vertex<V> v, V o);
	
	/**
	 * Replaces the element of the passed edge
	 * 
	 * 
	 * 
	 */
	public E replace(Edge<E> e, E o);
	
	/**
	 * Inserts a vertex  which stores an object
	 * 
	 * 
	 */
	public Vertex<V> insertVertex(V o);
	
	/**
	 * Takes two vertices and link  them with a new edge  which holds data.
	 * 
	 * 
	 */
	public Edge<E> insertEdge(Vertex<V> v, Vertex<V> w, E o);
	
	/**
	 * Removes the specified vertex
	 * 
	 * 
	 */
	public V removeVertex(Vertex<V> v);
	
	/**
	 * Removes a specified edge
	 * 
	 * 
	 */
	public E removeEdge(Edge<E> e);
	
	/**
	 * Returns the set of edges incident on a passed vertex
	 * 
	 * 
	 */
	 
	public Iterable<Edge<E>> incidentEdges(Vertex<V> v);
	
	/**

	 * Returns the set of vertices associated with the graph
	 */
	public Iterable<Vertex<V>> vertices();
	
	/**
	 * Returns the set of edges associated with the graph
	 * 
	 * 
	 */
	public Iterable<Edge<E>> edges();

}
