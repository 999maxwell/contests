import java.util.Scanner;
import java.util.Arrays;
public class nccc3j3s1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		int[] alphabet = new int[26];
		String list = "abcdefghijklmnopqrstuvwxyz";
		for (int i = 0; i < s.length(); i++) {
			for (int j = 0; j < 26; j++) {
				if (s.charAt(i) == list.charAt(j)) {
					alphabet[j]++;
				}
			}
		}
		Arrays.sort(alphabet);
		int count = 0;
		for (int i = 0; i < 24; i++) {
			count += alphabet[i];
		}
		System.out.println(count);
	}

}
