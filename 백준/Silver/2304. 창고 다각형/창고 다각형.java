import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int arr[] = new int[1001];

		int maxL = 0;
		int minL = 1001;
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int L = Integer.parseInt(st.nextToken());
			int H = Integer.parseInt(st.nextToken());
			if (L > maxL)
				maxL = L;
			if (L < minL)
				minL = L;
			arr[L] = H;
		}

		int sum = 0;
		int height = arr[minL];
		for (int i = minL; i <= maxL; i++) {
			if (height < arr[i]) {
				sum += (i - minL) * height;
				minL = i;
				height = arr[i];
			}
		}
		height = arr[maxL];
		for (int i = maxL; i >= minL; i--) {
			if (height < arr[i]) {
				sum += (maxL - i) * height;
				maxL = i;
				height = arr[i];
			}
		}
		sum += (maxL - minL + 1) * height;
		System.out.println(sum);
	}

}