import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int h = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int p = Integer.parseInt(br.readLine());
        int resultm = (m + p) % 60;
        int resulth = (h + (m + p) / 60) % 24;
		System.out.println(resulth + " " + resultm);
	}
}