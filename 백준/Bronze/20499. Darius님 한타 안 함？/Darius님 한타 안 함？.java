import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String s = br.readLine();
		String[] kda = s.split("/");

		if (Integer.parseInt(kda[0]) + Integer.parseInt(kda[2]) < Integer.parseInt(kda[1]) |
				Integer.parseInt(kda[1]) == 0) {
			System.out.println("hasu");
		} else {
			System.out.println("gosu");
		}
	}
}
