package geeksforgeeks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SubArrayWithSum {
	
	private static void subArraySum0(int A[], int sum) {
		for (int i = 0; i < A.length; i++) {
			int s = 0;
			int j = i;
			for (j = i; j < A.length; j++) {
				if (s >= sum) {
					break;
				} else {
					s += A[j];
				}
			}
			if (s == sum) {
				System.out.println((i + 1) + " " + j);
				return;
			}
		}
		System.out.println("-1");
	}
	
	private static void subArraySum1(int A[], int sum) {
		int s = 0;
		int i = 0;
		int j = i;
		while (i < A.length && j < A.length && s != sum) {
			s += A[j];
			if (s > sum) {
				i++;
				j = i;
				s = 0;
			} else {
				j++;
			}
		}
		if (s == sum) {
			System.out.println((i + 1) + " " + j);
		} else {
			System.out.println("-1");
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(bf.readLine());
		for (int i = 0; i < T; i++) {
			String input0[] = bf.readLine().split(" ");
			int n = Integer.parseInt(input0[0]);
			int sum = Integer.parseInt(input0[1]);
			String input1[] = bf.readLine().split(" ");
			int A[] = new int[n];
			for (int j = 0; j < input1.length; j++) {
				A[j] = Integer.parseInt(input1[j]);
			}
			subArraySum1(A, sum);
		}
	}

}
