import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb.append(":fan::fan::fan:\n:fan::").append(br.readLine()).append("::fan:\n:fan::fan::fan:");
		System.out.println(sb);
	}
}
