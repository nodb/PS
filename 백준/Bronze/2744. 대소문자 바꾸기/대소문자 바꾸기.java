import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String s = br.readLine();
        for (char c : s.toCharArray()) {
            if (Character.isLowerCase(c)) {
                // 소문자 -> 대문자
                sb.append(Character.toUpperCase(c));
            } else if (Character.isUpperCase(c)) {
                // 대문자 -> 소문자
                sb.append(Character.toLowerCase(c));
            } else {
                // 알파벳 외
                sb.append(c);
            }
        }
        System.out.println(sb.toString());
    }
}