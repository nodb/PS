import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine().trim());
        StringBuilder sb = new StringBuilder();

        for (int tc = 0; tc < T; tc++) {
            // 빈 줄(또는 공백만 있는 줄) 건너뛰기
            String line;
            while (true) {
                line = br.readLine();
                if (line == null) return; // 안전장치
                if (!line.trim().isEmpty()) break;
            }

            // 첫 번째 줄: cm, y, ssu, ssa, f
            StringTokenizer st = new StringTokenizer(line);
            long cm  = Long.parseLong(st.nextToken()); // 우유
            long y   = Long.parseLong(st.nextToken()); // 노른자
            long ssu = Long.parseLong(st.nextToken()); // 설탕
            long ssa = Long.parseLong(st.nextToken()); // 소금
            long f   = Long.parseLong(st.nextToken()); // 밀가루

            // 두 번째 줄: b, gs, gc, w
            line = br.readLine();
            while (line != null && line.trim().isEmpty()) {
                line = br.readLine();
            }
            st = new StringTokenizer(line);
            long b  = Long.parseLong(st.nextToken()); // 바나나
            long gs = Long.parseLong(st.nextToken()); // 딸기잼(그램)
            long gc = Long.parseLong(st.nextToken()); // 초콜릿(그램)
            long w  = Long.parseLong(st.nextToken()); // 호두(개)

            // --------------------------
            // 1. 반죽으로 만들 수 있는 팬케이크 수 계산
            // m = min(9cm, 9y, 18ssu, 72ssa, 8f)
            long m1 = 9L * cm;
            long m2 = 9L * y;
            long m3 = 18L * ssu;
            long m4 = 72L * ssa;
            long m5 = 8L * f;

            long m = Math.min(m1, Math.min(m2, Math.min(m3, Math.min(m4, m5))));

            // 반죽만으로 만들 수 있는 최대 개수: floor(2 * m / 9)
            long fromDough = (2L * m) / 9L;

            // --------------------------
            // 2. 토핑으로 만들 수 있는 팬케이크 수 계산
            long fromTopping = b
                    + (gs / 30L)
                    + (gc / 25L)
                    + (w  / 10L);

            // --------------------------
            // 3. 최종 결과: 두 값 중 최소
            long answer = Math.min(fromDough, fromTopping);
            sb.append(answer).append('\n');
        }

        System.out.print(sb);
    }
}
