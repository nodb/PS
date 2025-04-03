import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		int size = (n - 1) * 4 + 1;
		for (int y = 0; y < size; y++) {
			int h = y;
			if (y > size / 2) {
				h = size - y - 1;
			}
			if (h % 2 == 0) { // 짝수 줄
				for (int i = 0; i < h; i++) {
					if (i % 2 == 0) {
						sb.append("*");
					} else {
						sb.append(" ");
					}
				}
				for (int x = h; x < size - h; x++)
					sb.append("*");
				for (int i = size - h; i < size; i++) {
					if (i % 2 == 0) {
						sb.append("*");
					} else {
						sb.append(" ");
					}
				}
			} else { // 홀수 줄
				int cnt = (h + 1) / 2;
				for (int i = 0; i < cnt; i++)
					sb.append("* ");
				for (int i = 0; i < size - (cnt * 4) + 1; i++)
					sb.append(" ");
				for (int i = 0; i < cnt; i++)
					sb.append("* ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}