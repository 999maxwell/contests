import java.util.Scanner;
public class TODOccc09j4 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int w = sc.nextInt();
		String[] s = new String[6];
		s[0] = "WELCOME";
		s[1] = "TO";
		s[2] = "CCC";
		s[3] = "GOOD";
		s[4] = "LUCK";
		s[5] = "TODAY";
		int b = 0;
		for (int a = 0; a < 2; a++) {
			boolean lastline = true;
			int bb = b;
			int length = s[b].length();
			//System.out.println(s[b]);
			for (int i = b + 1; i < 6; i++) {
				if (length + s[i].length() > w) {
					b = i;
					lastline = false;
					break;
				} else {
					length += s[i].length();
				}
			}
			if (lastline) {
				b = 6;
			}
			int[] dots = new int[b - bb - 1];
			int cycle = 0;
			for (int i = 0; i < w - length; i++) {
				dots[cycle]++;
				cycle++;
				if (cycle >= dots.length) {
					cycle = 0;
				}
			}
			String line = s[bb];
			boolean flag = false;
			for (int i = bb + 1; i < b; i++) {
				for (int j = 0; j < dots[i - bb - 1]; j++) {
					line += ".";
				}
				line += s[i];
				if (s[i].equals("TODAY")) {
					flag = true;
				}
			}
			System.out.println(line);
			if (flag) {
				break;
			}
		}
	}

}
