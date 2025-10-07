import java.util.*;

class Solution {
    public int toDays(String date) {
        String[] sp = date.split("\\.");
        int y = Integer.parseInt(sp[0]);
        int m = Integer.parseInt(sp[1]);
        int d = Integer.parseInt(sp[2]);
        return y * 12 * 28 + (m - 1) * 28 + d;
    }
    
    public int[] solution(String today, String[] terms, String[] privacies) {
		// 1) today를 총 일수로
        int todayDays = toDays(today);

        // 2) 약관 → 개월수 매핑
        Map<String, Integer> termMonths = new HashMap<>();
        for (String t : terms) {
            String[] sp = t.split(" ");
            termMonths.put(sp[0], Integer.parseInt(sp[1]));
        }

        List<Integer> ans = new ArrayList<>();

        // 3) 각 개인정보 만료일 계산
        for (int i = 0; i < privacies.length; i++) {
            String[] sp = privacies[i].split(" ");      // ["YYYY.MM.DD", "A"]
            int start = toDays(sp[0]);                  // 수집일(총 일수)
            int months = termMonths.get(sp[1]);         // 유효 개월

            // 만료일 = 수집일 + (개월 * 28일) - 1일
            int expire = start + (months * 28) - 1;

            // today가 만료일보다 크거나 같으면 파기 대상
            if (todayDays > expire) {
                ans.add(i + 1); // 번호는 1부터
            }
        }

        // 4) 결과 변환
        int[] res = new int[ans.size()];
        for (int i = 0; i < ans.size(); i++) res[i] = ans.get(i);
        return res;
    }
}