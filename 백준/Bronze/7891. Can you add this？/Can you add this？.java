import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int c = Integer.parseInt(br.readLine());
		for (int i = 0; i < c; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			System.out.println(Integer.parseInt(st.nextToken()) + Integer.parseInt(st.nextToken())); 
		}
	}
}