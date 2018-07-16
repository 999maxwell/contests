import java.util.*;
public class valentines18j3 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		String[] name = new String[n];
		int[] cute = new int[n];
		int[] cuteSort = new int[n];
		for (int i = 0; i < n; i++) {
			name[i] = sc.next();
			int c = sc.nextInt();
			cute[i] = c;
			cuteSort[i] = c;
		}
		Arrays.sort(cuteSort);
		for (int i = 0; i < n; i++) {
			if (cute[i] > cuteSort[n / 2]) {
				System.out.println(name[i] + " is cute! <3");
			} else {
				System.out.println(name[i] + " is not cute. </3");
			}
		}
	}

}
