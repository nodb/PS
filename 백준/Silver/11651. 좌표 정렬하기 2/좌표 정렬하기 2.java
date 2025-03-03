import java.io.*;
import java.util.*;

public class Main {
    static class Point implements Comparable<Point> {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Point other) {
            if (this.y == other.y) {
                return Integer.compare(this.x, other.x); // x 좌표 오름차순
            }
            return Integer.compare(this.y, other.y); // y 좌표 오름차순
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Point> pq = new PriorityQueue<>();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            pq.add(new Point(x, y));
        }

        StringBuilder sb = new StringBuilder();
        while (!pq.isEmpty()) {
            Point p = pq.poll();
            sb.append(p.x).append(" ").append(p.y).append("\n");
        }
        System.out.print(sb);
    }
}
