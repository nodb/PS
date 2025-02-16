import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		int arr[] = new int[n];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int cnt = 0, sum = arr[0];
		int first = 0, last = 0;

		while (first < n) {
			if (sum == m) {
				cnt++;
				sum -= arr[first++];
				if (++last == n) {
					break;
				}
				sum += arr[last];
			} else if (sum < m) {
				if (++last == n) {
					break;
				}
				sum += arr[last];
			} else if (sum > m) {
				if (first == last) {
					if (++last == n) {
						break;
					}
					sum += arr[last];
				}
				sum -= arr[first++];
			}
		}

		System.out.println(cnt);
	}
}
// M보다 작으면 last++
// M보다 크면 first++
//		first==last이면 first++, last++
// M과 같으면 cnt++, first++, last++
