import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> U = new PriorityQueue<>(); // 양의 정수
		PriorityQueue<Integer> D = new PriorityQueue<>(Collections.reverseOrder()); // 음의 정수

		for (int i = 0; i < N; i++) {
			int x = Integer.parseInt(br.readLine());
			if (x > 0) {
				U.add(x);
			} else if (x < 0) {
				D.add(x);
			} else { // x == 0
				if (U.isEmpty() && D.isEmpty())
					System.out.println(0);
				else if (U.isEmpty())
					System.out.println(D.poll());
				else if (D.isEmpty())
					System.out.println(U.poll());
				else
					System.out.println(D.peek() * -1 <= U.peek() ? D.poll() : U.poll());
			}
		}
	}
}
