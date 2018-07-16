import java.util.*;
public class mockccc14s1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String t = sc.nextLine();
		String tt;
		String p = sc.nextLine();
		StringBuilder sb = new StringBuilder(t);
		sb.reverse();
		tt = sb.toString();
		if (tt.indexOf(p) != -1) {
			System.out.println(t.length() - tt.indexOf(p));
		} else {
			System.out.println(-1);
		}
	}

}
