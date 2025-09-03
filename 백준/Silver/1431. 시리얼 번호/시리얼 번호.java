import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<String> pq = new PriorityQueue<>((o1, o2) -> {
			if (o1.length() != o2.length()) // 길이가 다르면
				return Integer.compare(o1.length(), o2.length()); // 짧은 순
			else {
				int sum1 = 0; // o1 자리합
				int sum2 = 0; // 02 자리합
				for (int i = 0; i < o1.length(); i++)
					if (o1.charAt(i) >= '0' && o1.charAt(i) <= '9')
						sum1 += o1.charAt(i) - '0';
				for (int i = 0; i < o2.length(); i++)
					if (o2.charAt(i) >= '0' && o2.charAt(i) <= '9')
						sum2 += o2.charAt(i) - '0';
				if (sum1 != sum2) // 자리합이 다르다면
					return Integer.compare(sum1, sum2); // 자리합 작은 순
				else
					return o1.compareTo(o2); // 사전 순
			}
		});
		for (int i = 0; i < N; i++)
			pq.add(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++)
			sb.append(pq.remove()).append('\n');
		System.out.println(sb);
	}
}