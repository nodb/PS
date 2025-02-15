import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int cnt = Integer.parseInt(br.readLine());
		int arr[] = new int[cnt];
		String s = br.readLine();
		for (int i = 0; i < cnt; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}

		Stack<Double> st = new Stack<>();
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) >= 'A' && s.charAt(i) <= 'Z') {
				st.push((double) arr[s.charAt(i) - 'A']);
			} else {
				Double second = st.pop();
				Double first = st.pop();
				if (s.charAt(i) == '+') {
					st.push(first + second);
				} else if (s.charAt(i) == '-') {
					st.push(first - second);
				} else if (s.charAt(i) == '*') {
					st.push(first * second);
				} else if (s.charAt(i) == '/') {
					st.push(first / second);
				}
			}
		}
		System.out.printf("%.2f", st.pop());
	}
}
