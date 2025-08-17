import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String A = br.readLine();
		// [][][0] : 좀비
		// - 1 : 아래 방향 보는 좀비
		// - 2 : 위 방향 보는 좀비
		// [][][1] : 스위치
		// - 1 : 스위치
		// [][][2] : 불
		// - 1 : 불 켜짐
		int arr[][][] = new int[N][N][3];
		for (int y = 0; y < N; y++) {
			String s = br.readLine();
			for (int x = 0; x < N; x++) {
				char c = s.charAt(x);
				if (c == 'Z')
					arr[y][x][0] = 1;
				else if (c == 'S')
					arr[y][x][1] = 1;
			}
		}
		// Ahri[] : 아리 x, y 좌표, 방향
		// - 0 : x
		// - 1 : y
		// - 2 : 방향(시계방향)
		// - - 0 : 위쪽
		// - - 1 : 오른쪽
		// - - 2 : 아래
		// - - 3 : 왼쪽
		int ahri[] = { 0, 0, 2 };
		for (int i = 0; i < A.length(); i++) {
			// 아리 이동 후
			// - 스위치 있으면 불 켜기
			// - 좀비 true && 불 false : 기절
			// 좀비 이동 후
			// - 아리 위치에 좀비 위치 && 불 false : 기절
			char move = A.charAt(i);
			if (move == 'F') {
				// 아리 이동
				if (ahri[2] == 0 && ahri[1] >= 1) // 위쪽
					ahri[1]--;
				if (ahri[2] == 1 && ahri[0] < N - 1) // 오른쪽
					ahri[0]++;
				if (ahri[2] == 2 && ahri[1] < N - 1) // 아래쪽
					ahri[1]++;
				if (ahri[2] == 3 && ahri[0] >= 1) // 왼쪽
					ahri[0]--;
				// 스위치 있으면 불 켜기
				if (arr[ahri[1]][ahri[0]][1] == 1)
					for (int ny = ahri[1] - 1; ny < ahri[1] + 2; ny++)
						for (int nx = ahri[0] - 1; nx < ahri[0] + 2; nx++)
							if (nx >= 0 && ny >= 0 && nx < N && ny < N)
								arr[ny][nx][2] = 1;
				// 좀비 true && 불 false : 기절
				if (arr[ahri[1]][ahri[0]][0] != 0 && arr[ahri[1]][ahri[0]][2] == 0) {
					System.out.println("Aaaaaah!");
					return;
				}
			} else if (move == 'L') {
				if (--ahri[2] == -1)
					ahri[2] = 3;
			} else if (move == 'R') {
				if (++ahri[2] == 4)
					ahri[2] = 0;
			}
			// 임시 좀비 배열
			int zombi[][] = new int[N][N];
			// 좀비 이동
			for (int y = 0; y < N; y++) {
				for (int x = 0; x < N; x++) {
					// 내려가는 좀비
					if (arr[y][x][0] == 1) {
						if (y == N - 1)
							zombi[y][x] = 2;
						else {
							zombi[y + 1][x] = 1;
						}
					}
					// 올라가는 좀비
					if (arr[y][x][0] == 2) {
						if (y == 0)
							zombi[y][x] = 1;
						else {
							zombi[y - 1][x] = 2;
						}
					}

				}
			}
			// 아리 위치에 좀비 위치 && 불 false : 기절
			if (zombi[ahri[1]][ahri[0]] != 0 && arr[ahri[1]][ahri[0]][2] == 0) {
				System.out.println("Aaaaaah!");
				return;
			}
			// zombi 배열 저장
			for (int y = 0; y < N; y++) {
				for (int x = 0; x < N; x++) {
					arr[y][x][0] = zombi[y][x];
				}
			}
		}
		System.out.println("Phew...");
	}
}