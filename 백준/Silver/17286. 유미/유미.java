import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static double min = 10000;
	static int[] p0 = new int[2];
	static int[] p1 = new int[2];
	static int[] p2 = new int[2];
	static int[] p3 = new int[2];
	
    public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		p0[0] = Integer.parseInt(st.nextToken());
		p0[1] = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		p1[0] = Integer.parseInt(st.nextToken());
		p1[1] = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		p2[0] = Integer.parseInt(st.nextToken());
		p2[1] = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		p3[0] = Integer.parseInt(st.nextToken());
		p3[1] = Integer.parseInt(st.nextToken());

		if (d(p0, p1) + d(p1, p2) + d(p2, p3) < min) {
			min = d(p0, p1) + d(p1, p2) + d(p2, p3);
		}
		if (d(p0, p1) + d(p1, p3) + d(p3, p2) < min) {
			min = d(p0, p1) + d(p1, p3) + d(p3, p2);
		}
		if (d(p0, p2) + d(p2, p3) + d(p3, p1) < min) {
			min = d(p0, p2) + d(p2, p3) + d(p3, p1);
		}
		if (d(p0, p2) + d(p2, p1) + d(p1, p3) < min) {
			min = d(p0, p2) + d(p2, p1) + d(p1, p3);
		}
		if (d(p0, p3) + d(p3, p1) + d(p1, p2) < min) {
			min = d(p0, p3) + d(p3, p1) + d(p1, p2);
		}
		if (d(p0, p3) + d(p3, p2) + d(p2, p1) < min) {
			min = d(p0, p3) + d(p3, p2) + d(p2, p1);
		}
		System.out.printf("%.0f", Math.floor(min));

	}

	private static double d(int[] d1, int[] d2) {
		double x = Math.pow(d1[0] - d2[0], 2);
		double y = Math.pow(d1[1] - d2[1], 2);
		return Math.sqrt(x + y);
	}
}
