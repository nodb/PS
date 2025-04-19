import java.io.*;
import java.util.*;

class Solution
{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());

			int bit = (1 << n) - 1;
			sb.append("#" + test_case + " ");
			if ((m & bit) == bit)
				sb.append("ON");
			else
				sb.append("OFF");
			sb.append("\n");
		}
		System.out.println(sb);
	}
}