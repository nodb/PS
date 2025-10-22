import java.io.*;
import java.util.*;

public class Main {
	static int N, M, R;
	static int[][] A;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());

		A = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++)
				A[i][j] = Integer.parseInt(st.nextToken());
		}

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < R; i++) {
			int op = Integer.parseInt(st.nextToken());
			switch (op) {
			case 1:
				op1();
				break; // 상하 반전
			case 2:
				op2();
				break; // 좌우 반전
			case 3:
				op3();
				break; // 오른쪽 90도 회전
			case 4:
				op4();
				break; // 왼쪽 90도 회전
			case 5:
				op5();
				break; // 사분면 시계 회전
			case 6:
				op6();
				break; // 사분면 반시계 회전
			}
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++)
				sb.append(A[i][j]).append(' ');
			sb.append('\n');
		}
		System.out.print(sb);
	}

	static void op1() {
		for (int i = 0, j = N - 1; i < j; i++, j--) {
			int[] tmp = A[i];
			A[i] = A[j];
			A[j] = tmp;
		}
	}

	static void op2() {
		for (int i = 0; i < N; i++) {
			for (int l = 0, r = M - 1; l < r; l++, r--) {
				int t = A[i][l];
				A[i][l] = A[i][r];
				A[i][r] = t;
			}
		}
	}

	static void op3() {
		int[][] B = new int[M][N];
		for (int i = 0; i < N; i++)
			for (int j = 0; j < M; j++)
				B[j][N - 1 - i] = A[i][j];
		A = B;
		int t = N;
		N = M;
		M = t;
	}

	static void op4() {
		int[][] B = new int[M][N];
		for (int i = 0; i < N; i++)
			for (int j = 0; j < M; j++)
				B[M - 1 - j][i] = A[i][j];
		A = B;
		int t = N;
		N = M;
		M = t;
	}

	// 1(좌상) -> 2(우상) -> 3(우하) -> 4(좌하) -> 1
	static void op5() {
		int n2 = N / 2, m2 = M / 2;
		int[][] B = new int[N][M];

		// 1 -> 2
		copyBlock(A, B, 0, 0, 0, m2, n2, m2);
		// 2 -> 3
		copyBlock(A, B, 0, m2, n2, m2, n2, m2);
		// 3 -> 4
		copyBlock(A, B, n2, m2, n2, 0, n2, m2);
		// 4 -> 1
		copyBlock(A, B, n2, 0, 0, 0, n2, m2);

		A = B;
	}

	// 1(좌상) <- 2(우상) <- 3(우하) <- 4(좌하) <- 1
	static void op6() {
		int n2 = N / 2, m2 = M / 2;
		int[][] B = new int[N][M];

		// 1 -> 4
		copyBlock(A, B, 0, 0, n2, 0, n2, m2);
		// 4 -> 3
		copyBlock(A, B, n2, 0, n2, m2, n2, m2);
		// 3 -> 2
		copyBlock(A, B, n2, m2, 0, m2, n2, m2);
		// 2 -> 1
		copyBlock(A, B, 0, m2, 0, 0, n2, m2);

		A = B;
	}

	static void copyBlock(int[][] from, int[][] to, int sr, int sc, int dr, int dc, int h, int w) {
		for (int i = 0; i < h; i++)
			System.arraycopy(from[sr + i], sc, to[dr + i], dc, w);
	}
}
