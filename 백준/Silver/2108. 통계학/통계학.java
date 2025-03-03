import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] numbers = new int[N];
		int[] count = new int[8001]; // -4000 ~ 4000
		int sum = 0, min = 4000, max = -4000;

		for (int i = 0; i < N; i++) {
			numbers[i] = Integer.parseInt(br.readLine());
			sum += numbers[i];
			count[numbers[i] + 4000]++;
			min = Math.min(min, numbers[i]);
			max = Math.max(max, numbers[i]);
		}

		Arrays.sort(numbers);

		int maxFreq = 0;
		List<Integer> freq = new ArrayList<>();

		for (int i = 0; i < 8001; i++) {
			if (count[i] > maxFreq) {
				maxFreq = count[i];
				freq.clear();
				freq.add(i - 4000);
			} else if (count[i] == maxFreq) {
				freq.add(i - 4000);
			}
		}

		System.out.println((int) Math.round((double) sum / N)); // 산술 평균
		System.out.println(numbers[N / 2]); // 중앙값
		System.out.println((freq.size() > 1) ? freq.get(1) : freq.get(0)); // 최빈값
		System.out.println(max - min); // 최댓값 - 최솟값
	}
}
