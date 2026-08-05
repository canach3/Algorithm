import java.util.*;

class Solution {
    public int solution(int n, int m, int[] section) {
        boolean[] wall = new boolean[n + 1];
        
        for (int i = 0; i <= n; i++) {
            wall[i] = true;
        }
        
        for (int i = 0; i < section.length; i++) {
            wall[section[i]] = false;
        }
        
        int cnt = 0;
        for (int idx = 1; idx <= n; idx++) {
            if (!wall[idx]) {
                for (int i = 0; i < m; i++) {
                    if (idx > n) break;
                    
                    wall[idx++] = true;
                }
                
                idx--;
                cnt++;
            }
        }
        
        return cnt;
    }
}