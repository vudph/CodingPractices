package topcoder;

import java.util.Arrays;

public class MountainWalk {
	static int dx[] = {1, 0, -1, 0};
	static int dy[] = {0, -1, 0, 1};
	
	static int cellVistied(String areaMap[], int heightDiff) {
		int count = 0;
		int n = areaMap.length;
		int m = areaMap[0].length();
		boolean visited[][] = new boolean[n][m];
		for (int k = 0; k < n; k++) {
			Arrays.fill(visited[k], false);
		}
		int i = 0, j = 0;
		for (int k = 0; k < 4; k++) {
			int x = i + dx[k];
			int y = j + dy[k];
			if (x >= 0 && x < n && y >= 0 && y < m) {
				if (!visited[x][y]) {
					int currentHeight = Character.getNumericValue(areaMap[i].charAt(j));
					int nextHeight = Character.getNumericValue(areaMap[x].charAt(y));
					if (Math.abs((nextHeight - currentHeight)) <= heightDiff) {
						System.out.println("(" + x + "," + y + ")");
						count++;
						visited[x][y] = true;
						i = x;
						j = y;
						k = -1;
					}
				}
			}
		}
		return count;
	}

	public static void main(String[] args) {
		String areaMap[] = {"056", "135", "234"};
		System.out.println(cellVistied(areaMap, 1));
	}

}
