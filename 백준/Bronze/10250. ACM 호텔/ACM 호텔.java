import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());

		for (int i = 0; i < T; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int H = Integer.parseInt(st.nextToken());
			int W = Integer.parseInt(st.nextToken());
			int N = Integer.parseInt(st.nextToken());
            int Y = (N % H == 0) ? H : (N % H);
            int X = (N % H == 0) ? (N / H) : (N / H) + 1;
            sb.append(Y + String.format("%02d", X) + "\n");
		}
		
		System.out.print(sb);
	}
}
