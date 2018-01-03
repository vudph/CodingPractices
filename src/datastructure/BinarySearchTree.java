package datastructure;

public class BinarySearchTree<K extends Comparable<K>, V> {
	private Node root;
	
	public class Node {
		private K key;
		private V value;
		private Node left, right;
		private int N;
		
		public Node(K key, V value, int N) {
			this.key = key;
			this.value = value;
			this.N = N;
		}
		
		public K getKey() {
			return key;
		}

		public void setKey(K key) {
			this.key = key;
		}

		public V getValue() {
			return value;
		}

		public void setValue(V value) {
			this.value = value;
		}

		public Node getLeft() {
			return left;
		}

		public void setLeft(Node left) {
			this.left = left;
		}

		public Node getRight() {
			return right;
		}

		public void setRight(Node right) {
			this.right = right;
		}

		@Override
		public String toString() {
			return key + "[value=" + value + "]";
		}
	}
	
	public int size() {
		return size(root);
	}
	
	private int size(Node node) {
		if (node == null) 
			return 0;
		return node.N;
	}
	
	public Node getRoot() {
		return root;
	}

	public void put(K key, V value) {
		root = put(root, key, value);
	}

	private Node put(Node node, K key, V value) {
		if (node == null)
			return new Node(key, value, 1);
		int cmp = key.compareTo(node.key);
		if (cmp > 0) {
			node.right = put(node.right, key, value);
		} else if (cmp < 0) {
			node.left = put(node.left, key, value);
		} else {
			node.value = value;
		}
		node.N = size(node.left) + size(node.right) + 1;
		return node;
	}
	
	public V get(K key) {
		return get(root, key);
	}

	private V get(Node node, K key) {
		if (node == null) {
			return null;
		}
		int cmp = key.compareTo(node.key);
		if (cmp > 0) {
			return get(node.right, key);
		} else if (cmp < 0) {
			return get(node.left, key);
		} else {
			return node.value;
		}
	}
	
	public void printInOrder() {
		printInOrder(root);
	}
	
	private void printInOrder(Node node) {
		if (node != null) {
			printInOrder(node.left);
			System.out.println(node);
			printInOrder(node.right);
		}
	}
	
	public void printPostOrder() {
		printPostOrder(root);
	}
	
	private void printPostOrder(Node node) {
		if (node != null) {
			printPostOrder(node.left);
			printPostOrder(node.right);
			System.out.println(node);
		}
	}
	
	public Node trimBST1(K min, K max) {
		return trimBST1(root, min, max);
	}
	
	private Node trimBST1(Node node, K min, K max) {
		if (node == null) {
			return null;
		}
		node.left = trimBST1(node.left, min, max);
		node.right = trimBST1(node.right, min, max);
		int minCmp = node.key.compareTo(min);
		int maxCmp = node.key.compareTo(max);
		if (minCmp < 0) {
			return node.right;
		} else if (maxCmp > 0) {
			return node.left;
		} else {//if (minCmp >= 0 && maxCmp <= 0)
			return node;
		}
	}
	
	public Node trimBST2(K min, K max) {
		return trimBST2(root, min, max);
	}

	private Node trimBST2(Node node, K min, K max) {//traverse by in order (NLR)
		if (node == null) {
			return null;
		}
		int cmpMin = node.key.compareTo(min);
		int cmpMax = node.key.compareTo(max);
		if (cmpMin < 0) {
			return node.right;
		} else if (cmpMax > 0) {
			return node.left;
		} else {
			node.left = trimBST2(node.left, min, max);
			node.right = trimBST2(node.right, min, max);
			return node;
		}
	}

	public int height() {
		return height(root);
	}
	
	private int height(Node node) {
		if (node == null) {
			return -1;
		}
		return 1 + Math.max(height(node.left), height(node.right));
	}

	public K min() {
		return min(root).key;
	}
	
	private Node min(Node node) {
		if (node.left == null) {
			return node;
		}
		return min(node.left);
	}
	
	public boolean isBST(K type) {
		return isBST(root, type);
	}

	private boolean isBST(Node node, K prevNodeKey) {
		if (node == null) {
			return true;
		}
		if (!isBST(node.left, prevNodeKey)) {
			return false;
		}
		if (node.key.compareTo(prevNodeKey) < 0) {
			return false;
		}
		prevNodeKey = node.key;
		return isBST(node.right, prevNodeKey); 
	}
	
	public boolean isBalance() {
		return isBalance(root);
	}

	private boolean isBalance(Node node) {
		if (node == null) {
			return true;
		}
		int h1 = height(node.left);
		int h2 = height(node.right);
		if (Math.abs(h1 - h2) <= 1 && isBalance(node.left) && isBalance(node.right)) {
			return true;
		}
		return false;
	}

	public static void main(String[] args) {
		String keys[] = {"F", "G", "C", "B", "A", "D", "H", "E", "J", "I", "K"};
		BinarySearchTree<String, Integer> bst = new BinarySearchTree<>();
		for (int i = 0; i < keys.length; i++) {
			bst.put(keys[i], i);
		}
		bst.printInOrder();
		System.out.println(bst.min());
		System.out.println(bst.height());
//		System.out.println(bst.isBST("?"));
//		bst.printPostOrder();
		System.out.println(bst.isBalance());
		bst.trimBST1("D", "H");
		bst.printInOrder();
		System.out.println(bst.isBalance());
		
//		List<Transaction> transactions = new ArrayList<>();
//		transactions.add(new Transaction("abc", "D", 334));
//		transactions.add(new Transaction("aaa", "W", 443));
//		transactions.add(new Transaction("ddd", "Z", 555));
//		transactions.add(new Transaction("bbb", "B", 111));
//		transactions.add(new Transaction("ccc", "G", 322));
//		transactions.add(new Transaction("eee", "R", 444));
//		transactions.add(new Transaction("eee", "C", 111));
//		transactions.add(new Transaction("eee", "U", 222));
//		transactions.add(new Transaction("eee", "O", 356));
//		transactions.add(new Transaction("eee", "N", 776));
//		transactions.add(new Transaction("eee", "E", 865));
//		transactions.add(new Transaction("cde", "A", 756));
//		transactions.add(new Transaction("ddd", "D", 967));
//		
//		BinarySearchTree<Transaction, String> bst = new BinarySearchTree<>();
//		for (Transaction transaction : transactions) {
//			bst.put(transaction, transaction.name);
//		}
//		bst.print();
//		System.out.println();
//		String tran = bst.get(new Transaction("ddd", "D", 967));
//		System.out.println(tran);
	}
	
	static class Transaction implements Comparable<Transaction> {
		String name;
		String code;
		double value;
		public Transaction(String n, String key, double value) {
			this.name = n;
			this.code = key;
			this.value = value;
		}
		public String getName() {
			return name;
		}

		public String getCode() {
			return code;
		}
		
		@Override
		public String toString() {
			return "[name=" + name + ",code=" + code + ",value=" + value + "]";
		}
		@Override
		public int compareTo(Transaction o) {
			return this.code.compareTo(o.code);
		}
	}
}
