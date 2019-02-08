package graph;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class BFS {
	private Map<String, Integer> symbolToIndex = new HashMap<>();
	private String vertexName[];
	
	private void bfs(Graph graph, String start) {
		boolean visited[] = new boolean[graph.V()];
		Arrays.fill(visited, false);
		int previous[] = new int[graph.V()];
		Arrays.fill(previous, -1);
		
		Queue<Integer> queue = new LinkedList<>();
		queue.add(symbolToIndex.get(start));
		while (!queue.isEmpty()) {
			int v = queue.poll();
			visited[v] = true;
			System.out.print(vertexName[v] + " ");
			for (Integer u : graph.adj(v)) {
				if (!visited[u]) {
					queue.add(u);
					visited[u] = true;
					previous[u] = v;
				}
			}
		}
		System.out.println();
	}
	
	private boolean bfs(Graph graph, String start, String end) {
		boolean visited[] = new boolean[graph.V()];
		Arrays.fill(visited, false);
		int previous[] = new int[graph.V()];
		Arrays.fill(previous, -1);
		
		Queue<Integer> queue = new LinkedList<>();
		queue.add(symbolToIndex.get(start));
		boolean found = false;
		while (!queue.isEmpty()) {
			int v = queue.poll();
			visited[v] = true;
			System.out.print(vertexName[v] + " ");
			if (v == symbolToIndex.get(end)) {
				found = true;
				break;
			}
			for (Integer u : graph.adj(v)) {
				if (!visited[u]) {
					queue.add(u);
					visited[u] = true;
					previous[u] = v;
				}
			}
		}
		System.out.println();
		if (found) {
			int curr = symbolToIndex.get(end);
			while (curr != symbolToIndex.get(start)) {
				System.out.print(vertexName[curr] + "<-");
				curr = previous[curr];
			}
			System.out.print(start);
		}
		return found;
	}
	
	private void dfs(Graph graph, String start) {
		boolean visited[] = new boolean[graph.V()];
		Arrays.fill(visited, false);
		int previous[] = new int[graph.V()];
		Arrays.fill(previous, -1);
		dfsUtil(graph, symbolToIndex.get(start), visited, previous);
	}
	

	private void dfsUtil(Graph graph, int v, boolean visited[], int previous[]) {
		visited[v] = true;
		System.out.print(vertexName[v] + " ");
		for (int u : graph.adj(v)) {
			if (!visited[u]) {
				previous[u] = v;
				dfsUtil(graph, u, visited, previous);
			}
		}
	}

	public static void main(String[] args) {
		BFS bfs = new BFS();
		
		String verticesInput[] = {"A", "B", "C", "D", "E", "F", "H", "G"};
		bfs.vertexName = new String[verticesInput.length];
		
		int i = 0;
		for (String v : verticesInput) {
			bfs.symbolToIndex.put(v, i);
			bfs.vertexName[i] = v;
			i++;
		}
		String[] adjInput = {"A B", "A D", "A G", "B E", "B F", "C F", "C H", "D F", "E G"};
		Graph graph = new Graph(8);
		for (String edge : adjInput) {
			String a[] = edge.split(" ");
			graph.addEdge(bfs.symbolToIndex.get(a[0]), bfs.symbolToIndex.get(a[1]));
			graph.addEdge(bfs.symbolToIndex.get(a[1]), bfs.symbolToIndex.get(a[0]));
		}
		System.out.println("BFS traversal");
		bfs.bfs(graph, "A");
		bfs.bfs(graph, "A", "H");
		System.out.println("\nDFS traversal");
		bfs.dfs(graph, "A");
	}

}
