import java.util.*;
public class ccc06j3 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (true) {
			String input = sc.nextLine();
			int time = 0;
			int last = -1;
			if (input.equals("halt")) {
				break;
			}
			for (int i = 0; i < input.length(); i++) {
				int charGroup = 0;
				for (int j = 0; j < 5; j++) {
					if (Character.getNumericValue(input.charAt(i)) >= (j * 3) + 10 && Character.getNumericValue(input.charAt(i))
							<= (j * 3) + 12) {
						time += Character.getNumericValue(input.charAt(i)) - (9 + (j * 3));
						charGroup = j;
						if (charGroup == last) {
							time += 2;
						}
						last = j;
						break;
					} else if (Character.getNumericValue(input.charAt(i)) >= 25 && Character.getNumericValue(input.charAt(i))
							<= 28) {
						time += Character.getNumericValue(input.charAt(i)) - 24;
						charGroup = 5;
						if (charGroup == last) {
							time += 2;
						}
						last = 5;
						break;
					} else if (Character.getNumericValue(input.charAt(i)) >= 29 && Character.getNumericValue(input.charAt(i))
							<= 31) {
						time += Character.getNumericValue(input.charAt(i)) - 28;
						charGroup = 6;
						if (charGroup == last) {
							time += 2;
						}
						last = 6;
						break;
					} else if (Character.getNumericValue(input.charAt(i)) >= 32 && Character.getNumericValue(input.charAt(i))
							<= 35) {
						time += Character.getNumericValue(input.charAt(i)) - 31;
						charGroup = 7;
						if (charGroup == last) {
							time += 2;
						}
						last = 7;
						break;
					}
				}
			}
			System.out.println(time);
		}
	}

}
