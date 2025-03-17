import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 집의 개수
        int C = Integer.parseInt(st.nextToken()); // 설치할 공유기의 개수
        
        int[] houses = new int[N];
        
        for (int i = 0; i < N; i++) {
            houses[i] = Integer.parseInt(br.readLine());
        }
        
        Arrays.sort(houses);
        
        // 가능한 최소 거리의 범위 설정
        // 최소 거리는 1 (가장 작은 간격)
        // 최대 거리는 첫 번째 집과 마지막 집 사이의 거리
        int low = 1;
        int high = houses[N - 1] - houses[0];
        int result = 0; // 최종적으로 구할 최대 최소 거리
        
        // 이진 탐색 시작: 가능한 최소 거리를 탐색합니다.
        while(low <= high) {
            // 중간값(mid)는 현재 후보로 고려되는 최소 거리
            int mid = (low + high) / 2;
            
            // mid 거리만큼 간격을 두고 공유기를 설치할 수 있는지 확인
            if(isPossible(houses, C, mid)) {
                // 만약 설치 가능하다면, 더 큰 거리로 설치할 수 있는지 확인
                result = mid;    // 현재 mid 값은 가능한 후보이므로 저장
                low = mid + 1;   // 최소 거리를 늘려서 다시 탐색
            } else {
                // 설치가 불가능하다면, 거리 값을 줄여서 다시 탐색
                high = mid - 1;
            }
        }
        
        // 최대 최소 거리를 출력
        System.out.println(result);
    }
    
    public static boolean isPossible(int[] houses, int C, int distance) {
        int count = 1; // 첫 번째 집에는 무조건 공유기를 설치
        int lastInstalled = houses[0]; // 마지막으로 공유기를 설치한 집의 좌표
        
        // 두 번째 집부터 반복하며 공유기 설치 시도
        for (int i = 1; i < houses.length; i++) {
            // 현재 집과 마지막 설치한 집 사이의 거리가 candidate distance 이상이면 설치
            if(houses[i] - lastInstalled >= distance) {
                count++; // 공유기 설치 개수 증가
                lastInstalled = houses[i]; // 현재 집 위치로 업데이트
            }
        }
        
        // 설치한 공유기의 개수가 요구 개수 C 이상이면 true 반환
        return count >= C;
    }
}
