package leetcode;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {

	public static int[] twoSum(int[] nums, int target) {
		Map<Integer, Integer> set = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			int complement = target - nums[i];
			if (set.containsKey(complement)) {
				return new int[]{set.get(complement), i};
			} else {
				set.put(nums[i], i);
			}
		}
		return null;
	}

	public static void main(String[] args) {
		int a[] = twoSum(new int[]{2, 10, 11, 7, 15}, 9);
		System.out.print(a[0] + ", " + a[1]);
	}

}
