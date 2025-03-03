import java.io.*;

public class Main {
    static final int r = 31;
    static final int M = 1234567891;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int L = Integer.parseInt(br.readLine());
        String s = br.readLine();

        long result = 0;
        long power = 1;

        for (int i = 0; i < L; i++) {
            int charValue = s.charAt(i) - 'a' + 1;
            result = (result + (charValue * power) % M) % M;
            power = (power * r) % M;
        }

        System.out.println(result);
    }
}
