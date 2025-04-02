import java.io.*;
import java.math.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        ArrayList<BigInteger> list = new ArrayList<>();
        
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < s.length(); j++) {
                char c = s.charAt(j);
                // 현재 문자가 숫자라면 numBuilder에 추가
                if (Character.isDigit(c)) {
                    sb.append(c);
                } else {
                    // 숫자가 아닌 문자를 만나면, 지금까지 누적한 숫자가 있다면 리스트에 추가
                    if (sb.length() > 0) {
                        list.add(new BigInteger(sb.toString()));
                        sb.setLength(0);
                    }
                }
            }
            // 라인 끝까지 숫자가 누적되어 있다면 추가
            if (sb.length() > 0) {
                list.add(new BigInteger(sb.toString()));
            }
        }
        
        Collections.sort(list);
        
        for (BigInteger b : list) {
            System.out.println(b);
        }
    }
}
