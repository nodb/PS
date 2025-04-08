import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		int arr[] = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++)
			arr[i] = Integer.parseInt(st.nextToken());

		int dp[] = new int[n]; // 이진 탐색 대상
		int index[] = new int[n]; // dp 배열 위치에 해당하는 원래 인덱스를 저장 (수열 복원)
		int parent[] = new int[n]; // 각 원소의 LIS 내 이전 원소 인덱스 (복원 경로)
		Arrays.fill(parent, -1);

		int length = 0;

		for (int i = 0; i < n; i++) {
			// 이진 탐색
			int pos = Arrays.binarySearch(dp, 0, length, arr[i]);
			if (pos < 0)
				pos = -(pos + 1);

			dp[pos] = arr[i]; // 현재 원소로 갱신
			index[pos] = i; // 해당 위치에 원소의 인덱스 저장

			if (pos > 0) // pos가 0보다 크면, 이전 위치의 인덱스를 parent에 저장
				parent[i] = index[pos - 1];

			if (pos == length) // 새로운 길이가 형성된 경우 길이 증가
				length++;
		}

		sb.append(length).append("\n");

		int[] lis = new int[length]; // 복원: 최종 LIS의 마지막 원소 인덱스
		int k = index[length - 1];
		for (int i = length - 1; i >= 0; i--) { // parent 포인터를 따라 역으로 추적
			lis[i] = arr[k];
			k = parent[k];
		}

		for (int num : lis) {
			sb.append(num).append(" ");
		}
		System.out.println(sb);
	}
}
