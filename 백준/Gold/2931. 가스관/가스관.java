import java.io.*;
import java.util.*;

public class Main {

	static int arr[][];
	static HashSet<Pair> hs;

	public static class Pair {
		int x, y;

		Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}

		@Override
		public boolean equals(Object o) {
			if (this == o)
				return true;
			if (!(o instanceof Pair))
				return false;
			Pair pair = (Pair) o;
			return x == pair.x && y == pair.y;
		}

		@Override
		public int hashCode() {
			return Objects.hash(x, y);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		arr = new int[r][c];
		for (int i = 0; i < r; i++) {
			String s = br.readLine();
			for (int j = 0; j < c; j++)
				arr[i][j] = s.charAt(j);
		}
		hs = new HashSet<>();
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				int cur = arr[i][j];
				if (cur == '.') {
					continue;
				} else if (cur == '|') {
					up(j, i);
					down(j, i);
				} else if (cur == '-') {
					left(j, i);
					right(j, i);
				} else if (cur == '+') {
					up(j, i);
					down(j, i);
					left(j, i);
					right(j, i);
				} else if (cur == '1') {
					down(j, i);
					right(j, i);
				} else if (cur == '2') {
					up(j, i);
					right(j, i);
				} else if (cur == '3') {
					up(j, i);
					left(j, i);
				} else if (cur == '4') {
					down(j, i);
					left(j, i);
				}
			}
		}
		for (Pair i : hs) {
			int x = i.x;
			int y = i.y;
			sb.append((y + 1) + " " + (x + 1) + " ");

			int up = 0;
			int down = 0;
			int left = 0;
			int right = 0;
			if (y > 0)
				up = arr[y - 1][x];
			if (y < r - 1)
				down = arr[y + 1][x];
			if (x > 0)
				left = arr[y][x - 1];
			if (x < c - 1)
				right = arr[y][x + 1];

			boolean dir[] = new boolean[4]; // 0 위, 1 아래, 2 왼쪽, 3 오른쪽
			if (up == '|' || up == '+' || up == '1' || up == '4')
				dir[0] = true;
			if (down == '|' || down == '+' || down == '2' || down == '3')
				dir[1] = true;
			if (left == '-' || left == '+' || left == '1' || left == '2')
				dir[2] = true;
			if (right == '-' || right == '+' || right == '3' || right == '4')
				dir[3] = true;

			if (dir[0] && dir[1] && dir[2] && dir[3])
				sb.append("+");
			else if (dir[0] && dir[1])
				sb.append("|");
			else if (dir[2] && dir[3])
				sb.append("-");
			else if (dir[1] && dir[3])
				sb.append("1");
			else if (dir[0] && dir[3])
				sb.append("2");
			else if (dir[0] && dir[2])
				sb.append("3");
			else if (dir[1] && dir[2])
				sb.append("4");
		}
		System.out.println(sb);
	}

	private static void up(int x, int y) {
		int nx = x;
		int ny = y - 1;
		int na = arr[ny][nx];
		if (na == '.' && na != 'M' && na != 'Z')
			hs.add(new Pair(nx, ny));
	}

	private static void down(int x, int y) {
		int nx = x;
		int ny = y + 1;
		int na = arr[ny][nx];
		if (na == '.' && na != 'M' && na != 'Z')
			hs.add(new Pair(nx, ny));
	}

	private static void left(int x, int y) {
		int nx = x - 1;
		int ny = y;
		int na = arr[ny][nx];
		if (na == '.' && na != 'M' && na != 'Z')
			hs.add(new Pair(nx, ny));
	}

	private static void right(int x, int y) {
		int nx = x + 1;
		int ny = y;
		int na = arr[ny][nx];
		if (na == '.' && na != 'M' && na != 'Z')
			hs.add(new Pair(nx, ny));
	}

}