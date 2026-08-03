import java.util.*;

class Solution {
    static String[] days = {"월","화","수","목","금","토","주"};
    
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        int n = schedules.length;
        
        // schedules 시간 조정 (+10)
        for (int i = 0; i < n; i++) {
            schedules[i] += 10;
            
            int minutes = schedules[i] % 100;
            if (minutes >= 60) {
                schedules[i] += 40; 
            }
        }
        
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            boolean isOK = true;
            
            for (int j = 0; j < 7; j++) {
                int day = (startday - 1 + j) % 7;
                
                // System.out.print(days[day]);
                
                // 주말 제외
                if (day >= 5) continue; 
                
                if (timelogs[i][j] > schedules[i]) {
                    // System.out.print("기준 : " + schedules[i] + ", 나 : " + timelogs[i][j]);
                    isOK = false;
                    break;
                }
            }
            
            // System.out.println();
            
            if (isOK) cnt++;
        }
        
        return cnt;
    }
}