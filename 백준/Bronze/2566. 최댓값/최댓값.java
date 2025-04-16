import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int x = 0;
		int y = 0;
		int max = 0;
		for (int i = 0; i < 9; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 9; j++) {
				int n = Integer.parseInt(st.nextToken());
				if (n > max) {
					x = i;
					y = j;
					max = n;
				}
			}
		}
		System.out.println(max);
		System.out.println((x + 1) + " " + (y + 1));
	}
}