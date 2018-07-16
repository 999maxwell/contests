import java.util.*;
public class p108ex8 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		String[] outputs = new String[n];
		for (int i = 0; i < n; i++) {
			int x = sc.nextInt();
			String y = "";
			if (x <= 45) {
				y = "N";
			} else if (x > 45 && x <= 135) {
				y = "E";
			} else if (x > 135 && x <= 225) {
				y = "S";
			} else if (x > 225 && x <= 315) {
				y = "W";
			} else if (x > 315 && x <= 360) {
				y = "N";
			}
			outputs[i] = y;
		}
		for (int i = 0; i < outputs.length; i++) {
			System.out.println(outputs[i]);
		}
	}

}
