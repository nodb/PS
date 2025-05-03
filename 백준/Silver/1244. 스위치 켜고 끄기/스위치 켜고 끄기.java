import java.io.*;
import java.util.*;

public class Main {
   public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int switches = Integer.parseInt(br.readLine()); // 100 이하
      int arr[] = new int[switches + 1];
      StringTokenizer st = new StringTokenizer(br.readLine());
      for (int i = 1; i <= switches; i++) {
         arr[i] = Integer.parseInt(st.nextToken());
      }

      int students = Integer.parseInt(br.readLine()); // 100 이하
      for (int i = 0; i < students; i++) {
         st = new StringTokenizer(br.readLine());
         int gender = Integer.parseInt(st.nextToken());
         int number = Integer.parseInt(st.nextToken());
         if (gender == 1) {
            // 남학생: 배수 토글
            for (int cnt = number; cnt <= switches; cnt += number) {
               arr[cnt] = 1 - arr[cnt];
            }
         } else {
            // 여학생: 대칭 토글
            arr[number] = 1 - arr[number];
            int left = number - 1, right = number + 1;
            while (left > 0 && right <= switches && arr[left] == arr[right]) {
               arr[left--] = 1 - arr[left + 1];
               arr[right++] = 1 - arr[right - 1];
            }
         }
      }

      // 출력: 한 줄에 최대 20개
      for (int i = 1; i <= switches; i++) {
         System.out.print(arr[i]);
         if (i % 20 == 0 || i == switches) {
            System.out.println();
         } else {
            System.out.print(" ");
         }
      }
   }
}
