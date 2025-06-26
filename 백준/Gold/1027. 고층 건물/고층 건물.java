import java.io.*;
import java.util.*;
import java.util.Map.Entry;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int arr[] = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++)
			arr[i] = Integer.parseInt(st.nextToken());

		// 사이 각이 작은 것에서 커질수록 보임(같은 건 제외)
		// 사이각 tan : 길이(x) / 높이(y)
		// 높이 차가 양수이면 둔각
		int max = 0;
		for (int i = 0; i < N; i++) {
			double tan[] = new double[N];
			for (int j = 0; j < N; j++) {
				if (j == i) {
					tan[j] = 0;
					continue;
				}
				// 높이가 같은 경우
				if (arr[j] == arr[i])
					tan[j] = 0;
				else
					tan[j] = (double) (arr[j] - arr[i]) / (j - i);
			}
			int cnt = 0;
			double left = Integer.MAX_VALUE;
			double right = Integer.MIN_VALUE;
			// 왼쪽 : 큰 수에서 작은 수로 가면 cnt++
			for (int j = i - 1; j >= 0; j--) {
				if (tan[j] < left) {
					left = tan[j];
					cnt++;
				}
			}
			// 오른쪽 : 작은 수에서 큰 수로 가면 cnt++
			for (int j = i + 1; j < N; j++) {
				if (tan[j] > right) {
					right = tan[j];
					cnt++;
				}
			}
			if (max < cnt)
				max = cnt;
		}
		System.out.println(max);
	}
}
