import java.io.*;
import java.math.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String a = null, b = null;
        String line;
        while ((line = br.readLine()) != null) {
            StringTokenizer st = new StringTokenizer(line);
            while (st.hasMoreTokens()) {
                if (a == null) a = st.nextToken();
                else { b = st.nextToken(); break; }
            }
            if (b != null) break;
        }

        BigInteger A = new BigInteger(a);
        BigInteger B = new BigInteger(b);
        System.out.print(A.multiply(B).toString());
    }
}
