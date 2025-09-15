import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static char arr[];
    static int min;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine().trim());
        arr = br.readLine().trim().toCharArray();

        min = Integer.MIN_VALUE;

        boolean visited[] = new boolean[N / 2];
        dfs(0, visited);

        System.out.println(min);
    }

    private static void dfs(int i, boolean[] visited) {
        int ops = N / 2;
        if (i == ops) {
            evaluate(visited);
            return;
        }

        dfs(i + 1, visited);

        if (i == 0 || !visited[i - 1]) {
            visited[i] = true;
            dfs(i + 1, visited);
            visited[i] = false;
        }
    }

    private static void evaluate(boolean[] visited) {
        String[] temp = new String[N];
        for (int i = 0; i < N; i++) temp[i] = String.valueOf(arr[i]);

        int ops = N / 2;
        for (int i = 0; i < ops; i++) {
            if (visited[i]) {
                int leftIdx = i * 2;
                int opIdx = leftIdx + 1;
                int rightIdx = leftIdx + 2;

                int a = Integer.parseInt(temp[leftIdx]);
                int b = Integer.parseInt(temp[rightIdx]);
                String op = temp[opIdx];

                int res;
                if (op.equals("+")) res = a + b;
                else if (op.equals("-")) res = a - b;
                else res = a * b;

                temp[leftIdx] = String.valueOf(res);
                temp[opIdx] = null;
                temp[rightIdx] = null;
            }
        }

        int idx = 0;
        while (idx < N && temp[idx] == null) idx++;
        int sum = Integer.parseInt(temp[idx]);
        String lastOp = null;

        for (int i = idx + 1; i < N; i++) {
            if (temp[i] == null) continue;

            if (i % 2 == 1) {
                lastOp = temp[i];
            } else {
                int val = Integer.parseInt(temp[i]);
                if (lastOp.equals("+")) sum += val;
                else if (lastOp.equals("-")) sum -= val;
                else sum *= val;
            }
        }

        if (sum > min) min = sum;
    }
}
