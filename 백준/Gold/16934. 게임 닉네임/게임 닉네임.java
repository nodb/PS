import java.io.*;
import java.util.*;

public class Main {
	static final int ROOT = 1;
	static int unused = 2; // 새 번호 부여
	static final int MAX = 100_000 * 10 + 1; // 최대 등장 가능한 글자의 수
	static int check[] = new int[MAX]; // 문자열의 끝 여부, 동일한 이름 확인
	static int next[][] = new int[MAX][26]; // 자식 정점 번호

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < MAX; i++) // next 초기화, -1이면 자식 정점 없음
			Arrays.fill(next[i], -1);

		int n = Integer.parseInt(br.readLine());
		while (n-- > 0)
			sb.append(insert(br.readLine())).append("\n");

		System.out.println(sb);
	}

	static String insert(String s) {
		int cur = ROOT;
		int len = -1;
		for (int i = 0; i < s.length(); i++) {
			int alph = s.charAt(i) - 'a';
			if (next[cur][alph] == -1) {
				next[cur][alph] = unused++;
				if (len == -1) {
					len = i + 1;
				}
			}
			cur = next[cur][alph];
		}
		check[cur]++; //

		if (len != -1)
			return s.substring(0, len);
		else {
			if (check[cur] == 1)
				return s;
			else
				return s + check[cur];
		}
	}
}
