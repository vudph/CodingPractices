package sorting;

import java.util.Comparator;

public class InsertionSort extends SortStrategy {

	public InsertionSort(Comparator comp) {
		super(comp);
	}
	
	@Override
	protected void sort(Comparable[] A) {
		for (int i = 1; i < A.length; i++) {
			int j = i;
			while (j > 0 && greater(A[j - 1], A[j])) {
				swap(j, j - 1, A);
				j--;
			}
		}
	}
}
