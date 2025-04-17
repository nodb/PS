import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String arr[] = new String[5];
		int max = 0;
		for (int i = 0; i < 5; i++) {
			arr[i] = br.readLine();
			if (max < arr[i].length())
				max = arr[i].length();
		}
		for (int i = 0; i < max; i++) {
			for (int j = 0; j < 5; j++) {
				if (arr[j].length() > i)
					System.out.print(arr[j].charAt(i));
			}
		}
	}
}