import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		double sum = 0;
		int gradeCnt = 0;
		for (int i = 0; i < 20; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			st.nextToken();
			double grade = Double.parseDouble(st.nextToken());
			String alph = st.nextToken();
			if (alph.equals("A+")) {
				sum += 4.5 * grade;
				gradeCnt += grade;
			} else if (alph.equals("A0")) {
				sum += 4.0 * grade;
				gradeCnt += grade;
			} else if (alph.equals("B+")) {
				sum += 3.5 * grade;
				gradeCnt += grade;
			} else if (alph.equals("B0")) {
				sum += 3.0 * grade;
				gradeCnt += grade;
			} else if (alph.equals("C+")) {
				sum += 2.5 * grade;
				gradeCnt += grade;
			} else if (alph.equals("C0")) {
				sum += 2.0 * grade;
				gradeCnt += grade;
			} else if (alph.equals("D+")) {
				sum += 1.5 * grade;
				gradeCnt += grade;
			} else if (alph.equals("D0")) {
				sum += 1.0 * grade;
				gradeCnt += grade;
			} else if (alph.equals("F")) {
				sum += 0;
				gradeCnt += grade;
			} else if (alph.equals("P"))
				continue;
		}
		System.out.printf("%f", (sum / gradeCnt));
	}
}