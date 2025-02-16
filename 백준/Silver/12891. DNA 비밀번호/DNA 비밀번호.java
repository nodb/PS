import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int s = Integer.parseInt(st.nextToken());
		int p = Integer.parseInt(st.nextToken());
		char arr[] = new char[s];
		String text = br.readLine();
		for (int i = 0; i < s; i++) {
			arr[i] = text.charAt(i);
		}
		st = new StringTokenizer(br.readLine());
		int Amin = Integer.parseInt(st.nextToken());
		int Cmin = Integer.parseInt(st.nextToken());
		int Gmin = Integer.parseInt(st.nextToken());
		int Tmin = Integer.parseInt(st.nextToken());

		int Acnt = 0;
		int Ccnt = 0;
		int Gcnt = 0;
		int Tcnt = 0;
		int cnt = 0;
		for (int i = 0; i < p; i++) {
			if (arr[i] == 'A') {
				Acnt++;
			} else if (arr[i] == 'C') {
				Ccnt++;

			} else if (arr[i] == 'G') {
				Gcnt++;

			} else if (arr[i] == 'T') {
				Tcnt++;
			}
		}
		if (Acnt >= Amin && Ccnt >= Cmin && Gcnt >= Gmin && Tcnt >= Tmin) {
			cnt++;
		}

		for (int i = p; i < s; i++) {
			if (arr[i - p] == 'A') {
				Acnt--;
			} else if (arr[i - p] == 'C') {
				Ccnt--;

			} else if (arr[i - p] == 'G') {
				Gcnt--;

			} else if (arr[i - p] == 'T') {
				Tcnt--;
			}
			if (arr[i] == 'A') {
				Acnt++;
			} else if (arr[i] == 'C') {
				Ccnt++;

			} else if (arr[i] == 'G') {
				Gcnt++;

			} else if (arr[i] == 'T') {
				Tcnt++;
			}
			if (Acnt >= Amin && Ccnt >= Cmin && Gcnt >= Gmin && Tcnt >= Tmin) {
				cnt++;
			}
		}
		System.out.println(cnt);
	}
}
