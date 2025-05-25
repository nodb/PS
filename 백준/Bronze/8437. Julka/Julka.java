import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.math.BigInteger;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        BigInteger total = new BigInteger(br.readLine());
        BigInteger diff = new BigInteger(br.readLine());

        BigInteger more = total.add(diff).divide(BigInteger.valueOf(2));
        BigInteger less = total.subtract(diff).divide(BigInteger.valueOf(2));

        System.out.println(more);
        System.out.println(less);
    }
}
