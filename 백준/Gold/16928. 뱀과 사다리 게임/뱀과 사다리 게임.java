import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int arr[][] = new int[101][2]; // 현재 위치 : 이동 위치, cnt
		for (int i = 0; i < 101; i++) // cnt 초기화
			arr[i][1] = 101;
		for (int i = 0; i < N + M; i++) {
			st = new StringTokenizer(br.readLine());
			int pos = Integer.parseInt(st.nextToken());
			arr[pos][0] = Integer.parseInt(st.nextToken());
		}

		// 1부터 올라가기
		// +1, +2, +3, +4, +5, +6 확인
		// 각 이동한 위치
		// - 내려가는 곳(뱀) : 내려간 위치에 적용
		// - 올라가는 곳(사다리) : 올라간 위치에 적용
		// - 해당 위치
		// - - cnt 값 > 이전 위치 + 1 : 갱신 + q 추가
		// - - cnt 값 <= 이전 위치 + 1 : 무시

		// BFS
		Queue<Integer> q = new LinkedList<>();
		q.add(1);
		arr[1][1] = 0;

		while (!q.isEmpty()) {
			int now = q.poll(); // 현재 위치
			int cnt = arr[now][1]; // cnt
			for (int dice = 1; dice <= 6; dice++) {
				int next = now + dice;
				if (next > 100)
					break;
				if (arr[next][0] != 0) // 사다리 or 뱀
					next = arr[next][0];
				if (arr[next][1] > cnt + 1) {
					arr[next][1] = cnt + 1;
					if (next == 100)
						q.clear();
					else
						q.add(next);
				}
			}
		}
		System.out.println(arr[100][1]);
	}
}
