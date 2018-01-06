package geeksforgeeks;

import java.util.Arrays;

public class BinPacking {
	
	static int firstFit(int weight[], int n, int c) {
		// Initialize result (Count of bins)
		int res = 0;

		// Create an array to store remaining space in bins
		// there can be at most n bins
		int bin_rem[] = new int[n];

		// Place items one by one
		for (int i = 0; i < n; i++) {
			// Find the first bin that can accommodate
			// weight[i]
			int j;
			for (j = 0; j < res; j++) {
				if (bin_rem[j] >= weight[i]) {
					bin_rem[j] = bin_rem[j] - weight[i];
					break;
				}
			}

			// If no bin could accommodate weight[i]
			if (j == res) {
				bin_rem[res] = c - weight[i];
				res++;
			}
		}
		return res;
	}

	public static void main(String[] args) {
		int weight[] = {2, 5, 4, 7, 1, 3, 8};
	    int c = 10;
//	    Arrays.sort(weight);
	    weight = Arrays.stream(weight).boxed()
	            .sorted((i1, i2) -> Integer.compare(i2, i1))
	            .mapToInt(Integer::intValue).toArray();
	            
		System.out.println(firstFit(weight, weight.length, c));
	}

}
