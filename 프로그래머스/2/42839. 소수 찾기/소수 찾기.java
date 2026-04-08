import java.io.*;
import java.util.*;

class Solution {
    static int len;
    static int num[];
    static boolean prime[];
    static boolean visited[];
    static String s;
    static int target;
    static int answer = 0;
    
    public int solution(String numbers) {
        len = numbers.length();
        num = new int[len];
        for (int i = 0; i < len; i++) {
            num[i] = numbers.charAt(i) - '0';
        }
        
        isPrime();
        
        visited = new boolean[len];
        for (int i = 1; i <= len; i++) {
            s = "";
            target = i;
            dfs(0);
        }
        return answer;
    }
    
    static void dfs(int cnt) {
        if (cnt == target) {
            if (prime[Integer.parseInt(s)]) {
                answer++;
                prime[Integer.parseInt(s)] = false;
            }
            return;
        }
        for (int i = 0; i < len; i++) {
            if (visited[i])
                continue;
            s += num[i];
            visited[i] = true;
            dfs(cnt + 1);
            s = s.substring(0, s.length() - 1);
            visited[i] = false;
        }
    }
    
    static void isPrime(){ 
        prime = new boolean[10_000_000];
        
        for(int i = 0; i < prime.length; i++){
            prime[i] = true;
        }
        
        prime[0] = prime[1] = false;
        
        for (int i = 2; i < Math.sqrt(10_000_000); i++){
            if (prime[i]) {
                for (int j = i * i; j < 10_000_000; j += i) {
                    prime[j] = false;
                }
            }
        }
    }
}