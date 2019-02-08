package codility;

public class BusTicketCost {

	public static void main(String[] args) {
		int[] arr = { 1, 7, 8, 9, 10, 15, 16, 17, 18, 21, 25 };
		int[] arr1 = { 1, 2, 4, 5, 7, 8, 9, 10, 11, 12, 29, 30 };
		int[] tDays = { 1, 7, 30 };
		int[] tCost = { 2, 7, 25 };
		System.out.println(minCost(arr, tDays, tCost));
		System.out.println(minCost(arr));
	}
	
	public static int minCost(int arr[]) {
		if (arr.length > 24) {
			return 25;
		}
		if (arr.length < 4) {
			return arr.length * 2;
		}
		int daysOfMonth = 31;
		boolean daysOfTrip[] = new boolean[31];
		int cost[] = new int[31];
		cost[0] = 0;
		
		for (int i = 0; i < daysOfMonth; i++) {
			daysOfTrip[i] = false;
		}
		for (int i = 0; i < arr.length; i++) {
			daysOfTrip[arr[i]] = true;
		}
		for (int i = 1; i < daysOfMonth; i++) {
			if (!daysOfTrip[i]) {
				cost[i] = cost[i - 1];
			} else {
				if (i <= 7) {
					cost[i] = Math.min(cost[i - 1] + 2, 7);
				} else if (i > 7 && i <= 14) {
					cost[i] = Math.min(cost[i - 1] + 2, 14);
				} else if (i > 14 && i <= 21) {
					cost[i] = Math.min(cost[i - 1] + 2, 21);
				} else {
					cost[i] = Math.min(cost[i - 1] + 2, 25);
				}
				
			}
		}
		return cost[30];
	}
	
	public static int minCost1(int arr[]) {
		boolean[] isDayWithTrip = new boolean[31]; // note: initializes to false
		for (final int dayWithTrip : arr) {
		    isDayWithTrip[dayWithTrip] = true;
		}
		
		int[] minCostUpThroughDay = new int[31];
		minCostUpThroughDay[0] = 0; // technically redundant
		for (int d = 1; d <= 30; ++d) {
		    if (! isDayWithTrip[d]) {
		        minCostUpThroughDay[d] = minCostUpThroughDay[d-1];
		        continue;
		    }

		    int minCost;
		    // Possibility #1: one-day pass on day d:
		    minCost = minCostUpThroughDay[d-1] + 2;
		    // Possibility #2: seven-day pass ending on or after day d:
		    for (int prevD = Math.max(0, d - 7); prevD <= d - 4; ++prevD) {
		        minCost = Math.min(minCost, minCostUpThroughDay[prevD] + 7);
		    }
		    // Possibility #3: 30-day pass for the whole period:
		    minCost = Math.min(minCost, 25);

		    minCostUpThroughDay[d] = minCost;
		}
		return minCostUpThroughDay[30];
	}

	public static int minCost(int[] arr, int[] tDays, int[] tCost) {
		int[][] dp = new int[arr.length][tDays.length];

		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < tDays.length; j++) {
				int prevDayIndex = findPrevDayIndex(arr, i, tDays, j);
				int prevCost = prevDayIndex >= 0 ? dp[prevDayIndex][tDays.length - 1] : 0;
				int currCost = prevCost + tCost[j];
				if (j - 1 >= 0) {
					currCost = Math.min(currCost, dp[i][j - 1]);
				}
				dp[i][j] = currCost;
			}
		}
//		 print(dp);                           
		return dp[arr.length - 1][tDays.length - 1];
	}

	private static void print(int arr[][]) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}

	private static int findPrevDayIndex(int[] arr, int i, int[] days, int j) {
		int validAfterDate = arr[i] - days[j];
		if (validAfterDate < 1) {
			return -1;
		}
		for (int k = i - 1; k >= 0; k--) {
			if (arr[k] <= validAfterDate) {
				return k;
			}
		}
		return -1;
	}

}
