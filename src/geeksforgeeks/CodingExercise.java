package geeksforgeeks;

public class CodingExercise {
	
	public static void main(String[] args) {
		System.out.println(findLargest(3, 20)); 
	}
	
	// The largest number with given digit sum s and number of digits d.
	// Example: s = 9, d = 2 => 90; s = 20, d = 3 => 992; s = 7, d = 1 => 7; s = 11, d = 1 => -1;
	private static String findLargest(int d, int s) {
		if (d <= 0) {
			return "-1";
		}
		int digits[] = new int[d];
		for (int i = 0; i < d; i++) {
			if (s - 9 >= 0) {
				digits[i] = 9;
				s = s - 9;
			} else {
				digits[i] = s;
				s = 0;
			}
		}
		if (s > 0) {
			return "-1";
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < digits.length; i++) {
			sb.append(Integer.toString(digits[i]));
		}
		return sb.toString();
	}
}
