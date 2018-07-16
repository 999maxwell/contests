import java.util.Scanner;
public class dmpg18b5 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		int k = sc.nextInt();
		int count = 0;
		for (int i = 0; i <= s.length() - k; i++) {
			boolean valid = true;
			char c = s.charAt(i);
			for (int j = i; j < i + k; j++) {
				if (s.charAt(j) != c) {
					valid = false;
				}
			}
			if (valid) {
				count++;
			}
		}
		System.out.println(count);
	}

}
