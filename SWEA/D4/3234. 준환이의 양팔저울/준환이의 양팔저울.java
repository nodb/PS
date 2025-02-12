import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Solution {
    static int N;
    static int cnt;
    static int arr[];
    static boolean visit_p[];
    static int visit_s[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testcase = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= testcase; tc++) {
            N = Integer.parseInt(br.readLine());
            arr = new int[N];
            
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(arr);

            cnt = 0;
            visit_p = new boolean[N];
            visit_s = new int[N];
            perm(0);

            System.out.println("#" + tc + " " + cnt);
        }
    }

    private static void perm(int num) {
        if (num == N) {
            subset(1, visit_s[0], 0);
            return;
        }

        for (int i = 0; i < N; i++) {
            if (visit_p[i]) continue;
            if (i > 0 && arr[i] == arr[i - 1] && !visit_p[i - 1]) continue;
            visit_p[i] = true;
            visit_s[num] = arr[i];
            perm(num + 1);
            visit_p[i] = false;
        }
    }

    private static void subset(int num, int left, int right) {
        if (num == N) {
            if (left >= right) cnt++;
            return;
        }

        if (left >= right + visit_s[num]) { 
            subset(num + 1, left, right + visit_s[num]);
        }
        
        subset(num + 1, left + visit_s[num], right);
    }
}
