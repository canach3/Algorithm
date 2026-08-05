import java.util.*;

class Solution {
    public int solution(String s) {
        int same = 0;
        int diff = 0;
        char target = s.charAt(0);
    
        int cnt = 0;
        
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == target) same++;
            else diff++;
            
            if (same == diff) {
                cnt++;
                
                same = 0;
                diff = 0;
                
                if (i == s.length() - 1) {
                    cnt--;
                    break;
                }
                
                target = s.charAt(i + 1);
            }        
        }
        
        cnt++;
        
        return cnt;
    }
}