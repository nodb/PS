import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int cnt = 0;
		for (int i = 0; i < Integer.MAX_VALUE; i++) {
			if ((i + "").contains("666")) {
				cnt++;
			}
			if (cnt == n) {
				System.out.println(i);
				return;
			}
		}
	}
}
