package packag;
import java.util.Iterator;

/**
 * A concrete class that implements a graph using the adjacency list
 * structure.
 * 
 *
 */

public class AdListGraph<V,E> implements Graph<V, E> {
	
	/**
	 * 
	 * 
	 * Attributes
	 * 
	 * 
	 */
	protected NodePositionalList<Vertex<V>> nodes; 
	protected NodePositionalList<Edge<E>> edges; 

	/**
	 * Constructor that creates a blank graph and initializes attributes. 
	 * 
	 * 
	 */
	public AdListGraph(){
		
		
	
		nodes=new NodePositionalList<Vertex<V>>();
		
		
		edges=new NodePositionalList<Edge<E>>();
	}
	
	public Vertex<V>[] endVertices(Edge<E> e) {
		

		EdgeImp<E> temp=checkEdge(e);
		
		return temp.getEnds();
	}

	public Vertex<V> opposite(Vertex<V> v, Edge<E> e) {
		this.checkVertex(v);
		
		EdgeImp<E> temp=checkEdge(e);
		
		Vertex<V>[] ends=temp.getEnds();
		
		Vertex<V> returnValue = null;
		
		if(v==ends[0]){
			
		
			returnValue=ends[1];
		}
		else if(v==ends[1]){
			
		
			returnValue =ends[0];
		}
		else
		{
			
			
			throw new InvalidPositionException("Invalid Vertex");
		}
		return returnValue ;
	}

	public boolean areAdjacent(Vertex<V> u, Vertex<V> v) 
	{
		
		Iterable<Edge<E>> it;
		
		if(degree(u)<degree(v)){
			
		
			
			it=incidentEdges(u);
			
		}
		else{
			it=incidentEdges(v);
			
		}
		for(Edge<E> e:it)
		{
			Vertex<V>[] end=endVertices(e);
			
			if((end[0]==u && end[1]==v)||(end[0]==v && end[1]==u))
			{
				return true;
			}
		}
		return false;
	}

	public Object replace(Position<?> p, Object o)
	{
		
		PositionImp pos=checkPosition(p);
		
		
		Object obj=p.getElement();
		
		pos.setElement(o);
		
		return obj;
	}
	
	public Vertex<V> insertVertex(V o) {
		
		VertexImp<V> newVertex=new VertexImp<V>(o);
		
		
		nodes.addLast(newVertex);
		
		Position<Vertex<V>> p=nodes.last();
		
		newVertex.setLocation(p);
		
		return newVertex;
	}

	public Edge<E> insertEdge(Vertex<V> v, Vertex<V> w, E o) throws InvalidPositionException {
		
	
		VertexImp<V> start=checkVertex(v);
		
		VertexImp<V> end=checkVertex(w);
		
		EdgeImp<E> newEdge=new EdgeImp<E>(v,w,o);
		
		Position<Edge<E>> pStart=start.insertEdge(newEdge);
		
		Position<Edge<E>> pEnd=end.insertEdge(newEdge);
		
		newEdge.setAdjacent(pStart, pEnd);
		
		this.edges.addLast(newEdge);
		
		Position<Edge<E>> pnewEdge=edges.last();
		
		newEdge.setLocation(pnewEdge);
		
		return newEdge;
	}

	public V removeVertex(Vertex<V> v) {
		
	
		VertexImp<V> vertex=checkVertex(v);
		
		Iterator<Edge<E>> it=incidentEdges(v).iterator();
		
		while(it.hasNext()){
			
		
			EdgeImp<E> edge=(EdgeImp<E>) it.next();
			
			if(edge.getLocation()!= null){
				
			
				this.removeEdge(edge);
			}
		}
		this.nodes.remove(vertex.getLocation());
		
		return vertex.getElement();
	}

	public E removeEdge(Edge<E> e) 
	{
		EdgeImp<E> edge=checkEdge(e);
		
		VertexImp<V>[] end=edge.getEnds();
		
		Position<Edge<E>>[] incident=edge.getAdjacent();
		
		end[0].removeEdge(incident[0]);
		
		end[1].removeEdge(incident[1]);
		
		edges.remove(edge.getLocation());
		
		edge.setLocation(null);
		
		return e.getElement();
	}

	public Iterable<Edge<E>> incidentEdges(Vertex<V> v) 
	{
		VertexImp<V> temp=checkVertex(v);
		
		return temp.edges();
	}

	public Iterable<Vertex<V>> vertices() {
		
	
		return this.nodes;
	}

	public Iterable<Edge<E>> edges() 
	{
		return this.edges;
	}

	/**
	 * Returns the degree of the given vertex
	 * 
	 * 
	 * 
	 */
	public int degree(Vertex<V> v)
	{
	    VertexImp<V> vertex = checkVertex(v);
	    
	    
	    return vertex.degree();
	}
	
	/**
	 * Takes a graph and returns the shortest path using the Dijkstra's algorithm
	 * 
	 * 
	 */
	
	
	
	protected VertexImp<V> checkVertex(Vertex<V> v) throws InvalidPositionException
	{
		if(v==null || !(v instanceof VertexImp))
		{
			throw new InvalidPositionException("Invalid Position");
		}
		
		return (VertexImp<V>) v;
	}
	
	
	protected EdgeImp<E> checkEdge(Edge<E> e) throws InvalidPositionException
	{
		
		if(e==null || !(e instanceof EdgeImp))
		{
			
			throw new InvalidPositionException("Invalid Position");
		}
		return (EdgeImp<E>) e;
	}
	
	
	@SuppressWarnings("rawtypes")
	
	
	protected PositionImp checkPosition(Position p) throws InvalidPositionException
	
