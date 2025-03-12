import java.io.*;
import java.util.*;

public class Main {
	static int N, M;
	static ArrayList<Integer> list[];
	static int input_degree[];
	static Queue<Integer> q;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		list = new ArrayList[N + 1];
		for (int i = 0; i < N + 1; i++) {
			list[i] = new ArrayList<>();
		}
		input_degree = new int[N + 1];
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int first = Integer.parseInt(st.nextToken());
			int second = Integer.parseInt(st.nextToken());
			list[first].add(second);
			input_degree[second]++;
		}
		
		q = new LinkedList<>();
		for (int i = 1; i <= N; i++) {
			if (input_degree[i] == 0) {
				q.offer(i);
				System.out.print(i + " ");
			}
		}
		
		while (!q.isEmpty()) {
			int now = q.poll();
			for (int next : list[now]) {
				input_degree[next]--;
				if (input_degree[next] == 0) {
					q.offer(next);
					System.out.print(next + " ");
				}
			}
		}
	}
}

//input
//3 2 // 학생 수, 키 비교 횟수
//1 3
//2 3
//output
//1 2 3
//
//list
//1 3
//2 3
//3 
//
//input_degree
//1 2 3
//0 0 2
