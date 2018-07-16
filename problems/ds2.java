import java.util.LinkedList;
import java.util.Scanner;

public class ds2 {
	int V;
	int E;
	
	Edge[] edge;
	int[] parent;
	
	public class Edge { //no comparable because already sorted in question
		int bv;
		int ev;
	}
	
	//Constructor
	public ds2(int v, int e) {
		V = v;
		E = e;
		edge = new Edge[E];
		for (int i = 0; i < E; i++) {
			edge[i] = new Edge();
		}
		parent = new int[V];
		for (int i = 0; i < V; i++) {
			parent[i] = -1;
		}
	}
	
	//finding parent
	public int find(int v) {
		if (parent[v] == -1) {
			return v;
		} else {
			return find(parent[v]);
		}
	}
	
	public void union(int bv, int ev) {
		int pb = find(bv); //parent of beginning
		int pe = find(ev); //parent of end
		parent[pb] = pe;
	}
	
	public void kruskal() {
		//from edge array, choose one by one and add int minSpan
		//if parents of bv and ev of the edge are the same, discard
		//otherwise, add the edge into minSpan
		//union the two vertices
		LinkedList<Integer> result = new LinkedList<Integer>();
		int count = 0;
		for (int i = 0; i < E; i++) {
			int bv = edge[i].bv;
			int ev = edge[i].ev;
			int bp = find(bv);
			int ep = find(ev);
			if (bp != ep) {
				result.add(i + 1);
				union(bv, ev);
				count++;
				if (count == V - 1) {
					break;
				}
			}
		}
		if (result.size() == V - 1) {
			while (!result.isEmpty()) {
				System.out.println(result.pop());
			}
		} else {
			System.out.println("Disconnected Graph");
		}

	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int V = sc.nextInt();
		int E = sc.nextInt();
		ds2 graph = new ds2(V, E);
		for (int i = 0; i < E; i++) {
			int bv = sc.nextInt() - 1;
			int ev = sc.nextInt() - 1;
			graph.edge[i].bv = bv;
			graph.edge[i].ev = ev;
		}
		graph.kruskal();
	}
}
