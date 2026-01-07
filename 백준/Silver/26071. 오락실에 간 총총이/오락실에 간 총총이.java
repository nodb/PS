import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		char c[][] = new char[n][n];
		for (int i = 0; i < n; i++) {
			String s = br.readLine();
			c[i] = s.toCharArray();
		}
		int minX = n;
		int minY = n;
		int maxX = -1;
		int maxY = -1;
		for (int y = 0; y < n; y++) {
			for (int x = 0; x < n; x++) {
				if (c[y][x] == 'G') {
					if (x < minX)
						minX = x;
					if (x > maxX)
						maxX = x;
					if (y < minY)
						minY = y;
					if (y > maxY)
						maxY = y;
				}
			}
		}
		int x = 0;
		int y = 0;
		if (minX != maxX)
			x = Math.min(maxX, n - minX - 1);
		if (minY != maxY)
			y = Math.min(maxY, n - minY - 1);
		System.out.println(x + y);
	}
}
