package sorting;

public class Sorter {
	private SortStrategy sort;
	
	public Sorter(SortStrategy sort) {
		this.sort = sort;
	}
	
	public void sort(Comparable[] A) {
		this.sort.sort(A);
	}

	public SortStrategy getSort() {
		return sort;
	}
	
	public void setSort(SortStrategy sort) {
		this.sort = sort;
	}
	
	public void print(Comparable[] A) {
		this.sort.printArray(A);
	}
}
