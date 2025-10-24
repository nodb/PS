import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine().trim()); // 파일 이름 개수
        String[] arr = new String[n];
        for (int i = 0; i < n; i++) {
            arr[i] = br.readLine(); // 공백 없이 한 줄 전체가 파일명
        }

        // 문제 조건: 모든 문자열의 길이가 동일
        int len = arr[0].length();
        StringBuilder pattern = new StringBuilder(arr[0]); // 기준 패턴을 첫 문자열로 초기화

        // 각 위치별로 모두 같은지 검사, 다르면 '?' 대입
        for (int i = 1; i < n; i++) {
            for (int pos = 0; pos < len; pos++) {
                if (pattern.charAt(pos) != arr[i].charAt(pos)) {
                    pattern.setCharAt(pos, '?');
                }
            }
        }

        System.out.println(pattern.toString());
    }
}
