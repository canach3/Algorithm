import java.util.*;

class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        boolean[] check = new boolean[46];
        
        for (int num : win_nums) {
            check[num] = true;
        }
        
        int cnt = 0;
        int zeroCnt = 0;
        
        for (int num : lottos) {
            if (num == 0) zeroCnt++;
            else if (check[num]) cnt++;
        }
        
        int max = 7 - (cnt + zeroCnt);
        int min = 7 - (cnt);
        
        return new int[] {max == 7 ? 6 : max, min == 7 ? 6 : min};
    }
}