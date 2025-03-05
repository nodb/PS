import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        HashMap<String, String> hm = new HashMap<>();
        for (int i = 0; i < N; i++) {
        	st = new StringTokenizer(br.readLine());
        	String site = st.nextToken();
        	String pw = st.nextToken();
			hm.put(site, pw);
		}
        for (int i = 0; i < M; i++) {
        	String s = br.readLine();
			sb.append(hm.get(s)).append("\n");
		}
        System.out.println(sb);
    }
}
