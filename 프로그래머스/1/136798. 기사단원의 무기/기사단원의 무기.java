import java.util.*;

class Solution {
    public int solution(int number, int limit, int power) {
        int result = 0;
        
        for (int i = 1; i <= number; i++) {
            int cnt = 1;

            for (int j = 1; j <= i / 2; j++) {
                if (i % j == 0) cnt++;
            }
            
            if (cnt > limit) cnt = power;
            
            result += cnt;
        }
        
        return result;
    }
}