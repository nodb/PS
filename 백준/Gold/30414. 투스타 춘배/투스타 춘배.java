import java.io.*;
import java.util.*;

public class Main {

    // ---------- FastScanner (BufferedInputStream 기반) ----------
    static class FastScanner {
        private final InputStream in;
        private final byte[] buffer = new byte[1 << 16];
        private int ptr = 0, len = 0;

        FastScanner(InputStream in) { this.in = in; }

        private int readByte() throws IOException {
            if (ptr >= len) {
                len = in.read(buffer);
                ptr = 0;
                if (len <= 0) return -1;
            }
            return buffer[ptr++];
        }

        int nextInt() throws IOException {
            int c;
            do { c = readByte(); } while (c <= ' '); // 공백 스킵
            int sign = 1;
            if (c == '-') { sign = -1; c = readByte(); }
            int val = 0;
            while (c > ' ') {
                val = val * 10 + (c - '0');
                c = readByte();
            }
            return val * sign;
        }
    }

    // ---------- 인접 리스트를 배열로 구현 (head/to/next) ----------
    static int N, P;
    static int[] head, to, next;
    static int edgePtr = 0;

    static void addEdge(int u, int v) {
        to[edgePtr] = v;
        next[edgePtr] = head[u];
        head[u] = edgePtr++;
    }

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in);

        N = fs.nextInt();
        P = fs.nextInt();

        // diff[i] = (목표 - 현재)  : 양수면 부족, 음수면 남음
        long[] cur = new long[N + 1];
        long[] diff = new long[N + 1];

        for (int i = 1; i <= N; i++) cur[i] = fs.nextInt();
        for (int i = 1; i <= N; i++) {
            long target = fs.nextInt();
            diff[i] = target - cur[i];
        }

        // 간선 배열 초기화 (트리이므로 2*(N-1))
        head = new int[N + 1];
        Arrays.fill(head, -1);
        to = new int[2 * (N - 1)];
        next = new int[2 * (N - 1)];

        for (int i = 0; i < N - 1; i++) {
            int u = fs.nextInt();
            int v = fs.nextInt();
            addEdge(u, v);
            addEdge(v, u);
        }

        // parent, order를 만들어 "후위 순회 효과"를 냄 (order 역순으로 DP)
        int[] parent = new int[N + 1];
        int[] order = new int[N];
        int[] stack = new int[N];
        int top = 0, ordSz = 0;

        parent[P] = 0;
        stack[top++] = P;

        // 스택으로 루트 P 기준 트리 방향(부모) 확정 + 방문 순서 저장
        while (top > 0) {
            int u = stack[--top];
            order[ordSz++] = u;

            for (int e = head[u]; e != -1; e = next[e]) {
                int v = to[e];
                if (v == parent[u]) continue; // 부모로 되돌아가는 간선 제거
                parent[v] = u;
                stack[top++] = v;
            }
        }

        // need[u] = 부모가 u(서브트리)를 위해 "위에서 내려줘야 하는 최소 흙"
        // need[u] = max(0, diff[u] + Σ need[child])
        long[] need = new long[N + 1];

        // order는 루트->리프 방향이므로, 역순으로 처리하면 리프->루트(후위) DP가 됨
        for (int i = ordSz - 1; i >= 0; i--) {
            int u = order[i];

            long acc = diff[u]; // u 자체에서 필요한(+) / 남는(-) 흙

            // 자식들의 need만 누적 (부모는 제외)
            for (int e = head[u]; e != -1; e = next[e]) {
                int v = to[e];
                if (parent[v] == u) { // v가 u의 자식이면
                    acc += need[v];
                }
            }

            // 남는 흙(acc<0)은 위로 못 올리므로 버림(0으로 컷)
            need[u] = (acc > 0) ? acc : 0;
        }

        System.out.println(need[P]);
    }
}
