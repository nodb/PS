import java.io.*;
import java.util.*;

public class Main {
	static HashSet<rock> hs = new HashSet<>();
	static Queue<rock> q = new LinkedList<>();

	public static class rock {
		int a, b, c;

		rock(int a, int b, int c) {
			int gcd = gcd(a, gcd(b, c));
			int arr[] = { a / gcd, b / gcd, c / gcd };
			// 오름차순 정렬
			Arrays.sort(arr);
			this.a = arr[0];
			this.b = arr[1];
			this.c = arr[2];
		}

		// 최대공약수(GCD) - 유클리드 호제법
		int gcd(int x, int y) {
			while (y != 0) {
				int temp = y;
				y = x % y;
				x = temp;
			}
			return x;
		}

		@Override
		public boolean equals(Object o) {
			if (this == o)
				return true;
			if (o == null || getClass() != o.getClass())
				return false;
			rock other = (rock) o;
			return a == other.a && b == other.b && c == other.c;
		}

		@Override
		public int hashCode() {
			return Objects.hash(a, b, c);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int first[] = new int[3];
		for (int i = 0; i < 3; i++)
			first[i] = Integer.parseInt(st.nextToken());

		check(first[0], first[1], first[2]);
		// 1. 크기가 같지 않은 두 그룹
		// 2. 작은 쪽 : X, 큰 쪽 : Y
		// 3. X += X
		// 4. Y -= X

		// 모든 경우 다 보기
		// - 중복 방지 -> Set
		// - - Set에서 최소 공배수로 관리
		// - 새로운 값이 Set에 없다면 Queue에 추가
		// - 종료 조건 : [1, 2, 3] 배열
		while (!q.isEmpty()) {
			rock r = q.poll();
			if (r.a == 1 && r.b == 1 && r.c == 1) {
				System.out.println(1);
				return;
			}
			if (r.a != r.b)
				check(2 * r.a, r.b - r.a, r.c);
			if (r.b != r.c)
				check(r.a, 2 * r.b, r.c - r.b);
			if (r.a != r.c)
				check(2 * r.a, r.b, r.c - r.a);
		}
		System.out.println(0);
	}

	static void check(int i, int j, int k) {
		rock r = new rock(i, j, k);
		if (!hs.contains(r)) {
			hs.add(r);
			q.add(r);
		}
	}
}

//A = X + X
//A = Y - X
//X + X = Y - X
//Y = 3X