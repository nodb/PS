import java.io.*;
import java.util.*;

public class Main {
	public static class Pair implements Comparable<Pair> {
		int age;
		String name;

		Pair(int age, String name) {
			this.age = age;
			this.name = name;
		}

		@Override
		public int compareTo(Pair o) {
			return age - o.age;
		}

	}

	public static void main(String[] args) throws Exception {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		ArrayList<Pair> list = new ArrayList<>();
		int n = Integer.parseInt(br.readLine());
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int age = Integer.parseInt(st.nextToken());
			String name = st.nextToken();
			list.add(new Pair(age, name));
		}
		list.sort(null);
		for (int i = 0; i < n; i++) {
			sb.append(list.get(i).age + " " + list.get(i).name + "\n");			
		}
		System.out.println(sb);
	}
}
