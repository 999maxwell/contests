import java.util.Arrays;
import java.util.Scanner;
public class ccc06s2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String p = sc.nextLine();
		String c1 = sc.nextLine();
		String c2 = sc.nextLine();
		char[] normal = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', ' '};
		char[] code = new char[27];
		for (int i = 0; i < p.length(); i++) {
			char c = p.charAt(i); 
			for (int j = 0; j < normal.length; j++) {
				if (normal[j] == c) {
					code[j] = c1.charAt(i);
				}
			}
		}
		String output = "";
		for (int i = 0; i < c2.length(); i++) {
			char c = c2.charAt(i);
			boolean flag = false;
			for (int j = 0; j < code.length; j++) {
				if (code[j] == c) {
					output += normal[j];
					flag = true;
					break;
				}
			}
			if (!flag) {
				output += ".";
			}
		}
		System.out.println(output);
	}

}
