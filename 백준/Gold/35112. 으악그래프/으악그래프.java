import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken()); // 정점 개수
		int m = Integer.parseInt(st.nextToken()); // 간선 개수
		// 단순 연결 그래프 G, 방향 X
		// 정점 : 1 ~ N
		// 으악그래프 : 두 간선 제거했을 때, 연결 끊김 -> 1부터 N까지 연결 X
		// 두 개의 간선을 제거했음에도 한번이라도 연결그래프인 경우 -> No
		// 모든 두 개의 간선 제거에도 연결그래프 X인 경우 -> Yes
		// 항상 으악그래프인 경우
		// M <= N
		if (m <= n)
			System.out.println("Yes");
		else
			System.out.println("No");
	}
}