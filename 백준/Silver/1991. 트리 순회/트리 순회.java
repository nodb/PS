import java.io.*;
import java.util.*;

public class Main {
	static StringBuilder sb = new StringBuilder();
	static char arr[][];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		arr = new char[n][3];
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int alpa = st.nextToken().charAt(0);
			arr[alpa - 'A'][0] = (char) alpa; 
			arr[alpa - 'A'][1] = st.nextToken().charAt(0);
			arr[alpa - 'A'][2] = st.nextToken().charAt(0);
		}

		pre('A');
		sb.append('\n');
		in('A');
		sb.append('\n');
		post('A');
		System.out.println(sb);
	}

	private static void pre(char c) {
		if (c == '.')
			return;
		sb.append(c);
		pre(arr[c - 'A'][1]);
		pre(arr[c - 'A'][2]);
	}
	

	private static void in(char c) {
		if (c == '.')
			return;
		in(arr[c - 'A'][1]);
		sb.append(c);
		in(arr[c - 'A'][2]);
	}
	
	private static void post(char c) {
		if (c == '.')
			return;
		post(arr[c - 'A'][1]);
		post(arr[c - 'A'][2]);
		sb.append(c);
	}
}
