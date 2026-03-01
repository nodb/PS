import java.io.*;
import java.util.*;

class Solution {
    public String solution(String number, int k) {
        // 1.
        // 자리수 백 만 -> 완전탐색(combination; 조합) 불가
        
        // 2.
        // 앞에서 뒤로 이동하면서
        // 현재 확인하는 숫자가 바로 이전 숫자보다 크면
        // 현재 숫자로 대체 -> 스택 (= 대신 deque 사용)
        
        // deque
        // - 맨 앞/뒤 : 삽입/삭제/조회 O(1)
        // - 중간 불가능
        Deque<Character> q = new ArrayDeque<>();

        for (int i = 0; i < number.length(); i++) {
            char c = number.charAt(i);

            // 가능한 최대 삭제횟수 = k
            // deque에서 모든 숫자를 확인하며 현재보다 작은 숫자 제거
            while (k > 0 && !q.isEmpty() && q.peekLast() < c) {
                q.removeLast();
                k--;
            }
            q.addLast(c);
        }

        // 삭제횟수 k가 남아있으면 완성된 deque를 뒤부터 제거
        while (k > 0) {
            q.pollLast();
            k--;
        }

        // 문자열 형태로 return
        String answer = "";
        while (!q.isEmpty()) {
            answer += q.removeFirst();
        }

        return answer;
    }
}