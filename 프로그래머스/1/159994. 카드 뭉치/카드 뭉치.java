import java.util.*;

class Solution {
    static int n;
    static String[] cards1;
    static String[] cards2;
    static String[] goal;
    
    static String result = "No";
    
    public String solution(String[] mCards1, String[] mCards2, String[] mGoal) {
        cards1 = mCards1;
        cards2 = mCards2;
        goal = mGoal;
        n = goal.length;
        
        DFS(0, 0, 0);
    
        return result;
    }
    
    static void DFS(int idx1, int idx2, int targetIdx) {
        if (targetIdx == n) {
            result = "Yes";
            return;
        }
        
        String target = goal[targetIdx];
        
        if (idx1 < cards1.length) {
            if (target.equals(cards1[idx1])) {
                DFS(idx1 + 1, idx2, targetIdx + 1);
            }
        }
        
        if (idx2 < cards2.length) {
            if (target.equals(cards2[idx2])) {
                DFS(idx1, idx2 + 1, targetIdx + 1);
            }
        }
    }
}