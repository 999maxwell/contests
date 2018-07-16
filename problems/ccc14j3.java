import java.util.*;
public class ccc14j3 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[][] diceRolls = new int[2][n];
		int a = 100;
		int d = 100;
		for (int i = 0; i < n; i++) {
			diceRolls[0][i] = sc.nextInt();
			diceRolls[1][i] = sc.nextInt();
			if (diceRolls[0][i] > diceRolls[1][i]) {
				d -= diceRolls[0][i];
			} else if (diceRolls[1][i] > diceRolls[0][i]) {
				a -= diceRolls[1][i];
			}
		}
		System.out.println(a);
		System.out.println(d);
	}

}
