package datastructure;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class MinPQ<T> {
	private T pq[];
	private int N = 0;
	private Comparator<T> comparator;
	
	public MinPQ(int size, Comparator<T> comp) {
		this.comparator = comp;
		this.pq = (T[]) new Object[size + 1];
	}
	
	public void insert(T item) {
		pq[++N] = item;
		swim(N);
	}
	
	public void swim(int k) {
		while(k > 1 && greater(k/2, k)) {
			exch(k/2, k);
			k = k/2;
		}
	}
	
	public T removeMin() {
		T min = pq[1];
		exch(1, N);
		pq[N--] = null;
		sink(1);
		return min;
	}
	
	public void sink(int k) {
		while (k * 2 <= N) {
			int j = k * 2;
			if (j < N && greater(j, j + 1)) {
				j = j + 1;
			}
			if (greater(k, j)) {
				exch(k, j);
				k = j;
			} else {
				break;
			}
		}
	}
	
	public boolean isEmpty() {
		return N == 0;
	}
	
	public boolean greater(int i, int j) {
		return comparator.compare(pq[i], pq[j]) > 0;
	}
	
	public void exch(int i, int j) {
		T tmp = pq[i];
		pq[i] = pq[j];
		pq[j] = tmp;
	}
	
	public static void main(String[] args) {
		List<Transaction> transactions = new ArrayList<>();
		transactions.add(new Transaction("abc", "111", "D"));
		transactions.add(new Transaction("aaa", "222", "W"));
		transactions.add(new Transaction("ddd", "345", "Z"));
		transactions.add(new Transaction("bbb", "123", "B"));
		transactions.add(new Transaction("ccc", "234", "G"));
		transactions.add(new Transaction("eee", "434", "R"));
		transactions.add(new Transaction("eee", "565", "C"));
		transactions.add(new Transaction("eee", "232", "U"));
		transactions.add(new Transaction("eee", "676", "O"));
		transactions.add(new Transaction("eee", "233", "N"));
		transactions.add(new Transaction("eee", "343", "E"));
		transactions.add(new Transaction("cde", "113", "A"));
		MinPQ<Transaction> pq = new MinPQ<>(transactions.size(), new TransactionComparator());
		for (Transaction trans : transactions) {
			pq.insert(trans);
		}
		while(!pq.isEmpty()) {
			System.out.print(pq.removeMin() + ", ");
		}
	}
	
	static class Transaction {
		String name;
		String time;
		String key;
		public Transaction(String n, String t, String v) {
			this.name = n;
			this.time = t;
			this.key = v;
		}
		public String getName() {
			return name;
		}
		public String getTime() {
			return time;
		}
		public String getKey() {
			return key;
		}
		
		@Override
		public String toString() {
			return getKey() + "[name=" + name + ",time=" + time + "]";
		}
	}
	
	static class TransactionComparator implements Comparator<Transaction> {
		@Override
		public int compare(Transaction o1, Transaction o2) {
			return o1.key.compareTo(o2.key);
		}
	}
}
