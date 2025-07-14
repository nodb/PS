import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		while (T-- > 0) {
			String p = br.readLine();
			int n = Integer.parseInt(br.readLine());
			String s = br.readLine();
			Deque<String> dq;
			if (s.equals("[]")) {
				dq = new ArrayDeque<>();
			} else {
				String[] x = s.substring(1, s.length() - 1).split(",");
				List<String> list = Arrays.asList(x); // java.lang.UnsupportedOperationException 발생
				dq = new ArrayDeque<>(list);
			}
			boolean isError = false;
			boolean isForward = true; // 정방향인지
			for (int i = 0; i < p.length(); i++) {
				if (p.charAt(i) == 'R')
					isForward = !isForward;
				else { // D
					if (dq.size() == 0) {
						sb.append("error").append("\n");
						isError = true;
						break;
					}
					if (isForward)
						dq.removeFirst();
					else
						dq.removeLast();
				}
			}
			if (!isError) {
				sb.append("[");
				if (isForward) {
					while (!dq.isEmpty()) {
						sb.append(dq.removeFirst());
						if (!dq.isEmpty())
							sb.append(",");
					}
				} else {
					while (!dq.isEmpty()) {
						sb.append(dq.removeLast());
						if (!dq.isEmpty())
							sb.append(",");
					}
				}
				sb.append("]").append("\n");
			}
		}
		System.out.println(sb);
	}
}
