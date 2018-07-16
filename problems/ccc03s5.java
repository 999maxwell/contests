import java.util.LinkedList;
import java.util.Scanner;
public class ccc03s5 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int C = sc.nextInt(); //vertices
		int R = sc.nextInt(); //edges
		int D = sc.nextInt();

		//Prim's algorithm

		//Initialization
		//1. mst boolean array to find out if vertex has been added into mst
		boolean[] mst = new boolean[C];

		//2. 2D map to store edges and find out the neighbors
		int[][] map = new int[C][C];
		for (int i = 0; i < R; i++) {
			int bv = sc.nextInt() - 1;
			int ev = sc.nextInt() - 1;
			int cost = sc.nextInt();
			if (map[bv][ev] < cost) {
				map[bv][ev] = cost;
				map[ev][bv] = cost;
			}
		}

		//3. maximum weight array to store maximum edge weight connected to vertex i
		LinkedList<Integer> d = new LinkedList<Integer>();
		for (int i = 0; i < D; i++) {
			d.add(sc.nextInt() - 1);
		}
		int[] maxW = new int[C];
		maxW[0] = Integer.MAX_VALUE;

		//4. parent array used to store which vertex brought in new vertex to the tree
		int[] p = new int[C];

		//Processing
		//1. go to maxW to get vertex with max weight and add to mst
		//2. update maxW array, parent array, and mst array with newly added vertex
		for (int i = 0; i < C; i++) {
			int max = 0;
			int u = -1; //index of vertex with max weight
			for (int j = 0; j < C; j++) {
				if (!mst[j] && maxW[j] > max) {
					max = maxW[j];
					u = j;
				}
			}
			mst[u] = true;
			//from u, get neighbor edges, and update maxW and parent array
			//get neighbors through row u in map[]
			for (int j = 0; j < C; j++) {
				if (!mst[j] && map[u][j] > maxW[j]) {
					maxW[j] = map[u][j];
					p[j] = u;
				}
			}
		}

		int min = Integer.MAX_VALUE;
		//trace up parent path
		for (int i = 0; i < D; i++) {
			int v = d.poll();
			while (true) {
				if (min > maxW[v]) {
					min = maxW[v];
				}
				v = p[v];
				if (v == 0) { //0 is the beginning
					break;
				} 
			}
		}

		System.out.println(min);

	}

}
