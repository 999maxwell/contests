import java.util.*;
public class ccc02s1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int pink = sc.nextInt();
		int green = sc.nextInt();
		int red = sc.nextInt();
		int orange = sc.nextInt();
		int goal = sc.nextInt();
		int combinations = 0;
		int minimum = 0;
		boolean firstMin = true;
		for (int i = 0; i <= goal; i++) {
			for (int j = 0; j <= goal; j++) {
				for (int k = 0; k <= goal; k++) {
					for (int l = 0; l <= goal; l++) {
						if ((i * pink) + (j * green) + (k * red) + (l * orange) == goal) {
							System.out.println("# of PINK is " + i + " # of GREEN is " + j + " # of RED is " + k + " # of ORANGE is " + l);
							combinations++;
							if (firstMin){
								minimum = i + j + k + l;
								firstMin = false;
							} else {
								if (i + j + k + l < minimum) {
									minimum = i + j + k + l;
								}
							}
						}
					}
				}
			}
		}
		System.out.println("Total combinations is " + combinations + ".");
		System.out.println("Minimum number of tickets to print is " + minimum + ".");
	}

}
