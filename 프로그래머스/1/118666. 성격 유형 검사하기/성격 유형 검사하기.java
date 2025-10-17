import java.io.*;
import java.util.*;

class Solution {
    public String solution(String[] survey, int[] choices) {
        int R = 0;
        int T = 0;
        int C = 0;
        int F = 0;
        int J = 0;
        int M = 0;
        int A = 0;
        int N = 0;
        for (int i = 0; i < survey.length; i++) {
            String s[] = survey[i].split("");
            int c = choices[i];
            
            int select = 0;
            if (c == 4)
                continue;
            else if (c < 4)
                select = 0;
            else if (c > 4)
                select = 1;
            
            int score = 0;
            if (c == 1 || c == 7)
                score = 3;
            else if (c == 2 || c == 6)
                score = 2;
            else if (c == 3 || c == 5)
                score = 1;
            
            switch (s[select]) {
                case "R":
                    R += score;
                    break;
                case "T":
                    T += score;
                    break;
                case "C":
                    C += score;
                    break;
                case "F":
                    F += score;
                    break;
                case "J":
                    J += score;
                    break;
                case "M":
                    M += score;
                    break;
                case "A":
                    A += score;
                    break;
                case "N":
                    N += score;
                    break;
            }
        }
        String s1 = "R";
        String s2 = "C";
        String s3 = "J";
        String s4 = "A";
        if (R < T)
            s1 = "T";
        if (C < F)
            s2 = "F";
        if (J < M)
            s3 = "M";
        if (A < N)
            s4 = "N";
        return s1 + s2 + s3 + s4;
    }
}