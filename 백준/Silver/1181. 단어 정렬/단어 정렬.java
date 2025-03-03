import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int N = Integer.parseInt(br.readLine());
        Set<String> word = new HashSet<>();

        for (int i = 0; i < N; i++) {
            word.add(br.readLine());
        }

        List<String> list = new ArrayList<>(word);

        Collections.sort(list, (a, b) -> {
            if (a.length() == b.length()) {
                return a.compareTo(b); // 사전순 정렬
            }
            return a.length() - b.length(); // 길이순 정렬
        });

        for (String s : list) {
            sb.append(s).append("\n");
        }
        System.out.print(sb);
    }
}
