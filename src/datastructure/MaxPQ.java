package datastructure;

import java.util.NoSuchElementException;

public class MaxPQ<E extends Comparable<E>> {
	private E[] pq;
	private int N = 0;

	public MaxPQ(int maxN) {
		pq = (E[]) new Comparable[maxN + 1];
	}
	
	public MaxPQ() {
        this(1);
    }

	public boolean isEmpty() {
		return N == 0;
	}

	public int size() {
		return N;
	}

	public void insert(E v) {
		// double size of array if necessary
//        if (N == pq.length - 1) 
//        	resize(2 * pq.length);
		pq[++N] = v;
		swim(N);
	}

	public E delMax() {
        if (isEmpty()) throw new NoSuchElementException("Priority queue underflow");
        E max = pq[1];
        exch(1, N--);
        pq[N + 1] = null;     // to avoid loiterig and help with garbage collection
        sink(1);
//        if ((N > 0) && (N == (pq.length - 1) / 4)) 
//        	resize(pq.length / 2);
        return max;
    }

	private void swim(int k) {
		while (k > 1 && less(k / 2, k)) {
			exch(k / 2, k);
			k = k / 2;
		}
	}

	private void sink(int k) {
		while (2 * k <= N) {
			int j = 2 * k;
			if (j < N && less(j, j + 1))
				j++;
			if (!less(k, j))
				break;
			exch(k, j);
			k = j;
		}
	}
	
	private void resize(int capacity) {
        E[] temp = (E[]) new Comparable[capacity];
        for (int i = 1; i <= N; i++) {
            temp[i] = pq[i];
        }
        pq = temp;
    }
	
	private boolean less(int i, int j) {
		return ((Comparable<E>) pq[i]).compareTo(pq[j]) < 0;
	}

	private void exch(int i, int j) {
		E swap = pq[i];
		pq[i] = pq[j];
		pq[j] = swap;
	}
	
	public static void main(String[] args) {
		int key[] = new int[] {2, 3, 8, 5, 1, 9, 10};//, 7, 0, 4, 11};
		String value[] = new String[] {"two", "three", "eight", "five", "one", "nine", "ten"};//, "seven", "zero", "four", "eleven"};
		
		MaxPQ<MyObj<String>> pq = new MaxPQ<MyObj<String>>(key.length);
		for (int i = 0; i < key.length; i++) {
			pq.insert(new MyObj<String>(key[i], value[i]));
		}
		while (!pq.isEmpty()) {
			System.out.print(pq.delMax().getValue() + ", ");
		}
	}
	
	static class MyObj<T> implements Comparable<MyObj<T>> {
		Integer key;
		T value;
		public MyObj(Integer key, T value) {
			this.key = key;
			this.value = value;
		}
		
		@Override
		public int compareTo(MyObj<T> o) {
			return Integer.compare(key, o.key);
		}
		
		public T getValue() {
			return value;
		}
		
		@Override
		public String toString() {
			return value.toString();
		}
	}
}


