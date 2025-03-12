import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static int arr[][];
	static ArrayList<Integer> list;

	public static void main(String[] args) throws IOException {
		// 해밀턴 경로
		// 한 꼭지점은 단 한 번만 지난다 (중복 불가)
		// 한 붓그리기
		
		// 조건
		// 서로 다른 두 작업 A, B에 대해서, A가 끝난 이후에 B를 수행할 수 있거나, B가 끝난 이후에 A를 수행할 수 있다.
		// 두 경우 모두 성립할 수도 있다, 연결 보장
		// 예) arr[1][2] = 0이면 반드시 arr[2][1] = 1
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;
		N = Integer.parseInt(br.readLine());
		arr = new int[N + 1][N + 1];
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		list = new ArrayList<>();
		list.add(1); // 초기값 : 1번
		
		for (int i = 2; i <= N; i++) { // 2번부터 순회
			int size = list.size(); // 기본 : list의 tail 바로 오른쪽
			while (size > 0 && arr[list.get(size - 1)][i] == 0) {// arr[list의 tail 값 = 1][2]이 없는 연결인 경우
				size--; // 연결이 나올 때 까지 왼쪽으로 이동
			}
			list.add(size, i); // 해당 위치에 i 삽입
		}
		sb.append(1).append("\n").append(N + " "); // 반드시 1번만에 연결(입력 회수), 꼭지점 갯수만큼 작업(작업 개수)
		for (int i : list) {
			sb.append(i + " ");
		}
		System.out.println(sb);
		
	}
}
