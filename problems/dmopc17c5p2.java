import java.util.Scanner;
public class dmopc17c5p2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		int n = sc.nextInt();
		for (int i = 0; i < n; i++) {
			int sub = sc.nextInt();
			int occur = sc.nextInt();
			int digit = sc.nextInt();
			int count = 0;
			int output = 0;
			boolean b = false;
			for (int j = sub - 1; j < s.length(); j++) {
				output = j + 1;
				if (Character.getNumericValue(s.charAt(j)) == digit) {
					count++;
					if (count == occur) {
						b = true;
						break;
					}
				}
			}
			if (b) {
				System.out.println(output);
			} else {
				System.out.println(-1);
			}
		}
	}

}
