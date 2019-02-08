package leetcode;

public class MultiplyString {
	
	public static String multiply(String num, int n) {
		String finalRes = "";
		int i = num.length() - 1;
		int carry = 0;
		while (i >= 0) {
			int m = Character.getNumericValue(num.charAt(i));
			int tmpRes = (m * n) + carry;
			finalRes = Integer.toString(tmpRes % 10) + finalRes;
			carry = tmpRes / 10;
			i--;
		}
		if (carry > 0) {
			finalRes = carry + finalRes;
		}
		return finalRes;
	}
	
	public static String multiply(String num1, String num2) {
		String finalRes = "";
		for (int i = num2.length() - 1; i >= 0; i--) {
			String tmpRes = multiply(num1, Character.getNumericValue(num2.charAt(i)));
			for (int j = num2.length() - 1; j > i; j--) {
				tmpRes = tmpRes + '0';
			}
			finalRes = add(finalRes, tmpRes);
		}
		return finalRes.charAt(0) == '0' ? "0" : finalRes;
    }

	private static String add(String num1, String num2) {
		while(num1.length() < num2.length()) {
			num1 = '0' + num1;
		}
		while(num2.length() < num1.length()) {
			num2 = '0' + num2;
		}
		String result = "";
		int carry = 0;
		int i = num1.length() - 1;
		while (i >= 0) {
			int n1 = Character.getNumericValue(num1.charAt(i));
			int n2 = Character.getNumericValue(num2.charAt(i));
			int n = n1 + n2 + carry;
			result = Integer.toString(n % 10) + result;
			carry = n / 10;
			i--;
		}
		if (carry > 0) {
			result = carry + result;
		}
		return result;
	}

	public static void main(String[] args) {
//		System.out.println(add("1234", "789"));
//		System.out.println(add("36436345645576567567567456453634634664476752323", "56745673474524234758786345344645756856834347453463"));
//		System.out.println(multiply("36436345645576567567567456453634634664476752323", "56745673474524234758786345344645756856834347453463"));
		System.out.println(multiply("1234", "0"));
	}

}
