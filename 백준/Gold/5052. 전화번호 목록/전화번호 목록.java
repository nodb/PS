import java.io.*;
import java.util.Arrays;

public class Main {
	static final int ROOT = 1;
	static int unused; // 새 노드 번호 부여
	static int max; // 최대 등장 가능한 노드의 수
	static boolean isLeaf[]; // 해당 노드가 문자열의 끝인지 여부
	static int next[][]; // 각 노드에서 자식 노드의 번호

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int tc = 0; tc < T; tc++) {
			int n = Integer.parseInt(br.readLine());

			unused = 2; // 새 노드 번호 부여
			max = 10000 * 10 + 1; // 최대 등장 가능한 노드의 수
			isLeaf = new boolean[max]; // 해당 노드가 문자열의 끝인지 여부
			next = new int[max][10]; // 각 노드에서 자식 노드의 번호

			for (int i = 0; i < max; i++) // -1 : 해당 자식 정점이 없음
				Arrays.fill(next[i], -1);

			String num[] = new String[n];
			for (int i = 0; i < n; i++)
				num[i] = br.readLine();

			boolean isExist = false;
			for (int i = 0; i < n; i++) {
				if (!insert(num[i])) {
					isExist = true;
					break;
				}
			}
			sb.append(isExist ? "NO" : "YES").append("\n");
		}
		System.out.println(sb);
	}

	private static boolean insert(String num) {
		int cur = ROOT;

		for (int i = 0; i < num.length(); i++) {
			int c = num.charAt(i) - '0';

			if (isLeaf[cur]) // 가는 길에 문자 끝이 존재하면
				return false;

			if (next[cur][c] == -1) // 자식 노드가 없으면 새로 생성
				next[cur][c] = unused++;
			cur = next[cur][c];
		}

		// 자식 노드가 있으면 내가 누군가의 접두어
		for (int i = 0; i < 10; i++) {
			if (next[cur][i] != -1) { // 이미 자식 노드가 있다면
				return false;
			}
		}

		isLeaf[cur] = true; // 현재 노드는 문자열 끝
		return true;
	}
}