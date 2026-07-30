import java.util.*;

class Solution {
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};
    
    static int height;
    static int width;
    
    static int[][] map;
    static boolean[][] visited;
    static int[] cnts;
    
    public int solution(int[][] land) {
        height = land.length;
        width = land[0].length;
        map = land;
        
        cnts = new int[width];
        visited = new boolean[height][width];
        
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                BFS(i, j);    
            }
        }
        
        int max = 0;
        for (int cnt : cnts) {
            max = Math.max(max, cnt);
        }
        
        return max;
    }
    
    static void BFS(int y, int x) {
        if (visited[y][x] || map[y][x] == 0) return;
        
        int[] Xs = new int[width];
        int cnt = 0;
        
        Deque<int[]> deque = new ArrayDeque();
        deque.addLast(new int[] {y, x});
        visited[y][x] = true;
        
        while (!deque.isEmpty()) {
            int[] curr = deque.pollFirst();
            int currY = curr[0];
            int currX = curr[1];
            
            Xs[currX] = 1;
            cnt++;
            
            for (int i = 0; i < 4; i++) {
                int nextY = currY + dy[i];
                int nextX = currX + dx[i];
                
                if (nextY < 0 || nextY >= height || nextX < 0 || nextX >= width 
                    || visited[nextY][nextX]
                    || map[nextY][nextX] == 0) continue;
                
                visited[nextY][nextX] = true;
                deque.addLast(new int[] {nextY, nextX});
            }
        }
        
        for (int i = 0; i < width; i++) {
            if (Xs[i] == 1) cnts[i] += cnt; 
        }
    }
}