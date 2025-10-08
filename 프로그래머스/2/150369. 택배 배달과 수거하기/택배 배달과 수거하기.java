class Solution {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long ans = 0L;

        int di = n - 1;
        int pi = n - 1;

        while (di >= 0 && deliveries[di] == 0)
            di--;
        while (pi >= 0 && pickups[pi] == 0)
            pi--;

        while (di >= 0 || pi >= 0) {
            int far = Math.max(di, pi) + 1;
            ans += (long) far * 2;

            // 배달
            int box = cap;
            while (di >= 0 && box > 0) {
                if (deliveries[di] == 0) {
                    di--;
                    continue;
                }
                int min = Math.min(box, deliveries[di]);
                deliveries[di] -= min;
                box -= min;
                if (deliveries[di] == 0)
                    di--;
            }

            // 수거
            box = cap;
            while (pi >= 0 && box > 0) {
                if (pickups[pi] == 0) {
                    pi--;
                    continue;
                }
                int min = Math.min(box, pickups[pi]);
                pickups[pi] -= min;
                box -= min;
                if (pickups[pi] == 0)
                    pi--;
            }
            
            while (di >= 0 && deliveries[di] == 0)
                di--;
            while (pi >= 0 && pickups[pi] == 0)
                pi--;
        }
        return ans;
    }
}
