import java.util.*;

class Solution {
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
                
                // 주말 제외
                if (day >= 5) continue; 
                
                if (timelogs[i][j] > schedules[i]) {
                    isOK = false;
                    break;
                }
            }
            
            if (isOK) cnt++;
        }
        
        return cnt;
    }
}