package hackerrank;

import java.util.ArrayList;
import java.util.List;

public class SampleTest {
	
	static String findNumber(int[] arr, int k) {
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == k)
				return "YES";
		}
		return "NO";
    }
	
	static int[] oddNumbers(int l, int r) {
		List<Integer> odds = new ArrayList<>();
		for (int i = l; i <= r; i++) {
			if (i % 2 != 0) {
				odds.add(i);
			}
		}
		int a[] = new int[odds.size()];
		for (int i = 0; i < a.length; i++) {
			a[i] = odds.get(i);
		}
		return a;
    }

	public static void main(String[] args) {
		
	}

}
