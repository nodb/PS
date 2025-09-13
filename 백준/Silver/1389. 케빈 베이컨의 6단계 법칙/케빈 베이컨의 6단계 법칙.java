import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int arr[][] = new int[N + 1][N + 1]; // 0부터 시작이 아닌, 1부터 N까지! 주의
		
		// A에서 B로 가는 최단 거리를 구하는데 중간 노드(C)가 끼어있다?!
		// 바로 "플로이드 워셜" 알고리즘!
		// (A → B) 최단거리: (A → B) vs. (A → C → B) 둘 중에 짧은 것으로 선택하여 A → B 값으로 갱신
		// 또한 최단 거리를 찾기위해 모든 중간 노드 C를 확인해 보아야 한다.

		// 먼저 모든 값들을 INF(충분히 큰 값)로 초기화
		// 여기서 INF를 Integer.MAX_VALUE로 잡아버리면 후에 노드간에 더할 때 Integer 범위를 넘어 오류 발생 가능
		for (int i = 1; i <= N; i++) {
			// 초기화는 두 방법 중 편한 걸로
			// for (int j = 1; j <= N; j++) {
			// arr[i][j] = 1_000_000;
			// }
			Arrays.fill(arr[i], 1_000_000);
			// 자기 자신까지의 거리는 항상 0
			arr[i][i] = 0;
		}
		
		// 입력 받은 관계들은 1로 갱신
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			arr[A][B] = 1; // (A → B) 거리 : 1
			arr[B][A] = 1; // (B → A) 거리 : 1
		}

		for (int C = 1; C <= N; C++) { // 중간 노드 C가 1~N까지 돌면서
			for (int A = 1; A <= N; A++) { // 시작 노드 A가 1~N까지 돌면서
				for (int B = 1; B <= N; B++) { // 끝 노드 B가 1~N까지 돌면서
					// 만약 (A → B)보다 (A → C → B)이 짧다면
					// (A → B)값을 (A → C → B)로 갱신
					if (arr[A][B] > arr[A][C] + arr[C][B]) {
						arr[A][B] = arr[A][C] + arr[C][B];
					}
				}
			}
		}

		int cnt = Integer.MAX_VALUE; // 케빈 베이컨의 수
		int num = 0; // 케빈 베이컨의 수가 가장 작은 사람
		
		for (int i = 1; i <= N; i++) { // i: 현재 사람
			int sum = 0; // 현재 사람의 케빈 베이컨 수
			for (int j = 1; j <= N; j++) {
				sum += arr[i][j];
			}
			// 만약 현재 사람의 케빈 베이컨 수가 지금까지보다 작다면 갱신
			if (cnt > sum) {
				cnt = sum;
				num = i;
			}
		}
		System.out.println(num);
	}
}