	{
		if(p==null || !(p instanceof PositionImp))
		
		{
			throw new InvalidPositionException("Invalid Position");
		}
		
		return (PositionImp) p;
	}
	
	/**
	 * Returns the number of vertices in the graph
	 * 
	 * 
	 */
	public int getVertices(){
		return nodes.size();
	}
	
	/**
	 * Returns the number of edges in the graph.
	 * 
	 * 
	 */
	public int getEdges()
	
	{
		return edges.size();
	}
	
	public V replace(Vertex<V> v, V o)
	{
		VertexImp<V> vertex=checkVertex(v);
		
		V temp=v.getElement();
		
		vertex.setElement(o);
		
		return temp;
	}

	public E replace(Edge<E> e, E o)
	{
		EdgeImp<E> edge=checkEdge(e);
		
		E temp = e.getElement();
		
		edge.setElement(o);
		
		return temp;
	}
	
	public String toString()
	{
		return nodes.toString()+"\n\n"+edges.toString();
	}

	/**
	 * A concrete class which implements the Position interface by means 
	 * of a hash-map.
	 * 
	 * 
	 */

	protected class PositionImp<P> extends HashTableMap<Object, Object> implements ComPosition<P>{
		
		private static final long serialVersionUID = 1L;
		protected P element; 
		
		
		/**
		 * Sets the element at the position to the one that was passed.
		 * 
		 * 
		 */
	    public void setElement(P p){
	    	element = p;
	    }
	    
		public P getElement()throws IllegalStateException{
			return element;
		}
	}
	
	/**
	 * A concrete implementation of the vertex interface, which
	 * will be used for the graph.
	 * 
	 * 
	 *
	 */
	
	protected class VertexImp<V> extends PositionImp<V> implements Vertex<V>{

		private static final long serialVersionUID = 1L;
		
		private Position<Vertex<V>> location; 
		
		private NodePositionalList<Edge<E>> edgeIn; 
		
		
		/**
		 * Initializes the vertex. 
		 * 
		 * 
		 */
		public VertexImp(V v){
			
		
			element=v;
			
			edgeIn = new NodePositionalList<Edge<E>>();
		}
		
		/**
		 * Sets the position of the vertex.
		 * 
		 * 
		 */
		public void setLocation(Position<Vertex<V>> p)
		{
			location=p;
		}
		
		/**
		 * Returns the degree of the given vertex
		 * 
		 * 
		 * 
		 */
		public int degree()
		{
			
			
			return edgeIn.size();
		}
		
		/**
		 * Returns the location of the vertex.
		 * 
		 * 
		 */
		public Position<Vertex<V>> getLocation(){
			
			
	
			return location;
		}
		
		/**
		 * Inserts an edge
		 * 
		 * 
		 */
		public Position<Edge<E>> insertEdge(Edge<E> e){
			
			
		
			edgeIn.addLast(e);
			
			return edgeIn.last();
		}
		
		/**
		 * Removes an edge associated with a given position
		 * 
		 * 
		 */
		public void removeEdge(Position<Edge<E>> p){
			edgeIn.remove(p);
		}

		/**
		 * Returns the edges 
		 * 
		 * 
		 */
		public Iterable<Edge<E>> edges()
		
		{
			return edgeIn;
		}
		
		public String toString()
		{
			return element.toString();
		}
	}
	
	/**
	 * A concrete class which implements the Edge interface for use
	 * in the graph.
	 * 
	 * 
	 */
	protected class EdgeImp<E> extends PositionImp<E> implements Edge<E>{
		
		private static final long serialVersionUID = 1L;
		
		protected VertexImp<V>[] ends;
		
		protected Position<Edge<E>> location; 
		
		protected Position<Edge<E>>[] adjacent;
		
		/**
		 * Initializes an edge object with 2 vertices
		 * 
		 * 
		 */
		public EdgeImp(Vertex<V> start, Vertex<V> end, E o)
		
		{
			
			this.setElement(o);
			
			ends=(VertexImp<V>[]) new VertexImp[2];
			
			ends[0]=(VertexImp<V>) start;
			
			ends[1]=(VertexImp<V>) end;
			
			adjacent=(Position<Edge<E>>[]) new Position[2];
		}
		
		/**
		 * Sets the position of the edge
		 * 
		 * 
		 * 
		 */
		public void setAdjacent(Position<Edge<E>> start, Position<Edge<E>> end){
			adjacent[0]=start;
			
			adjacent[1]=end;
		}
		
		/**
		 * Sets the new position for the edge
		 * 
		 * 
		 * 
		 */
		public void setLocation(Position<Edge<E>> p){
			location=p;
		}
		
		/**
		 * Returns the location of the edge
		 * 
		 * 
		 */
		public Position<Edge<E>> getLocation()
		
		{
			return location;
		}
		
		public Position<Edge<E>>[] getAdjacent(){
			
			
			return adjacent;
		}
		
		/**
		 * Returns the two vertices attached to the edge
		 * 
		 * 
		 * */
		
		public VertexImp<V>[] getEnds()
		
		{
			return ends;
		}
		
		public String toString()
		
		{
			return this.getElement()+"("+ends[0].toString()+","+ends[1].toString()+")";
		}
	}
}
