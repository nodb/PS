import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int[][] can;        // can[inning][player] : 이닝 i에서 선수 j의 결과 (0~4)
    static int[] order = new int[9]; // 타순: index=타석 순서(0~8), value=선수 번호(0~8)
    static boolean[] visited = new boolean[9];
    static int max = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        can = new int[n][9];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 9; j++) {
                can[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 1번 선수(인덱스 0)는 4번 타자(인덱스 3) 고정
        visited[0] = true;
        order[3] = 0;

        perm(0);

        System.out.println(max);
    }

    // 타순 순열 생성 (order[3]은 이미 0으로 고정)
    static void perm(int idx) {
        if (idx == 9) {
            game();
            return;
        }

        // 4번 타자 자리는 이미 1번 선수로 고정
        if (idx == 3) {
            perm(idx + 1);
            return;
        }

        for (int p = 1; p < 9; p++) { // 선수 2~9 (인덱스 1~8)
            if (visited[p]) continue;
            visited[p] = true;
            order[idx] = p;
            perm(idx + 1);
            visited[p] = false;
        }
    }

    // 현재 order 타순으로 경기 시뮬레이션
    static void game() {
        int score = 0;
        int batterIdx = 0; // 타순 인덱스(0~8), 이닝 사이에서도 이어짐

        for (int inning = 0; inning < n; inning++) {
            int outs = 0;
            boolean[] base = new boolean[3]; // 0: 1루, 1: 2루, 2: 3루

            while (outs < 3) {
                int player = order[batterIdx];      // 지금 타석에 선 선수 번호(0~8)
                int result = can[inning][player];   // 이 이닝에서의 타격 결과(0~4)

                if (result == 0) { // 아웃
                    outs++;
                } else if (result == 1) { // 1루타
                    if (base[2]) score++;
                    base[2] = base[1];
                    base[1] = base[0];
                    base[0] = true;
                } else if (result == 2) { // 2루타
                    if (base[2]) score++;
                    if (base[1]) score++;
                    base[2] = base[0];
                    base[1] = true;
                    base[0] = false;
                } else if (result == 3) { // 3루타
                    if (base[2]) score++;
                    if (base[1]) score++;
                    if (base[0]) score++;
                    base[2] = true;
                    base[1] = false;
                    base[0] = false;
                } else if (result == 4) { // 홈런
                    if (base[2]) score++;
                    if (base[1]) score++;
                    if (base[0]) score++;
                    score++; // 타자 본인 득점
                    base[0] = base[1] = base[2] = false;
                }

                // 다음 타자 (9번 다음은 다시 1번)
                batterIdx = (batterIdx + 1) % 9;
            }
        }

        max = Math.max(max, score);
    }
}
