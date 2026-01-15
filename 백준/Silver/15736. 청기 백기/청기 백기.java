import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		// 제곱수만 백색
		// 1~n까지 제곱수의 개수
		// = n 제곱근의 정수 부분
		System.out.println((int) Math.sqrt(n));
	}
}