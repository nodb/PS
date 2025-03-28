import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.math.BigInteger;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        BigInteger wealth = new BigInteger(input[0]);
        BigInteger people = new BigInteger(input[1]);
        BigInteger quotient = wealth.divide(people);
        BigInteger remainder = wealth.mod(people);
        System.out.println(quotient);
        System.out.println(remainder);
    }
}
