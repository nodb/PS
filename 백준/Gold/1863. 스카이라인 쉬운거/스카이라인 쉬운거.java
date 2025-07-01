import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int cnt = 0;
		Stack<Integer> s = new Stack<>();

		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			st.nextToken();
			int h = Integer.parseInt(st.nextToken());

			// 이전 값보다 낮다면
			// - 스택 제거, cnt 증가
			while (!s.isEmpty() && s.peek() > h) {
				s.pop();
				cnt++;
			}

			// 이전 값보다 높다면
			// - 스택 넣기
			if (s.isEmpty() || s.peek() < h) {
				if (h != 0)
					s.push(h);
			}
		}

		// 남아있는 높이
		cnt += s.size();

		System.out.println(cnt);
	}
}
