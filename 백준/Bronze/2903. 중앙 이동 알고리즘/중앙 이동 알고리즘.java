import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());

		int init = 2;
		for (int i = 1; i <= num; i++) {
			init = init * 2 - 1;
		}

		System.out.println(init * init);
	}
}
