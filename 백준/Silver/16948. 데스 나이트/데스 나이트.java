import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int x1 = Integer.parseInt(st.nextToken());
		int y1 = Integer.parseInt(st.nextToken());
		int x2 = Integer.parseInt(st.nextToken());
		int y2 = Integer.parseInt(st.nextToken());
		int diffX = Math.abs(x2 - x1);
		int diffY = Math.abs(y2 - y1);
		int maxDiffX = diffX / 2;
		if (diffX % 2 == 1) {
			System.out.println(-1);
			return;
		}
		if ((diffX / 2) % 2 == 1 && diffY % 2 == 0) {
			System.out.println(-1);
			return;
		}
		if ((diffX / 2) % 2 == 0 && diffY % 2 == 1) {
			System.out.println(-1);
			return;
		}
		int result = diffX / 2;
		if (diffY - maxDiffX > 0)
			result += (diffY - maxDiffX) / 2;
		System.out.println(result);
	}
}