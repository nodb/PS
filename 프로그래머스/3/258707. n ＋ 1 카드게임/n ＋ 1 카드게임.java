import java.util.*;

/**
 * 커스텀 규칙 + coin 조건 반영:
 * 1) 라운드 시작 시 덱에서 2장을 overflow(넘어간 카드 저장소)에 먼저 넣는다.
 *    - 남은 카드가 2장 미만이면 해당 라운드는 시작 불가 → 현재 라운드 번호 반환.
 * 2) 손패-손패(코인 소모 없음)로 합 n+1이 가능하면 두 장 소멸 → 라운드 성공.
 * 3) 손패-overflow(coin >= 1 필요)로 합 n+1 가능하면 각 1장 소멸, coin -= 1 → 라운드 성공.
 * 4) overflow-overflow(coin >= 2 필요)로 합 n+1 가능하면 두 장 소멸, coin -= 2 → 라운드 성공.
 * 5) 셋 다 불가하면 종료(현재 라운드 번호 반환).
 */
class Solution {
    public int solution(int coin, int[] cards) {
        final int n = cards.length;
        final int T = n + 1;     // 목표 합
        final int init = n / 3;  // 시작 손패 개수

        // 초기 손패
        Set<Integer> hand = new HashSet<>();
        for (int i = 0; i < init; i++) hand.add(cards[i]);

        // 넘어간 카드 저장소 (무료 창고처럼 동작 - 커스텀 규칙)
        Set<Integer> overflow = new HashSet<>();

        int ptr = init; // 아직 overflow에 넣지 않은 다음 카드의 위치
        int round = 1;  // 라운드 번호 (1부터)

        while (true) {
            // 라운드 시작: 2장을 overflow에 먼저 적립
            if (ptr + 1 >= n) return round; // 2장 부족 → 시작 불가 → 현재 라운드 반환
            int a = cards[ptr], b = cards[ptr + 1];
            overflow.add(a); overflow.add(b);
            ptr += 2;

            boolean progressed = false;

            // (A) 손패-손패: 코인 조건 없음
            int[] hh = findPairInSameSet(hand, T);
            if (hh != null) {
                hand.remove(hh[0]);
                hand.remove(hh[1]);
                progressed = true;
            } else {
                // (B) 손패-overflow: coin >= 1 필요
                if (coin >= 1) {
                    int[] ho = findPairBetweenSets(hand, overflow, T);
                    if (ho != null) {
                        hand.remove(ho[0]);
                        overflow.remove(ho[1]);
                        coin -= 1;
                        progressed = true;
                    }
                }

                // (C) overflow-overflow: coin >= 2 필요
                if (!progressed && coin >= 2) {
                    int[] oo = findPairInSameSet(overflow, T);
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

    // 동일 Set 내에서 x + y = T가 되는 (x != y) 한 쌍 찾기
    private int[] findPairInSameSet(Set<Integer> set, int T) {
        if (set.size() < 2) return null;
        // 결정적 선택을 위해 정렬 순회 (원하면 HashSet 직순회로 바꿔도 무방)
        List<Integer> list = new ArrayList<>(set);
        Collections.sort(list);
        for (int x : list) {
            int y = T - x;
            if (y != x && set.contains(y)) {
                return new int[]{x, y};
            }
        }
        return null;
    }

    // 서로 다른 두 Set 사이에서 x(fromSet) + y(toSet) = T 한 쌍 찾기
    private int[] findPairBetweenSets(Set<Integer> fromSet, Set<Integer> toSet, int T) {
        if (fromSet.isEmpty() || toSet.isEmpty()) return null;
        List<Integer> list = new ArrayList<>(fromSet);
        Collections.sort(list);
        for (int x : list) {
            int y = T - x;
            if (toSet.contains(y)) {
                return new int[]{x, y};
            }
        }
        return null;
    }
}
