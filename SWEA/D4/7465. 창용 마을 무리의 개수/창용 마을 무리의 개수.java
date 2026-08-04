import java.io.*;
import java.util.*;

class Solution {

    static int N;
    static int M;
    static int[] parent;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {

            StringTokenizer st = new StringTokenizer(br.readLine());

            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            parent = new int[N + 1];
            
            // 유니온 파인드 문제!!
            // 자기 자신 초기화
            for (int i = 1; i <= N; i++) {
                parent[i] = i;
            }

            // 관계 입력
            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());

                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                union(a, b);
            }

            // set(중복 허용 X)에 넣기
            HashSet<Integer> hs = new HashSet<>();

            for (int i = 1; i <= N; i++) {
                hs.add(find(i));
            }

            // set 크기 = 무리 개수
            sb.append("#" + tc + " " + hs.size() + "\n");
        }

        System.out.print(sb);
    }
    
    static void union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);

        if (rootA == rootB) {
            return;
        }
        parent[rootB] = rootA;
    }

    static int find(int x) {
        if (parent[x] == x) {
            return x;
        }
        return parent[x] = find(parent[x]);
    }
}