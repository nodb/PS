import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	private static int N;
	static private String [] s = {"\"재귀함수가 뭔가요?\"", "\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.", "마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.", "그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\""};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());

		System.out.println("어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.");
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < s.length; j++) {
				for (int k = 0; k < i * 4; k++) {
					System.out.print("_");
				}
				System.out.println(s[j]);
			}
		}
		for (int j = 0; j < N*4; j++) {
			System.out.print("_");
		}
		System.out.println(s[0]);
		for (int j = 0; j < N*4; j++) {
			System.out.print("_");
		}
		System.out.println("\"재귀함수는 자기 자신을 호출하는 함수라네\"");
		for (int i = 0; i <= N; i++) {
			for (int j = (N - i) * 4; j > 0; j--) {
				System.out.print("_");
			}
			System.out.println("라고 답변하였지.");
		}
	}
}
