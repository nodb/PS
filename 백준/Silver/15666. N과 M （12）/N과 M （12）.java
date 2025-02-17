import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	static int n, m;
	static int[] arr;
	static List<Integer> print;
	static LinkedHashSet<List<Integer>> save;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		arr = new int[n];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(arr);
		print = new ArrayList<>();
		save = new LinkedHashSet<>();

		perm(0);

		StringBuilder sb = new StringBuilder();
		for (List<Integer> list : save) {
			for (int num : list) {
				sb.append(num + " ");
			}
			sb.append("\n");
		}
		System.out.print(sb);
	}

	private static void perm(int cnt) {
		if (cnt == m) {
			save.add(new ArrayList<>(print));  // 중복 방지를 위해 LinkedHashSet 사용
			return;
		}
		for (int i = 0; i < n; i++) {
			if (!print.isEmpty() && print.get(print.size() - 1) > arr[i]) {
				continue;
			}
			print.add(arr[i]);
			perm(cnt + 1);
			print.remove(print.size() - 1);
		}
	}
}
