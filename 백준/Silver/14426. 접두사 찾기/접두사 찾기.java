import java.io.*;
import java.util.*;

public class Main {

	static int trie[][] = new int[10_000 * 500][26]; // 최대 노드 수(개수 x 길이) x 알파벳 수
	static int nodeCnt = 1; // root = 0

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		for (int i = 0; i < n; i++)
			insert(br.readLine());

		int cnt = 0;
		for (int i = 0; i < m; i++) {
			if (find(br.readLine()))
				cnt++;
		}
		System.out.println(cnt);
	}

	static void insert(String s) {
		int node = 0;
		for (int i = 0; i < s.length(); i++) {
			int c = s.charAt(i) - 'a';
			if (trie[node][c] == 0)
				trie[node][c] = nodeCnt++;
			node = trie[node][c];
		}
	}

	static boolean find(String s) {
		int node = 0;
		for (int i = 0; i < s.length(); i++) {
			int c = s.charAt(i) - 'a';
			if (trie[node][c] == 0)
				return false;
			node = trie[node][c];
		}
		return true;
	}
}
