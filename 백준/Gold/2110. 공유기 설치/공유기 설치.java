import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		int arr[] = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(arr);
		
		int minDis = 1;
		int maxDis = arr[N - 1] - arr[0];
		int result = 0;
		
		while (minDis <= maxDis) {
			int midDis = (minDis + maxDis) / 2; // 공유기간 거리
//			System.out.println(Arrays.toString(arr));
//			System.out.println(minDis + " " + maxDis + " " + midDis);
			int install = arr[0]; // 설치 값
			int cnt = 1;
			for (int i = 1; i < N; i++) {
				if (install + midDis <= arr[i]) {
					install = arr[i];
					cnt++;
				}
			}
//			System.out.println("cnt : " + cnt);
		    if (cnt >= C) {
		        result = midDis;     // 현재 midDis 값 저장
		        minDis = midDis + 1; // 더 큰 간격을 시도
		    } else {
		        maxDis = midDis - 1; // 설치 불가능하므로 간격을 줄여야 함
		    }
		}
		System.out.println(result);
	}
}