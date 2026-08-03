import java.util.*;

class Solution {
    public int solution(int[] wallet, int[] bill) {
        
        int cnt = 0;
        while (Math.max(bill[0], bill[1]) > Math.max(wallet[0], wallet[1]) ||
               Math.min(bill[0], bill[1]) > Math.min(wallet[0], wallet[1])) {
            int bBigger = Math.max(bill[0], bill[1]);
            int bSmaller = Math.min(bill[0], bill[1]);
            int wBigger = Math.max(wallet[0], wallet[1]);
            int wSmaller = Math.min(wallet[0], wallet[1]);
            
            if (bill[0] == bBigger) bill[0] /= 2;
            else bill[1] /= 2;
            
            cnt++;
        }
               
        return cnt;
    }
}