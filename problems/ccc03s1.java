import java.util.ArrayList;
import java.util.Scanner;
public class ccc03s1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int pos = 1;
		while (true) {
			int s = sc.nextInt();
			if (s == 0) {
				System.out.println("You Quit!");
				break;
			}
			if (pos + s <= 100) {
				pos += s;
				if (pos == 9) {
					pos = 34;
				} else if (pos == 40) {
					pos = 64;
				} else if (pos == 67) {
					pos = 86;
				} else if (pos == 54) {
					pos = 19;
				} else if (pos == 90) {
					pos = 48;
				} else if (pos == 99) {
					pos = 77;
				}
			}
			
			System.out.println("You are now on square " + pos);
			if (pos == 100) {
				System.out.println("You Win!");
				break;
			}
		}
	}

}
