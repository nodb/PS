import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		if (n == 1) {
			System.out.println(arr[0]);
			return;
		} else if (n == 2) {
			System.out.println(arr[0] + arr[1]);
			return;
		}
		int[][] max = new int[n][2]; // [i][0]: 연속 X, [i][1]: 연속
		max[0][0] = arr[0];
		max[0][1] = arr[0];
		max[1][0] = arr[1];
		max[1][1] = arr[0] + arr[1];
		for (int i = 2; i < n; i++) {
			max[i][0] = Math.max(max[i - 2][0], max[i - 2][1]) + arr[i];
			max[i][1] = max[i - 1][0] + arr[i];
		}
		
		System.out.println(Math.max(max[n - 1][0], max[n - 1][1]));
	}
}

/*
 * 
 * 조건
 * 
 * 1. +1 or +2
 * 
 * 2. 연속 세 번 X
 * 
 * 3. 마지막은 반드시
 * 
 * 풀이
 * 
 * 1. 연속 3번 아닌 경우
 * 
 * max[i-1] max[i-2] 중 큰 값
 * 
 * max[i][0] = Math.max(max[i - 1][0], max[i - 2][0]) + arr[i];
 * 
 * 2. 연속 3번인 경우
 * 
 * max[i-2]
 * 
 * max[i][1] = max[i - 2][1] + arr[i];
 */