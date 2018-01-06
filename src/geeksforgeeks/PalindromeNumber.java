package geeksforgeeks;

//https://www.geeksforgeeks.org/check-binary-representation-number-palindrome/

public class PalindromeNumber {
	private static boolean isKthBitSet(long x, int k) {
	    return (x & (1 << (k-1))) > 0 ? true : false;
	}
	private static int log2(long value) {
	    return Long.SIZE - Long.numberOfLeadingZeros(value);
	}
	private static boolean isPalindrome(long n){
		String bin = Long.toBinaryString(n);
		System.out.println(bin);
//		for (int i = 0; i < bin.length()/2; i++) {
//			if (bin.charAt(i) != bin.charAt(bin.length() - 1 - i)) {
//				return false;
//			}
//		}
		
		int l = 1;
		int r = log2(n);
		System.out.println(r);
		while (l < r)
	    {
	        if (isKthBitSet(n, l) != isKthBitSet(n, r))
	            return false;
	        l++;     
	        r--;
	    }
		return true;
	}
	
	private static long bitAtKth(long n, int k) {
		return (n & (1 << (k-1)));
	}

	public static void main(String[] args) {
		System.out.println(isPalindrome(999));
		System.out.println(17 & (1 << 0));
	}

}
