import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		String S = br.readLine();
		String P = "I";
		for (int i = 0; i < N; i++)
			P += "OI";

		int cnt = 0;
		for (int i = 0; i < M - (2 * N); i++)
			if (S.substring(i, i + 1 + (2 * N)).equals(P))
				cnt++;
		System.out.println(cnt);
	}
}