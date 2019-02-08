package sorting;

public class SelectionSort extends SortStrategy {

	@Override
	protected void sort(Comparable[] A) {
		for (int i = 0; i < A.length - 1; i++) {
			int minIdx = i;
			for (int j = i + 1; j < A.length; j++) {
				if (greater(A[minIdx], A[j])) {
					minIdx = j;
				}
			}
			swap(i, minIdx, A);
		}
	}

}
