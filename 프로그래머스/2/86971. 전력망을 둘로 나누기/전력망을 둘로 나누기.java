import java.io.*;
import java.util.*;

class Solution {
    static int root[];
    public int solution(int n, int[][] wires) {
        int answer = 100;
        int cnt = wires.length;
        root = new int[n + 1];
        for (int i = 0; i < cnt; i++) {
            // root 초기화
            for (int j = 1; j <= n; j++) {
                root[j] = j;
            }
            for (int k = 0; k < cnt; k++) {
            for (int j = 0; j < cnt; j++) {
                // 하나씩 연결 미포함
                if (i == j)
                    continue;
                int a = wires[j][0];
                int b = wires[j][1];
                if (root[a] < root[b]) {
                    root[b] = root[a];
                } else {
                    root[a] = root[b];
                }
            }
            }
            int one = 0;
            for (int j = 1; j <= n; j++) {
                if (root[j] == 1)
                    one++;
            }
            answer = Math.min(Math.abs(2 * one - n), answer);
        }
        return answer;
    }
}