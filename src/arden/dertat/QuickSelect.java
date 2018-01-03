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
		return k;
	}
	
	private static int quickSelect(int a[], int left, int right, int k) {
		if (left == right) {
			return a[left];
		}
		int pivotIndex = right; //select the last element of a partition is pivot
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

	public static void main(String[] args) {
		int a[] = new int[] {7, 3, 8, 4, 9, 11, 1, 5};
		System.out.println(quickSelect(a, 0, a.length - 1, 6));
	}

}
