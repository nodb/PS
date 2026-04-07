class Solution {
    static int arr[]; // 배열
    static int len; // 개수
    static int t = 0; // 타겟
    static int sum = 0; // 합계
    static int cnt = 0; // 개수
    
    public int solution(int[] numbers, int target) {
        arr = numbers;
        len = numbers.length;
        t = target;
        dfs(0);
        return cnt;
    }
    
    public static void dfs(int n) {
        if (n == len) {
            if (sum == t)
                cnt++;
            return;
        }
        int num = arr[n];
        sum += num;
        dfs(n + 1);
        sum -= num * 2;
        dfs(n + 1);
        sum += num;
    }
}