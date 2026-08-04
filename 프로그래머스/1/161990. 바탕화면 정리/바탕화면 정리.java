class Solution {
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};
    
    public int[] solution(String[] wallpaper) {
        int height = wallpaper.length;
        int width = wallpaper[0].length();
        
        int luy = 0;
        int lux = 0;
        int rdy = 0;
        int rdx = 0;
        
        // 상 -> 하
        int y = 0;
        for (int i = 0; i < height; i++) {
            boolean isFile = false;
            
            for (int j = 0; j < width; j++) {
                if (wallpaper[y].charAt(j) == '#') {
                    isFile = true;
                    luy = y;
                    break;
                }
            }
            if (isFile) break;
            
            y += dy[1];
        }
        
        // 좌 -> 우
        int x = 0;
        for (int i = 0; i < width; i++) {
            boolean isFile = false;
            
            for (int j = 0; j < height; j++) {
                if (wallpaper[j].charAt(x) == '#') {
                    isFile = true;
                    lux = x;
                    break;
                }
            }
            if (isFile) break;
            
            x += dx[3];
        }
        
        // 하 -> 상
        y = height - 1;
        for (int i = 0; i < height; i++) {
            boolean isFile = false;
            
            for (int j = 0; j < width; j++) {
                if (wallpaper[y].charAt(j) == '#') {
                    isFile = true;
                    rdy = y;
                    break;
                }
            }
            if (isFile) break;
            
            y += dy[0];
        }
        
        // 우 -> 좌
        x = width - 1;
        for (int i = 0; i < width; i++) {
            boolean isFile = false;
            
            for (int j = 0; j < height; j++) {
                if (wallpaper[j].charAt(x) == '#') {
                    isFile = true;
                    rdx = x;
                    break;
                }
            }
            if (isFile) break;
            
            x += dx[2];
        }
        
        return new int[] {luy, lux, rdy + 1, rdx + 1};
    }
}