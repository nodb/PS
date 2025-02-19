import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {
	static int a[], b[];
	static int a_win, b_win;
	static boolean visited[];
	static int arr[];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testcase = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= testcase; tc++) {
			a = new int[9]; // 규영
			b = new int[9]; // 인영
			boolean used[] = new boolean[19]; // 규영 미사용 카드			
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 9; i++) {
				a[i] = Integer.parseInt(st.nextToken());
				used[a[i]] = true;
			}
			
			int index = 0;
			for (int i = 1; i <= 18; i++) {
				if (!used[i]) {
					b[index++] = i;
				}
			}

			a_win = 0; // 규영 승리 횟수
			b_win = 0; // 인영 승리 횟수
			visited = new boolean[9];
			arr = new int[9];
			perm(0);
			System.out.println("#" + tc + " " + a_win + " " + b_win);
		}
	}

	private static void perm(int cnt) {
		if (cnt == 9) {
			int a_score = 0;
			int b_score = 0;
			for (int i = 0; i < 9; i++) {
				if (a[i] > b[arr[i]]) {
					a_score += a[i] + b[arr[i]];
				} else if (a[i] < b[arr[i]]) {
					b_score += a[i] + b[arr[i]];
				}
			}
			if (a_score > b_score) {
				a_win++;
			} else if (a_score < b_score) {
				b_win++;
			}
			return;
		}
		for (int i = 0; i < 9; i++) {
			if (!visited[i]) {
				visited[i] = true;
				arr[cnt] = i;
				perm(cnt + 1);
				visited[i] = false;
			}
		}
	}
}

//362880