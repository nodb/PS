import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> minH = new PriorityQueue<>(Collections.reverseOrder());
		PriorityQueue<Integer> maxH = new PriorityQueue<>();

		for (int i = 0; i < N; i++) {
			int x = Integer.parseInt(br.readLine());
			if (x == 0) {
				int min = 0;
				int max = 0;
				if (!minH.isEmpty())
					min = minH.remove();
				if (!maxH.isEmpty())
					max = maxH.remove();

				if (min == 0 && max == 0)
					sb.append(0).append("\n");
				else if (min == 0 && max != 0)
					sb.append(max).append("\n");
				else if (min != 0 && max == 0)
					sb.append(min).append("\n");
				else { // min != 0 && max != 0
					if (min * -1 <= max) {
						sb.append(min).append("\n");
						maxH.add(max);
					} else {
						sb.append(max).append("\n");
						minH.add(min);
					}
				}

			} else if (x < 0) {
				minH.add(x);
			} else if (x > 0) {
				maxH.add(x);
			}
		}
		System.out.println(sb);
	}
}
