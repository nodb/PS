import java.io.*;
import java.util.*;

public class Main
{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int i = 0; i < T; i++) { 
    		StringTokenizer st = new StringTokenizer(br.readLine());
    		int x1 = Integer.parseInt(st.nextToken());
    		int y1 = Integer.parseInt(st.nextToken());
    		int r1 = Integer.parseInt(st.nextToken());
    		int x2 = Integer.parseInt(st.nextToken());
    		int y2 = Integer.parseInt(st.nextToken());
    		int r2 = Integer.parseInt(st.nextToken());
    		
    		double dis = Math.sqrt((x2 - x1)*(x2 - x1) + (y2 - y1)*(y2 - y1));
    		
    		if (x1 == x2 && y1 == y2 && r1 == r2) { // 같으면
    		    sb.append(-1 + "\n");
    		    continue;
    		}
    		if (r1 + r2 == dis) { // 안쪽 한 점 닿음
    		    sb.append(1 + "\n");
    		    continue;
    		}
    		if (r1 + dis == r2 || r2 + dis == r1) { // 바깥쪽 한 점 닿음
    		    sb.append(1 + "\n");
    		    continue;
    		}
    		if (r1 + r2 < dis) { // 양쪽 짧아서 안 닿음
    		    sb.append(0 + "\n");
    		    continue;
    		}
    		if (r1 + dis < r2 || r2 + dis < r1) { // 넘어서(포함해서) 안 닿음
    		    sb.append(0 + "\n");
    		    continue;
    		}
    		if (r1 + r2 > dis) { // 두 점 닿음
    		    sb.append(2 + "\n");
    		    continue;
    		}
		}
		System.out.println(sb);
	}
}
