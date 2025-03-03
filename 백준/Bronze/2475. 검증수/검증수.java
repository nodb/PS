import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n1 = Integer.parseInt(st.nextToken());
		int n2 = Integer.parseInt(st.nextToken());
		int n3 = Integer.parseInt(st.nextToken());
		int n4 = Integer.parseInt(st.nextToken());
		int n5 = Integer.parseInt(st.nextToken());

		System.out.println(((long) n1 * n1 + (long) n2 * n2 + (long) n3 * n3 + (long) n4 * n4 + (long) n5 * n5) % 10);

	}
}
