import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        for (char c : s.toCharArray()) {
            if (c >= 'A' && c <= 'Z') {  // 대문자
                c = (char) ('A' + (c - 'A' + 13) % 26);
            } else if (c >= 'a' && c <= 'z') {  // 소문자
                c = (char) ('a' + (c - 'a' + 13) % 26);
            }
            System.out.print(c);
        }
    }
}
