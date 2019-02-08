package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class GraphTraversal {
	
	static class Vertex<T> {
		T data;
		boolean visited;
		Vertex<T> prevVertex;
		Vertex(T data) {
			this.data = data;
			visited = false;
			prevVertex = null;
		}
		public T getData() {
			return data;
		}
		public void setData(T data) {
			this.data = data;
		}
		public boolean isVisited() {
			return visited;
		}
		public void setVisited(boolean isVisited) {
			this.visited = isVisited;
		}
		public Vertex<T> getPrevVertex() {
			return prevVertex;
		}
		public void setPrevVertex(Vertex<T> prevVertex) {
			this.prevVertex = prevVertex;
		}
		@SuppressWarnings("unchecked")
		@Override
		public boolean equals(Object obj) {
			if (obj == null || !(obj instanceof Vertex))
				return false;
			Vertex<T> v = (Vertex<T>) obj;
			return data.equals(v.data);
		}
		@Override
		public int hashCode() {
			return data.hashCode();
		}
		@Override
		public String toString() {
			return data.toString();
		}
	}
	
	private void BFS(List<Vertex<String>> vertices, int adjMatrix[][], Vertex<String> s) {
		Queue<Vertex<String>> queue = new LinkedList<>();
		s.visited = true;
		s.prevVertex = null;
		queue.add(s);
		while (!queue.isEmpty()) {
			Vertex<String> v = queue.poll();
			System.out.print(v + " ");
			List<Vertex<String>> neighbors = findNeighbors(vertices, adjMatrix, v);
			for (Vertex<String> n : neighbors) {
				if (!n.visited) {
					queue.add(n);
					n.visited = true;
					n.prevVertex = v;
				}
			}
		}
		System.out.println();
	}
	
	private boolean BFS(List<Vertex<String>> vertices, int adjMatrix[][], Vertex<String> s, Vertex<String> e) {
		Queue<Vertex<String>> queue = new LinkedList<>();
		s.visited = true;
		s.prevVertex = null;
		queue.add(s);
		while (!queue.isEmpty()) {
			Vertex<String> v = queue.poll();
			if (v.equals(e)) {
				return true;
			}
			System.out.print(v + " ");
			List<Vertex<String>> neighbors = findNeighbors(vertices, adjMatrix, v);
			for (Vertex<String> n : neighbors) {
				if (!n.visited) {
					queue.add(n);
					n.visited = true;
					n.prevVertex = v;
				}
			}
		}
		return false;
	}
	
	private void DFS(List<Vertex<String>> vertices, int adjMatrix[][], Vertex<String> v) {
		v.visited = true;
		System.out.print(v + " ");
		List<Vertex<String>> neighbors = findNeighbors(vertices, adjMatrix, v);
		for (Vertex<String> n : neighbors) {
			if (!n.visited) {
				n.prevVertex = v;
				DFS(vertices, adjMatrix, n);
			}
		}
	}
	
	private void DFSIterative(List<Vertex<String>> vertices, int adjMatrix[][], Vertex<String> v) {
		Stack<Vertex<String>> stack = new Stack<>();
		stack.push(v);
		while (!stack.isEmpty()) {
			Vertex<String> u = stack.pop();
			if (!u.visited) {
				u.visited = true;
				System.out.print(u + " ");
				List<Vertex<String>> neighbors = findNeighbors(vertices, adjMatrix, u);
				for (Vertex<String> n : neighbors) {
					n.prevVertex = u;
					stack.push(n);
				}
			}
		}
	}

	private List<Vertex<String>> findNeighbors(List<Vertex<String>> vertices, int[][] adjMatrix, Vertex<String> v) {
		int vertexIdx = -1;
		for (int i = 0; i < vertices.size(); i++) {
			if (vertices.get(i).equals(v)) {
				vertexIdx = i;
				break;
			}
		}
		List<Vertex<String>> neighbors = new ArrayList<>();
		for (int i = 0; i < adjMatrix[vertexIdx].length; i++) {
			if (adjMatrix[vertexIdx][i] == 1 && !vertices.get(i).visited) {
				neighbors.add(vertices.get(i));
			}
		}
		return neighbors;
	}
	
	private void printPath(Vertex<String> start, Vertex<String> end) {
		Vertex<String> curr = end;
		while (!curr.equals(start)) {
			System.out.print(curr + "<-");
			curr = curr.prevVertex;
		}
		System.out.print(start);
	}

	public static void main(String[] args) {
		GraphTraversal gt = new GraphTraversal();
		String verticesInput[] = {"A", "B", "C", "D", "E", "F", "H", "G"};
//		String[] adjInput = {"A B", "A D", "A G", "B E", "B F", "C F", "C H", "D F", "E G"};
		int adjMatrix[][] = {
				{0, 1, 0, 1, 0, 0, 0, 1}, 
				{1, 0, 0, 0, 1, 1, 0, 0},
				{0, 0, 0, 0, 0, 1, 1, 0},
				{1, 0, 0, 0, 0, 1, 0, 0},
				{0, 1, 0, 0, 0, 0, 0, 1},
				{0, 1, 1, 1, 0, 0, 0, 0},
				{0, 0, 1, 0, 0, 0, 0, 0},
				{1, 0, 0, 0, 1, 0, 0, 0}
		};
		List<Vertex<String>> vertices = new ArrayList<>();
		for (String s : verticesInput) {
			vertices.add(new Vertex<String>(s));
		}
		Vertex<String> start = vertices.get(0);
		Vertex<String> end = vertices.get(3);
		
//		boolean ret = gt.BFS(vertices, adjMatrix, start, end);
//		System.out.println();
//		if (ret) {
//			gt.printPath(start, end);
//		}
		gt.DFSIterative(vertices, adjMatrix, start);
		System.out.println();
		gt.printPath(start, end);
	}

}
