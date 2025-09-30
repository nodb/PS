import java.io.*;
import java.util.*;

public class Main {
	static int dx[] = { -1, 1, 0, 0 };
	static int dy[] = { 0, 0, -1, 1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken()); // 세로
		int c = Integer.parseInt(st.nextToken()); // 가로
		int result = 0;

		/*
		 * Z 탐색 시 사분면 단위로 잘라서 위치 확인하기!
		 * 
		 * 먼저 (c 가로, r 세로)이 어느 사분면에 속하는지 판단
		 * 		순서: 0-좌상, 1-우상, 2-좌하, 3-우하
		 * -> 이전 값을 result에 더하기
		 * -> 좌표 (c, r) 수정하기
		 * N번 반복!!
		 * 
		 * 직접 보면서 이해하면 좋아서 아래 print 주석을 달아놨어 :)
		 * 3 7 7 <- 이걸로 넣어서 보면 이해가 쉬울거야
		 * 
		 */

		for (int i = N; i > 0; i--) {
			/* 
			 * first : 각 탐색에서 우상(1사분면)의 첫 번째 값
			 * 예를 들어
			 * 
			 * N이 1일 때
			 * 		0 1<
			 * 		2 3
			 * first는 1
			 * 
			 * N이 2일 때
			 * 		0  1  4< 5
			 * 		2  3  6  7
			 * 		8  9  12 13
			 * 		10 11 14 15
			 * first는 4
			 * 
			 * N일 때 first를 구해보면 -> 1:1, 2:4, 3:16...
			 * 
			 * 2의 제곱으로 나타내면 -> 1:2^0, 2:2^2, 3:2^4
			 * N일 때 2^((N-1)*2) 라는 것을 알 수 있다!
			 * 자바로는 1 << ((N - 1) * 2)
			 */
			int first = 1 << ((i - 1) * 2); //
			/*
			 * mid는 가로 세로 길이의 중간
			 * 예를 들어
			 * 
			 * N이 1일 때 가로(or 세로) 길이: 2 -> 이때 mid: 1
			 * N이 2일 때 가로 길이: 4 -> mid: 2
			 * N이 3일 때 가로 길이: 8 -> mid: 4
			 * 
			 * 즉 2^(N-1)
			 * 자바로는 1 << (i - 1)
			 */
			int mid = 1 << (i - 1);
//			System.out.println("first: " + first + "\tmid: " + mid + "\t\t(가로, 세로): (" + c + "," + r + ")\tresult: " + result);
			
			if (r < mid && c < mid) { // 좌상(2사분면)

			} else if (r < mid && c >= mid) { // 우상(1사분면)
				result += first;
				c -= mid;
			} else if (r >= mid && c < mid) { // 좌하(3사분면)
				result += first * 2;
				r -= mid;
			} else if (r >= mid && c >= mid) { // 우하(4사분면)
				result += first * 3;
				r -= mid;
				c -= mid;
			}
		}
		System.out.println(result);
	}
}