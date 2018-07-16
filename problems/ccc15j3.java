import java.util.*;
public class ccc15j3 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();
		for (int i = 0; i < input.length(); i++) {
			switch (input.charAt(i)) {
				case 'a':
					break;
				case 'e':
					break;
				case 'i':
					break;
				case 'o':
					break;
				case 'u':
					break;
				default:
					input = input.substring(0, i) + findReplacement(input.charAt(i)) + input.substring(i + 1);
					i += 2;
					break;
			}
		}
		System.out.println(input);
	}
	public static String findReplacement(char c) {
		int[] vowels = {10, 14, 18, 24, 30};
		int difference = 30;
		int index = 0;
		char vowel;
		char consonant = 0;
		boolean consonantTest = true;
		for (int i = 0; i < vowels.length; i++) {
			if (consonantTest) {
				if (vowels[i] - Character.getNumericValue(c) == 1) {
					consonant = Character.valueOf((char) (Character.getNumericValue(c) + 89));
					consonantTest = false;
					if (c == 'z'){
						consonant = 'z';
					}
				} else {
					consonant = Character.valueOf((char) (Character.getNumericValue(c) + 88));
					if (c == 'z'){
						consonant = 'z';
					}
				}
			}
			if (Math.abs(vowels[i] - Character.getNumericValue(c)) < difference) {
				difference = Math.abs(vowels[i] - Character.getNumericValue(c));
				index = i;
			}
		}
		vowel = Character.valueOf((char) (vowels[index] + 87));
		return "" + c + vowel + consonant;
	}
}
