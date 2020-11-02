package packag;

public class test {

	public static void main(String[] args) {
		AdListGraph<Integer, String> graph = new AdListGraph<>();
		
		Vertex<Integer> a = graph.insertVertex(1);
		Vertex<Integer> b = graph.insertVertex(2);
		Vertex<Integer> c = graph.insertVertex(3);
		Vertex<Integer> d = graph.insertVertex(4);
		Vertex<Integer> e = graph.insertVertex(5);
		Vertex<Integer> f = graph.insertVertex(6);
		
		graph.insertEdge(a, b, "A");//1 ---> 2
		graph.insertEdge(b, c, "B");//2 ---> 3
		graph.insertEdge(c, d, "C");//3 ---> 4
		graph.insertEdge(d, e, "D");//4 ---> 5
		graph.insertEdge(e, f, "E");//5 ---> 6
		graph.insertEdge(f, c, "F");//6 ---> 3
		graph.insertEdge(a, d, "G");//1 ---> 4
		
				// a     "A"       b     "B"       c
				//[1]-------------[2]-------------[3]
				// |							   |
				// |"G"							   | "F"
				// |							   |
				//[4]-------------[5]-------------[6]
				// d    "D"        e      "E"      f

//		System.out.print("Number of vertices: ");
//		System.out.println(graph.numVertices());
//		System.out.print("Number of edges: ");
//		System.out.println(graph.numEdges());
		System.out.println("Adjacency List:");
		System.out.println(graph.toString());
	}

}
