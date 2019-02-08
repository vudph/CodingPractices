package sorting;

import java.util.Comparator;

public class SortingAlgorithms<T extends Comparable<T>> {
	private Comparator<T> comparator;
	
	public SortingAlgorithms() {
	}
	
	public SortingAlgorithms(Comparator<T> comparator) {
		this.comparator = comparator;
	}
	
	public Comparator<T> getComparator() {
		return comparator;
	}

	public void setComparator(Comparator<T> comparator) {
		this.comparator = comparator;
	}

	private boolean greater(T a, T b) {
        if (comparator == null) {
            return a.compareTo(b) > 0;
        }
        else {
            return comparator.compare(a, b) > 0;
        }
    }
	
	public void selectionSort(T A[]) {
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
	
	public void insertionSort(T A[]) {
		for (int i = 1; i < A.length; i++) {
			int j = i;
			while (j > 0 && greater(A[j - 1], A[j])) {
				swap(j, j - 1, A);
				j--;
			}
		}
	}
	
	public void bubleSort(T A[]) {
		for (int i = A.length - 1; i >= 0; i--) {
			for (int j = 0; j < i; j++) {
				if (greater(A[j], A[j + 1])) {
					swap(j, j + 1, A);
				}
			}
		}
	}
	
	public void quickSort(T A[]) {
		quicksort(A, 0, A.length - 1);
	}
	
	private void quicksort(T[] A, int l, int r) {
		if (r <= l) return;
		int k = partition(A, l, r);
		quicksort(A, l, k - 1);
		quicksort(A, k + 1, r);
	}
	
	private int partition(T[] A, int l, int r) {
		T pivot = A[l];
		int i = l + 1;
		int j = r;
		while (true) {
			while (i <= r && !greater(A[i], pivot)) i++;
			while (j >= l && greater(A[j], pivot)) j--;
			if (i >= j) break;
			swap(i, j, A);
		}
		swap(l, j, A);
//		printArray(A);
		return j;
	}
	
	public T quickSelect(T[] A, int k) {
        if (k < 0 || k >= A.length) {
            throw new IllegalArgumentException("index is not between 0 and " + (A.length - 1) + ": " + k);
        }
        int lo = 0, hi = A.length - 1;
        while (hi > lo) {
            int i = partition(A, lo, hi);
            if (i > k) 
            	hi = i - 1;
            else if (i < k) 
            	lo = i + 1;
            else 
            	return A[i];
        }
        return A[lo];
    }

	private static <T> void printArray(T A[]) {
		for (int i = 0; i < A.length; i++) {
			System.out.print(A[i] + ", ");
		}
		System.out.println();
	}
	
	private void swap(int i, int j, T A[]) {
		T tmp = A[i];
		A[i] = A[j];
		A[j] = tmp;
	}
	
	public static void main(String[] args) {
		SortingAlgorithms<Integer> sort = new SortingAlgorithms<>();
		Integer A[] = new Integer[]{5, 6, 5, 3, 1, 8, 7, 2, 4};
		System.out.print("Input: ");
		printArray(A);
//		System.out.println("Insertion sort");
//		sort.insertionSort(A);
//		printArray(A);
//		System.out.println("Selection sort");
//		sort.selectionSort(A);
//		printArray(A);
//		System.out.println("Bubble sort");
//		sort.bubleSort(A);
//		printArray(A);
		System.out.println("Quick sort");
		sort.quickSort(A);
		printArray(A);
		System.out.println(String.format("Quick select %dth smallest element: ", 8) + sort.quickSelect(A, 8));
		
	}
}
