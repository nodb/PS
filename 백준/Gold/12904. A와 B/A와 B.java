import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String S = br.readLine();
		String T = br.readLine();
		while (S.length() != T.length()) {
			if (T.charAt(T.length() - 1) == 'A') // tail = A : tail을 없애기
				T = T.substring(0, T.length() - 1);
			else { // tail = B : tail을 없애고 flip
				StringBuilder sb = new StringBuilder();
				sb.append(T.substring(0, T.length() - 1));
				T = sb.reverse().toString(); // 뒤집기
			}
		}
		System.out.println(S.equals(T) ? 1 : 0);
	}
}
