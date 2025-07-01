import java.io.*;
import java.util.*;

public class Main {
	static boolean[][] visited = new boolean[1501][1501]; // 세 번째 값 : sum - a - b
	static Queue<int[]> q = new LinkedList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		// hashset 사용하지 않고 배열로 처리
		int arr[] = new int[3];
		arr[0] = Integer.parseInt(st.nextToken());
		arr[1] = Integer.parseInt(st.nextToken());
		arr[2] = Integer.parseInt(st.nextToken());

        // sum은 항상 유지
		int sum = arr[0] + arr[1] + arr[2];
		if (sum % 3 != 0) {
			System.out.println(0);
			return;
		}

		Arrays.sort(arr); // 항상 오름차순 정렬
		q.add(arr);
		visited[arr[0]][arr[1]] = true;

		// 모든 경우 다 보기
		// - 중복 방지 -> visited
		// - 방문한 적 없다면 Queue에 추가
		while (!q.isEmpty()) {
			int now[] = q.poll();
            
            // 종료 조건 : 배열의 세 값이 동일
			if (now[0] == now[1] && now[1] == now[2]) {
				System.out.println(1);
				return;
			}
            
            // 1. 크기가 같지 않은 두 그룹
			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {
					if (i == j)
						continue;
                    // 2. 작은 쪽 : X, 큰 쪽 : Y
					if (now[i] < now[j]) { // X = now[i], Y = now[j]
						int[] next = now.clone();
						next[i] += now[i]; // X += X
						next[j] -= now[i]; // Y -= X
						Arrays.sort(next); // 항상 오름차순 정렬
						if (!visited[next[0]][next[1]]) {
							visited[next[0]][next[1]] = true;
							q.add(next);
						}
					}
				}
			}
		}
		System.out.println(0);
	}
}