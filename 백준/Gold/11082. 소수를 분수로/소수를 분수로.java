import java.io.*;
import java.util.*;

public class Main {

    static long gcd(long a, long b) {
        while (b != 0) {
            long t = a % b;
            a = b;
            b = t;
        }
        return a;
    }

    static long pow10(int n) {
        long result = 1;
        for (int i = 0; i < n; i++) result *= 10;
        return result;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine().trim();

        long numerator;
        long denominator;

        // 정수만 있는 경우
        if (!s.contains(".")) {
            numerator = Long.parseLong(s);
            denominator = 1;
        }
        // 소수점은 있는데 순환이 없는 경우
        else if (!s.contains("(")) {
            String[] parts = s.split("\\.");
            String integerPart = parts[0];
            String decimalPart = parts[1];

            long den = pow10(decimalPart.length());
            long num = Long.parseLong(integerPart + decimalPart);

            long g = gcd(num, den);
            numerator = num / g;
            denominator = den / g;
        }
        // 순환소수인 경우
        else {
            String[] parts = s.split("\\.");
            String integerPart = parts[0];
            String decimalAll = parts[1];   // 예: 12(34)

            int openIdx = decimalAll.indexOf('(');
            int closeIdx = decimalAll.indexOf(')');

            String nonRepeat = decimalAll.substring(0, openIdx);         // 비순환 부분
            String repeat = decimalAll.substring(openIdx + 1, closeIdx); // 순환 부분

            int m = nonRepeat.length();
            int n = repeat.length();

            long den = pow10(m) * (pow10(n) - 1);

            String full1 = integerPart + nonRepeat + repeat; // 정수+비순환+순환
            String full2 = integerPart + nonRepeat;          // 정수+비순환

            long num1 = Long.parseLong(full1);
            long num2 = Long.parseLong(full2);

            long num = num1 - num2;

            long g = gcd(num, den);
            numerator = num / g;
            denominator = den / g;
        }

        System.out.println(numerator + "/" + denominator);
    }
}