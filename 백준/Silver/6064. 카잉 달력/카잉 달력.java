import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int tc = 0; tc < T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int M = Integer.parseInt(st.nextToken());
			int N = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());

			int lcmValue = lcm(M, N);
			int answer = -1; // 조건을 만족하는 해를 찾지 못하면 -1

			for (int year = x; year <= lcmValue; year += M) {
				int currentY = year % N;
				if (currentY == 0) {
					currentY = N;
				}
				if (currentY == y) {
					answer = year;
					break;
				}
			}
			sb.append(answer).append("\n");
		}
		System.out.println(sb);
	}

	// 유클리드 호제법
	// 두 정수의 최대공약수
	public static int gcd(int a, int b) {
		while (b != 0) {
			int temp = a % b;
			a = b;
			b = temp;
		}
		return a;
	}

	// 두 정수의 최소공배수
	// LCM(a, b) = (a * b) / GCD(a, b)
	public static int lcm(int a, int b) {
		return (a * b) / gcd(a, b);
	}
}
