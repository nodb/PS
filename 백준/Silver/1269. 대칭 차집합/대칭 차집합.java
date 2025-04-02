import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int aCnt = Integer.parseInt(st.nextToken());
		int bCnt = Integer.parseInt(st.nextToken());

		boolean list[] = new boolean[100_000_000];
		int cnt = aCnt + bCnt;
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < aCnt; i++)
			list[Integer.parseInt(st.nextToken())] = true;
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < bCnt; i++) {
			int n = Integer.parseInt(st.nextToken());
			if (list[n]) {
				list[n] = false;
				cnt -= 2;
			} else
				list[n] = true;
		}
		System.out.println(cnt);
	}
}
