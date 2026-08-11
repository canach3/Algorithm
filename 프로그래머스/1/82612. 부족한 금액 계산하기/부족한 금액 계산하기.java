import java.util.*;

class Solution {
    public long solution(int price, int money, int count) {
        int totalCnt = 0;
        
        for (int i = 1; i <= count; i++) {
            totalCnt += i;
        }
        
        long result = (long) price * totalCnt - money;
        
        if (result > 0) return result;
        else return 0;
    }
}