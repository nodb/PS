import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int j = Integer.parseInt(br.readLine());
		
		int left = 1;
		int right = m;
		int cnt = 0;
		
		for (int i = 0; i < j; i++) {
			int apple = Integer.parseInt(br.readLine());
			
			if (apple > right) {
				cnt += apple - right;
				left += apple - right;
				right += apple - right;
			} else if (apple < left) {
				cnt += left - apple;
				right -= left - apple;
				left -= left - apple;
			}
		}
		System.out.println(cnt);
	}
}