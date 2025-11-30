import java.io.*;
import java.util.*;

public class Main {
	static int r, c, k;
	static int arr[][];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		arr = new int[100][100];
		for (int y = 0; y < 3; y++) {
			st = new StringTokenizer(br.readLine());
			for (int x = 0; x < 3; x++) {
				arr[y][x] = Integer.parseInt(st.nextToken());
			}
		}
		int lenX = 3;
		int lenY = 3;
		for (int t = 0; t <= 100; t++) {
			if (check()) {
				System.out.println(t);
				return;
			}
			if (lenY >= lenX) {
				int newLenX = 0;
				for (int y = 0; y < lenY; y++) {
					Map<Integer, Integer> hm = new HashMap<>();
					for (int x = 0; x < lenX; x++) {
						int num = arr[y][x];
						if (num == 0)
							continue;
						hm.put(num, hm.getOrDefault(num, 0) + 1);
					}
					List<Map.Entry<Integer, Integer>> list = new ArrayList<>(hm.entrySet());
					list.sort((o1, o2) -> {
						int v = o1.getValue().compareTo(o2.getValue());
						if (v != 0)
							return v;
						return o1.getKey().compareTo(o2.getKey());
					});
					int x = 0;
					for (int i = 0; i < list.size() && x < 100; i++) {
						arr[y][x++] = list.get(i).getKey();
						arr[y][x++] = list.get(i).getValue();
					}
					for (int i = x; i < 100; i++) {
						arr[y][i] = 0;
					}
					newLenX = Math.max(newLenX, x);
				}
				lenX = newLenX;
			} else {
				int newLenY = 0;
				for (int x = 0; x < lenX; x++) {
					Map<Integer, Integer> hm = new HashMap<>();
					for (int y = 0; y < lenY; y++) {
						int num = arr[y][x];
						if (num == 0)
							continue;
						hm.put(num, hm.getOrDefault(num, 0) + 1);
					}
					List<Map.Entry<Integer, Integer>> list = new ArrayList<>(hm.entrySet());
					list.sort((o1, o2) -> {
						int v = o1.getValue().compareTo(o2.getValue());
						if (v != 0)
							return v;
						return o1.getKey().compareTo(o2.getKey());
					});
					int y = 0;
					for (int i = 0; i < list.size() && y < 100; i++) {
						arr[y++][x] = list.get(i).getKey();
						arr[y++][x] = list.get(i).getValue();
					}
					for (int i = y; i < 100; i++) {
						arr[i][x] = 0;
					}
					newLenY = Math.max(newLenY, y);
				}
				lenY = newLenY;
			}
		}
		System.out.println(-1);
	}

	private static boolean check() {
		if (arr[r - 1][c - 1] == k)
			return true;
		return false;
	}
}