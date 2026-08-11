import java.util.*;

class Solution {
    public int solution(int[][] sizes) {
        int max1 = 0;
        int max2 = 0;
        
        for (int i = 0; i < sizes.length; i++) {
            max1 = Math.max(max1, Math.max(sizes[i][0], sizes[i][1]));
            max2 = Math.max(max2, Math.min(sizes[i][0], sizes[i][1]));
        }
        
        return max1 * max2;
    }
}