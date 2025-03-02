import java.io.*;
import java.util.*;

public class Main {
	static char[][] board;
	static int N, M;
	static final char[][] boardB =
		  { { 'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W' },
			{ 'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B' },
			{ 'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W' },
			{ 'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B' },
			{ 'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W' },
			{ 'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B' },
			{ 'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W' },
			{ 'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B' } };
	static final char[][] boardW =
		  { { 'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B' },
			{ 'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W' },
			{ 'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B' },
			{ 'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W' },
			{ 'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B' },
			{ 'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W' },
			{ 'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B' },
			{ 'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W' } };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		board = new char[N][M];

		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			for (int j = 0; j < M; j++) {
				board[i][j] = s.charAt(j);
			}
		}

		int min = 64;

		for (int y = 0; y <= N - 8; y++) {
			for (int x = 0; x <= M - 8; x++) {
				int countB = 0;
				int countW = 0;

				for (int i = 0; i < 8; i++) {
					for (int j = 0; j < 8; j++) {
						if (board[y + j][x + i] != boardB[i][j]) // B보드와 다른 곳
							countB++;
						if (board[y + j][x + i] != boardW[i][j]) // W보드와 다른 곳
							countW++;
					}
				}
				min = Math.min(Math.min(countB, countW), min);
			}
		}

		System.out.println(min);
	}
}
