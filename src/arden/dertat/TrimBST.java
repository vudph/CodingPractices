package arden.dertat;

import datastructure.BinarySearchTree;
import datastructure.BinarySearchTree.Node;

public class TrimBST {
	private static void trimBST(BinarySearchTree<String, Integer> bst, String from, String to) {
		trimBSTHelper(bst.getRoot(), from, to);
	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private static Node trimBSTHelper(Node node, String from, String to) {
		if (node == null) {
			return null;
		}
		node.setLeft(trimBSTHelper(node.getLeft(), from, to));
		node.setRight(trimBSTHelper(node.getRight(), from, to));
		int cpmMin = node.getKey().compareTo(from);
		int cpmMax = node.getKey().compareTo(to);
		if (cpmMin < 0) {
			return node.getRight();
		} else if (cpmMax > 0) {
			return node.getLeft();
		} else {
			return node;
		}
	}

	public static void main(String[] args) {
		String keys[] = {"F", "G", "C", "B", "A", "D", "H", "E", "J", "I", "K"};
		BinarySearchTree<String, Integer> bst = new BinarySearchTree<>();
		for (int i = 0; i < keys.length; i++) {
			bst.put(keys[i], i);
		}
		bst.printInOrder();
		System.out.println("After triming!");
		trimBST(bst, "D", "J");
		bst.printInOrder();
	}

}
