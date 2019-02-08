package string;

import java.util.Arrays;

public class VersionHelper {

	public static int compare(String v1, String v2) { //"0.0.0.2", "0.1"
		String v1a[] = v1.split("\\.");
		String v2a[] = v2.split("\\.");
		if (v1a.length > v2a.length) {
			String v2atmp[] = Arrays.copyOf(v2a, v1a.length);
			for (int i = v2a.length; i < v2atmp.length; i++) {
				v2atmp[i] = "0";
			}
			v2a = v2atmp;
		} else if (v1a.length < v2a.length) {
			String v1atmp[] = Arrays.copyOf(v1a, v2a.length);
			for (int i = v1a.length; i < v1atmp.length; i++) {
				v1atmp[i] = "0";
			}
			v1a = v1atmp;
		}
		long v1l = 0;
		long v2l = 0;
		for (int i = v1a.length - 1; i >= 0; i--) {
			v1l += Integer.parseInt(v1a[v1a.length - i - 1]) * Math.pow(10, i);
			v2l += Integer.parseInt(v2a[v1a.length - i - 1]) * Math.pow(10, i);
		}
		if (v1l > v2l) {
			return 1;
		} else if (v1l < v2l) {
			return -1;
		}
		return 0; 
	}
	
//	public static int compare(String str1, String str2) {
//	    String[] vals1 = str1.split("\\.");
//	    String[] vals2 = str2.split("\\.");
//	    int i = 0;
//	    // set index to first non-equal ordinal or length of shortest version string
//	    while (i < vals1.length && i < vals2.length && vals1[i].equals(vals2[i])) {
//	      i++;
//	    }
//	    // compare first non-equal ordinal number
//	    if (i < vals1.length && i < vals2.length) {
//	        int diff = Integer.valueOf(vals1[i]).compareTo(Integer.valueOf(vals2[i]));
//	        return Integer.signum(diff);
//	    }
//	    // the strings are equal or one string is a substring of the other
//	    // e.g. "1.2.3" = "1.2.3" or "1.2.3" < "1.2.3.4"
//	    return Integer.signum(vals1.length - vals2.length);
//	}	
	
	public static void main(String[] args) {
		compare("0.0.0.2", "0.1");
	}

}
