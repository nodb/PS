import java.util.*;

class Solution {
    int n;
    int[][] dice;
    List<Integer> best = null;     // 0-based indices
    long bestWin = -1;

    public int[] solution(int[][] dice) {
        this.dice = dice;
        this.n = dice.length;

        // 조합 생성: 0..n-1 중 n/2개 선택
        dfs(0, new ArrayList<>());

        // 1-based, 오름차순으로 반환
        int[] ans = new int[best.size()];
        for (int i = 0; i < best.size(); i++) ans[i] = best.get(i) + 1;
        Arrays.sort(ans);
        return ans;
    }

    // 조합 DFS: idx부터 고르기
    private void dfs(int idx, List<Integer> pick) {
        int need = n/2 - pick.size();
        int left = n - idx;
        if (need > left) return;              // 남은 개수 부족
        if (pick.size() == n/2) {
            evaluate(pick);
            return;
        }
        if (idx == n) return;

        // 고르기
        pick.add(idx);
        dfs(idx + 1, pick);
        pick.remove(pick.size() - 1);

        // 안 고르기
        dfs(idx + 1, pick);
    }

    private void evaluate(List<Integer> Aidx) {
        // Bidx = 전체 - Aidx
        boolean[] chosen = new boolean[n];
        for (int x : Aidx) chosen[x] = true;
        List<Integer> Bidx = new ArrayList<>();
        for (int i = 0; i < n; i++) if (!chosen[i]) Bidx.add(i);

        // 모든 합 생성
        List<Integer> sumA = enumerateSums(Aidx);
        List<Integer> sumB = enumerateSums(Bidx);
        Collections.sort(sumB);

        // 승 수 = sumB에서 (b < a) 개수 합
        long wins = 0;
        for (int a : sumA) {
            int cnt = lowerBound(sumB, a); // b < a
            wins += cnt;
        }

        if (wins > bestWin) {
            bestWin = wins;
            best = new ArrayList<>(Aidx); // 복사
        }
    }

    // 선택된 주사위 인덱스들의 모든 합 나열
    private List<Integer> enumerateSums(List<Integer> idxs) {
        List<Integer> res = new ArrayList<>();
        res.add(0);
        for (int di : idxs) {
            List<Integer> next = new ArrayList<>(res.size() * 6);
            for (int base : res) {
                for (int face = 0; face < 6; face++) {
                    next.add(base + dice[di][face]);
                }
            }
            res = next;
        }
        return res;
    }

    // 첫 번째 (value >= key)의 위치 -> 그 인덱스가 곧 (value < key)의 개수
    private int lowerBound(List<Integer> arr, int key) {
        int l = 0, r = arr.size();
        while (l < r) {
            int m = (l + r) >>> 1;
            if (arr.get(m) >= key) r = m;
            else l = m + 1;
        }
        return l;
    }
}
