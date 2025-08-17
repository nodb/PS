import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 식의 값을 최소
		// → 모든 + 값 계산 후
		// → 모든 - 값 계산
		
		// -로 분리
		String arr[] = br.readLine().split("-");
		
		// 분리한 값의 합을 저장할 배열
		int sum[] = new int[arr.length];
		
		// 각각의 + 값을 계산
		for (int i = 0; i < sum.length; i++) {
			// +로 분리
			// +는 메타 문자라서 단순히 split("+") 사용하면 오류 발생
			// 방법 1 : split("\\+") - 이스케이프
			// 방법 2 : split("[+]") - 정규표현식
			// - [] : 대괄호 안의 문자중 일치하는 것 ← 대괄호 안에 사용하면 편함
			// 방법 3 : StringTokenizer 사용
			// - StringTokenizer st = new StringTokenizer(arr[i], "+");
			// 편한걸로 사용하면 됨
			String arr2[] = arr[i].split("[+]");
			for (int j = 0; j < arr2.length; j++) 
				sum[i] += Integer.parseInt(arr2[j]);
		}
		
		// 처음 sum 값에서 이후 모든 sum 값 빼주기
		int result = sum[0];
		for (int i = 1; i < sum.length; i++)
			result -= sum[i];
		System.out.println(result);
	}
}