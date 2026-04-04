import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		char arr[][] = new char[r][c];

		for (int y = 0; y < r; y++) {
			arr[y] = br.readLine().toCharArray();
		}

		int max = 0;

		// up ~ down 행 범위 고정
		for (int up = 0; up < r; up++) {

		    // 각 열이 막혔는지 저장
		    boolean[] canX = new boolean[c];

		    for (int down = up; down < r; down++) {

		        // down 행을 포함시키면서 canX 갱신
		        for (int x = 0; x < c; x++) {
		            if (arr[down][x] == 'X') {
		                canX[x] = true;
		            }
		        }

		        int h = down - up + 1;
		        int w = 0;

		        // 연속한 가능한 열 찾기
		        for (int x = 0; x < c; x++) {
		            if (!canX[x]) {
		                w++;
		                max = Math.max(max, 2 * (h + w));
		            } else {
		                w = 0;
		            }
		        }
		    }
		}

		System.out.println(max - 1);
	}
}