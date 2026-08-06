import java.util.*;

class Solution {
    public int solution(int k, int m, int[] mScore) {
        Integer[] score = new Integer[mScore.length];
        for (int i = 0; i < score.length; i++) {
            score[i] = mScore[i];
        }
        
        Arrays.sort(score, Collections.reverseOrder());
        
        int result = 0;
        for (int i = 0; i < score.length; i += m) {
            int min = score[i];
            
            for (int j = 1; j < m; j++) {
                if (i + j >= score.length) return result;
                
                min = Math.min(min, score[i + j]);
            }
            
            result += min * m;
        }
        
        return result;
    }
}