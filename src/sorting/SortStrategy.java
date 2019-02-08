package sorting;

import java.util.Comparator;

public abstract class SortStrategy<T extends Comparable<T>> {
	private Comparator<T> comparator;
	
	public SortStrategy() {
	}
	
	public SortStrategy(Comparator<T> comparator) {
		this.comparator = comparator;
	}
	
	protected void swap(int i, int j, T A[]) {
		T tmp = A[i];
		A[i] = A[j];
		A[j] = tmp;
	}
	
	protected boolean greater(T a, T b) {
        if (comparator == null) {
            return a.compareTo(b) > 0;
        }
        else {
            return comparator.compare(a, b) > 0;
        }
    }
	
	protected static <T> void printArray(T A[]) {
		for (int i = 0; i < A.length; i++) {
			System.out.print(A[i] + ", ");
		}
		System.out.println();
	}
	
	protected abstract void sort(T[] a);
}
