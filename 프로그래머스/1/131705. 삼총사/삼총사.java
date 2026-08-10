import java.util.*;

class Solution {
    static int result;
    
    public int solution(int[] number) {
        result = 0;
        DFS(0, 0, 0, number);

        return result;
    }
    
    static void DFS(int idx, int cnt, int sum, int[] number) {
       
        if (idx > number.length) return;
        
        if (cnt == 3) {
            if (sum == 0) result++;
            return;
        }
        
        if (idx == number.length) return;
        
        DFS(idx + 1, cnt + 1, sum + number[idx], number);
        DFS(idx + 1, cnt, sum, number);
    }
}   