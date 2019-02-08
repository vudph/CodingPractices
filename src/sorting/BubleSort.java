package sorting;

public class BubleSort extends SortStrategy {

	@Override
	protected void sort(Comparable[] A) {
		for (int i = A.length - 1; i >= 0; i--) {
			for (int j = 0; j < i; j++) {
				if (greater(A[j], A[j + 1])) {
					swap(j, j + 1, A);
				}
			}
		}
	}
}
