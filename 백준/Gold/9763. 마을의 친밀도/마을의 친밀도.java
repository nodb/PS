import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());

		int[] x = new int[n];
		int[] y = new int[n];
		int[] z = new int[n];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			x[i] = Integer.parseInt(st.nextToken());
			y[i] = Integer.parseInt(st.nextToken());
			z[i] = Integer.parseInt(st.nextToken());
		}

		int min = Integer.MAX_VALUE;

		// i를 가운데 마을(B)로 고정
		for (int i = 0; i < n; i++) {
			int m1 = Integer.MAX_VALUE; // i에서 가장 가까운 거리
			int m2 = Integer.MAX_VALUE; // i에서 두 번째로 가까운 거리

			int xi = x[i];
			int yi = y[i];
			int zi = z[i];

			// i에서 다른 모든 마을까지 거리 계산
			for (int j = 0; j < n; j++) {
				if (j == i)
					continue;

				int d = abs(xi - x[j]) + abs(yi - y[j]) + abs(zi - z[j]);

				// 최소 2개 거리만 유지
				if (d < m1) {
					m2 = m1;
					m1 = d;
				} else if (d < m2) {
					m2 = d;
				}
			}

			// i가 가운데일 때 가능한 최소 친밀도
			if (m1 + m2 < min)
				min = m1 + m2;
		}
		System.out.println(min);
	}

    static int abs(int n) {
		return n >= 0 ? n : -n;
	}
}
