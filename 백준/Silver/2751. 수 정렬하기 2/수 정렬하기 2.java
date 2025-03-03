import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        boolean[] arr = new boolean[2_000_001]; // -1,000,000 ~ 1,000,000

        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());
            arr[num + 1_000_000] = true;
        }

        for (int i = 0; i < 2_000_001; i++) {
            if (arr[i]) {
                sb.append(i - 1_000_000).append("\n");
            }
        }

        System.out.print(sb);
    }
}
