import java.io.*;
import java.util.*;

public class Main {
	static int MAX = 1_000_000;
	static int arr[];

	public static void main(String[] args) throws Exception {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 에라토스테네스의 체
		ArrayList<Integer> list = new ArrayList<>();
		list.add(2); // 2는 유일한 짝수 소수

		int size = (MAX - 1) / 2; // 홀수만 관리
		boolean isComposite[] = new boolean[size];

		int limit = (int) Math.sqrt(MAX);

		for (int i = 1; (2 * i + 1) <= limit; i++) {
			if (!isComposite[i]) { // 아직 지워지지 않은 수
				int p = 2 * i + 1;
				for (int j = (p * p - 1) / 2; j < size; j += p) {
					isComposite[j] = true;
				}
			}
		}

		for (int i = 1; i < size; i++) {
			if (!isComposite[i]) {
				list.add(2 * i + 1);
			}
		}

		arr = new int[list.size()];
		for (int i = 0; i < list.size(); i++)
			arr[i] = list.get(i);

		int n = Integer.parseInt(br.readLine());
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int left = lowerBound(Integer.parseInt(st.nextToken())); // primes[left] >= a
			int right = upperBound(Integer.parseInt(st.nextToken())); // primes[right] > b
			int count = right - left; // [a,b] 범위 소수 개수
			if (count % 2 == 0) {
				sb.append(-1).append('\n');
			} else {
				sb.append(arr[(right + left) / 2]).append('\n');
			}
		}
		System.out.println(sb);
	}

	// 이분 탐색
	// arr에서 최초로 arr[idx] >= target 인 idx
	static int lowerBound(int target) {
		int l = 0;
		int r = arr.length; // [l, r)
		while (l < r) {
			int m = (l + r) / 2;
			if (arr[m] >= target)
				r = m;
			else
				l = m + 1;
		}
		return l;
	}

	// arr에서 최초로 arr[idx] > target 인 idx
	static int upperBound(int target) {
		int l = 0;
		int r = arr.length; // [l, r)
		while (l < r) {
			int m = (l + r) / 2;
			if (arr[m] > target)
				r = m;
			else
				l = m + 1;
		}
		return l;
	}
}
