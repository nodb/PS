import java.io.BufferedReader;
import java.io.*;
import java.util.*;

public class Main {
	static int max; // 최대 숫자
	static boolean[] arr; // 숫자 사용 여부 체크
	static List<Integer> result = new ArrayList<>(); // 복구 순열 저장
	static String s;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		s = br.readLine();
		int len = s.length();
		max = (len <= 9) ? len : 9 + (len - 9) / 2;

		arr = new boolean[max + 1];

		dfs(0);
		for (int i = 0; i < result.size(); i++) {
			System.out.print(result.get(i) + " ");
		}

	}

	private static boolean dfs(int index) {
		// 문자열을 끝까지 탐색했다면 true 반환
		if (index == s.length()) {
			return true;
		}

		// 한 자리 숫자 (1 ~ 9)
		if (index < s.length()) {
			int num = s.charAt(index) - '0'; // 한 자리 숫자 변환
			if (num >= 1 && num <= max && !arr[num]) { // 1 ~ max 사이의 숫자 & 미사용 숫자 확인
				arr[num] = true; // 숫자 사용 처리
				result.add(num); // 결과 리스트에 추가
				if (dfs(index + 1))
					return true; // 다음 숫자 탐색
				arr[num] = false; // 백트래킹 (사용 취소)
				result.remove(result.size() - 1); // 리스트에서 제거
			}
		}

		// 두 자리 숫자 시도 (10 ~ max)
		if (index + 1 < s.length()) {
			int num = Integer.parseInt(s.substring(index, index + 2)); // 두 자리 숫자 변환
			if (num >= 10 && num <= max && !arr[num]) { // 10 ~ max 사이의 숫자 & 미사용 숫자 확인
				arr[num] = true; // 숫자 사용 처리
				result.add(num); // 결과 리스트에 추가
				if (dfs(index + 2))
					return true; // 다음 숫자 탐색
				arr[num] = false; // 백트래킹 (사용 취소)
				result.remove(result.size() - 1); // 리스트에서 제거
			}
		}

		return false; // 유효한 순열을 찾지 못한 경우
	}
}
