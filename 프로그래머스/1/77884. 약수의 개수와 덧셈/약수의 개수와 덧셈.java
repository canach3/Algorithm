import java.util.*;

class Solution {
    public int solution(int left, int right) {
        int result = 0;
        
        for (int i = left; i <= right; i++) {
            int cnt = 1;
            
            for (int j = 1; j <= i / 2; j++) {
                if (i % j == 0) cnt++;
            }
            
            if (cnt % 2 == 0) result += i;
            else result -= i;
        }
        
        return result;
    }
}