import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine()); // 학교의 수
        int sum = 0; // 남는 사과 총합

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int students = Integer.parseInt(st.nextToken()); // 학생 수 A
            int apples = Integer.parseInt(st.nextToken());   // 사과 수 B

            sum += apples % students;
        }

        System.out.println(sum);
    }
}
