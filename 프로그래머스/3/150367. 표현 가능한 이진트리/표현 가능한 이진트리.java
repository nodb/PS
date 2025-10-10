import java.io.*;
import java.util.*;

class Solution {
    static int answer[];

    public int[] solution(long[] numbers) {
        answer = new int[numbers.length];
        Arrays.fill(answer, 1);
        
        ArrayList<Long> list = new ArrayList<>();
        Long l = 1L;
        list.add(1L);
        for (int i = 0; i < 62; i++) {
            l *= 2;
            list.add(l * 2 - 1);
        }
        
        for (int num = 0; num < numbers.length; num++) {
            String b = Long.toBinaryString(numbers[num]);
            Long len = Long.valueOf(b.length());
            int v = 0;
            for (int i = 0; i < 62; i++) {
                if (list.get(i) >= len) {
                    v = i;
                    break;
                }
            }
            Long diff = list.get(v) - len;
            String s = "";
            while(diff-- > 0) {
                s += "0";
            }
            b = s + b;

            check(num, b, 0, b.length() - 1);
        }
        return answer;
    }
    
    public void check(int num, String b, int start, int end) {
        if (start == end || answer[num] == 0)
            return;
        
        int mid = (start + end) / 2;
        // 가운데가 0일 때
        if (b.charAt(mid) == '0') {
            // 왼쪽
            for (int i = start; i < mid; i++) {
                if (b.charAt(i) == '1') {
                    answer[num] = 0;
                    return;
                }
            }
            // 오른쪽
            for (int i = mid + 1; i <= end; i++) {
                if (b.charAt(i) == '1') {
                    answer[num] = 0;
                    return;
                }
            }
        }
        // 가운데가 1일 때
        else {
            check(num, b, start, mid - 1);
            check(num, b, mid + 1, end);
        }
    }
}
/* 
    가능한 이진수의 길이 : 2의 제곱 - 1
    자리수
    1, 1+2, 1+2+4, 1+2+4+8
    1, 3,   7,     15
    
    1. 값을 2진수로 변경
    - 최대값 10^15 -> 2진수로 변경 -> 자리수?
    
    2. 더미 0 왼쪽으로 채우기
    - 어느 구간에 포함되는지 확인
    
    3. 가운데 값 확인
    - 가운데 값 0
        - 양 옆 구간에 1인 값이 있으면 불가
    - 가운데 값 1
        - 다시 양 옆 구간 가운데 확인
   
*/