import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int arr[] = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++)
			arr[i] = Integer.parseInt(st.nextToken());

		int max = 0;
		// 2가지를 선택하는 모든 가능한 경우의 수
		// 선택한 수 : num1, num2
		for (int num1 = 1; num1 <= 8; num1++) {
			for (int num2 = num1 + 1; num2 <= 9; num2++) {
				int cnt = 0;
				// 배열을 도는 동안
				for (int i = 0; i < N; i++) {
					// 선택한 수가 아니라면
					if (arr[i] != num1 && arr[i] != num2) {
						// max 갱신
						if (cnt > max)
							max = cnt;
						// cnt 초기화
						cnt = 0;
					}
					// 선택한 수라면
					else
						// cnt 증가
						cnt++;
				}
				// 다 끝나고 한 번 더 확인
				if (cnt > max)
					max = cnt;
			}
		}
		System.out.println(max);
	}
}