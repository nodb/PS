import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            int n = Integer.parseInt(br.readLine());
            if (n == 0) break;

            // 1부터 n까지의 합: n * (n + 1) / 2
            int sum = n * (n + 1) / 2;
            System.out.println(sum);
        }
    }
}
