import java.util.*;
public class ccc13s1 {

	public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
		int input = sc.nextInt() + 1;
		boolean distinct = false;
			for (int i = 0; i <= 9; i++) {
				distinct = true;
				for (int j = 0; j < Integer.toString(input).length(); j++) {
					if (Character.getNumericValue(Integer.toString(input).charAt(j)) == i) {
						if (!distinct) {
							i = -1;
							input++;
							break;
						}
						distinct = false;
					}
				}
			}
		System.out.println(input);
	}
}