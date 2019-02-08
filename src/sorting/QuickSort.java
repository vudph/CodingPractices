package sorting;

import java.util.Comparator;

public class QuickSort extends SortStrategy {
	
	public QuickSort(Comparator comparator) {
		super(comparator);
	}

	@Override
	protected void sort(Comparable[] A) {
		quicksort(A, 0, A.length - 1);
	}
	
	private void quicksort(Comparable[] A, int l, int r) {
		if (r <= l) return;
		int k = partition(A, l, r);
		quicksort(A, l, k - 1);
		quicksort(A, k + 1, r);
	}
	
	protected int partition(Comparable[] A, int l, int r) {
		Comparable pivot = A[l];
		int i = l + 1;
		int j = r;
		while (true) {
			while (i <= r && !greater(A[i], pivot)) i++;
			while (j >= l && greater(A[j], pivot)) j--;
			if (i >= j) break;
			swap(i, j, A);
		}
		swap(l, j, A);
		return j;
	}
}
