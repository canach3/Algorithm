import java.util.*;

class Solution {
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};
    static Map<Character, Integer> map;
    static String[] park;
    
    public int[] solution(String[] mPark, String[] routes) {
        park = mPark;
        
        map = new HashMap<>();
        map.put('N', 0);
        map.put('S', 1);
        map.put('W', 2);
        map.put('E', 3);
        
        int height = park.length;
        int width = park[0].length();
        
        int currY = 0;
        int currX = 0;
        
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (park[i].charAt(j) == 'S') {
                    currY = i;
                    currX = j;
                }
            }
        }
        
        for (int i = 0; i < routes.length; i++) {
            int d = map.get(routes[i].charAt(0));
            int len = routes[i].charAt(2) - '0';
            
            int[] idx = move(currY, currX, d, len);
            currY = idx[0];
            currX = idx[1];
        }
        
        return new int[] {currY, currX};
    }
    
    static int[] move(int startY, int startX, int d, int len) {
        int y = startY;
        int x = startX;
        
        for (int i = 0; i < len; i++) {
            y += dy[d];
            x += dx[d];
            
            if (y < 0 || y >= park.length || x < 0 || x >= park[0].length() || 
                park[y].charAt(x) == 'X') {
                return new int[] {startY, startX};
            }
        }
        
        return new int[] {y, x};
    }
}