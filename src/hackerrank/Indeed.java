package hackerrank;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Indeed {
	
	private static class Node {
		Node left, right;
		int data;

		Node(int newData) {
			left = right = null;
			data = newData;
		}
	}

	private static Node insert(Node node, int data) {
		if (node == null) {
			node = new Node(data);
		} else {
			if (data <= node.data) {
				node.left = insert(node.left, data);
			} else {
				node.right = insert(node.right, data);
			}
		}
		return (node);
	}
	
	private static int isPresent(Node root, int val) {
		if (root == null) {
			return 0;
		}
		if (root.data == val) {
			return 1;
		} else if (val > root.data) {
			return isPresent(root.right, val);
		} else {
			return isPresent(root.left, val);
		}
	}
	
	static void test() {
		Scanner scanner = new Scanner(System.in);
		int arrCount = scanner.nextInt();
		
		String arr[] = new String[arrCount];
		for (int arrItr = 0; arrItr < arrCount; arrItr++) {
			String arrItem = scanner.nextLine();
			arr[arrItr] = arrItem;
		}
		for (int i = 0; i < arr.length; i++) {
			int count[] = new int[26];
			Arrays.fill(count, 0);
			String s = arr[i];
			char ret[] = new char[s.length()];
			for (int j = 0; j < s.length(); j++) {
				int cnt = count[s.charAt(j) - 97];
				if (cnt == 0) {
					ret[j] = s.charAt(j);
				} else {
					int r = s.charAt(j) + cnt;
					if (r > 122) {
						ret[j] = (char) (r % 122 + 96);
					} else {
						ret[j] = (char) r;
					}
				}
				count[s.charAt(j) - 97]++;
			}
			System.out.println(String.valueOf(ret));
		}
		scanner.close();
	}
	
	static int[] getMinimumUniqueSum(String[] arr) {
		int squares[] = new int[arr.length];
		for (int i = 0; i < arr.length; i++) {
			String s[] = arr[i].split(" ");
			int a = Integer.parseInt(s[0]);
			int b = Integer.parseInt(s[1]);
			int squareCnt = (int) (Math.floor(Math.sqrt(b)) - Math.ceil(Math.sqrt(a)) + 1);;
			
			squares[i] = squareCnt;
		}
		return squares;
    }
	
	static String[] isCircular(String commands[]) {
		String results [] = new String[commands.length];
		for (int i = 0; i < commands.length; i++) {
			int x = 0, y = 0;
			int direction = 0;
			for (int j = 0; j < commands[i].length(); j++) {
				char step = commands[i].charAt(j);
				if (step == 'R') {
					direction = (direction + 1) % 4;
				} else if (step == 'L') {
					direction = (4 + direction - 1) % 4;
				} else {
					if (direction == 0) {
						y++;
					} else if (direction == 1) {
						x++;
					} else if (direction == 2) {
						y--;
					} else {
						x--;
					}
				}
			}
			if (x == 0 && y == 0) {
				results[i] = "YES";
			} else {
				results[i] = "NO";
			}
		}
		return results;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
		int arrCount = Integer.parseInt(buffer.readLine());
		String arr[] = new String[arrCount];
        for (int i = 0; i < arrCount; i++) {
        	buffer.readLine();
        	String line1 = buffer.readLine();
        	arr[i] = line1;
        }
		for (int i = 0; i < arr.length; i++) {
			int count[] = new int[26];
			Arrays.fill(count, 0);
			String s = arr[i];
			char ret[] = new char[s.length()];
			for (int j = 0; j < s.length(); j++) {
				int cnt = count[s.charAt(j) - 97];
				if (cnt == 0) {
					ret[j] = s.charAt(j);
				} else {
					int r = s.charAt(j) + cnt;
					if (r > 122) {
						ret[j] = (char) (r % 122 + 96);
					} else {
						ret[j] = (char) r;
					}
				}
				count[s.charAt(j) - 97]++;
			}
			System.out.println(String.valueOf(ret));
		}
		buffer.close();
	}
}
