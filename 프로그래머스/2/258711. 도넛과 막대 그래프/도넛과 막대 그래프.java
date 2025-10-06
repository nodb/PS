import java.util.*;
import java.io.*;

class Solution {
    public int[] solution(int[][] edges) {
        int result[] = new int[4];
        
        List<Integer> arr[] = new ArrayList[1_000_001];
        for (int i = 0; i < 1_000_001; i++) {
            arr[i] = new ArrayList<>();
        }
        int aCnt[] = new int[1_000_001]; // 출력 차수
        int bCnt[] = new int[1_000_001]; // 입력 차수
        
        for (int i = 0; i < edges.length; i++) {
            int A = edges[i][0];
            int B = edges[i][1];
            arr[A].add(B);
            aCnt[A]++;
            bCnt[B]++;
        }
        
        for (int i = 1; i < 1_000_001; i++) {
            if (aCnt[i] >= 2 && bCnt[i] == 0) {
                result[0] = i;
                break;
            }
        }
        
        for (int n : arr[result[0]]) {
            int now = n;
            while(true) {
                // 막대 모양: 출력차수 ==  0
                if (aCnt[now] == 0) {
                    result[2]++;
                    break;
                }
                // 도넛 모양: 출력차수 == 2
                if (aCnt[now] == 2) {
                    result[3]++;
                    break;
                }
                now = arr[now].get(0);
                if (now == n) {
                    result[1]++;
                    break;
                }
            }
        }
        
        return result;
    }
}

/*

시작점
- 입력차수: 0
- 출력차수: 2이상

전체 개수: 시작점의 출력차수

도넛모양
- 입력차수: 1
- 출력차수: 1
    - 순환
    - 돌다보면 원래 자신으로 돌아옴

막대 모양
- 입력차수: 1
- 출력차수: 1
(마지막)
- 입력차수: 1
- 출력차수: 0
    - 돌다보면 끝
    
8자 모양 정점 중
(일반)
- 입력차수: 1
- 출력차수: 1
(중간)
- 입력차수: 2
- 출력차수: 2
    - 인 정점이 존재

- 정점의 입력차수가 2인 경우가 존재
    -> 8자 모양
- 돌다가 끝남
    -> 막대 모양
- 원래 자신으로 되돌아옴
    -> 도넛 모양

*/