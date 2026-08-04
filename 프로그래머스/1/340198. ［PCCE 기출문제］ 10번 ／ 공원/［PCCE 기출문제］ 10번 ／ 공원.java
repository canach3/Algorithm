import java.util.*;

class Solution {
    static int height;
    static int width;
    
    public int solution(int[] mats, String[][] park) {
        height = park.length;
        width = park[0].length;
        
        Integer[] sizes = new Integer[mats.length];
        for (int i = 0; i < mats.length; i++) {
            sizes[i] = mats[i];
        }
        
        Arrays.sort(sizes, Collections.reverseOrder());
        
        for (int size : sizes) {
            for (int i = 0; i < height; i++) {
                for (int j = 0; j < width; j++) {
                    if (!park[i][j].equals("-1")) continue;
                    if (find(i, j, size, park)) return size;   
                }
            }            
        }
        
        return -1;
    }
    
    static boolean find(int y, int x, int size, String[][] park) {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (i + y >= height || j + x >= width) return false;
                if (!park[i + y][j + x].equals("-1")) return false;
            }
        }
        
        return true;
    }
}