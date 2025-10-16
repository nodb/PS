import java.util.*;

/**
 * 커스텀 규칙 + coin 조건 (정렬 제거, O(k) 탐색)
 * 1) 라운드 시작 시 덱에서 2장을 overflow에 먼저 넣는다.
 * 2) 손패-손패(코인 0) → 손패-overflow(코인 ≥1) → overflow-overflow(코인 ≥2) 순서로 검사.
 * 3) 하나라도 성사되면 해당 2장 소멸(+ coin 차감) 후 다음 라운드, 모두 실패면 현재 라운드 번호 반환.
 */
class Solution {
    public int solution(int coin, int[] cards) {
        final int n = cards.length;
        final int T = n + 1;     // 목표 합
        final int init = n / 3;  // 초기 손패 개수

        // 초기 손패
        Set<Integer> hand = new HashSet<>();
        for (int i = 0; i < init; i++) hand.add(cards[i]);

        // 넘어간 카드 저장소
        Set<Integer> overflow = new HashSet<>();

        int ptr = init; // 다음에 overflow로 보낼 카드 시작 위치
        int round = 1;  // 라운드 번호 (1부터)

        while (true) {
            // 라운드 시작: 2장을 overflow에 적립(2장 미만이면 시작 불가 → 현재 라운드 반환)
            if (ptr + 1 >= n) return round;
            int a = cards[ptr], b = cards[ptr + 1];
            overflow.add(a);
            overflow.add(b);
            ptr += 2;

            boolean progressed = false;

            // (A) 손패-손패: coin 소모 없음
            int[] hh = findPairInSameSet_NoSort(hand, T);
            if (hh != null) {
                hand.remove(hh[0]);
                hand.remove(hh[1]);
                progressed = true;
            } else {
                // (B) 손패-overflow: coin >= 1 필요
                if (coin >= 1) {
                    int[] ho = findPairBetweenSets_NoSort(hand, overflow, T);
                    if (ho != null) {
                        hand.remove(ho[0]);
                        overflow.remove(ho[1]);
                        coin -= 1;
                        progressed = true;
                    }
                }

                // (C) overflow-overflow: coin >= 2 필요
                if (!progressed && coin >= 2) {
                    int[] oo = findPairInSameSet_NoSort(overflow, T);
                    if (oo != null) {
                        overflow.remove(oo[0]);
                        overflow.remove(oo[1]);
                        coin -= 2;
                        progressed = true;
                    }
                }
            }

            if (!progressed) {
                // 어떤 조합도 불가 → 종료
                return round;
            }

            // 라운드 성공 → 다음 라운드
            round++;
        }
    }

    /**
     * 동일 Set에서 x + y = T가 되는 (x != y) 임의의 한 쌍을 O(k)로 찾는다.
     * 정렬 없이 HashSet 조회만 사용.
     */
    private int[] findPairInSameSet_NoSort(Set<Integer> set, int T) {
        if (set.size() < 2) return null;
        for (int x : set) {
            int y = T - x;
            if (y != x && set.contains(y)) {
                return new int[]{x, y};
            }
        }
        return null;
    }

    /**
     * 서로 다른 두 Set 사이에서 (fromSet의 x) + (toSet의 y) = T 인 쌍을 O(k)로 찾는다.
     * 정렬 없이 HashSet 조회만 사용.
     */
    private int[] findPairBetweenSets_NoSort(Set<Integer> fromSet, Set<Integer> toSet, int T) {
        if (fromSet.isEmpty() || toSet.isEmpty()) return null;
        for (int x : fromSet) {
            int y = T - x;
            if (toSet.contains(y)) {
                return new int[]{x, y};
            }
        }
        return null;
    }
}