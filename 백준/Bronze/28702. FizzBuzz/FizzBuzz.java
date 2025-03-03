import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] s = new String[3];
		for (int i = 0; i < 3; i++) {
			s[i] = br.readLine();
		}

		int num = 0;
		for (int i = 0; i < 3; i++) {
			if (s[i].equals("Fizz") || s[i].equals("Buzz") || s[i].equals("FizzBuzz")) {
				continue;
			}
			num = Integer.parseInt(s[i]) + (3 - i);
			break;
		}

		if (num % 3 == 0 && num % 5 == 0) {
			System.out.println("FizzBuzz");
		} else if (num % 3 == 0) {
			System.out.println("Fizz");
		} else if (num % 5 == 0) {
			System.out.println("Buzz");
		} else {
			System.out.println(num);
		}
	}
}
