import java.io.*;
import java.util.*;

class Solution {
    static int a[] = {1, 2, 3, 4, 5};
    static int b[] = {2, 1, 2, 3, 2, 4, 2, 5};
    static int c[] = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
    
    public int[] solution(int[] answers) {
        int cntA = 0;
        int cntB = 0;
        int cntC = 0;
        
        for (int i = 0; i < answers.length; i++) {
            int num = answers[i];
            if (num == a[i % a.length]) {
                cntA++;
            }
            if (num == b[i % b.length]) {
                cntB++;
            }
            if (num == c[i % c.length]) {
                cntC++;
            }
        }
        
        int max = Math.max(cntA, Math.max(cntB, cntC));
        ArrayList<Integer> list = new ArrayList<>();
        
        int listCnt = 0;
        if (cntA == max)
            listCnt++;
        if (cntB == max)
            listCnt++;
        if (cntC == max)
            listCnt++;
            
        int answer[] = new int[listCnt];
        
        int cnt = 0;
        if (cntA == max) {
            answer[cnt] = 1;
            cnt++;
        }
        if (cntB == max) {
            answer[cnt] = 2;
            cnt++;
        }
        if (cntC == max) {
            answer[cnt] = 3;
        }
        return answer;
    }
}