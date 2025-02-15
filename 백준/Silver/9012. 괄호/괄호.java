import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int testcase = Integer.parseInt(br.readLine());
		for (int tc = 0; tc < testcase; tc++) {
			String s = br.readLine();
			int cnt = s.length();
			boolean flag = true;
			Stack<Character> st = new Stack<>();
			for (int i = 0; i < cnt; i++) {
				if (s.charAt(i) == '(') {
					st.push(s.charAt(i));
				} else if (s.charAt(i) == ')') {
					if (st.isEmpty()) {
						flag = false;
						break;
					}
					st.pop();
				}
			}
			if (!st.isEmpty()) {
				flag = false;
			}
			sb.append((flag ? "YES" : "NO") + "\n");
		}
		System.out.println(sb);
	}
}
