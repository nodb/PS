import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        // 입력을 빠르게 읽기 위한 BufferedReader 사용
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 테스트 케이스의 수를 읽는다.
        int T = Integer.parseInt(br.readLine().trim());
        
        // 각 테스트 케이스별로 처리
        for (int t = 1; t <= T; t++) {
            // 나무의 개수 N을 읽음
            int N = Integer.parseInt(br.readLine().trim());
            int[] trees = new int[N];
            
            // StringTokenizer를 사용해 N개의 나무의 높이를 읽는다.
            StringTokenizer st = new StringTokenizer(br.readLine());
            int maxHeight = 0;
            for (int i = 0; i < N; i++) {
                trees[i] = Integer.parseInt(st.nextToken());
                // 최대 높이 갱신
                maxHeight = Math.max(maxHeight, trees[i]);
            }
            
            // 각 나무가 목표 높이까지 필요한 증가량(diff)을 계산
            int[] diff = new int[N];
            int countOdd = 0;    // 각 나무마다 diff가 홀수인 경우, 반드시 1회 이상의 홀수날이 필요하다.
            int sumEvenNeeded = 0; // 각 나무별 최소 짝수날(2씩 채워야 하는 횟수)의 합
            for (int i = 0; i < N; i++) {
                diff[i] = maxHeight - trees[i];
                // diff가 홀수라면 최소 1회 홀수날이 필요하다.
                if (diff[i] % 2 == 1) {
                    countOdd++;
                }
                // diff에서 홀수 부분(1회 필요)을 제외한 나머지는 2씩 채워야 하므로 diff/2 (내림)을 사용
                sumEvenNeeded += diff[i] / 2;
            }
            
            // 만약 모든 나무가 이미 목표 높이라면(증가량 0) 바로 0일 출력
            if (sumEvenNeeded == 0 && countOdd == 0) {
                System.out.println("#" + t + " " + 0);
                continue;
            }
            
            // 최소 날짜 수 d를 0부터 증가시키며 조건을 만족하는지 확인
            int d = 0;
            while (true) {
                d++; // d일째까지 고려
                
                int oddAvail, evenAvail;
                // d일 동안 홀수날과 짝수날의 개수를 계산
                if (d % 2 == 0) {
                    oddAvail = d / 2;    // 짝수일이면 홀수날 = d/2, 짝수날 = d/2
                    evenAvail = d / 2;
                } else {
                    oddAvail = (d + 1) / 2;  // 홀수일이면 홀수날 = (d+1)/2, 짝수날 = (d-1)/2
                    evenAvail = (d - 1) / 2;
                }
                
                // 첫번째 조건: 전체 사용 가능한 홀수날이 각 나무가 최소로 필요한 홀수날(countOdd)보다 크거나 같아야 함.
                if (oddAvail < countOdd) {
                    continue; // 조건 미달이면 d를 증가시키고 다시 체크
                }
                
                // 남는 홀수날은 각 나무에 할당한 최소 1회(필요한 경우)를 제외한 나머지
                int extraOdd = oddAvail - countOdd;
                // 남는 홀수날 2회를 짝지으면 짝수날 1회의 효과를 낼 수 있음
                int additionalEven = extraOdd / 2;
                
                // 총 짝수날으로 사용할 수 있는 횟수 = d일 동안의 짝수날 수 + 추가적으로 짝지어진 횟수
                int totalEvenAvail = evenAvail + additionalEven;
                
                // 두번째 조건: 모든 나무에 필요한 짝수날(sumEvenNeeded)보다 사용 가능한 짝수날이 많거나 같아야 함.
                if (totalEvenAvail >= sumEvenNeeded) {
                    // 조건을 만족하면 현재 d일이 최소 날짜 수임
                    System.out.println("#" + t + " " + d);
                    break;
                }
            }
        }
    }
}
