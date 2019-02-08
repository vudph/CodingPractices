package leetcode;

//https://leetcode.com/problems/maximum-average-subarray-i/description/

public class MaxAvgSubArray {
	
	private static double find(int a[], int k) {
		int sum[] = new int[a.length];
		sum[0] = a[0];
		for (int i = 1; i < a.length; i++) {
			sum[i] = sum[i - 1] + a[i];
		}
//		1, 12, -5, -6, 50, 3
//		1, 13,  8,  2, 52, 55 
//		in order to find the sum of elements from i - k to i (i >= k), all we need to do is to use: sum[i] - sum[i-k]
//		e.g. sum at i = 5 => sum[5] - sum[5-4] = 55 - 13 = 42
		double res = (sum[k - 1] * 1.0) / k;
		for (int i = k; i < a.length; i++) {
			int sumAt = sum[i] - sum[i - k];
			res = Math.max(res, (sumAt * 1.0) / k);
		}
		
		return res;
	}
	
	private static double find1(int a[], int k) {
		int sum = 0;
		for (int i = 0; i < k; i++) {
			sum += a[i];
		}
		int res = sum;
		for (int i = k; i < a.length; i++) {
			sum = (sum - a[i - k]) + a[i];
			res = Math.max(res, sum);
		}
		return res*1.0/k;
	}
	
	public static void main(String[] args) {
		int input[] = {1, 12, -5, -6, 50, 3};
		int k = 4;
		System.out.println(find(input, k));
	}

}
