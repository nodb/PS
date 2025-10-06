import java.io.*;
import java.util.*;

class Solution {
    public int solution(String[] friends, String[] gifts) {
        int friendsSize = friends.length;
        int giftCnt[][] = new int[friendsSize][friendsSize];
        int giftJisu[] = new int[friendsSize];
        int next[] = new int[friendsSize];
        
        HashMap<String, Integer> hm = new HashMap<>();
        for (int i = 0; i < friendsSize; i++) {
            hm.put(friends[i], i);
        }
        
        int giftsSize = gifts.length;
        for (int i = 0; i < giftsSize; i++) {
            StringTokenizer st = new StringTokenizer(gifts[i]);
            String A = st.nextToken();
            String B = st.nextToken();
            giftCnt[hm.get(A)][hm.get(B)]++;
        }
        
        for (int A = 0; A < friendsSize; A++) {
            int cntFrom = 0;
            int cntTo = 0;
            for (int B = 0; B < friendsSize; B++) {
                cntFrom += giftCnt[A][B];
                cntTo += giftCnt[B][A];
            }
            giftJisu[A] = cntFrom - cntTo;
        }
        
        for (int A = 0; A < friendsSize - 1; A++) {
            for (int B = A + 1; B < friendsSize; B++) {
                if (giftCnt[A][B] < giftCnt[B][A])
                    next[B]++;
                else if (giftCnt[A][B] > giftCnt[B][A])
                    next[A]++;
                else {
                    if (giftJisu[A] < giftJisu[B])
                        next[B]++;
                    else if (giftJisu[A] > giftJisu[B])
                        next[A]++;
                }
            }
        }
        
        int max = 0;
        for (int A = 0; A < friendsSize - 1; A++) {
            if (max < next[A])
                max = next[A];
        }
        
        return max;
    }
}

/*
선물 횟수 작은 사람 -> 큰 사람

선물 횟수 동일 시
    선물 지수: 이번 달까지 친구들에게 준 선물 - 받은 선물 수
    선물 지수 작은 사람 -> 큰 사람
    
선물 지수 동일 시
    선물 X
    
friends: 친구들의 이름을 담은 1차원 문자열 배열
gifts: 이번 달까지 친구들이 주고받은 선물 기록을 담은 1차원 문자열 배열
    "A B": A -> B
    
return: 다음달에 가장 많은 선물을 받는 친구가 받을 선물의 수

*/
