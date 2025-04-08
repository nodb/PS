import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int a = Integer.parseInt(br.readLine());
		int arr[] = new int[a];
		ArrayList<Integer> list[] = new ArrayList[a];
		for (int i = 0; i < a; i++) {
			list[i] = new ArrayList<>();
			list[i].add(i);
		}
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < a; i++)
			arr[i] = Integer.parseInt(st.nextToken());
		for (int i = 0; i < a; i++) {
			for (int j = 0; j < i; j++) {
				if (arr[i] > arr[j])
					if (list[i].size() < list[j].size() + 1) {
						list[i] = (ArrayList<Integer>) list[j].clone();
						list[i].add(i);
					}
			}
		}
		int num = 0;
		for (int i = 0; i < a; i++) {
			if (list[num].size() < list[i].size())
				num = i;
		}
		System.out.println(list[num].size());
		for (int n : list[num]) {
			System.out.print(arr[n] + " ");
		}
	}
}