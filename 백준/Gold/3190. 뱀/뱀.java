import java.io.*;
import java.util.*;

public class Main {
	static class Head {
		int x, y;
		char d;

		Head(int x, int y, char d) {
			this.x = x;
			this.y = y;
			this.d = d;
		}
	}

	static class Pair {
		int x, y;

		Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	private static final Character NULL = null;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		Head now = new Head(0, 0, 'R');

		int N = Integer.parseInt(br.readLine());
		int arr[][] = new int[N][N];
		HashMap<Integer, Character> time = new HashMap<>();

		int K = Integer.parseInt(br.readLine());
		for (int i = 0; i < K; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int y = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			arr[y - 1][x - 1] = 1;
		}

		int L = Integer.parseInt(br.readLine());
		for (int i = 0; i < L; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			char c = st.nextToken().charAt(0);
			time.put(x, c);
		}

		int cnt = 0;
		Queue<Pair> q = new LinkedList<>();
		q.add(new Pair(now.x, now.y));
		arr[now.y][now.x] = 2;
		
		while (true) {
//			System.out.println("TIME : " + cnt + " " + time.get(cnt + 1));
//			System.out.println("DIR : " + now.d);
//			for (int i = 0; i < N; i++) {
//				for (int j = 0; j < N; j++) {
//					System.out.print(arr[i][j]);
//				}
//				System.out.println();
//			}
//			System.out.println();
			
			
			switch (now.d) { // 해당 방향으로 위치 옮기기
			case 'U':
				now.y--;
				break;
			case 'R':
				now.x++;
				break;
			case 'D':
				now.y++;
				break;
			case 'L':
				now.x--;
			}

			if (now.x < 0 || now.x >= N || now.y < 0 || now.y >= N || arr[now.y][now.x] == 2) {
				System.out.println(++cnt);
				return;
			}

			q.add(new Pair(now.x, now.y));

			if (arr[now.y][now.x] == 0) { // 사과 없으면
				Pair p = q.poll();
				arr[p.y][p.x] = 0;
			}

			arr[now.y][now.x] = 2;

			switch (time.get(++cnt) != null ? time.get(cnt) : 'n') { // 해당 시간에 방향 전환이 있다면 전환
			case 'L': // 왼쪽
				if (now.d == 'U')
					now.d = 'L';
				else if (now.d == 'R')
					now.d = 'U';
				else if (now.d == 'D')
					now.d = 'R';
				else if (now.d == 'L')
					now.d = 'D';
				break;
			case 'D': // 오른쪽
				if (now.d == 'U')
					now.d = 'R';
				else if (now.d == 'R')
					now.d = 'D';
				else if (now.d == 'D')
					now.d = 'L';
				else if (now.d == 'L')
					now.d = 'U';
				break;
			}
		}
	}
}
