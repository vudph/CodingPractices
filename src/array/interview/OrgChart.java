package array.interview;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class OrgChart {
	static class ChartNode<T> {
		List<ChartNode<T>> children;
		ChartNode<T> parent;
		T data;
		public ChartNode(T data) {
			this.data = data;
		}
	}
	
	private static void printOrgChart(String input[]) {
		Map<String, ChartNode<String>> mapNodes = new HashMap<>();
		for (int i = 0; i < input.length; i++) {
			String n[] = input[i].split(", ");
			ChartNode<String> parentNode;
			if (mapNodes.containsKey(n[0])) {
				parentNode = mapNodes.get(n[0]);
			} else {
				parentNode = new ChartNode<String>(n[0]);
				mapNodes.put(n[0], parentNode);
			}
			List<ChartNode<String>> childrenNodes = new ArrayList<>();
			for (int j = 1; j < n.length; j++) {
				ChartNode<String> childNode;
				if (mapNodes.containsKey(n[j])) {
					childNode = mapNodes.get(n[j]);
				} else {
					childNode = new ChartNode<String>(n[j]);
					mapNodes.put(n[j], childNode);
				}
				childrenNodes.add(childNode);
				childNode.parent = parentNode;
			}
			if (!childrenNodes.isEmpty()) {
				parentNode.children = childrenNodes;
			}
		}
		Iterator<ChartNode<String>> iter = mapNodes.values().iterator();
		while (iter.hasNext()) {
			ChartNode<String> node = iter.next();
			if (node.parent == null) { //top level
				printChart(node, 0);
			}
		}
	}
	
	private static void printChart(ChartNode<String> node, int level) {
		for (int i = 0; i < level; i++) {
			System.out.print("  ");
		} 
		System.out.println(node.data);
		if(node.children != null) {
			for (int i = 0; i < node.children.size(); i++) {
				printChart(node.children.get(i), level + 1);
			}
		}
	}

	public static void main(String[] args) {
		// a1, c1, b1
		// c1, c2, c3
		// b1, b2, b3
		// c2, d1, d2, d3
		// c3, e1, a2, a3
		// e2, e3, f1, f2
		// e3, e4, e5, e6
		// g, a1, e2
//		a1
//		  c1
//		    c2
//		      d1
//		      d2
//		      d3
//		    c3
//		      e1
//		      a2
//		      a3
//		  b1  
//		    b2
//		    b3
//		e2
//		  e3
//		  f1
//		  f2
		
		String input[] = {"d1, h1", "a1, c1, b1", "c1, c2, c3", "b1, b2, b3", "c2, d1, d2, d3", "c3, e1, a2, a3",  "e2, e3, f1, f2", "e3, e4, e5, e6", "g, a1, e2"};
		printOrgChart(input);
		  
	}

}
