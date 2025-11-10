import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		char c[] = s.toCharArray();
		int result = 10;
		for (int i = 1; i < c.length; i++) {
			if (c[i - 1] == c[i])
				result += 5;
			else
				result += 10;
		}
		System.out.println(result);
	}
}
