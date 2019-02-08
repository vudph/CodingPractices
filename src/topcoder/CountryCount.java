package topcoder;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class CountryCount {
	int dx[] = {0, 1, 0, -1};
	int dy[] = {1, 0, -1, 0};
	
	static class Node {
		int i;
		int j;
		public Node(int i, int j) {
			this.i = i;
			this.j = j;
		}
	}
	
	public int countriesCount(int A[][]) {
		int count = 0;
		int n = A.length;
		int m = A[0].length;
		boolean visited[][] = new boolean[n][m];
		for (int i = 0; i < n; i++) {
			Arrays.fill(visited[i], false);
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (!visited[i][j]) {
					count++;
					BFS(A, visited, i, j);
				}
			}
		}
		return count;
	}

	private void DFS(int[][] A, boolean[][] visited, int i, int j) {
		visited[i][j] = true;
		for (int k = 0; k < 4; k++) {
			int x = i + dx[k];
			int y = j + dy[k];
			if (x >= 0 && x < A.length && y >= 0 && y < A[0].length) {
				if (!visited[x][y] && A[i][j] == A[x][y]) {
					DFS(A, visited, x, y);
				}
			}
		}
	}
	
	private void BFS(int[][] A, boolean[][] visited, int i, int j) {
		visited[i][j] = true;
		Queue<Node> queue = new LinkedList<>();
		queue.add(new Node(i, j));
		while (!queue.isEmpty()) {
			Node node = queue.poll();
			for (int k = 0; k < 4; k++) {
				int x = node.i + dx[k];
				int y = node.j + dy[k];
				if (x >= 0 && x < A.length && y >= 0 && y < A[0].length) {
					if (!visited[x][y] && A[i][j] == A[x][y]) {
						visited[x][y] = true;
						queue.add(new Node(x, y));
					}
				}
			}
		}
	}
	public static void main(String[] args) {
		int A[][] = {{4,4,4}, {4,3,4}, {3,2,4}, {2,2,2}, {3,3,4}, {1,4,4}, {4,1,1}};
		System.out.println(new CountryCount().countriesCount(A));
	}
}
