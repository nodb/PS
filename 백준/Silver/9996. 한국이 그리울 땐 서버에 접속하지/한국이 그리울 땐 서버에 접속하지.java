import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		String pattern = br.readLine();
		String[] part = pattern.split("\\*");
		for (int i = 0; i < n; i++) {
			String s = br.readLine();
			// 길이 고려
			if (part[0].length() + part[1].length() > s.length()) {
				sb.append("NE").append("\n");
				continue;
			}
			boolean flag = true;
			for (int front = 0; front < part[0].length(); front++) {
				if (s.charAt(front) != part[0].charAt(front)) {
					sb.append("NE").append("\n");
					flag = false;
					break;
				}
			}
			if (flag) {
				int index = s.length() - 1;
				for (int back = part[1].length() - 1; back >= 0; back--) {
					if (s.charAt(index--) != part[1].charAt(back)) {
						sb.append("NE").append("\n");
						flag = false;
						break;
					}
				}
				if (flag)
					sb.append("DA").append("\n");
			}
		}
		System.out.println(sb);
	}
}
// regex(정규 표현식; Regular expression)
// - 논리식, 계산식 사용시 부호로 사용
// - "|", "*", ".", "&", "^"
//
// split() 함수 사용시 regex를 문자로 사용시
// - regex 앞에 \\(백슬래시 두 번) 넣어줘야 문자로 적용
