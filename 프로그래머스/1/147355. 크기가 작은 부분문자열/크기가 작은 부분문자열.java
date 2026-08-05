import java.util.*;

class Solution {
    public int solution(String t, String p) {
        int size = p.length();
        long target = Long.parseLong(p);
        
        int cnt = 0;
        for (int i = 0; i < t.length(); i++) {
            if (i + size > t.length()) break;
            
            String numStr = t.substring(i, i + size);
            long num = Long.parseLong(numStr);
        
            if (num <= target) cnt++;
        }
        
        return cnt;
    }
}