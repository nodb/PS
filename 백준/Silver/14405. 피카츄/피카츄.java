import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		int n = 0;
		boolean can = true;
		while (n != s.length()) {
			if (s.charAt(n) == 'p') {
				if (n + 1 < s.length() && s.charAt(n + 1) == 'i') {
					n += 2;
				} else {
					can = false;
					break;
				}
			} else if (s.charAt(n) == 'k') {
				if (n + 1 < s.length() && s.charAt(n + 1) == 'a') {
					n += 2;
				} else {
					can = false;
					break;
				}
			} else if (s.charAt(n) == 'c') {
				if (n + 2 < s.length() && s.charAt(n + 1) == 'h' && s.charAt(n + 2) == 'u') {
					n += 3;
				} else {
					can = false;
					break;
				}
			} else {
				can = false;
				break;
			}
		}
		System.out.println(can ? "YES" : "NO");
	}
}
