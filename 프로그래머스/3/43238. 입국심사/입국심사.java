import java.io.*;
import java.util.*;

class Solution {
    public long solution(int n, int[] times) {
        long l = 0L;
        long r = 0L;
        for (int i : times) {
            r = Math.max(r, i);
        }
        r *= n;
        long m = 0L;

        long answer = 0L;
        while (l <= r) {
            m = (l + r) / 2;
            long sum = 0L;

            for (int time : times) {
                sum += m / time;
                if (sum >= n)
                    break;
            }

            if (sum >= n) {
                answer = m;
                r = m - 1;
            } else {
                l = m + 1;
            }
        }

        return answer;
    }
}