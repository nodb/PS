import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        
        StringBuilder sb = new StringBuilder();
        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());  // 건물의 개수
            int K = Integer.parseInt(st.nextToken());  // 건설 규칙의 개수
            
            // 각 건물의 건설 시간 저장 (1-indexed)
            int[] time = new int[N + 1];
            // 각 건물까지 도달하는 데 걸리는 최소 시간을 저장하는 dp 배열
            int[] dp = new int[N + 1];
            // 진입 차수 배열 (선행 건물 개수)
            int[] indegree = new int[N + 1];
            
            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= N; i++) {
                time[i] = Integer.parseInt(st.nextToken());
                dp[i] = time[i];  // 초기값은 자기 자신의 건설 시간
            }
            
            // 인접 리스트로 그래프 구성
            List<Integer>[] graph = new ArrayList[N + 1];
            for (int i = 1; i <= N; i++) {
                graph[i] = new ArrayList<>();
            }
            
            // 건설 규칙 입력받기: X 건물을 짓고 Y 건물을 지을 수 있음
            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine());
                int X = Integer.parseInt(st.nextToken());
                int Y = Integer.parseInt(st.nextToken());
                graph[X].add(Y);
                indegree[Y]++;
            }
            
            // 목표 건물 번호
            int target = Integer.parseInt(br.readLine());
            
            // 위상 정렬을 위한 큐 초기화
            Queue<Integer> queue = new LinkedList<>();
            for (int i = 1; i <= N; i++) {
                if (indegree[i] == 0) {
                    queue.add(i);
                }
            }
            
            // 위상 정렬 및 동적 계획법(DP) 수행
            while (!queue.isEmpty()) {
                int curr = queue.poll();
                for (int next : graph[curr]) {
                    // 선행 건물들을 모두 건설한 후 다음 건물을 건설하는 최소 시간 계산
                    dp[next] = Math.max(dp[next], dp[curr] + time[next]);
                    indegree[next]--;
                    if (indegree[next] == 0) {
                        queue.add(next);
                    }
                }
            }
            
            sb.append(dp[target]).append("\n");
        }
        System.out.print(sb);
    }
}
