import java.util.*;
public class ccc01j2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();
		int m = sc.nextInt();
		int n = 0;
		boolean exists = false;
		for (int i = 0; i <= m; i++) {
			n = i;
			if ((x * n) % m == 1) {
				exists = true;
				break;
			}
		}
		if (exists) {
			System.out.println(n);
		} else {
			System.out.println("No such integer exists.");
		}
	}

}
