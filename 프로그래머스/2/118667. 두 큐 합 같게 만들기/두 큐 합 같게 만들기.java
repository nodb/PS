import java.io.*;
import java.util.*;

class Solution {
    public static int solution(int[] queue1, int[] queue2) {
        int n = queue1.length;
        long sum1 = 0, sum2 = 0;
        for (int v : queue1) sum1 += v;
        for (int v : queue2) sum2 += v;

        long total = sum1 + sum2;
        // 합이 홀수면 불가능
        if (total % 2 != 0) return -1;
        long target = total / 2;
        // 이미 같다면 0
        if (sum1 == target) return 0;

        // 두 큐를 이어붙인 배열 (순환 접근에 사용)
        int len = 2 * n;
        long[] arr = new long[len];
        for (int i = 0; i < n; i++) arr[i] = queue1[i];
        for (int i = 0; i < n; i++) arr[n + i] = queue2[i];

        // 포인터 i: 현재 queue1의 맨 앞(빼는 위치)
        // 포인터 j: queue2의 맨 앞(빼서 queue1에 넣을 위치) — 초기 j = n
        int i = 0;
        int j = n;
        long cur = sum1;
        int cnt = 0;
        // 안전한 상한: 최대 시도 횟수 (무한 루프 방지). 4*n이면 충분.
        int maxOps = 4 * n;

        while (cnt <= maxOps) {
            if (cur == target) return cnt;
            if (cur > target) {
                // queue1에서 pop해서 queue2로 보냄 (시뮬레이션 상 cur에서 제거)
                cur -= arr[i % len];
                i++;
            } else {
                // queue2에서 pop해서 queue1으로 보냄 (시뮬레이션 상 cur에 더함)
                cur += arr[j % len];
                j++;
            }
            cnt++;
        }

        return -1;
    }
}