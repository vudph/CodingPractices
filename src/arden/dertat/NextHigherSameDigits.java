package arden.dertat;

import java.util.Arrays;
import java.util.Collections;

public class NextHigherSameDigits {
	private static long nextHigher(long n) {
//		int a[] = Integer.toString(n).chars().map(x -> x - '0').toArray();
		char a[] = Long.toString(n).toCharArray();
		int i = a.length - 2; 
		while (i >= 0 && a[i] >= a[i+1]) {
			i--;
		}
		if (i >= 0) {
			Arrays.sort(a, i + 1, a.length); //132446
			int j = i + 1;
			while (j < a.length && a[j] <= a[i])
				j++;
			char tmp = a[j];
			a[j] = a[i];
			a[i] = tmp;
			String nextHigher = String.valueOf(a);
			return Long.parseLong(nextHigher);
		}
		return n; //no higher found
	}
	
	private static long previousSmaller(long n) {
		Character a[] = Long.toString(n).chars().mapToObj(c -> (char)c).toArray(Character[]::new); ;
		int i = a.length - 2; 
		while (i >= 0 && a[i] <= a[i+1]) {
			i--;
		}
		if (i >= 0) {
			Arrays.sort(a, i + 1, a.length, Collections.reverseOrder()); //132446
			int j = i + 1;
			while (j < a.length && a[j] >= a[i])
				j++;
			Character tmp = a[j];
			a[j] = a[i];
			a[i] = tmp;
			StringBuilder sb = new StringBuilder();
			for (int k = 0; k < a.length; k++) {
				sb.append(a[k]);
			}
			return Long.parseLong(sb.toString());
		}
		return n; //no higher found
	}
	
	public static void main(String[] args) {
//		12543 => stop at 2 (2 < 5), then swap 2 with smallest number in the right "3" -> 13542 -> sort numbers in the right of "3" => 13245
//		76543 => no higher
//		1232 => 1322
//		136442 => 142346
		//1. find the pivot which has its value is less than the next right element (3 < 6) -> 3 is the pivot.
		//2. sort ascending all elements in the right of the pivot => 2, 4, 4, 6
		//3. find the first element (4) which is greater than the pivot (3), then swap the pivot (3) with this element (4) => 1, 4, 2, 3, 4, 6
		System.out.println(nextHigher(136442));
		//previous smaller: 8123 -> pivot=8, sort [1, 2, 3] descending => [3, 2, 1] select 3 -> switch 3 & 8 => 3821
		System.out.println(previousSmaller(43322123));
//		43322123 => 4332 2321 => 4332 1322
	}
}
