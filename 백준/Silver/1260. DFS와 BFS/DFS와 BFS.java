import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, M, V;
	static List<Integer> AL[];
	static int DFS[];
	static int BFS[];
	static int visited[];
	static int cnt = 0;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken()); // 정점 갯수
		M = Integer.parseInt(st.nextToken()); // 간선 개수
		V = Integer.parseInt(st.nextToken()); // 시작 정점
		
		AL = new ArrayList[N + 1];
		for (int i = 0; i < N + 1; i++) {
			AL[i] = new ArrayList<>();
		}
		
		DFS = new int[N + 1];
		BFS = new int[N + 1];
		visited = new int[N + 1];
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int f = Integer.parseInt(st.nextToken());
			int r = Integer.parseInt(st.nextToken());
			AL[f].add(r);
			AL[r].add(f);
		}
		
		// 각 정점 리스트 내부 정렬 1~N
		for (int i = 1; i <= N; i++) {
			Collections.sort(AL[i]);
		}
		
		dfs(V);
		
		for (int i = 0; i < cnt; i++) {
			System.out.print(DFS[i] + " ");
		}
		
		System.out.println();
		cnt = 0;
		visited = new int[N + 1];

		bfs(V);
		
		for (int i = 0; i < cnt; i++) {
			System.out.print(BFS[i] + " ");
		}
	}

	private static void dfs(int v) {
		visited[v] = 1;
		DFS[cnt++] = v;
		if (cnt == N || AL[v].isEmpty()) {
			return;
		}
		for (int i : AL[v]) {
			if (visited[i] == 0) {
				dfs(i);
			}
		}
	}
	
	private static void bfs(int v) {
		Queue<Integer> q = new LinkedList<>();
		q.offer(v);
		while(cnt < N && !q.isEmpty()) {
			int val = q.poll(); 
			visited[val] = 1;
			BFS[cnt++] = val;
			for (int i : AL[val]) {
				if (visited[i] == 0 && !q.contains(i)) {
					q.offer(i);
				}
			}
		}
	}
}
