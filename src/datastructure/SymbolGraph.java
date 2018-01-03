package datastructure;

import java.util.TreeMap;

public class SymbolGraph {
	private TreeMap<String, Integer> st; // String -> index
	private String[] keys; // index -> String
	private Graph G; // the graph
	private String[] sampleInput = {"JFK MCO", "JFK MCO",
			"ORD DEN",
			"ORD HOU",
			"DFW PHX",
			"JFK ATL",
			"ORD DFW",
			"ORD PHX",
			"ATL HOU",
			"DEN PHX",
			"PHX LAX",
			"JFK ORD",
			"DEN LAS",
			"DFW HOU",
			"ORD ATL",
			"LAS LAX",
			"ATL MCO",
			"HOU MCO",
			"LAS PHX"};

	public SymbolGraph() {
		st = new TreeMap<String, Integer>();
		for (int i = 0; i < sampleInput.length; i++) {
			String[] a = sampleInput[i].split(" "); // by reading strings
			for (int k = 0; k < a.length; k++) // to associate each
				if (!st.containsKey(a[k])) // distinct string
					st.put(a[k], st.size()); // with an index.
		}
		keys = new String[st.size()]; // Inverted index
		for (String name : st.keySet()) // to get string keys
			keys[st.get(name)] = name; // is an array.
		G = new Graph(st.size());
		for (int k = 0; k < sampleInput.length; k++) {
			String[] a = sampleInput[k].split(" "); // by connecting the
			int v = st.get(a[0]); // first vertex
			for (int i = 1; i < a.length; i++) // on each line
				G.addEdge(v, st.get(a[i])); // to all the others.
		}
	}
	public SymbolGraph(String vertices[]) {
		st = new TreeMap<String, Integer>();
		for (int i = 0; i < vertices.length; i++) {
			if (!st.containsKey(vertices[i])) {
				st.put(vertices[i], st.size());
			}
		}
		keys = new String[st.size()];
		for (String name : st.keySet()) {
			keys[st.get(name)] = name;
		}
		G = new Graph(st.size());
	}

	public boolean contains(String s) {
		return st.containsKey(s);
	}

	public int index(String s) {
		return st.get(s);
	}

	public String name(int v) {
		return keys[v];
	}

	public Graph G() {
		return G;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (int v = 0; v < G.V(); v++) {
			sb.append(name(v) + ": ");
			for (int w : G.adj(v)) {
				sb.append(name(w) + ", ");
			}
			sb.append("\n");
		}
		return sb.toString();
	}
	
	public static void main(String[] args) {
		SymbolGraph sg = new SymbolGraph();
		Graph g = sg.G();
		for (int v = 0; v < g.V(); v++) {
            System.out.print(sg.name(v) + ": ");
            for (int w : g.adj(v)) {
                System.out.print(sg.name(w) + " ");
            }
            System.out.println();
        }
	}

}
