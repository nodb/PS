import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		/*
		 * 가장 긴 V자 모양
		 * 
		 * 가운데가 c번째 - 0 ~ c : 내리막길 - c ~ n-1 : 오르막길
		 * 
		 * 각각 왼쪽, 오른쪽 최대값 구하기 전체가 내리막길 or 오르막길 가능
		 */
		int[] left = new int[n];
		int[] right = new int[n];
		Arrays.fill(left, 1);
		Arrays.fill(right, 1);

		for (int c = 0; c < n; c++) {
			for (int l = 0; l < c; l++) {
				if (arr[l] > arr[c]) {
					left[c] = Math.max(left[c], left[l] + 1);
				}
			}
		}
		for (int c = n - 1; c >= 0; c--) {
			for (int r = c + 1; r < n; r++) {
				if (arr[c] < arr[r]) {
					right[c] = Math.max(right[c], right[r] + 1);
				}
			}
		}

		int max = 0;
		for (int i = 0; i < n; i++) {
			max = Math.max(max, left[i] + right[i]);
		}

		System.out.println(max - 1);
	}
}