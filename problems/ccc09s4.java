import java.util.PriorityQueue;
import java.util.Scanner;

public class ccc09s4 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); //vertex amount
		int T = sc.nextInt(); //trade route edge amount
		int[][] trade = new int[N][N];
		for (int i = 0; i < T; i++) {
			int bv = sc.nextInt() - 1;
			int ev = sc.nextInt() - 1;
			int cost = sc.nextInt();
			trade[bv][ev] = cost;
			trade[ev][bv] = cost;
		}
		int K = sc.nextInt(); //pencils
		int[] price = new int[N];
		for (int i = 0; i < K; i++) {
			int n = sc.nextInt() - 1;
			price[n] = sc.nextInt();
		}
		int D = sc.nextInt() - 1;
		
		//dijkstra
		//step
		//queue
//		PriorityQueue<Node> queue = new PriorityQueue<Node>();
		int[] step = new int[N];
		for (int i = 0; i < N; i++) {
			step[i] = Integer.MAX_VALUE;
		}
		step[D] = 0;
		boolean[] vis = new boolean[N];
		for (int i = 0; i < N; i++) {
			int min = Integer.MAX_VALUE;
			int index = -1;
			for (int j = 0; j < N; j++) {
				if (min > step[j] && !vis[j]) {
					min = step[j];
					index = j;
				}
			}
			
			//find index for current vertex you pick to process
			//update neighbor step value
			vis[index] = true;
			for (int j = 0; j < N; j++) {
				if (trade[index][j] != 0 && !vis[j] && step[j] > step[index] + trade[index][j]) {
					step[j] = step[index] + trade[index][j];
				}
			}
		}
		
		
		
		
		//add city D to queue
//		queue.add(new Node(D, step[D]));
//		while (!queue.isEmpty()) {
//			Node cur = queue.poll(); //cur = current
//			//get all the neighbors
//			for (int i = 0; i < N; i++) { //i = neighbor vertex
//				if (trade[cur.v][i] != 0 && step[i] > step[cur.v] + trade[cur.v][i]) {
//					step[i] = step[cur.v]+ trade[cur.v][i]; 
//					queue.add(new Node(i, step[i]));
//				}
//			}
//		}
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < N; i++) {
			if (price[i] != 0 && step[i] + price[i] < min) {
				min = step[i] + price[i];
			}
		}
		System.out.println(min);
	}
	
	public static class Node implements Comparable<Node> {
		int v; //city number
		int step;
		public Node(int v, int step) {
			this.v = v;
			this.step = step;
		}
		@Override
		public int compareTo(Node o) {
			return this.step - o.step;
		}
	}

}
