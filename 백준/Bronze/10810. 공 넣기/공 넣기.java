import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] firstLine = br.readLine().split(" ");
        int N = Integer.parseInt(firstLine[0]);
        int M = Integer.parseInt(firstLine[1]);
        
        int[] baskets = new int[N];
        
        for (int i = 0; i < M; i++) {
            String[] operation = br.readLine().split(" ");
            int start = Integer.parseInt(operation[0]) - 1;
            int end = Integer.parseInt(operation[1]) - 1;
            int ball = Integer.parseInt(operation[2]);
            
            for (int j = start; j <= end; j++) {
                baskets[j] = ball;
            }
        }
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(baskets[i]);
            if (i != N - 1) {
                sb.append(" ");
            }
        }
        System.out.println(sb);
    }
}
