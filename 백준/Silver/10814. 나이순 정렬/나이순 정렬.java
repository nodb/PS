import java.io.*;
import java.util.*;

public class Main {
    static class Member implements Comparable<Member> {
        int age;
        String name;
        int index;

        public Member(int age, String name, int index) {
            this.age = age;
            this.name = name;
            this.index = index;
        }

        @Override
        public int compareTo(Member other) {
            if (this.age == other.age) {
                return Integer.compare(this.index, other.index);
            }
            return Integer.compare(this.age, other.age);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        Queue<Member> pq = new PriorityQueue<>();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int age = Integer.parseInt(st.nextToken());
            String name = st.nextToken();
            pq.add(new Member(age, name, i));
        }

        while (!pq.isEmpty()) {
            Member m = pq.poll();
            sb.append(m.age+ " " + m.name + "\n");
        }
        System.out.print(sb);
    }
}
