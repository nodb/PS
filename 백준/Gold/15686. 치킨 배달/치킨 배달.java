import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int m;
	static int arr[][];
	static int arr_visited[][];
	static int num1[][];
	static int num2[][];
	static int cnt1 = 0;
	static int cnt2 = 0;
	static int result = Integer.MAX_VALUE;
	static ArrayList<Integer> list;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new int[n][n];
		num1 = new int[2*n+1][2];
		num2 = new int[14][2];
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if (arr[i][j] == 1) {
					num1[cnt1][0] = i;
					num1[cnt1++][1] = j;
				}
				if (arr[i][j] == 2) {
					num2[cnt2][0] = i;
					num2[cnt2++][1] = j;
				}
			}
		}
		
		arr_visited = new int[cnt2][cnt1];
		for (int i = 0; i < cnt2; i++) {
			int y2 = num2[i][0];
			int x2 = num2[i][1];
			for (int j = 0; j < cnt1; j++) {
				int y1 = num1[j][0];
				int x1 = num1[j][1];
				arr_visited[i][j] = Math.abs(x2 - x1) + Math.abs(y2 - y1);
			}
		}
		
//		System.out.println("2칸");
//		for (int i = 0; i < cnt2; i++) {
//			System.out.println(num2[i][0] + " " + num2[i][1]);
//		}
//		
//		System.out.println("1칸");
//		for (int i = 0; i < cnt1; i++) {
//			System.out.println(num1[i][0] + " " + num1[i][1]);
//		}
//		
//		System.out.println("거리");
//		for (int i = 0; i < cnt2; i++) {
//			for (int j = 0; j < cnt1; j++) {
//				System.out.print(arr_visited[i][j] + " ");
//			}
//			System.out.println();
//		}
		
		list = new ArrayList<>();
		combi(0); // cnt2 C m
		
		System.out.println(result);
	}
	private static void combi(int c) {
		if (list.size() == m) {
//			System.out.println(list);
			minDistance(list);
			return;
		}
		for (int i = c; i < cnt2; i++) {
			list.add(i);
			combi(i + 1);
			list.remove(list.size() - 1);
		}
	}
	
	private static void minDistance(ArrayList<Integer> l) {
		int sum = 0;
		for (int j = 0; j < cnt1; j++) {
			int min = Integer.MAX_VALUE;
			for (int i : l) {
				if (arr_visited[i][j] < min) {
					min = arr_visited[i][j];
				}
			}
			sum += min;
		}
//		System.out.println("sum : " + sum);
		if (sum < result) {
			result = sum;
		}
	}
}
