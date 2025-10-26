import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(br.readLine().trim());

        long a = (n + 1) * 2;
        long b = (n + 1) * 3;

        System.out.println(a + " " + b);
    }
}