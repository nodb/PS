import java.io.*;
import java.util.*;

public class Main
{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		int m100 = M / 100;
		int m10 = M / 10 % 10;
		int m1 = M % 10;
		System.out.println(N * m1);
		System.out.println(N * m10);
		System.out.println(N * m100);
		System.out.println(N * M);
	}
}
