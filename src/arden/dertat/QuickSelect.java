package arden.dertat;

public class QuickSelect {
	private static int partition(int a[], int left, int right, int pivotIndex) {
		int pivotValue = a[pivotIndex];
		int k = left;
		for (int i = left; i < right; i++) {
			if (a[i] < pivotValue) {
				swap(a, i, k);
				k++;
			}
		}
		swap(a, k, right);
		printArray(a);
		System.out.println();
		return k;
	}
	private static int quickSelect(int a[], int left, int right, int k) {
		if (left == right) {
			return a[left];
		}
		int pivotIndex = left; //select the last element of a partition is pivot
		pivotIndex = partition(a, left, right, pivotIndex);
		if (k - 1 == pivotIndex) {
			return a[k - 1];
		}
		if (pivotIndex > k - 1) { //
			int newright = pivotIndex - 1;
			return quickSelect(a, left, newright, k);
		} else {
			int newleft = pivotIndex + 1;
			return quickSelect(a, newleft, right, k);
		}
	}
	private static void swap(int[] a, int i, int k) {
		int tmp = a[i];
		a[i] = a[k];
		a[k] = tmp;
	}
	private static void printArray(int A[]) {
		for (int i = 0; i < A.length; i++) {
			System.out.print(A[i] + ", ");
		}
		System.out.println();
	}
	public static void main(String[] args) {
		int a[] = new int[] {5, 6, 5, 3, 1, 8, 7, 2, 4};
		System.out.println(quickSelect(a, 0, a.length - 1, 6));
	}
}
