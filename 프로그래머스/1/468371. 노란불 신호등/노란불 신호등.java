import java.util.*;

class Solution {
    public int solution(int[][] signals) {
        int n = signals.length;
        
        int[][] patterns = new int[n][20];
        int[] lens = new int[n];
        
        for (int i = 0; i < n; i++) {
            int sum = 0;
            int idx = 0;
            
            for (int j = 0; j < 3; j++) {
                int len = signals[i][j];
                sum += len;
                
                for (int k = 0; k < len; k++) {
                    patterns[i][idx++] = j;
                }
            }
            
            lens[i] = sum;
        }
        
        // for (int i = 0; i < n; i++) {
        //     System.out.print(Arrays.toString(patterns[i]));
        //     System.out.println(lens[i]);
        // }
        
        int maxTime = 1;
        for (int i = 0; i < n; i++) {
            maxTime *= lens[i];
        }
        
        int time = 0;
        int result = 0;
        while(time <= maxTime) {
            boolean isOK = true;
            
            for (int i = 0; i < n; i++) {
                if (patterns[i][time % lens[i]] != 1) {
                    isOK = false;
                    break;
                }
            }
            
            if (isOK) return time + 1;
            
            time++;
        }
        
        return -1;
    }
}