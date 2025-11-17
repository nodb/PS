import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int p = Integer.parseInt(st.nextToken());  // 한 번 누르는 시간
        int w = Integer.parseInt(st.nextToken());  // 같은 숫자 키 연속 사용 대기 시간
        String s = br.readLine();

        // 각 알파벳이 어떤 숫자 키에 속하는지
        int[] key = {
                2, 2, 2,   // A B C
                3, 3, 3,   // D E F
                4, 4, 4,   // G H I
                5, 5, 5,   // J K L
                6, 6, 6,   // M N O
                7, 7, 7, 7,// P Q R S
                8, 8, 8,   // T U V
                9, 9, 9, 9 // W X Y Z
        };

        // 각 알파벳이 해당 키에서 몇 번째 누름인지
        int[] pressCnt = {
                1, 2, 3,   // A B C
                1, 2, 3,   // D E F
                1, 2, 3,   // G H I
                1, 2, 3,   // J K L
                1, 2, 3,   // M N O
                1, 2, 3, 4,// P Q R S
                1, 2, 3,   // T U V
                1, 2, 3, 4 // W X Y Z
        };

        long totalTime = 0L;
        int lastKey = -1; // 직전에 눌렀던 숫자 키 (없으면 -1)

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            // 공백 처리: 무조건 p만 더하고, 대기시간(w)은 없음
            if (c == ' ') {
                totalTime += p;
                // 공백 뒤에는 같은 키 판정을 하지 않도록 lastKey 초기화
                lastKey = -1;
                continue;
            }

            int idx = c - 'A';      // 'A' -> 0, 'B' -> 1 ...
            int curKey = key[idx];   // 현재 문자가 있는 숫자 키
            int cnt = pressCnt[idx]; // 몇 번 눌러야 하는지

            // 직전 문자와 같은 숫자 키면 대기시간 추가
            if (curKey == lastKey) {
                totalTime += w;
            }

            // 현재 문자 누르는 시간
            totalTime += (long) cnt * p;

            // 마지막 키 갱신
            lastKey = curKey;
        }

        System.out.println(totalTime);
    }
}
