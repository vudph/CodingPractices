package graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Graph {
	private int V; //number of vertices
	private int E; //number of edges
	private Set<Integer> adj[];
	
	public Graph(int V) {
		this.V = V;
		this.E = 0;
		adj = new HashSet[V];
		for (int i = 0; i < adj.length; i++) {
			adj[i] = new HashSet<>();
		}
	}
	
	public void addEdge(int u, int w) {
		adj[u].add(w); //add edge u-w
//		adj[w].add(u); //add edge w-u
		E++;
	}
	
	public int V() {
		return V;
	}

	public int E() {
		return E;
	}

	public Set<Integer> adj(int v) {
		return adj[v];
	}
	
	public static void main(String[] args) {
		int vertex = 4;
		Graph g = new Graph(vertex);
		g.addEdge(0, 1);
		g.addEdge(0, 2);
		g.addEdge(1, 2);
		g.addEdge(2, 0);
		g.addEdge(2, 3);
		g.addEdge(3, 1);
		for (int v = 0; v < vertex; v++) {
			System.out.print(v + ": ");
			for (Integer a : g.adj(v)) {
				System.out.print(a + ", ");
			}
			System.out.println();
		}
		
		
//		g.addEdge("a", "b");
//		g.addEdge("a", "c");
//		g.addEdge("b", "c");
//		g.addEdge("c", "a");
//		g.addEdge("c", "d");
//		g.addEdge("d", "d");
//		Iterator<String> iter = g.adj("a").iterator();
//		for (String v : g.adj("a")) {
//			System.out.print(v + " ");
//		}
		
//		String[] sampleInput = {
//						"JFK MCO", 
//						"JFK MCO",
//						"ORD DEN",
//						"ORD HOU",
//						"DFW PHX",
//						"JFK ATL",
//						"ORD DFW",
//						"ORD PHX",
//						"ATL HOU",
//						"DEN PHX",
//						"PHX LAX",
//						"JFK ORD",
//						"DEN LAS",
//						"DFW HOU",
//						"ORD ATL",
//						"LAS LAX",
//						"ATL MCO",
//						"HOU MCO",
//						"LAS PHX"
//		};
//		for (int k = 0; k < sampleInput.length; k++) {
//			String[] a = sampleInput[k].split(" "); // by connecting the
//			g.addEdge(a[0], a[1]);
//			g.addEdge(a[1], a[0]);
//		}
//		for (String v : g.adj("JFK")) {
//			System.out.print(v + " ");
//		}
	}
}
