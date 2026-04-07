import java.io.*;
import java.util.*;

class Solution {
    public int solution(int[][] sizes) {
        int w = 0; // 더 작은 값 모으기
        int h = 0; // 더 큰 값 모으기
        for (int i = 0; i < sizes.length; i++) {
            int a = sizes[i][0];
            int b = sizes[i][1];
            int min = Math.min(a, b);
            int max = Math.max(a, b);
            w = Math.max(w, min);
            h = Math.max(h, max);
        }
        System.out.println(w);
        System.out.println(h);
        return w * h;
    }
}