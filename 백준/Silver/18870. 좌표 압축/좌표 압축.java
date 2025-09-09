import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        // 두 개의 배열 준비
        //    original: 입력된 원래 순서 그대로 저장 (출력 시 순서 보존용)
        //    sorted  : 정렬용 복사본 (고유 값들에 0,1,2.. 인덱스를 매길 때 사용)
        int[] original = new int[N];
        int[] sorted   = new int[N];

        for (int i = 0; i < N; i++) {
            int v = Integer.parseInt(st.nextToken());
            original[i] = v; // 원본 순서 보존
            sorted[i] = v; // 정렬 대상으로 복사
        }

        // 동일 값은 인접하게 모이므로 뒤에서 중복 제거가 쉬워진다
        Arrays.sort(sorted); // 정렬 시간복잡도: O(N log N)

        // 값 -> 압축 좌표(0,1,2,...) 매핑을 위한 해시맵
        //    HashMap을 쓰면 평균 O(1)에 가까운 시간으로 매핑을 조회할 수 있다!
        //    TreeMap을 쓰면 키가 정렬된 상태를 유지하지만 여기선 필요 없음 (정렬은 배열에서 이미 처리)
        HashMap<Integer, Integer> comp = new HashMap<>();

        // 정렬된 배열을 순회하면서 "처음 나오는 값"에게만 새로운 좌표를 부여(중복 제거)
        int idx = 0; // 압축 좌표 순서
        for (int key : sorted) {
            // 아직 매핑되지 않은(=처음 보는) 값만 좌표를 부여
            if (!comp.containsKey(key)) {
                comp.put(key, idx++);
            }
        }

        // 원본 배열 순서대로 매핑된 좌표를 꺼내서 출력 버퍼에 적재
        for (int i = 0; i < N; i++) {
            sb.append(comp.get(original[i]) + " ");
        }

        System.out.println(sb.toString());
    }
}