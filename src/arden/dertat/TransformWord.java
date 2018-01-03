package arden.dertat;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

import datastructure.SymbolGraph;

public class TransformWord {
	private static SymbolGraph buildGraph(String dictionary[]) {
		List<String> dictionaryList = Arrays.asList(dictionary);
		SymbolGraph sg = new SymbolGraph(dictionary);
		for (int i = 0; i < dictionary.length; i++) {
			String word = dictionary[i];
			for (int j = 0; j < word.length(); j++) {
				// removing a character
				String wordRemoved = removeCharAt(word, j);
				if (dictionaryList.contains(wordRemoved)) {
					sg.G().addEdge(sg.index(word), sg.index(wordRemoved));
				}
				// changing a character
				for (char alphabet = 'a'; alphabet <= 'z'; alphabet++) {
					String wordChanged = changeCharAt(word, j, alphabet);
					if (!wordChanged.equals(word)) {
						if (dictionaryList.contains(wordChanged)) {
							sg.G().addEdge(sg.index(word), sg.index(wordChanged));
						}
					}
				}
			}
			// adding a character
			for (char alphabet = 'a'; alphabet <= 'z'; alphabet++) {
				String wordAdded = word + alphabet;
				if (dictionaryList.contains(wordAdded)) {
					sg.G().addEdge(sg.index(word), sg.index(wordAdded));
				}
			}
		}
		return sg;
	}
	
	public static String[] transformWord(String dictionary[], String words[]) {
		String source = words[0];
		String target = words[1];
		List<String> dictionaryList = Arrays.asList(dictionary);
		if (!dictionaryList.contains(target)) {
			return null; //cannot transform
		}
		SymbolGraph sg = buildGraph(dictionary);
		System.out.println(sg);
		
		Queue<Integer> queue = new LinkedList<>();
		boolean[] marked = new boolean[sg.G().V()];
		int[] edgeTo = new int[sg.G().V()];
		marked[sg.index(source)] = true; // Mark the source
		queue.add(sg.index(source)); // and put it on the queue.
		while (!queue.isEmpty()) {
			int v = queue.poll(); // Remove next vertex from the queue.
			for (int w : sg.G().adj(v))
				if (!marked[w]) // For every unmarked adjacent vertex,
				{
					edgeTo[w] = v; // save last edge on a shortest path,
					marked[w] = true; // mark it because path is known,
					queue.add(w); // and add it to the queue.
				}
		}
		Stack<Integer> path = (Stack<Integer>) pathTo(sg.index(target), sg.index(source), marked, edgeTo);
		String ret[] = new String[path.size()];
		int i = 0;
		while(!path.isEmpty()) {
			ret[i++] = sg.name(path.pop());
		}
		return ret;
	}
	
	private static boolean hasPathTo(int v, boolean marked[]) { 
		return marked[v];
	}
	
	private static Iterable<Integer> pathTo(int v, int s, boolean marked[], int edgeTo[]) {
		if (!hasPathTo(v, marked))
			return null;
		Stack<Integer> path = new Stack<Integer>();
		for (int x = v; x != s; x = edgeTo[x])
			path.push(x);
		path.push(s);
		return path;
	}
	
	private static String removeCharAt(String s, int at) {
		return s.substring(0, at) + s.substring(at + 1);
	}
	
	private static String changeCharAt(String s, int at, char ch) {
		return s.substring(0, at) + ch + s.substring(at + 1);
	}
	
	public static void main(String[] args) {
		String dictionary[] = new String[] {"cat", "bat", "bet", "bed", "at", "ad", "ed"};
		String words[] = new String[] {"cat", "baat"};
		String shortestStep[] = transformWord(dictionary, words);
		if (shortestStep != null) {
			for (String st : shortestStep) {
				System.out.print(st + ", ");
			}
			
		}
	}

}
