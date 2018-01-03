package arden.dertat;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import datastructure.BinarySearchTree;
import datastructure.BinarySearchTree.Node;

public class TreeLevelOrderPrint {

	@SuppressWarnings({ "rawtypes"})
	private static String printTreeLevelOrder(Node root) {
		Queue<Node> queue = new LinkedList<>();
		queue.add(root);
		int currentLevel = 1;
		int nextLevel = 0;
		StringBuilder sb = new StringBuilder();
		while (!queue.isEmpty()) {
			Node node = queue.poll();
			currentLevel--;
			sb.append(node.getKey());
			if (node.getLeft() != null) {
				queue.add(node.getLeft());
				nextLevel++;
			}
			if (node.getRight() != null) {
				queue.add(node.getRight());
				nextLevel++;
			}
			if (currentLevel == 0) {
				sb.append("\n");
				currentLevel = nextLevel;
				nextLevel = 0;
			}
		}
		return sb.toString();
	}
	
	@SuppressWarnings({ "rawtypes" })
	private static String printReverseTreeLevelOrder(Node root) {
		Queue<Node> queue = new LinkedList<>();
		queue.add(root);
		int currentLevel = 1;
		int nextLevel = 0;
		StringBuilder sb = new StringBuilder();
		
		Stack<String> stack = new Stack<>();
		
		while (!queue.isEmpty()) {
			Node node = queue.poll();
			currentLevel--;
			sb.append(node.getKey());
			if (node.getLeft() != null) {
				queue.add(node.getLeft());
				nextLevel++;
			}
			if (node.getRight() != null) {
				queue.add(node.getRight());
				nextLevel++;
			}
			if (currentLevel == 0) {
				sb.append("\n");
				stack.push(sb.toString());
				currentLevel = nextLevel;
				nextLevel = 0;
				sb.setLength(0);
			}
		}
		sb.setLength(0);
		while (!stack.isEmpty()) {
			sb.append(stack.pop());
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		BinarySearchTree<Integer, Integer> bst = new BinarySearchTree<>();
		int key[] = { 4, 2, 1, 3, 7, 5, 6, 8, 9 };
		for (int i = 0; i < key.length; i++) {
			bst.put(key[i], key[i]);
		}
		System.out.println(printTreeLevelOrder(bst.getRoot()));
		System.out.println(printReverseTreeLevelOrder(bst.getRoot()));
	}

}
