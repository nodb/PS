import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		String S = br.readLine();

		int result = 0; // 결과: 패턴이 등장하는 횟수
		int count = 0; // 현재 IOI가 몇 번 반복되는지 저장

		for (int i = 1; i < M - 1;) {
			// IOI 패턴 발견
			if (S.charAt(i - 1) == 'I' && S.charAt(i) == 'O' && S.charAt(i + 1) == 'I') {
				count++; // IOI 하나 발견
				if (count == N) {
					result++; // 원하는 N번 만큼 IOI가 반복되면 결과 증가
					count--; // 겹치기 때문에 하나 줄이고 계속 진행
				}
				i += 2; // IOI는 2글자씩 이동
			} else {
				count = 0; // 패턴 끊기면 count 초기화
				i++; // 다음 문자로 이동
			}
		}

		System.out.println(result);
	}
}
