package hackerrank;

public class CodingPractices {

	public static void main(String[] args) {
		System.out.println(repeatedString("aba", 10));
		System.out.println(kangarooJump(1571, 4240, 9023, 4234));
		System.out.println(timeConversion("12:45:54PM"));
		
		System.out.println(larryArray(new int[]{6, 5, 3, 1, 8, 7, 2, 4}));
		
		selectionSort(new int[]{5, 6, 5, 3, 1, 8, 7, 2, 4});
		bubleSort(new int[]{5, 6, 5, 3, 1, 8, 7, 2, 4});
	}

	private static long repeatedString(String s, long n) {
		long numberOfA = s.chars().filter(ch -> ch == 'a').count();
		long repeatedCount = numberOfA * (n / s.length()) + s.substring(0, (int) (n % s.length())).chars().filter(ch -> ch == 'a').count();
		return repeatedCount;
	}
	
	private static String kangarooJump(int x1, int v1, int x2, int v2) {
		if (x2 <= x1) {
			return "NO";
		}
		if (v2 >= v1) {
			return "NO";
		}
//		int i = 0;
//		while (x1 != x2 && i < 10000) {
//			x1 += v1;
//			x2 += v2;
//			i++;
//		}
//		return i < 10000 ? "YES" : "NO";
		return (x2 - x1) % (v1 - v2) == 0 ? "YES" : "NO";
	}
	
	private static String timeConversion(String s) {
		String apm = s.substring(s.length() - 2);
		String hour = s.substring(0, 2);
		if (apm.equals("AM")) {
			if (Integer.parseInt(hour) == 12) {
				hour = "00";
			}
		} else {
			if (Integer.parseInt(hour) == 12) {
				hour = "12";
			} else {
				hour = Integer.toString(Integer.parseInt(hour) + 12); 
			}
		}
		return hour + s.substring(2, s.length() - 2);
	}
	
	private static String larryArray(int A[]) {
		int swapCount = 0;
		for (int i = 1; i < A.length; i++) {
//			int k = 0;
//			while (k < i && A[k] < A[i])
//				k++;
//			for (int j = i; j > k; j--) {
//				swap(j, j - 1, A);
//				swapCount++;
//			}
			
			int j = i;
			while (j > 0 && A[j] < A[j - 1]) {
				swap(j, j - 1, A);
				j--;
				swapCount++;
			}
		}
		
		return swapCount % 2 == 0 ? "YES" : "NO";
	}
	
	private static void selectionSort(int A[]) {
		for (int i = 0; i < A.length - 1; i++) {
			int minIdx = i;
			for (int j = i + 1; j < A.length; j++) {
				if (A[j] < A[minIdx]) {
					minIdx = j;
				}
			}
			swap(i, minIdx, A);
		}
		System.out.println(A);
	}
	
	private static void insertionSort(int A[]) {
		for (int i = 1; i < A.length - 1; i++) {
			int j = i;
			while (j > 0 && A[j] < A[j - 1]) {
				swap(j, j - 1, A);
				j--;
			}
		}
	}
	
	private static void bubleSort(int A[]) {
		for (int i = A.length - 1; i >= 0; i--) {
			for (int j = 0; j < i; j++) {
				if (A[j] > A[j + 1]) {
					swap(j, j + 1, A);
				}
				printArray(A);
			}
		}
		System.out.println();
	}
	
	private static void printArray(int A[]) {
		for (int i = 0; i < A.length; i++) {
			System.out.print(A[i] + ", ");
		}
		System.out.println();
	}
	private static void swap(int i, int j, int A[]) {
		int tmp = A[i];
		A[i] = A[j];
		A[j] = tmp;
	}
}
