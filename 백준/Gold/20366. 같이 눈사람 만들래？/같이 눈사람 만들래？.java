import java.io.*;
import java.util.*;

public class Main {
    static class Pair implements Comparable<Pair> {
        int i, j;
        long sum;
        public Pair(int i, int j, long sum) {
            this.i = i;
            this.j = j;
            this.sum = sum;
        }
        @Override
        public int compareTo(Pair o) {
            return Long.compare(this.sum, o.sum);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine().trim());
        long[] H = new long[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int k = 0; k < N; k++) {
            H[k] = Long.parseLong(st.nextToken());
        }
        Arrays.sort(H);

        // 1) 모든 눈사람 쌍 생성
        int P = N * (N - 1) / 2;
        Pair[] pairs = new Pair[P];
        int idx = 0;
        for (int a = 0; a < N; a++) {
            for (int b = a + 1; b < N; b++) {
                pairs[idx++] = new Pair(a, b, H[a] + H[b]);
            }
        }

        // 2) 높이 기준 정렬
        Arrays.sort(pairs);

        // 3) 인접한 쌍 중 겹치지 않는 것들의 최소 차이 찾기
        long ans = Long.MAX_VALUE;
        for (int k = 1; k < P; k++) {
            Pair p1 = pairs[k - 1];
            Pair p2 = pairs[k];
            // 완전한 겹침 체크: i,j 전부 달라야 함
            if (p1.i != p2.i && p1.i != p2.j && p1.j != p2.i && p1.j != p2.j) {
                long diff = p2.sum - p1.sum;
                if (diff < ans) ans = diff;
                // diff가 0이면 더 이상 작아질 수 없으므로 종료해도 됩니다.
                if (ans == 0) break;
            }
        }

        System.out.println(ans);
    }
}
