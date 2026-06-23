import java.io.*;
import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        HashMap<String, Integer> hm = new HashMap<>();
        for (String p : participant) {
            hm.put(p, hm.getOrDefault(p, 0) + 1);
        }
        
        for (String c : completion) {
            int cnt = hm.get(c);
            if (cnt == 1){
                hm.remove(c);
            } else {
                hm.put(c, cnt - 1);
            }
        }
        
        String s = "";
        for (String ss : hm.keySet()) {
            s += ss;
        }
        
        return s;
    }
}