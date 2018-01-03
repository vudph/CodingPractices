package arden.dertat;

import java.util.Collections;
import java.util.PriorityQueue;

//http://www.ardendertat.com/2011/11/03/programming-interview-questions-13-median-of-integer-stream/
//median is the middle element in an odd length sorted array, and in the even case it’s the average of the middle elements.

public class MedianElement {
	private static double medianElement(int input[]) {
		PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
		PriorityQueue<Integer> minHeap = new PriorityQueue<>();
		
		for (int i = 0; i < input.length; i++) {
			if (i % 2 == 0) {
				maxHeap.add(input[i]);
			} else {
				minHeap.add(input[i]);
			}
			if (!minHeap.isEmpty()) {
				if (maxHeap.peek() > minHeap.peek()) {
					int fromMax = maxHeap.poll();
					int fromMin = minHeap.poll();
					minHeap.add(fromMax);
					maxHeap.add(fromMin);
				}
			}
		}
		return input.length % 2 != 0 ? maxHeap.peek() : (maxHeap.peek() + minHeap.peek()) / 2.0;
	}
	
	public static void main(String[] args) {
		int a[] = new int[] {-50, 50, 10};
		System.out.println(medianElement(a));
	}
}
