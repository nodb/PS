import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			String s = br.readLine();
			if (s.equals("0"))
				break;
			char c[] = s.toCharArray();
			int cnt = 0;
			for (char cc : c) {
				if (cc == '0') {
					cnt += 4;
				}
				else if (cc == '1') {
					cnt += 2;
				}
				else {
					cnt += 3;
				}
			}
			cnt += c.length + 1;
			sb.append(cnt + "\n");
		}
		System.out.println(sb);
	}
}
