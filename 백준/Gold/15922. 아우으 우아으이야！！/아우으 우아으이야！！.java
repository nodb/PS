import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine());
		int prevX = Integer.parseInt(st.nextToken());
		int prevY = Integer.parseInt(st.nextToken());
		int sum = prevY - prevX;

		for (int i = 1; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			if (y < prevY) {
				continue;
			} else if (x < prevY) {
				sum += y - prevY;
				prevY = y;
			} else { // x > prevY
				sum += y - x;
				prevY = y;
			}
		}
		System.out.println(sum);
	}
}