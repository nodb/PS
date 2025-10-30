import java.io.*;
import java.util.*;

class Solution {
    static int cnt = 0;
    static String want = "";
    static int answer = 0;
    public int solution(String word) {
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (c == 'A')
                want += "1";
            else if (c == 'E')
                want += "2";
            else if (c == 'I')
                want += "3";
            else if (c == 'O')
                want += "4";
            else if (c == 'U')
                want += "5";
        }
        System.out.println(want);
        dic("");
        return answer - 1;
    }
    
    static public void dic(String s) {
        System.out.println(s);
        cnt++;
        if (s.equals(want))
            answer = cnt;
        if (s.length() == 5)
            return;
        for (int i = 1; i <= 5; i++) {
            dic(s + (i + ""));
        }
    }
}
/*
1. 숫자 1부터 5까지 모든 가능한 5자리 조합
3. word를 A -> 1, E -> 2, I -> 3, O -> 4, U -> 5으로 매칭하여 숫서 찾기

1  A     1
2  AA    11
3  AAA   111
4  AAAA  1111
5  AAAAA 11111 
6  AAAAE 11112
7  AAAAI 11113
8  AAAAO 11114
9  AAAAU 11115
10 AAAE  1112
*/