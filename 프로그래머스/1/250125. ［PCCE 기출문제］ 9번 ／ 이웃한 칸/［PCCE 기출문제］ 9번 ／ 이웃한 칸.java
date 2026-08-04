import java.util.*;

class Solution {
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};
    
    public int solution(String[][] board, int h, int w) {
        String color = board[h][w];
        
        int cnt = 0;
        for (int i = 0; i < 4; i++) {
            int nextY = h + dy[i];
            int nextX = w + dx[i];
            
            if (nextY < 0 || nextY >= board.length ||
                nextX < 0 || nextX >= board[0].length) continue;
            
            if (color.equals(board[nextY][nextX])) cnt++;
        }
        
        return cnt;
    }
}               