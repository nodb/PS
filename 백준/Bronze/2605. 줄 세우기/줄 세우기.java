import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine()); // 학생 수
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 줄을 표현할 리스트
        List<Integer> line = new ArrayList<>();

        // 1번 학생부터 n번 학생까지 순서대로 처리
        for (int i = 0; i < n; i++) {
            int x = Integer.parseInt(st.nextToken()); // 뽑은 번호
            int student = i + 1; // 현재 학생 번호

            // 맨 뒤에서 x만큼 앞으로 가서 끼어들기
            int idx = line.size() - x;
            line.add(idx, student);
        }

        StringBuilder sb = new StringBuilder();
        for (int num : line) {
            sb.append(num).append(' ');
        }

        System.out.println(sb.toString());
    }
}
