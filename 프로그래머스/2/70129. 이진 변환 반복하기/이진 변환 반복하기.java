class Solution {
    public int[] solution(String s) {
        int[] answer = {};
        int cnt = 0;
        int zero = 0;
        String b = s;
        
        while (true) {
            int beforeLen = b.length();
            int zeroLen = 0;
            for (char c : b.toCharArray()) {
                if (c == '0')
                    zeroLen++;
            }
            //if (zeroLen == 0)
            //     break;
            int next = beforeLen - zeroLen;
            System.out.print(b + " ");
            b = Integer.toBinaryString(next);
            System.out.println(zeroLen + " " + next + " " + b);
            cnt++;
            zero += zeroLen;
            if (b.equals("1"))
                break;
        }
        return new int[] {cnt, zero};
    }
}