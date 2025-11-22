import java.io.*;
import java.util.*;

public class Main {

	static int n;
	static int arr[];
	static boolean visited[]; // DFS에서 한 번이라도 방문한 적 있는지
	static boolean finished[]; // x에서 시작되는 DFS 처리가 모두 끝났는지 (사이클 마킹이 끝났는지)
	static boolean isInCycle[]; // 최종적으로 선택할 정점(사이클에 포함되는 숫자)인지 여부

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine().trim());
		arr = new int[n + 1];
		visited = new boolean[n + 1];
		finished = new boolean[n + 1];
		isInCycle = new boolean[n + 1];

		for (int i = 1; i <= n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}

		for (int i = 1; i <= n; i++) {
			if (!visited[i]) {
				dfs(i);
			}
		}

		StringBuilder sb = new StringBuilder();
		int count = 0;
		for (int i = 1; i <= n; i++) {
			if (isInCycle[i])
				count++;
		}

		sb.append(count).append('\n');
		for (int i = 1; i <= n; i++) {
			if (isInCycle[i]) {
				sb.append(i).append('\n');
			}
		}

		System.out.print(sb);
	}

	private static void dfs(int x) {
		// 1) 현재 정점 x를 방문 처리
		// - visited[x] = true 는 "이 정점 x는 한 번이라도 DFS에 의해 들어왔다"는 뜻
		// - 사이클인지 여부와는 무관, 단순 도달 여부만 체크
		visited[x] = true;

		// x가 가리키는 다음 정점(next)
		int next = arr[x];

		// 2) 아직 next를 방문한 적이 없다면 → 아직 탐색되지 않은 노드
		// 이 경우 DFS로 계속 탐색을 이어가며 사이클을 찾는다.
		if (!visited[next]) {
			dfs(next);
		}
		// 3) next는 방문한 적은 있지만 아직 finished 되지 않음
		// → 즉, next는 현재 DFS 경로(스택) 안에 있는 정점
		// → 바로 이 상황이 "사이클 발견" 조건
		//
		// visited[next] == true : next에 도달한 적 있음
		// finished[next] == false : next 탐색이 끝나지 않았음 → 아직 콜스택 안
		//
		// x → ... → next → ... → x 로 이어지는 사이클이 존재한다는 의미
		else if (!finished[next]) {
			// 4) now = next 를 시작점으로 잡아서,
			// arr[now] 를 계속 따라가며 x에 도달할 때까지
			// 모든 정점을 사이클 구성원으로 표시함.
			int now = next;
			isInCycle[now] = true; // next는 무조건 사이클에 포함

			// 5) 사이클 내부를 한 바퀴 돌며 표시
			// now가 다시 x에 도달할 때까지 이동
			// (처음 now=next 이기 때문에 최소 한 번은 실행됨)
			while (now != x) {
				now = arr[now]; // 다음 정점으로 이동
				isInCycle[now] = true; // 이동한 정점도 사이클에 포함
			}
		}

		// 6) x의 DFS 탐색이 완전히 끝났음을 표시
		// - finished[x] = true는 "이 정점에서 시작해 더 따라갈 곳이 없음"을 의미
		// - 후에 다른 노드가 x로 돌아와도 사이클 탐색 대상에서 제외됨
		finished[x] = true;
	}

}
