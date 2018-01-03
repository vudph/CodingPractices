package arden.dertat;

public class ReverseWords {

	private static String reverse(String input) {
		input = input.trim().replaceAll(" +", " ");
		
		String words[] = input.split(" ");
		StringBuilder sb = new StringBuilder();
		for (int i = words.length - 1; i >= 0; i--) {
			sb.append(words[i]).append(" ");
		}
		String output = sb.toString();
		output = output.substring(0, output.length() - 1);
		return output;
	}
	
	public static void main(String[] args) {
		System.out.println(reverse("Vu  bv        "));
	}
}
