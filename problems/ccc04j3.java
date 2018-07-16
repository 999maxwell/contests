import java.util.*;
public class ccc04j3 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] adj = new String[sc.nextInt()];
		sc.nextLine();
		String[] nouns = new String[sc.nextInt()];
		sc.nextLine();
		for (int i = 0; i < adj.length; i++) {
			adj[i] = sc.nextLine();
		}
		for (int i = 0; i < nouns.length; i++) {
			nouns[i] = sc.nextLine();
		}
		for (int i = 0; i < adj.length; i++) {
			for (int j = 0; j < nouns.length; j++) {
				System.out.println(adj[i] + " as " + nouns[j]);
			}
		}
	}

}
