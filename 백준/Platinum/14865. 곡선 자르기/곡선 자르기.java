import java.io.*;
import java.util.*;

public class Main {
    
    // 꼭짓점을 저장하는 클래스
    static class Point {
        int x, y;
        Point(int x, int y) {
            this.x = x; this.y = y;
        }
    }
    
    // 봉우리(peak)를 나타내는 클래스 – x축상의 구간 [left, right]
    static class Peak {
        long left, right;
        int childCount; // 이 봉우리가 포함하는 다른 봉우리 수
        Peak(long left, long right) {
            this.left = left;
            this.right = right;
            this.childCount = 0;
        }
    }
    
    // x축과의 교차점을 나타내는 클래스 (교차점은 vertical edge에서 발생)
    // type = 1: 아래에서 위로 (upward) / -1: 위에서 아래로 (downward)
    static class Event {
        int type;
        int x; // 교차점의 x좌표 (y=0)
        Event(int type, int x) {
            this.type = type;
            this.x = x;
        }
    }
    
    public static void main(String[] args) throws Exception {
        // 빠른 입출력을 위해 BufferedReader 사용
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine().trim());
        Point[] pts = new Point[N];
        for (int i = 0; i < N; i++) {
            String[] tok = br.readLine().split(" ");
            int x = Integer.parseInt(tok[0]);
            int y = Integer.parseInt(tok[1]);
            pts[i] = new Point(x, y);
        }
        
        // [1] 회전: 입력 순서가 “가장 왼쪽에 있는 수직 선분”을 기준으로 방향이 정해지므로,
        //     먼저 모든 vertical edge 중 y좌표가 증가하는 (아래→위) edge 중 x좌표가 최소인 것을 찾고,
        //     그 edge의 아래쪽 끝점을 시작점으로 삼는다.
        int startIndex = 0;
        int bestX = Integer.MAX_VALUE;
        for (int i = 0; i < N; i++) {
            int j = (i + 1) % N;
            if (pts[i].x == pts[j].x) { // vertical edge
                if (pts[i].y < pts[j].y) { // 아래에서 위로
                    if (pts[i].x < bestX) {
                        bestX = pts[i].x;
                        startIndex = i;
                    }
                }
            }
        }
        // 회전하여 새 배열에 저장 (원형 순회의 기준점을 변경)
        Point[] rotated = new Point[N];
        for (int i = 0; i < N; i++) {
            rotated[i] = pts[(startIndex + i) % N];
        }
        pts = rotated;
        
        // [2] 폴리곤의 변(에지)을 순회하면서, x축 (y=0)과 만나는 vertical edge(교차점)를 찾는다.
        //     (horizontal edge는 y가 일정하므로 교차 없음)
        //     각 교차점은 아래→위(UP) 혹은 위→아래(DOWN) 중 하나이다.
        ArrayList<Event> events = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            int j = (i + 1) % N;
            if (pts[i].x == pts[j].x) { // vertical edge
                // 두 점의 y값 부호가 다르면 x축과 교차함
                if (pts[i].y < 0 && pts[j].y > 0) {
                    // 아래→위 : upward crossing. 교차점은 (pts[i].x, 0)
                    events.add(new Event(1, pts[i].x));
                } else if (pts[i].y > 0 && pts[j].y < 0) {
                    // 위→아래 : downward crossing.
                    events.add(new Event(-1, pts[i].x));
                }
            }
        }
        // 이제 events는 폴리곤을 따라 순서대로 등장하는 교차점들이다.
        // (입력 회전을 통해 시작점은 y<0인 상태에서 시작하므로 첫 교차는 UP, 마지막은 DOWN)
        
        // [3] 교차점들을 순서대로 두 개씩 묶으면, 해당 구간이 x축 위에 있는 봉우리의 경계를 이룬다.
        //     봉우리의 x축상의 구간은 두 교차점의 x좌표를 정렬한 [min, max]로 나타낸다.
        ArrayList<Peak> peaks = new ArrayList<>();
        // events의 개수는 짝수여야 함
        for (int i = 0; i < events.size(); i += 2) {
            Event e1 = events.get(i);
            Event e2 = events.get(i + 1);
            // 정상적인 경우, e1은 UP, e2는 DOWN이어야 함.
            int a = e1.x, b = e2.x;
            long left = Math.min(a, b);
            long right = Math.max(a, b);
            peaks.add(new Peak(left, right));
        }
        
        // [4] 봉우리들은 서로 겹치거나 포함되는 관계를 이루는데,
        //     두 봉우리의 x축상의 구간 [L,R]에 대해, 한 봉우리가 다른 봉우리를 포함하는(또는 포함되는)
        //     관계는 구간 포함 관계와 일치한다.
        //     (문제의 조건상 두 봉우리의 경계는 서로 만나지 않으므로, 구간은 disjoint하거나 nested한다.)
        //     따라서 각 봉우리의 구간을 left 기준으로 정렬한 후, 스택을 이용하여 중첩(포함) 관계를 구한다.
        Collections.sort(peaks, new Comparator<Peak>() {
            public int compare(Peak p1, Peak p2) {
                if (p1.left != p2.left)
                    return Long.compare(p1.left, p2.left);
                // left가 같다면, 더 큰 right (즉, 더 큰 구간)을 앞쪽에
                return -Long.compare(p1.right, p2.right);
            }
        });
        
        int outerCount = 0; // 다른 봉우리에 포함되지 않는 봉우리 수
        // 봉우리의 포함관계(중첩)를 파악하기 위해 스택 사용
        Stack<Peak> stack = new Stack<>();
        for (Peak p : peaks) {
            // 스택의 top에 있는 봉우리의 right보다 현재 봉우리의 right가 크면, 겹치지 않는(또는 상위 구간이 끝난) 경우이므로 pop
            while (!stack.isEmpty() && p.right > stack.peek().right) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                // 스택이 비어있으면, 현재 봉우리는 외부 봉우리(다른 봉우리에 포함되지 않음)
                outerCount++;
            } else {
                // 그렇지 않으면, 현재 봉우리는 stack.peek()에 포함된다.
                stack.peek().childCount++;
            }
            stack.push(p);
        }
        
        // [5] 이제 "다른 봉우리를 포함하지 않는 봉우리"는 자식(child)이 없는 봉우리이다.
        int leafCount = 0;
        for (Peak p : peaks) {
            if (p.childCount == 0) leafCount++;
        }
        
        // 결과 출력: [외부봉우리 개수] [리프봉우리 개수]
        System.out.println(outerCount + " " + leafCount);
    }
}
