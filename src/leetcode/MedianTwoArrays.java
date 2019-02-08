package leetcode;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.stream.Stream;

//https://leetcode.com/problems/median-of-two-sorted-arrays/description/

public class MedianTwoArrays {

	public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
		PriorityQueue<Integer> minHeap = new PriorityQueue<>();
		PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
		
		int[] nums = new int[nums1.length + nums2.length];
		System.arraycopy(nums1, 0, nums, 0, nums1.length);
		System.arraycopy(nums2, 0, nums, nums1.length, nums2.length);
		for (int i = 0; i < nums.length; i++) {
			if (i % 2 == 0) {
				maxHeap.add(nums[i]);
			} else {
				minHeap.add(nums[i]);
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
        return nums.length % 2 != 0 ? maxHeap.peek() : (maxHeap.peek() + minHeap.peek()) / 2.0;
    }
	
	private static void buildHeaps(PriorityQueue<Integer> heap, int x) {
		
	}
	
	public static void main(String[] args) {
		System.out.println(findMedianSortedArrays(new int[]{1, 2}, new int[]{3, 4}));
	}

}
