import java.io.*;

public class Main {
	static int N;
	static char in1[], in2[], out[];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		in1 = br.readLine().toCharArray();
		in2 = in1.clone(); // 복제
		out = br.readLine().toCharArray();

		// 처음 안 누름
		int num1 = check(in1, 0);

		// 처음 누름
		change(in2, 0);
		change(in2, 1);
		int num2 = check(in2, 1);

		if (num1 == 100_001 && num2 == 100_001) // 둘 다 결과 안 맞으면
			System.out.println(-1);
		else
			System.out.println(Math.min(num1, num2));

	}

	private static int check(char[] in, int num) {
		for (int i = 1; i < N; i++) {
			if (i == N - 1) { // 마지막은 뒤 갱신 X
				if (in[i - 1] != out[i - 1]) { // 앞부분 다르면
					num++;
					change(in, i - 1);
					change(in, i);
				}
			} else {
				if (in[i - 1] != out[i - 1]) { // 앞부분 다르면
					num++;
					change(in, i - 1);
					change(in, i);
					change(in, i + 1);
				}
			}
		}

		for (int i = 0; i < N; i++) { // 결과와 다르면
			if (in[i] != out[i]) {
				num = 100_001;
			}
		}

		return num;
	}

	private static void change(char in[], int n) {
		if (in[n] == '0')
			in[n] = '1';
		else
			in[n] = '0';
	}
}